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
		jQuery("#resultForm").attr("action", "/admin/result/resultRegistForm.do");
		jQuery("#resultForm").submit();
	}
	
	function fncView(resultMasterSn){
		jQuery("#resultMasterSn").val(resultMasterSn);
		jQuery("#resultForm").attr("action", "/admin/result/resultView.do");
		jQuery("#resultForm").submit();
	}
	
	function fncList(){
		jQuery("#resultForm").attr("action", "/admin/result/resultList.do");
		jQuery("#resultForm").submit();
	}
	
	//페이지 이동
	function fn_page(pageNo) {
		jQuery("#pageIndex").val(pageNo);
		jQuery("#resultForm").attr("action", "/admin/result/resultList.do");
		jQuery("#resultForm").submit();
	}
	
</script>
<!-- Content Start -->
<form name="resultForm" id="resultForm" method="post" >
	<!-- 메뉴 코드 공통 start -->
	<input type="hidden" name="gnbMenuCd" id="gnbMenuCd" value="${searchVO.gnbMenuCd }" />
	<!-- 메뉴 코드 공통 end -->  
	<div id="container">
	<!-- title Start -->
	<div class="location">
		<h2 class="tit_h2">실적 관리 리스트</h2>
	</div>
	<!-- title End -->	
	<!-- searchBox Start -->
	<div class="searchBox margin_b15">
		<fieldset>
			<legend>검색하기</legend>
			<select name="searchType" class="link_select02" title="검색조건 선택">
				<option value="searchYear" <c:if test="${searchVO.searchType eq 'searchYear'}">selected</c:if>>검색년도</option>
				<option value="searchMonth" <c:if test="${searchVO.searchType eq 'searchMonth'}">selected</c:if>>검색월</option>
				<option value="searchYM" <c:if test="${searchVO.searchType eq 'searchYM'}">selected</c:if>>검색년월</option>
			</select>
			<input type="text" name="searchValue" class="inputBox" size="46" value="<c:out value="${searchVO.searchValue}" />" maxlength="6" title="검색어 입력" />
			<a href="javascript:fncList();" title="검색하기"><img src="/static/admin/images/common/btn/btnc_search.gif" alt="검색하기" /></a>
		</fieldset>
	</div>
	<!-- searchBox End -->
		<!-- BOARD Start -->
		<div>
			<fieldset>
				<legend>실적관리 리스트</legend>
					<input name="resultMasterSn" id="resultMasterSn" type="hidden" />
					<input name="pageIndex" id="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>" />
					
					<c:choose>
						<c:when test="${searchVO.pageIndex != 1}">
							<c:set var="no" value="${paginationInfo.totalRecordCount - ((searchVO.pageIndex-1)*searchVO.pageSize)}" />
						</c:when>
						<c:otherwise>
							<c:set var="no" value="${paginationInfo.totalRecordCount}" />
						</c:otherwise>
					</c:choose>
					<table class="bbs_list">
						<caption>실적관리 게시판 리스트</caption>
						<colgroup>
							<col width="20%" />
							<col width="30%" />
							<col width="20%" />
							<col width="30%" />
						</colgroup>
						<thead>
							<tr>
								<th scope="col">번호</th>		
								<th scope="col">실적년도</th>		
								<th scope="col">실적월</th>		
								<th scope="col">등록일자</th>		
							</tr>
						</thead>
						<tbody>
							<c:forEach var="result" items="${resultList}" varStatus="status">
								<tr>
									<td><c:out value="${no}"/></td>
									<td><a href="javascript:fncView('<c:out value="${result.resultMasterSn}" />');"><c:out value="${result.registYear}" /></a></td>
									<td><a href="javascript:fncView('<c:out value="${result.resultMasterSn}" />');"><c:out value="${result.registMonth}" /></a></td>
									<td><c:out value="${result.frstRegistDt}" /></td>
								</tr>
								<c:set var="no" value="${no-1}" />
							</c:forEach>
							<c:if test="${fn:length(resultList) == 0}">
								<tr>
									<td colspan="4"><spring:message code="common.nodata.msg" /></td>
								</tr>
							</c:if>
						</tbody>
					</table>
					<div class="paging"><!-- PAGING START -->
						<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_page" />
						<div class='r_btn'><a href="javascript:fnc_regist();"><img src="/static/admin/images/common/btn/btn_register.gif" /></a></div>
					</div><!-- //PAGING END --> 
			</fieldset>
		</div>
		<!-- BOARD End -->
	</div>
</form>
<!-- Content End -->
<jsp:include page="/admin/common/footer.do" />