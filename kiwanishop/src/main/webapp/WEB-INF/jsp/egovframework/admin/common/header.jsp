<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>기와니샵 메인</title>    
<link rel="stylesheet" type="text/css" href="/static/admin/css/unification.css" />
<link rel="stylesheet" type="text/css" href="/static/admin/css/admin.css" />
<!-- <link rel="stylesheet" type="text/css" href="/static/admin/css/jquery-ui.css" /> -->
<!-- <script src="/static/admin/jQueryPlugIn/js/jquery-ui-1.8.5.custom.min.js" type="text/javascript"></script> -->
<script src="/static/admin/js/globalURL.js" type="text/javascript"></script>
<!-- <script src="/static/admin/js/common.js" type="text/javascript"></script> -->
<script src="/static/admin/js/jquery-1.8.2.js" type="text/javascript"></script>
<script type="text/javascript">
	jQuery(document).ready(function(){
		if("${msg}" != "" && "${msg}" != "mainChk"){
			alert("${msg}");
		}
	});
</script>
</head>
<body id="totalBg">
<div id="admin_totalLayout">
	<a class="accLink" href="#gnbList" title="메인메뉴로 바로 이동하기">메인메뉴로 바로 이동하기</a>
	<a class="accLink" href="#leftMenu" title="좌측 서브 메뉴 바로가기">좌측 서브 메뉴 바로가기</a>
	<a class="accLink" href="#container" title="본문 내용 바로가기">본문 내용 바로가기</a>
	<a class="accLink" href="#footer" title="푸터로 바로 이동하기">푸터로 바로 이동하기</a>
	<!-- 대메뉴 영역 Start -->
	<div id="admin_header">
		<div class="admin_gnbMenu">
			<!-- gnb menu Start -->
			<div id="admin_gnbList">
				<ul class="admin_gnbMenuList">
					<c:forEach var="gnbList" items="${menuGnbList }" varStatus="j">
						<c:if test="${fn:indexOf(gnbList.authCheck, sessionScope.sessionAuth) > -1}">
							<li><a href="javascript:fncKwsLink('${gnbList.menuUrl }', '${gnbList.menuCode }');" title="${gnbList.menuExplain }" <c:if test="${fn:substring(gnbList.menuCode,0,4) eq fn:substring(searchVO.gnbMenuCd,0,4) and msg ne 'mainChk' }" >style='color:red;'</c:if> ><c:out value="${gnbList.menuNm }" /></a></li>
							<c:if test="${menuGnbListCnt ne j.count }">
								<li>|</li>
							</c:if>
						</c:if>
					</c:forEach>
				</ul>				                    
			</div>
			<!-- gnb menu End -->
		</div>
		<div class="admin_comment">
			<c:choose>
				<c:when test="${sessionScope.sAdminId eq '' || sessionScope.sAdminId == null}">
					KIWANISHOP&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    
					<a href="javascript:fncKwsLink('/admin/login/loginForm.do', '');" title="로그인" class="margin_l770" onkeypress="">Login</a>
				</c:when>
				<c:otherwise>
					${sessionScope.sAdminId} 님 환영합니다. 
					<a href="javascript:fncKwsLink('/admin/login/logout.do', '');" title="로그아웃" class="margin_l770" onkeypress="">Logout</a>	
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<hr />
	<!-- 대메뉴 영역 End -->
	<!-- 전체 컨텐츠 영역 Start -->
	<div id="admin_wrap">
		<c:if test="${msg ne 'mainChk'}">
			<!-- leftMemu Start -->
			<div id="admin_leftMenu">
				<img src="/static/admin/images/common/lnb/lnb_bg_top.gif" width="186" height="25" alt=""  />
				<div class="lnbMenu_bg">
					<h1 class="admin_lnbTit"><c:out value="${menuFirstNm }" /> </h1>
					<p class="padding_l2 left"><img src="/static/admin/images/common/admin/admin_lnb_line.gif" width="180" height="9" alt=""  /></p>
					<div>
						<ul class="lnb_menuList">
						<c:forEach var="lnbList" items="${menuLnbList }" varStatus="j">
							<c:if test="${fn:indexOf(lnbList.authCheck, sessionScope.sessionAuth) > -1}">
								<li>
									<c:choose>
										<c:when test="${lnbList.menuDepth eq '2' }">
											&nbsp;&nbsp;&nbsp;																				
										</c:when>
										<c:when test="${lnbList.menuDepth eq '3' }">
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;																				
										</c:when>
										<c:when test="${lnbList.menuDepth eq '4' }">
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;																				
										</c:when>
									</c:choose>
									<a href="javascript:fncKwsLink('${lnbList.menuUrl }', '${lnbList.menuCode }');" class="lnbList" title="${lnbList.menuExplain }" onkeypress="" <c:if test="${lnbList.menuCode eq searchVO.gnbMenuCd or (fn:substring(searchVO.gnbMenuCd,4,16) eq '000000000000' and fn:substring(lnbList.menuCode,4,8) eq '0001') }" >style='color:red;'</c:if>  ><c:out value="${lnbList.menuNm }" /></a>
								</li>
							</c:if>
						</c:forEach>
						</ul>
					</div>
	            </div>
				<img src="/static/admin/images/common/lnb/lnb_bg_btm.gif" width="186" height="32" alt=""  />
			</div>
			<!-- leftMemu End -->
		</c:if>
		<hr />