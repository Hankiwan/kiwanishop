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
<link rel="stylesheet" type="text/css" href="/static/home/css/unification.css" />
<link rel="stylesheet" type="text/css" href="/static/home/css/admin.css" />
<link rel="stylesheet" type="text/css" href="/static/home/css/jquery-ui.css" />
<script src="/static/home/js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="/static/home/jQueryPlugIn/js/jquery-ui-1.8.5.custom.min.js" type="text/javascript"></script>
<script src="/static/home/js/globalURL.js" type="text/javascript"></script>
<script src="/static/home/js/common.js" type="text/javascript"></script>
<script type="text/javascript">
	jQuery(document).ready(function(){
			<c:if test="${param.msg == '99'}" >
				alert("아이디 및 비밀번호가 올바르지 않습니다. \n 다시 로그인해주세요.");
			</c:if>
	});
	
	//로그인, 로그아웃
	function fncLoginout(val){
		if(val == "login"){
			if(jQuery("#userId").val() == ""){
				alert("아이디를 입력하세요.");
				jQuery("#userId").focus();
				return;
			}
			if(jQuery("#passwd").val() == ""){
				alert("비밀번호를 입력하세요.");
				jQuery("#passwd").focus();
				return;
			}
			
			jQuery("#mainForm").attr("action", "/home/login/login.do");
		}else{
			jQuery("#mainForm").attr("action", "/home/login/logout.do");			
		}
		jQuery("#mainForm").submit();
	}
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
		<div class="admin_logo"></div>
		<div class="admin_gnbMenu">
			<!-- gnb menu Start -->
			<div id="admin_gnbList">
				<ul class="admin_gnbMenuList">
					<c:forEach var="gnbList" items="${menuGnbList }" varStatus="j">
						<c:if test="${fn:indexOf(gnbList.authCheck, sessionScope.sessionAuth) > -1}">
							<li><a href="javascript:fncKwsLink('${gnbList.menuUrl }', '${gnbList.menuCode }');" title="${gnbList.menuExplain }"><c:out value="${gnbList.menuNm }" /></a></li>
							<c:if test="${menuGnbListCnt ne j.count }">
								<li>|</li>
							</c:if>
						</c:if>
					</c:forEach>
				</ul>				                    
			</div>
			<!-- gnb menu End -->
		</div>
		<form id="mainForm" name="mainForm" method="post" >
			<div class="admin_comment">
				<c:choose>
					<c:when test="${sessionScope.sessionId eq '' || sessionScope.sessionId == null}">
						KIWANISHOP
						<span name="" class="margin_l520" ></span>
						아이디 <input type="text" id="userId" name="userId" maxlength="20" size="15"  />
						비밀번호 <input type="password" id="passwd" name="passwd" maxlength="20" size="15" />
						<a href="javascript:fncLoginout('login');" title="로그인" class="margin_l10" onkeypress="">Login</a>
					</c:when>
					<c:otherwise>
						KIWANISHOP
						<span name="" class="margin_l620" ></span>
						${sessionScope.sessionId} 님 환영합니다. 
						<a href="javascript:fncLoginout('logout');" title="로그아웃" class="margin_l10" onkeypress="">Logout</a>	
					</c:otherwise>
				</c:choose>
			</div>
		</form>
	</div>
	<hr />
	<!-- 대메뉴 영역 End -->
	<!-- 전체 컨텐츠 영역 Start -->
	<div id="admin_wrap">
		<!-- leftMemu Start -->
		<div id="admin_leftMenu">
			<img src="/static/home/images/common/lnb/lnb_bg_top.gif" width="186" height="25" alt=""  />
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
								<a href="javascript:fncKwsLink('${lnbList.menuUrl }', '${lnbList.menuCode }');" class="lnbList" title="${lnbList.menuExplain }" onkeypress="" <c:if test="${lnbList.menuCode eq searchVO.gnbMenuCd }" >style='color:red;'</c:if>  ><c:out value="${lnbList.menuNm }" escapeXml="false" /></a>
							</li>
						</c:if>
					</c:forEach>
					</ul>
				</div>
            </div>
			<img src="/static/home/images/common/lnb/lnb_bg_btm.gif" width="186" height="32" alt=""  />
		</div>
		<!-- leftMemu End -->
		<hr />