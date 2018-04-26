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
	function fnc_regist(){
		
		if(jQuery("#resultFileUploader").val() == ""){
			alert("파일을 선택해 주세요.");
			return;
		}
		
		if(confirm("등록하시겠습니까?")){
			jQuery("#resultForm").attr("action", "/admin/result/resultRegist.do");
			jQuery("#resultForm").submit();	
		}
	}
</script>
<!-- Content Start -->
	<div id="container">
	<!-- title Start -->
	<div class="location">
		<h2 class="tit_h2">실적 관리 등록</h2>
	</div>
	<!-- title End -->
	<!-- BOARD Start -->
	<form name="resultForm" id="resultForm" method="post" enctype="multipart/form-data" >
	<!-- 메뉴 코드 공통 start -->
	<input type="hidden" name="gnbMenuCd" id="gnbMenuCd" value="${searchVO.gnbMenuCd }" />
	<!-- 메뉴 코드 공통 end -->  
		<div class="clear_b">
			<fieldset>
			<legend>실적 관리 등록</legend>
				<table class="tbl_submit">
					<caption>실적 관리 등록</caption> 		                   
					<colgroup>
						<col width="15%" />
						<col />
						<col width="15%" />
						<col width="35%" />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">해당년월 선택</th>
							<td>
								<select name="registYear">
									<c:forEach var="yearList" items="${yearCodeList}" varStatus="j">
										<option value="${yearList.codeNm }">${yearList.codeNm }</option>
									</c:forEach>
								</select>
								<select name="registMonth">
									<c:forEach var="monthList" items="${monthCodeList}" varStatus="j">
										<option value="${monthList.codeNm }">${monthList.codeNm }</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row">엑셀파일 등록</th>
							<td><input name="file_1" id="resultFileUploader" type="file" /></td>
						</tr>
					</tbody>
				</table>
				<!-- bbs btn Start -->
				<div class="overflow_h margin_t10">
					<div class="float_r"><a href="javascript:fnc_regist();"><img src="/static/admin/images/common/btn/btn_register.gif" /></a></div>
				</div>
				<!-- bbs btn End -->
			</fieldset>
		</div>
		<!-- BOARD End -->
	</form>
	</div>
<!-- Content End -->
<jsp:include page="/admin/common/footer.do" />