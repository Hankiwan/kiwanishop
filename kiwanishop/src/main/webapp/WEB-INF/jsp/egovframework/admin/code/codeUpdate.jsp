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
		
		if(jQuery("#codeNm").val() == ""){
			alert("코드명을 작성해 주세요.");
			jQuery("#codeNm").focus();
			return;
		}
		
		if(jQuery("#codeDc").val() == ""){
			alert("코드 설명을 작성해 주세요.");
			jQuery("#codeDc").focus();
			return;
		}
		
		if(confirm("수정하시겠습니까?")){
			jQuery("#codeForm").attr("action", "/admin/code/codeUpdate.do");
			jQuery("#codeForm").submit();	
		}
	}
</script>
<!-- Content Start -->
	<div id="container">
	<!-- title Start -->
	<div class="location">
		<h2 class="tit_h2">코드 관리 수정</h2>
	</div>
	<!-- title End -->
	<!-- BOARD Start -->
	<form name="codeForm" id="codeForm" method="post" >
		<input type="hidden" name="codeSn" id="codeSn" value="<c:out value="${codeView.codeSn}" />">
		<!-- 메뉴 코드 공통 start -->
		<input type="hidden" name="gnbMenuCd" id="gnbMenuCd" value="${searchVO.gnbMenuCd }" />
		<!-- 메뉴 코드 공통 end -->  
		<div class="clear_b">
			<fieldset>
			<legend>코드 관리 수정</legend>
				<table class="tbl_submit">
					<caption>코드 관리 수정</caption> 		                   
					<colgroup>
						<col width="15%" />
						<col />
						<col width="15%" />
						<col width="35%" />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">코드명</th>
							<td>
								<input type="text" name="codeNm" id="codeNm" maxlength="25" value="<c:out value="${codeView.codeNm}" />" />
							</td>
						</tr>
						<tr>
							<th scope="row">코드 설명</th>
							<td>
								<textarea name="codeDc" id="codeDc" rows="" cols=""><c:out value="${codeView.codeDc}" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row">사용 여부</th>
							<td>
								<select name="useYn">
									<option value="Y" <c:if test="${codeView.useYn eq 'Y' }">selected</c:if>>사용</option>
									<option value="N" <c:if test="${codeView.useYn eq 'N' }">selected</c:if>>사용안함</option>
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