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

	jQuery(document).ready(function(){
		
	});

	function fncUpdate(){
		jQuery("#memberForm").attr("action", "/admin/member/memberMenuAuth.do");
		jQuery("#memberForm").submit();
	}
	
	function fncList(){
		jQuery("#memberForm").attr("action", "/admin/member/memberList.do");
		jQuery("#memberForm").submit();
	}

</script>
<!-- Content Start -->
<form name="memberForm" id="memberForm" method="post" >
	<!-- 메뉴 코드 공통 start -->
	<input type="hidden" name="gnbMenuCd" id="gnbMenuCd" value="${searchVO.gnbMenuCd }" />
	<!-- 메뉴 코드 공통 end -->  
	<input type="hidden" name="userId" id="userId" value="${searchVO.userId }" />
	<div id="container">
	<!-- title Start -->
	<div class="location">
		<h2 class="tit_h2">메뉴 권한 부여</h2>
	</div>
	<!-- title End -->	
		<!-- BOARD Start -->
		<div id="container">
			<fieldset>
				<legend>메뉴권한 부여</legend>
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
										<c:set var="nbsp" value="" />																									
										<c:set var="displayId" value="${fn:substring(menu.menuCode,0,4)}" />																									
									</c:when>
									<c:when test="${menu.menuDepth eq '2' }">
										<c:set var="nbsp" value="&nbsp;&nbsp;&nbsp;" />
										<c:set var="displayId" value="${fn:substring(menu.menuCode,0,8)}" />
									</c:when>
									<c:when test="${menu.menuDepth eq '3' }">
										<c:set var="nbsp" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" />		
										<c:set var="displayId" value="${fn:substring(menu.menuCode,0,12)}" />															
									</c:when>
									<c:when test="${menu.menuDepth eq '4' }">
										<c:set var="nbsp" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" />	
										<c:set var="displayId" value="${fn:substring(menu.menuCode,0,16)}" />					
									</c:when>
								</c:choose>
								
								<tr id="display<c:out value="${displayId}" />">
									<td style="text-align:left;">
										<c:set var="chkGubun" value="" />
										<c:forEach var="authList" items="${menuAuthList }" varStatus="authStatus">
											<c:if test="${authList.menuCode eq menu.menuCode }">
												<c:set var="chkGubun" value="checked" />
											</c:if>
										</c:forEach>
										<input type="checkbox" name="chkbxMenu" value="<c:out value="${menu.menuCode }" />" <c:out value="${chkGubun }" escapeXml="false" /> />
										<c:out value="${nbsp }" escapeXml="false" /><c:out value="${menu.menuNm}" escapeXml="false" />
									</td>
								</tr>	
							</c:forEach>
							<c:if test="${fn:length(selectMenuList) == 0}">
								<tr>
									<td><spring:message code="common.nodata.msg" /></td>
								</tr>
							</c:if>
						</tbody>
					</table>
					<div class="paging"><!-- PAGING START -->
						<div class='float_r'><a href="javascript:fncUpdate();"><img src="/static/admin/images/common/btn/btn_modify.gif" /></a></div>
						<div class="float_l"><a href="javascript:fncList();"><img src="/static/admin/images/common/btn/btn_list.gif" alt="목록" /></a></div>
					</div><!-- //PAGING END --> 
			</fieldset>
		</div>
		<!-- BOARD End -->
	</div>
</form>
<!-- Content End -->
<jsp:include page="/admin/common/footer.do" />