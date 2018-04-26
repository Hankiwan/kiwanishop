<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<jsp:include page="/admin/common/header.do" />

<script type="text/javascript" src="/static/home/js/jquery.js"></script>
<script type="text/javascript" src="/static/comjs/EgovBBSMng.js" ></script>
<script type="text/javascript">
	function fnc_regist(){
		jQuery("#menuForm").attr("action", "/admin/menu/menuRegistForm.do");
		jQuery("#menuForm").submit();
	}
	
	function fncView(menuCode){
		jQuery("#menuCode").val(menuCode);
		jQuery("#menuForm").attr("action", "/admin/menu/menuView.do");
		jQuery("#menuForm").submit();
	}
	
	function fncList(){
		jQuery("#menuForm").attr("action", "/admin/menu/menuList.do");
		jQuery("#menuForm").submit();
	}
	
	function fncUseGubun(){
		jQuery("#menuForm").attr("action", "/admin/menu/menuList.do");
		jQuery("#menuForm").submit();
	}
	
	function fncPlusMinus(menuCode, menuDepth){
		var param = "menuCode=" + menuCode + "&menuDepth=" + menuDepth; 
		
		if(menuDepth == "1" || menuDepth == "2"){
			if(document.getElementById("plusMinus" + menuCode).src.indexOf("btn_minus") > 0){	//접기
				param = param + "&minusGubun=Y";
				$.ajax({ 
					type: "POST", 
					url: "/admin/menu/ajaxSelectMenu.do", 
					data: param,
					success: function(data){
						var arrData = data.split(",");
						for(var i=0; i<arrData.length; i++){
							if(arrData.length != 1){
								if(i > 0){
									jQuery("#display" + arrData[i].trim()).hide();
								}
								jQuery("#plusMinus" + arrData[i].trim()).attr("src", "/static/admin/images/common/quick/btn_plus.gif");
							}
						}
					},
					error:function (data){
						alert("통신실패");
					} 
				});
			}else{	//펼치기
				$.ajax({ 
					type: "POST", 
					url: "/admin/menu/ajaxSelectMenu.do", 
					data: param,
					success: function(data){
						var arrData = data.split(",");
						for(var i=0; i<arrData.length; i++){	
							jQuery("#display" + arrData[i].trim()).show();
							if(arrData.length != 1){
								jQuery("#plusMinus" + menuCode).attr("src", "/static/admin/images/common/quick/btn_minus.gif");
							}
						}	
					},
					error:function (data){
						alert("통신실패");
					} 
				});
			}
		}else if(menuDepth == "3"){
			$.ajax({ 
				type: "POST", 
				url: "/admin/menu/ajaxSelectMenu.do", 
				data: param,
				success: function(data){
					var arrData = data.split(",");
					if(document.getElementById("plusMinus" + menuCode).src.indexOf("btn_minus") > 0){	//접기
						for(var i=0; i<arrData.length; i++){
							jQuery("#display" + arrData[i].trim()).hide();
							jQuery("#plusMinus" + menuCode).attr("src", "/static/admin/images/common/quick/btn_plus.gif");
						}
					}else{	//펼치기
						for(var i=0; i<arrData.length; i++){	
							jQuery("#display" + arrData[i].trim()).show();
							jQuery("#plusMinus" + menuCode).attr("src", "/static/admin/images/common/quick/btn_minus.gif");
							jQuery("#plusMinus" + arrData[i].trim()).remove();
						}
					}
				},
				error:function (data){
					alert("통신실패");
				} 
			});
		}
	}
	
	//메뉴 순위 변경
	function fncMenuChange(updown, useGubun, menuCode, menuDepth){
		//메뉴 MAX값, MIN값 체크
		var param = "menuMaxMin=" + updown + "&useGubun=" + useGubun; 
		$.ajax({ 
			type: "POST", 
			url: "/admin/menu/ajaxMenuMaxMin.do", 
			data: param,
			dataType:"html",
			success: function(data){
				if(data.trim() == menuCode.trim()){
					if(updown == "max"){
						alert("마지막 메뉴입니다.");	
					}else if(updown == "min"){
						alert("첫번째 메뉴입니다.");
					}
					return;
				}else{
					if(confirm("메뉴를 이동하시겠습니까?")){
						jQuery("#menuMaxMin").val(updown);
						jQuery("#menuCode").val(menuCode);
						jQuery("#menuForm").attr("action", "/admin/menu/menuChange.do");
						jQuery("#menuForm").submit();
					}
				}
			},
			error:function (data){
				alert("통신실패");
			} 
		});
	}
	
	String.prototype.trim = function(){
		return this.replace(/\s/g, "");
	}
</script>
<!-- Content Start -->
<form name="menuForm" id="menuForm" method="post" >
	<input type="hidden" name="menuCode" id="menuCode" />
	<input type="hidden" name="menuMaxMin" id="menuMaxMin" />
	<!-- 메뉴 코드 공통 start -->
	<input type="hidden" name="gnbMenuCd" id="gnbMenuCd" value="${searchVO.gnbMenuCd }" />
	<!-- 메뉴 코드 공통 end -->  
	<div id="container">
	<!-- title Start -->
	<div class="location">
		<h2 class="tit_h2">메뉴 관리 리스트</h2>
	</div>
	<!-- title End -->	
		<!-- BOARD Start -->
		<div id="container">
			<fieldset>
				<legend>메뉴관리 리스트</legend>
					사용 구분 : 
					<select name="useGubun" id="useGubun" onChange="fncUseGubun();">
						<c:forEach var="useList" items="${useGubunList }" varStatus="j">
							<option value="${useList.codeNm }" <c:if test="${searchVO.useGubun eq useList.codeNm }">selected</c:if>><c:out value="${useList.codeNm }" /></option>
						</c:forEach>
					</select>
					<table class="bbs_list">
						<caption>메뉴관리 게시판 리스트</caption>
						<colgroup>
							<col width="100%" />
						</colgroup>
						<thead>
							<tr>
								<th scope="col">메뉴</th>		
							</tr>
						</thead>
						<tbody>
							<c:forEach var="menu" items="${selectMenuList}" varStatus="status">
								<c:choose>
									<c:when test="${menu.menuDepth eq '1' }">
										<tr id="display<c:out value="${fn:substring(menu.menuCode,0,4)}" />">
											<td style="text-align:left;">
												<a href="javascript:fncMenuChange('min', '<c:out value="${menu.useGubun}" />','<c:out value="${fn:substring(menu.menuCode,0,4)}" />', '<c:out value="${menu.menuDepth}" />');" ><img src="/static/admin/images/common/blt/blt_top.gif" /></a>
												<a href="javascript:fncMenuChange('max', '<c:out value="${menu.useGubun}" />','<c:out value="${fn:substring(menu.menuCode,0,4)}" />', '<c:out value="${menu.menuDepth}" />');" ><img src="/static/admin/images/common/blt/blt_bottom.gif" /></a>&nbsp;&nbsp;
												<c:choose>
													<c:when test="${menu.cnt > 0 }">
														<a href="javascript:fncPlusMinus('<c:out value="${fn:substring(menu.menuCode,0,4)}" />', '<c:out value="${menu.menuDepth}" />');" ><img id="plusMinus<c:out value="${fn:substring(menu.menuCode,0,4)}" />" src="/static/admin/images/common/quick/btn_plus.gif" /></a>
													</c:when>
													<c:otherwise>
														&nbsp;&nbsp;&nbsp;
													</c:otherwise>
												</c:choose>
												<a href="javascript:fncView('<c:out value="${menu.menuCode}" />');"><c:out value="${menu.menuNm}" escapeXml="false" /></a>
											</td>
										</tr>																											
									</c:when>
									<c:when test="${menu.menuDepth eq '2' }">
										<tr id="display<c:out value="${fn:substring(menu.menuCode,0,8)}" />" style="display:none;">
											<td style="text-align:left;">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<c:choose>
													<c:when test="${menu.cnt > 0 }">																		
														<a href="javascript:fncPlusMinus('<c:out value="${fn:substring(menu.menuCode,0,8)}" />', '<c:out value="${menu.menuDepth}" />');" ><img id="plusMinus<c:out value="${fn:substring(menu.menuCode,0,8)}" />" src="/static/admin/images/common/quick/btn_plus.gif" /></a>
													</c:when>
													<c:otherwise>
														&nbsp;&nbsp;&nbsp;
													</c:otherwise>
												</c:choose>
												<a href="javascript:fncView('<c:out value="${menu.menuCode}" />');"><c:out value="${menu.menuNm}" escapeXml="false" /></a>
											</td>
										</tr>
									</c:when>
									<c:when test="${menu.menuDepth eq '3' }">
										<tr id="display<c:out value="${fn:substring(menu.menuCode,0,12)}" />" style="display:none;">
											<td style="text-align:left;">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<c:choose>
													<c:when test="${menu.cnt > 0 }">	
														<a href="javascript:fncPlusMinus('<c:out value="${fn:substring(menu.menuCode,0,12)}" />', '<c:out value="${menu.menuDepth}" />');" ><img id="plusMinus<c:out value="${fn:substring(menu.menuCode,0,12)}" />" src="/static/admin/images/common/quick/btn_plus.gif" /></a>
													</c:when>
													<c:otherwise>
														&nbsp;&nbsp;&nbsp;
													</c:otherwise>
												</c:choose>
												<a href="javascript:fncView('<c:out value="${menu.menuCode}" />');"><c:out value="${menu.menuNm}" escapeXml="false" /></a>
											</td>
										</tr>																				
									</c:when>
									<c:when test="${menu.menuDepth eq '4' }">
										<tr id="display<c:out value="${fn:substring(menu.menuCode,0,16)}" />" style="display:none;">
											<td style="text-align:left;">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<c:choose>
													<c:when test="${menu.cnt > 0 }">													
														<a href="javascript:fncPlusMinus('<c:out value="${fn:substring(menu.menuCode,0,16)}" />', '<c:out value="${menu.menuDepth}" />');" ><img id="plusMinus<c:out value="${fn:substring(menu.menuCode,0,16)}" />" src="/static/admin/images/common/quick/btn_plus.gif" /></a>
													</c:when>
													<c:otherwise>
														&nbsp;&nbsp;&nbsp;
													</c:otherwise>
												</c:choose>
												<a href="javascript:fncView('<c:out value="${menu.menuCode}" />');"><c:out value="${menu.menuNm}" escapeXml="false" /></a>
											</td>
										</tr>							
									</c:when>
								</c:choose>
							</c:forEach>
							<c:if test="${fn:length(selectMenuList) == 0}">
								<tr>
									<td><spring:message code="common.nodata.msg" /></td>
								</tr>
							</c:if>
						</tbody>
					</table>
					<div class="paging"><!-- PAGING START -->
						<div class='r_btn'><a href="javascript:fnc_regist();"><img src="/static/admin/images/common/btn/btn_register.gif" /></a></div>
					</div><!-- //PAGING END --> 
			</fieldset>
		</div>
		<!-- BOARD End -->
	</div>
</form>
<!-- Content End -->
<jsp:include page="/admin/common/footer.do" />