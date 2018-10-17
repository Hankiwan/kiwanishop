<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Daum 지도 시작하기</title>
</head>
<body>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0482b0e3b2e902222ddacd7bc3a921b0"></script>
	<div class="wrapLineCon">
	<article id="wrap"><!-- CONTENTS START -->
		<section class="locationMap">
			<a name="mapfoc"></a>
			<div id="map"  style="swidth:938px;height:600px;"></div>
		</section>
	</article><!-- CONTENTS END -->
	<script type="text/javascript" src="/static/home/js/jquery-1.8.2.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function(){
			$.ajax({
			    type : "GET",
			    url : "https://dapi.kakao.com/v2/search/web?query=이효리",
			    headers : { "Authorization" : "KakaoAK bd6d174970568347a7e82ca1dd4f628e" }
			}).done(function(data){
				console.log(data);
			});
			
			
// 			$.ajax({
// 			    type : "GET",
// 			    url : "https://dapi.kakao.com/v2/search/web?query=이효리",
// 			    dataType : "json",
// 			    headers : {
// 			    	"Content-Type" : "application/json",
// 			    	"Authorization" : "KakaoAK bd6d174970568347a7e82ca1dd4f628e",
// 			    	"Access-Control-Allow-Origin" : "*",
// 			    	"Access-Control-Allow-Headers" : "origin, x-requested-with, content-type, accept",
// 			     	"X-HTTP-Method-Override" : "GET",
// 			    },			    
// 			    success : function (result) {
// 			     alert(result);
// 			    },
// 			    error:function(jqXHR, textStatus, errorThrown){
// 			    	alert(jqXHR.status);
// 		            alert("에러 발생~~ \n" + textStatus + " : " + errorThrown);
// 		        }
// 			});
			
// 			$.ajax({
// 		        type : 'get',
// 		        url : 'https://dapi.kakao.com/v2/search/web?query=이효리',
// 		        dataType : 'json',
// 		        beforeSend : function(xhr){
// 		            xhr.setRequestHeader("Authorization","KakaoAK bd6d174970568347a7e82ca1dd4f628e");
// 		        },
// 		        error: function(xhr, status, error){
// 		            alert("error : " + error);
// 		        },
// 		        success : function(data){
// 		            alert("data : " + data);
// 		        }
// 		    });
			
		});
	</script>
	
	<script>
// 	var userAgent = navigator.userAgent;
//     var LOAD_MAP = false;
//     var map;
//     var icon=new daum.maps.MarkerImage(
//             '/static/home/images/common/btn/btnc_submit.gif',
//             new daum.maps.Size(27,22),
//             new daum.maps.Point(8,10)
//      );
//     /** 다음 Map **/  
//     var daumMap = {
    		
//         init : function(lat,lng){   
//             map =  new daum.maps.Map(document.getElementById('map'), {   
//                 center: new daum.maps.LatLng(lat,lng),   
//                 level:4   
//             });
//             zoomControl = new daum.maps.ZoomControl();       
//             map.addControl(zoomControl, daum.maps.ControlPosition.RIGHT);       
//             mapTypeControl = new daum.maps.MapTypeControl();       
//             map.addControl(mapTypeControl, daum.maps.ControlPosition.TOPRIGHT); 
//             marker = new daum.maps.Marker({position: new daum.maps.LatLng(lat, lng),image : icon});  
//         }, 
        
//       	searchMark : function(lat,lng,name,juso1,juso2,number){ 
//             marker = new daum.maps.Marker({position: new daum.maps.LatLng(lat, lng),image : icon});  
//             marker.setMap(map);
//             var infowindow = new daum.maps.InfoWindow({
//                 content: '<p style="margin:7px 22px 7px 12px;font:12px/1.5 sans-serif"><strong>'+name+'</strong><br /><br />'+juso1+'<br />'+juso2+'<br /><br />'+number+'</p>',
//                 removable : true
//             });
//             daum.maps.event.addListener(marker, "click", function() {
//             	infowindow.open(map, marker);
// 			});

//             map.panTo(new daum.maps.LatLng(lat, lng));  
//             var loca = location;
//             location.hash='mapfoc';
//             location = loca;
//         }
//     };   
    
	/********************
	 * name : Init()
	 * 초기화 하는 메뉴
	 ********************/
// 	function Init(){
// 		if(userAgent.match(/iPhone|iPod|Android|Windows CE|BlackBerry|Symbian|Windows Phone|webOS|Opera Mini|Opera Mobi|POLARIS|IEMobile|lgtelecom|nokia|SonyEricsson/i) != null || userAgent.match(/LG|SAMSUNG|Samsung/) != null){
// 			loadMap();w
// 		}else{
// 			userAgent = userAgent.toLowerCase();
// 			if (userAgent.indexOf("msie") > -1){loadMap();}
// 			else if(userAgent.indexOf("firefox") > -1){loadMap();}
// 			else if(userAgent.indexOf("opera") > -1){loadMap();}
// 			else if(userAgent.indexOf("chrome") > -1){loadMap();}
// 			else if(userAgent.indexOf("safari") > -1){daumMap.init(37.557090,126.973529);}
// 			else{
// 				loadMap();
// 			}
// 		}
// 	}
	
	//최초 페이지 로딩시 맵 로케이션 분기점
// 	function loadMap() {
// 	   daumMap.init(37.557090,126.973529);  
// 	   daumMap.searchMark(37.457090,127.973529,"기와니집","서울시 도봉구 쌍문동", " 81-126", "02-1111-2222")
// 	}
	
//  	function zoomIn(){
//   		map.setLevel(map.getLevel() - 1);
//   	}
	  	
//   	function zoomOut(){
//   		map.setLevel(map.getLevel() + 1);
//   	}
  	
//   	Init();
	</script>
</div>
</body>
</html>