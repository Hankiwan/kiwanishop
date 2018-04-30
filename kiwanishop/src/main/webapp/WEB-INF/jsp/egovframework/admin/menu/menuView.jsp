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
		jQuery("#menuForm").attr("action", "/admin/menu/menuList.do");
		jQuery("#menuForm").submit();
	}
	
	function fncDelete(menuCode){
		if(confirm("삭제하시겠습니까?")){
			jQuery("#menuCode").val(menuCode);
			jQuery("#menuForm").attr("action", "/admin/menu/menuDelete.do");
			jQuery("#menuForm").submit();			
		}
	}
	
	function fncUpdateForm(menuCode){
		jQuery("#menuCode").val(menuCode);
		jQuery("#menuForm").attr("action", "/admin/menu/menuUpdateForm.do");
		jQuery("#menuForm").submit();
	}
	
	function fncRegist(menuCode){
		jQuery("#menuCode").val(menuCode);
		jQuery("#menuForm").attr("action", "/admin/menu/menuRegistForm.do");
		jQuery("#menuForm").submit();
	}
</script>
<!-- Content Start -->
<div id="container">
	<!-- title Start -->
	<div class="location">
		<h2 class="tit_h2">메뉴 관리 상세</h2>
	</div>
	<!-- title End -->	
	<!-- BOARD Start -->
	<div id="container">
		<fieldset>
			<legend>메뉴관리 상세</legend>
			<form name="menuForm" id="menuForm" method="post" >
				<input type="hidden" name="menuCode" id="menuCode" />
				<input type="hidden" name="useGubun" id="useGubun" value="${searchVO.useGubun }" />
				<!-- 메뉴 코드 공통 start -->
				<input type="hidden" name="gnbMenuCd" id="gnbMenuCd" value="${searchVO.gnbMenuCd }" />
				<!-- 메뉴 코드 공통 end -->  
				<table class="tbl_submit">
					<caption>메뉴 관리 상세</caption>
					<colgroup>
						<col width="15%" />
						<col width="85%" />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">메뉴 depth</th>
							<td colspan="3">
								<c:out value="${menuView.menuDepth }" />
							</td>
						</tr>
						<tr>
							<th scope="row">메뉴 이름</th>
							<td colspan="3">
								<c:out value="${menuView.menuNm }" escapeXml="false" />
							</td>
						</tr>
						<tr>
							<th scope="row">메뉴 설명</th>
							<td colspan="3">
								<% pageContext.setAttribute("LF", "\n"); %>
								<c:out value="${fn:replace(menuView.menuExplain, LF, '<br />')}" escapeXml="false" />
							</td>
						</tr>
						<tr>
							<th scope="row">메뉴 URL</th>
							<td colspan="3">
								<c:out value="${menuView.menuUrl}" />
							</td>
						</tr>
						<tr>
							<th scope="row">권한 설정</th>
							<td colspan="3">
								<c:out value="${menuView.authCheck}" />
							</td>
						</tr>
						<tr>
							<th scope="row">오픈 여부</th>
							<td colspan="3">
								<c:out value="${menuView.openYn}" />
							</td>
						</tr>
						<tr>
							<th scope="row">사용 구분</th>
							<td colspan="3">
								<c:out value="${menuView.useGubun}" />
							</td>
						</tr>
					</tbody>
				</table>
					<!-- bbs btn Start -->
				<div class="overflow_h margin_t10">
					<div class="float_l"><a href="javascript:fncList();"><img src="/static/admin/images/common/btn/btn_list.gif" alt="목록" /></a></div>
					<div class="float_r"><a href="javascript:fncUpdateForm('<c:out value="${menuView.menuCode }" />');"><img src="/static/admin/images/common/btn/btn_modify.gif" alt="수정하기" /></a></div>
					<div class="float_r"><a href="javascript:fncDelete('<c:out value="${menuView.menuCode }" />');"><img src="/static/admin/images/common/btn/btn_del.gif" alt="삭제하기" /></a></div>
					<c:if test="${menuView.menuDepth ne '4' }">
						<div class="float_r"><a href="javascript:fncRegist('<c:out value="${menuView.menuCode }" />');"><img src="/static/admin/images/common/btn/btn_register.gif" alt="하위메뉴등록하기" /></a></div>
					</c:if>
				</div>
				<!-- bbs btn End -->          
			</form>
		</fieldset>
	</div>
	<!-- BOARD End -->
</div>
<!-- Content End -->
<jsp:include page="/admin/common/footer.do" />