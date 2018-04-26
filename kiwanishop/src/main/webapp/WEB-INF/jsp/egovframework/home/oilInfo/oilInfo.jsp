<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<jsp:include page="/home/oilInfo/common/oilInfoHeader.do" />

<script type="text/javascript" src="/static/home/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=by7_phQrEkMuknfvSEaA&amp;submodules=panorama,geocoder"></script>

		<div>주유소 인포</div>
		<div id="map" style="width:100%;height:580px;"></div>
		<script id="code">
			//지도를 삽입할 HTML 엘리먼트 또는 HTML 엘리먼트의 id를 지정합니다.
			var mapDiv = jQuery("#map").get(0); // 'map' 으로 선언해도 동일
			var mapLatLng = new naver.maps.LatLng(37.3595704, 127.105399);
			
			//지도 생성시에 옵션을 지정할 수 있습니다.
			var map = new naver.maps.Map(mapDiv, {
			        center: mapLatLng, //지도의 초기 중심 좌표
			        zoom: 7, //지도의 초기 줌 레벨
			        minZoom: 1, //지도의 최소 줌 레벨
			        zoomControl: true, //줌 컨트롤의 표시 여부
			        zoomControlOptions: { //줌 컨트롤의 옵션
			            position: naver.maps.Position.TOP_RIGHT
			        }
			    });
			
			var ktmXy = naver.maps.TransCoord.fromLatLngToTM128(map.getCenter());
			
			var circle;
			var markers = [];
			var infoWindows = [];
			var oilIds = [];
			
			$.ajax({
				type:"POST",
				url:"/home/oilInfo/oilInfoAjax.do",
				data:{"ktmX":ktmXy.x,"ktmY":ktmXy.y,"zoomVal":map.getZoom()},
				dataType:"json",
				success:function(data,status){
					var parseOilList = eval(data);
					for(var i=0; i<parseOilList.RESULT.OIL.length; i++){
						var ktmChng = new naver.maps.Point(parseInt(parseOilList.RESULT.OIL[i].GIS_X_COOR), parseInt(parseOilList.RESULT.OIL[i].GIS_Y_COOR));
						
						var iconImg = "";
						if(parseOilList.RESULT.OIL[i].POLL_DIV_CD == "HDO"){
							iconImg = "/static/oilInfo/images/oilbank_icon.jpg";
						}else if(parseOilList.RESULT.OIL[i].POLL_DIV_CD == "SKE"){
							iconImg = "/static/oilInfo/images/sk_icon.jpg";
						}else if(parseOilList.RESULT.OIL[i].POLL_DIV_CD == "GSC"){
							iconImg = "/static/oilInfo/images/gs_icon.jpg";
						}else if(parseOilList.RESULT.OIL[i].POLL_DIV_CD == "SOL"){
							iconImg = "/static/oilInfo/images/soil_icon.jpg";
						}else{
							iconImg = "/static/oilInfo/images/etc_icon.jpg";
						}
						
						markers[i] = new naver.maps.Marker({
			 			    position: naver.maps.TransCoord.fromTM128ToLatLng(ktmChng),
			 			    map: map,
			 			    icon: {
			 			    	url: iconImg
			 			    }
			 			});
						
						var infoWindow = new naver.maps.InfoWindow();
						
						infoWindows.push(infoWindow);
						oilIds[i] = parseOilList.RESULT.OIL[i].UNI_ID;
						
					}
					circle = new naver.maps.Circle({
					    map: map,
					    center: mapLatLng,
					    radius: 2000,
					    fillColor: 'crimson',
					    fillOpacity: 0.1
					});
					
					for(var j=0; j < markers.length; j++){
						naver.maps.Event.addListener(markers[j], "click", fncOilDetail(j));
					}
					
				},
				error:function(xhr,textStatus,errorThrown){
					alert("데이터요청중 에러가 발생되었습니다.");
				}
			});
			
			map.addListener('idle', function(e) {	//맵 이동 시
				circle.setRadius(0);
				for(var i=0; i<markers.length; i++){
					markers[i].setVisible(false);
					infoWindows[i].close();
					oilIds[i] = "";
				}
				
				ktmXy = naver.maps.TransCoord.fromLatLngToTM128(map.getCenter());
			
				var zoom = 2000;
				switch(Number(map.getZoom())){
					case 1 : zoom = 5000; break; 
					case 2 : zoom = 4500; break; 
					case 3 : zoom = 3000; break; 
					case 4 : zoom = 3500; break; 
					case 5 : zoom = 3000; break; 
					case 6 : zoom = 2500; break; 
					case 7 : zoom = 2000; break; 
					case 8 : zoom = 1500; break; 
					case 9 : zoom = 1000; break; 
					case 10 : zoom = 900; break; 
					case 11 : zoom = 800; break; 
					case 12 : zoom = 700; break; 
					case 13 : zoom = 600; break; 
					case 14 : zoom = 500; break; 
				}
			
				$.ajax({
					type:"POST",
					url:"/home/oilInfo/oilInfoAjax.do",
					data:{"ktmX":ktmXy.x,"ktmY":ktmXy.y,"zoomVal":map.getZoom()},
					dataType:"json",
					success:function(data,status){
						var parseOilList = eval(data);
						for(var i=0; i<parseOilList.RESULT.OIL.length; i++){
							var ktmChng = new naver.maps.Point(parseInt(parseOilList.RESULT.OIL[i].GIS_X_COOR), parseInt(parseOilList.RESULT.OIL[i].GIS_Y_COOR));
							
							var iconImg = "";
							if(parseOilList.RESULT.OIL[i].POLL_DIV_CD == "HDO"){
								iconImg = "/static/oilInfo/images/oilbank_icon.jpg";
							}else if(parseOilList.RESULT.OIL[i].POLL_DIV_CD == "SKE"){
								iconImg = "/static/oilInfo/images/sk_icon.jpg";
							}else if(parseOilList.RESULT.OIL[i].POLL_DIV_CD == "GSC"){
								iconImg = "/static/oilInfo/images/gs_icon.jpg";
							}else if(parseOilList.RESULT.OIL[i].POLL_DIV_CD == "SOL"){
								iconImg = "/static/oilInfo/images/soil_icon.jpg";
							}else{
								iconImg = "/static/oilInfo/images/etc_icon.jpg";
							}
							
							markers[i] = new naver.maps.Marker({
				 			    position: naver.maps.TransCoord.fromTM128ToLatLng(ktmChng),
				 			    map: map,
				 			    icon: {
				 			    	url: iconImg
				 			    }
				 			});
							
							var infoWindow = new naver.maps.InfoWindow();
							
							infoWindows.push(infoWindow);
							oilIds[i] = parseOilList.RESULT.OIL[i].UNI_ID;
							
						}
						circle = new naver.maps.Circle({
						    map: map,
						    center: map.getCenter(),
						    radius: zoom,
						    fillColor: 'crimson',
						    fillOpacity: 0.1
						});
						
						for(var j=0; j < markers.length; j++){
							naver.maps.Event.addListener(markers[j], "click", fncOilDetail(j));
						}
					},
					error:function(xhr,textStatus,errorThrown){
						alert("데이터요청중 에러가 발생되었습니다.");
					}
				});
			});
			
			function fncOilDetail(seq){
				return function(e) {
			        var marker = markers[seq],
			            infoWindow = infoWindows[seq];

			        if (infoWindow.getMap()) {
			            infoWindow.close();
			        } else {
			            
			            $.ajax({
							type:"POST",
							url:"/home/oilInfo/oilInfoDetailAjax.do",
							data:{"oilId":oilIds[seq]},
							dataType:"json",
							success:function(data,status){
								var parseOilDetail = eval(data);
								var content = '';
								var oilCompany = "";
								if(parseOilDetail.RESULT.OIL[0].POLL_DIV_CO == "SKE"){
									oilCompany = "SK에너지";
								}else if(parseOilDetail.RESULT.OIL[0].POLL_DIV_CO == "GSC"){
									oilCompany = "GS칼텍스";
								}else if(parseOilDetail.RESULT.OIL[0].POLL_DIV_CO == "HDO"){
									oilCompany = "현대오일뱅크";
								}else if(parseOilDetail.RESULT.OIL[0].POLL_DIV_CO == "SOL"){
									oilCompany = "S-OIL";
								}else if(parseOilDetail.RESULT.OIL[0].POLL_DIV_CO == "RTO"){
									oilCompany = "자영알뜰";
								}else if(parseOilDetail.RESULT.OIL[0].POLL_DIV_CO == "RTX"){
									oilCompany = "고속도로알뜰";
								}else if(parseOilDetail.RESULT.OIL[0].POLL_DIV_CO == "NHO"){
									oilCompany = "농협알뜰";
								}else if(parseOilDetail.RESULT.OIL[0].POLL_DIV_CO == "ETC"){
									oilCompany = "자가상표";
								}else if(parseOilDetail.RESULT.OIL[0].POLL_DIV_CO == "E1G"){
									oilCompany = "E1";
								}else if(parseOilDetail.RESULT.OIL[0].POLL_DIV_CO == "SKG"){
									oilCompany = "SK가스";
								}
								
								var lpgYn = "";
								if(parseOilDetail.RESULT.OIL[0].LPG_YN == "N"){
									lpgYn = "주유소";
								}else if(parseOilDetail.RESULT.OIL[0].LPG_YN == "Y"){
									lpgYn = "자동차충전소";
								}if(parseOilDetail.RESULT.OIL[0].LPG_YN == "C"){
									lpgYn = "주유소/충전소 겸업";
								}
								
								content += '<div style="width:450px;text-align:left;padding:10px;">상표 : "' + oilCompany + '"<br />';
								content += '상호 : "'+ parseOilDetail.RESULT.OIL[0].OS_NM +'"<br />';
								content += '지번주소 : "'+ parseOilDetail.RESULT.OIL[0].VAN_ADR +'"<br />';
								content += '도로명주소 : "'+ parseOilDetail.RESULT.OIL[0].NEW_ADR +'"<br />';
								content += '전화번호 : "'+ parseOilDetail.RESULT.OIL[0].TEL +'"<br />';
								content += '업종구분 : "'+ lpgYn +'"<br />';
								content += '경정비 : "'+ parseOilDetail.RESULT.OIL[0].MAINT_YN +'"<br />';
								content += '세차장 : "'+ parseOilDetail.RESULT.OIL[0].CAR_WASH_YN +'"<br />';
								content += '편의점 : "'+ parseOilDetail.RESULT.OIL[0].CVS_YN +'"<br />';
								
								var prodcd = "";
								for(var i=0; i<parseOilDetail.RESULT.OIL[0].OIL_PRICE.length; i++){
									if(parseOilDetail.RESULT.OIL[0].OIL_PRICE[i].PRODCD == "B027"){
										prodcd = "휘발유";
									}else if(parseOilDetail.RESULT.OIL[0].OIL_PRICE[i].PRODCD == "D047"){
										prodcd = "경유";
									}else if(parseOilDetail.RESULT.OIL[0].OIL_PRICE[i].PRODCD == "B034"){
										prodcd = "고급휘발유";
									}else if(parseOilDetail.RESULT.OIL[0].OIL_PRICE[i].PRODCD == "C004"){
										prodcd = "실내등유";
									}else if(parseOilDetail.RESULT.OIL[0].OIL_PRICE[i].PRODCD == "K015"){
										prodcd = "자동차부탄";
									}
									content += '유종 : "'+ prodcd +'", ';
									content += '판매가격 : "'+ parseOilDetail.RESULT.OIL[0].OIL_PRICE[i].PRICE +'", ';
									content += '기준일자 : "'+ parseOilDetail.RESULT.OIL[0].OIL_PRICE[i].TRADE_DT +'", ';
									content += '기준시간 : "'+ parseOilDetail.RESULT.OIL[0].OIL_PRICE[i].TRADE_TM +'"<br />';
								}
								content += '</div>';
								infoWindow.setContent(content);
								infoWindow.open(map, marker);
							},
							error:function(xhr,textStatus,errorThrown){
								alert("데이터요청중 에러가 발생되었습니다.");
							}
						});
			        }
			    }
			}
			
		</script>
<jsp:include page="/home/oilInfo/common/oilInfoFooter.do" />