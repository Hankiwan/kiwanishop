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
		jQuery("#boardForm").attr("action", "/admin/board/boardManageList.do");
		jQuery("#boardForm").submit();
	}
	
	function fncDelete(masterSn){
		if(confirm("삭제하시겠습니까?")){
			jQuery("#masterSn").val(masterSn);
			jQuery("#boardForm").attr("action", "/admin/board/boardManageDelete.do");
			jQuery("#boardForm").submit();			
		}
	}
	
	function fncUpdateForm(masterSn){
		jQuery("#masterSn").val(masterSn);
		jQuery("#boardForm").attr("action", "/admin/board/boardManageUpdateForm.do");
		jQuery("#boardForm").submit();
	}
</script>
<!-- Content Start -->
<div id="container">
	<!-- title Start -->
	<div class="location">
		<h2 class="tit_h2">게시판 관리 상세</h2>
	</div>
	<!-- title End -->	
	<!-- BOARD Start -->
	<div id="container">
		<fieldset>
			<legend>게시판 관리 상세</legend>
			<form name="boardForm" id="boardForm" method="post" >
				<input type="hidden" name="masterSn" id="masterSn" />
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
							<th scope="row">게시판 이름</th>
							<td colspan="3">
								<c:out value="${boardManageView.masterNm }" escapeXml="false" />
							</td>
						</tr>
						<tr>
							<th scope="row">게시판 설명</th>
							<td colspan="3">
								<% pageContext.setAttribute("LF", "\n"); %>
								<c:out value="${fn:replace(boardManageView.masterCn, LF, '<br />')}" escapeXml="false" />
							</td>
						</tr>
						<tr>
							<th scope="row">비밀글 사용 여부</th>
							<td colspan="3">
								<c:choose>
									<c:when test="${boardManageView.secretYn eq 'Y'}">사용</c:when>
									<c:otherwise>사용안함</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<th scope="row">에디터 사용 여부</th>
							<td colspan="3">
								<c:choose>
									<c:when test="${boardManageView.editorYn eq 'Y'}">사용</c:when>
									<c:otherwise>사용안함</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<th scope="row">댓글 사용 여부</th>
							<td colspan="3">
								<c:choose>
									<c:when test="${boardManageView.commentYn eq 'Y'}">사용</c:when>
									<c:otherwise>사용안함</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<th scope="row">답글 사용 여부</th>
							<td colspan="3">
								<c:choose>
									<c:when test="${boardManageView.replyYn eq 'Y'}">사용</c:when>
									<c:otherwise>사용안함</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<th scope="row">파일첨부 사용 여부</th>
							<td colspan="3">
								<c:choose>
									<c:when test="${boardManageView.fileYn eq 'Y'}">사용</c:when>
									<c:otherwise>사용안함</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<th scope="row">키워드 사용 여부</th>
							<td colspan="3">
								<c:choose>
									<c:when test="${boardManageView.keywordYn eq 'Y'}">사용</c:when>
									<c:otherwise>사용안함</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<th scope="row">삭제 여부</th>
							<td colspan="3">
								<c:choose>
									<c:when test="${boardManageView.deleteYn eq 'Y'}">사용</c:when>
									<c:otherwise>사용안함</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</tbody>
				</table>
					<!-- bbs btn Start -->
				<div class="overflow_h margin_t10">
					<div class="float_l"><a href="javascript:fncList();"><img src="/static/admin/images/common/btn/btn_list.gif" alt="목록" /></a></div>
					<div class="float_r"><a href="javascript:fncUpdateForm('<c:out value="${boardManageView.masterSn }" />');"><img src="/static/admin/images/common/btn/btn_modify.gif" alt="수정하기" /></a></div>
					<div class="float_r"><a href="javascript:fncDelete('<c:out value="${boardManageView.masterSn }" />');"><img src="/static/admin/images/common/btn/btn_del.gif" alt="삭제하기" /></a></div>
				</div>
				<!-- bbs btn End -->          
			</form>
		</fieldset>
	</div>
	<!-- BOARD End -->
</div>
<!-- Content End -->
<jsp:include page="/admin/common/footer.do" />