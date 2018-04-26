<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<%
  /**
  * @Class Name : loginForm.jsp
  * @Description : 로그인 화면
  * @Modification Information
  * 
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2013.04.12            최초 생성
  *
  * author 기와니샵 개발팀 한기완
  * since 2013.04.12
  *  
  * Copyright (C) 2009 by MOPAS  All right reserved.
  */
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기와니샵 로그인폼</title>
<link rel="stylesheet" type="text/css" href="/static/home/css/unification.css" />
<link rel="stylesheet" type="text/css" href="/static/home/css/admin.css" />
<script type="text/javascript" src="/static/home/js/jquery.js"></script>
<script type="text/javascript">
	
	jQuery(document).ready(function(){
		if("${msg}" != ""){
 			alert("${msg}");
 		}
 		jQuery("#userId").focus();
	});

	function fn_login(){
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
		jQuery("#mainForm").submit();
	}
</script>

</head>
<body>
	<form name="mainForm" id="mainForm" method="post" >
		<input type="hidden" name="method" id="method" value="login" />
		<div id="admin_loginArea">
			<div class="adminLogo"></div>
			<!-- ROUND BOX Start -->
			<div><img src="/static/home/images/common/admin/roundbox_top.gif" width="538" height="20" alt="" /></div>
			<div class="admin_roundMid">
				<div class="admin_loginVisual"></div>
				<div class="admin_loginInput">
					<h1><img src="/static/home/images/common/admin/h1_adminlogin.gif" width="185" height="32" alt="Admin Login" /></h1>
					<fieldset>
						<legend>관리자 로그인</legend>
						<table width="285" cellpadding="0" cellspacing="0" border="0" class="margin_t20" summary="관리자 로그인 페이지 입니다.">
							<caption>관리자 로그인</caption>
							<colgroup>
								<col width="62px" />
								<col width="155px" />
								<col />
							</colgroup>
							<tbody>
								<tr>
									<td class="loginBlt"><label for="id">아이디</label></td>
									<td><input type="text" name="userId" id="userId" class="inputBox_08" size="" tabindex="1" value="" maxlength="20" /></td>
									<td rowspan="2"><a href="javascript:fn_login();"><img src="/static/home/images/common/btn/btnc_submit.gif" alt="확인" /></a></td>			
								</tr>
								<tr>
									<td class="loginBlt"><label for="passwd">비밀번호</label></td>
									<td><input type="password" name="passwd" id="passwd" class="inputBox_08" size="" tabindex="2" value="" maxlength="20" /></td>
								</tr>
							</tbody>
						</table>
					</fieldset>
				</div>
			</div>
			<div><img src="/static/home/images/common/admin/roundbox_btm.gif" width="538" height="20" alt="" /></div>
			<!-- ROUND BOX End --> 
			<!-- foot Start --> 
			<p class="admin_loginFoot">Copyright (C) Ministry of unification. All rights reserved.</p>
			<!-- foot End -->      
		</div>
	</form>
</body>
</html>