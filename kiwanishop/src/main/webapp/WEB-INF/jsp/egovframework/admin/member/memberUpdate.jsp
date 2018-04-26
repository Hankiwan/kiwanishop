<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<jsp:include page="/admin/common/header.do" />

<script type="text/javascript" src="/static/admin/js/jquery.js"></script>
<script type="text/javascript">
	function fnc_update(){
		
		if(jQuery("#userNm").val() == ""){
			alert("이름을 작성해 주세요.");
			jQuery("#userNm").focus();
			return;
		}
		
		if(jQuery("#passwd1").val() == ""){
			alert("비밀번호를 작성해 주세요.");
			jQuery("#passwd1").focus();
			return;
		}
		
		if(jQuery("#passwd2").val() == ""){
			alert("비밀번호 확인을 작성해 주세요.");
			jQuery("#passwd2").focus();
			return;
		}
		
		if(jQuery("#passwd1").val() != jQuery("#passwd2").val()){
			alert("비밀번호를 다시 한번 확인해 주세요.");
			jQuery("#passwd1").focus();
			return;
		}
		
		jQuery("#passwd").val(jQuery("#passwd1").val());
		
		if(confirm("수정하시겠습니까?")){
			jQuery("#memberForm").attr("action", "/admin/member/memberUpdate.do");
			jQuery("#memberForm").submit();	
		}
	}
</script>
<!-- Content Start -->
	<div id="container">
	<!-- title Start -->
	<div class="location">
		<h2 class="tit_h2">회원 관리 수정</h2>
	</div>
	<!-- title End -->
	<!-- BOARD Start -->
	<form name="memberForm" id="memberForm" method="post" >
		<input type="hidden" name="userId" id="userId" value="<c:out value="${memberView.userId }" />">
		<input type="hidden" name="passwd" id="passwd" />
		<!-- 메뉴 코드 공통 start -->
		<input type="hidden" name="gnbMenuCd" id="gnbMenuCd" value="${searchVO.gnbMenuCd }" />
		<!-- 메뉴 코드 공통 end -->  
		<div class="clear_b">
			<fieldset>
			<legend>회원 관리 수정</legend>
				<table class="tbl_submit">
					<caption>회원 관리 수정</caption> 		                   
					<colgroup>
						<col width="15%" />
						<col />
						<col width="15%" />
						<col width="35%" />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">이름</th>
							<td>
								<input type="text" name="userNm" id="userNm" value="<c:out value="${memberView.userNm}" />" maxlength="50" />
							</td>
						</tr>
						<tr>
							<th scope="row">비밀번호</th>
							<td>
								<input type="password" name="passwd1" id="passwd1" maxlength="12" />
							</td>
						</tr>
						<tr>
							<th scope="row">비밀번호 확인</th>
							<td>
								<input type="password" name="passwd2" id="passwd2" maxlength="12" />
							</td>
						</tr>
						<tr>
							<th scope="row">권한 구분</th>
							<td>
								<select name="authGubun">
									<c:forEach var="authList" items="${authCodeList }" varStatus="j">
										<option value="${authList.codeNm }" <c:if test="${memberView.authGubun eq authList.codeNm }">selected</c:if>>${authList.codeDc }</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row">삭제 여부</th>
							<td>
								<select name="deleteYn" id="deleteYn">
									<option value="Y" <c:if test="${memberView.deleteYn eq 'Y' }">selected</c:if>>Y</option>
									<option value="N" <c:if test="${memberView.deleteYn eq 'N' }">selected</c:if>>N</option>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
				<!-- bbs btn Start -->
				<div class="overflow_h margin_t10">
					<div class="float_r"><a href="javascript:fnc_update();"><img src="/static/admin/images/common/btn/btn_modify.gif" /></a></div>
				</div>
				<!-- bbs btn End -->
			</fieldset>
		</div>
		<!-- BOARD End -->
	</form>
	</div>
<!-- Content End -->
<jsp:include page="/admin/common/footer.do" />