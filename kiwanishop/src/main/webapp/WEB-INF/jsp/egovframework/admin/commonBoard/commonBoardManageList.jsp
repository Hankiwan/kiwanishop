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
		if(jQuery("#searchMasterSn").val() == ""){
			alert("등록할 게시판을 선택해주세요.");
			return;
		}
		
		jQuery("#boardForm").attr("action", "/admin/commonBoard/commonBoardManageRegistForm.do");
		jQuery("#boardForm").submit();
	}
	
	function fncView(boardSn){
		jQuery("#boardSn").val(boardSn);
		jQuery("#boardForm").attr("action", "/admin/commonBoard/commonBoardManageView.do");
		jQuery("#boardForm").submit();
	}
	
	function fncList(){
		jQuery("#masterSn").val(jQuery("#searchMasterSn").val());
		jQuery("#boardForm").attr("action", "/admin/commonBoard/commonBoardManageList.do");
		jQuery("#boardForm").submit();
	}
	
	//페이지 이동
	function fn_page(pageNo) {
		jQuery("#pageIndex").val(pageNo);
		jQuery("#boardForm").attr("action", "/admin/commonBoard/commonBoardManageList.do");
		jQuery("#boardForm").submit();
	}
	
</script>
<!-- Content Start -->
<form name="boardForm" id="boardForm" method="post" >
	<input type="hidden" name="masterSn" id="masterSn" />
	<!-- 메뉴 코드 공통 start -->
	<input type="hidden" name="gnbMenuCd" id="gnbMenuCd" value="${searchVO.gnbMenuCd }" />
	<!-- 메뉴 코드 공통 end -->  
	<div id="container">
	<!-- title Start -->
	<div class="location">
		<h2 class="tit_h2">공통 게시판 관리 리스트</h2>
	</div>
	<!-- title End -->	
	<!-- searchBox Start -->
	<div class="searchBox margin_b15">
		<fieldset>
			<legend>검색하기</legend>
			<select name="searchMasterSn" id="searchMasterSn">
				<option value="">게시판 선택</option>
				<c:forEach var="masterList" items="${selectBoardManageList}" varStatus="status">
					<option value="${masterList.masterSn}" <c:if test="${searchVO.masterSn eq masterList.masterSn }">selected</c:if>><c:out value="${masterList.masterNm}" escapeXml="false" /></option>
				</c:forEach>
			</select>
			<select name="searchType" class="link_select02" title="검색조건 선택" onchange="">
				<option value="masterNm" <c:if test="${searchVO.searchType eq 'masterNm'}">selected</c:if>>게시판 이름</option>
				<option value="masterCn" <c:if test="${searchVO.searchType eq 'masterCn'}">selected</c:if>>게시판 설명</option>
			</select>
			<input type="text" name="searchValue" class="inputBox" size="46" value="<c:out value="${searchVO.searchValue}" />" maxlength="20" title="검색어 입력" />
			<a href="javascript:fncList();" title="검색하기"><img src="/static/admin/images/common/btn/btnc_search.gif" alt="검색하기" /></a>
		</fieldset>
	</div>
	<!-- searchBox End -->
		<!-- BOARD Start -->
		<div>
			<fieldset>
				<legend>공통 게시판 관리 리스트</legend>
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
						<caption>공통 게시판 관리 리스트</caption>
						<colgroup>
							<col width="10%" />
							<col width="40%" />
							<col width="25%" />
							<col width="25%" />
						</colgroup>
						<thead>
							<tr>
								<th scope="col">번호</th>		
								<th scope="col">제목</th>		
								<th scope="col">첨부파일</th>		
								<th scope="col">등록일자</th>		
							</tr>
						</thead>
						<tbody>
							<c:forEach var="bList" items="${selectCommonBoardManageList}" varStatus="status">
								<tr>
									<td><c:out value="${no}"/></td>
									<td><a href="javascript:fncView('<c:out value="${bList.boardSn}" />');"><c:out value="${bList.title}" escapeXml="false" /></a></td>
									<td><c:out value="${bList.fileId}" /></td>
									<td><c:out value="${bList.frstRegistDt}" /></td>
								</tr>
								<c:set var="no" value="${no-1}" />
							</c:forEach>
							<c:if test="${fn:length(selectCommonBoardManageList) == 0}">
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