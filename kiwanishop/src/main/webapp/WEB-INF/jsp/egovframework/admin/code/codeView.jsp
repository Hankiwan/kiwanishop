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
	function fncList(){
		jQuery("#codeForm").attr("action", "/admin/code/codeList.do");
		jQuery("#codeForm").submit();
	}
	
	function fncDelete(codeSn){
		if(confirm("삭제하시겠습니까?")){
			jQuery("#codeSn").val(codeSn);
			jQuery("#codeForm").attr("action", "/admin/code/codeDelete.do");
			jQuery("#codeForm").submit();			
		}
	}
	
	function fncUpdateForm(codeSn){
		jQuery("#codeSn").val(codeSn);
		jQuery("#codeForm").attr("action", "/admin/code/codeUpdateForm.do");
		jQuery("#codeForm").submit();
	}
</script>
<!-- Content Start -->
<div id="container">
	<!-- title Start -->
	<div class="location">
		<h2 class="tit_h2">코드 관리 상세</h2>
	</div>
	<!-- title End -->	
	<!-- BOARD Start -->
	<div id="container">
		<fieldset>
			<legend>코드관리 상세</legend>
			<form name="codeForm" id="codeForm" method="post" >
				<input type="hidden" name="codeSn" id="codeSn" />
				<!-- 메뉴 코드 공통 start -->
				<input type="hidden" name="gnbMenuCd" id="gnbMenuCd" value="${searchVO.gnbMenuCd }" />
				<!-- 메뉴 코드 공통 end -->  
				<table class="tbl_submit">
					<caption>코드 관리 상세</caption>
					<colgroup>
						<col width="15%" />
						<col width="85%" />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">아이디</th>
							<td colspan="3">
								<c:out value="${codeView.codeId }" />
							</td>
						</tr>
						<tr>
							<th scope="row">이름</th>
							<td colspan="3">
								<c:out value="${codeView.codeNm }" />
							</td>
						</tr>
						<tr>
							<th scope="row">코드 설명</th>
							<td colspan="3">
								<c:out value="${codeView.codeDc}" />
							</td>
						</tr>
						<tr>
							<th scope="row">사용 여부</th>
							<td colspan="3">
								<c:choose>
									<c:when test="${codeView.useYn eq 'Y' }">
										사용
									</c:when>
									<c:otherwise>
										사용안함
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</tbody>
				</table>
					<!-- bbs btn Start -->
				<div class="overflow_h margin_t10">
					<div class="float_l"><a href="javascript:fncList();"><img src="/static/admin/images/common/btn/btn_list.gif" alt="목록" /></a></div>
					<div class="float_r"><a href="javascript:fncUpdateForm('<c:out value="${codeView.codeSn }" />');"><img src="/static/admin/images/common/btn/btn_modify.gif" alt="수정하기" /></a></div>
					<div class="float_r"><a href="javascript:fncDelete('<c:out value="${codeView.codeSn }" />');"><img src="/static/admin/images/common/btn/btn_del.gif" alt="삭제하기" /></a></div>
				</div>
				<!-- bbs btn End -->          
			</form>
		</fieldset>
	</div>
	<!-- BOARD End -->
</div>
<!-- Content End -->
<jsp:include page="/admin/common/footer.do" />