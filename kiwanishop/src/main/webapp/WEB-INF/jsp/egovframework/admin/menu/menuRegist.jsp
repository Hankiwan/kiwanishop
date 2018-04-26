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
		
		if(jQuery("#menuNm").val() == ""){
			alert("메뉴 이름을 작성해 주세요.");
			jQuery("#menuNm").focus();
			return;
		}
		
		if(jQuery("#menuExplain").val() == ""){
			alert("메뉴 설명을 작성해 주세요.");
			jQuery("#menuExplain").focus();
			return;
		}
		
		if(jQuery("#menuUrl").val() == ""){
			alert("메뉴 URL을 작성해 주세요.");
			jQuery("#menuUrl").focus();
			return;
		}
		
		var authCheckStr = "";
		if(jQuery("input:checked[name='arrayAuthCheck']:checked").length > 0){
			jQuery("input:checkbox[name=arrayAuthCheck]:checked").each(function(index){
				if(jQuery("input:checked[name='arrayAuthCheck']:checked").length == (index+1)){
					authCheckStr += this.value;					
				}else{
					authCheckStr += this.value + ",";
				}
			});
			jQuery("#authCheck").val(authCheckStr);
		}else{
			alert("권한 설정을 체크해주세요.");
			return;
		}
		
		if(jQuery("#menuDepth").val() == ""){
			jQuery("#menuDepth").val("1");
		}else if(jQuery("#menuDepth").val() == "1"){
			jQuery("#menuDepth").val("2");
		}else if(jQuery("#menuDepth").val() == "2"){
			jQuery("#menuDepth").val("3");
		}else if(jQuery("#menuDepth").val() == "3"){
			jQuery("#menuDepth").val("4");
		}
		
		if(confirm("등록하시겠습니까?")){
			jQuery("#menuForm").attr("action", "/admin/menu/menuRegist.do");
			jQuery("#menuForm").submit();	
		}
	}
</script>
<!-- Content Start -->
	<div id="container">
	<!-- title Start -->
	<div class="location">
		<h2 class="tit_h2">메뉴 관리 등록</h2>
	</div>
	<!-- title End -->
	<!-- BOARD Start -->
	<form name="menuForm" id="menuForm" method="post" >
		<input type="hidden" name="authCheck" id="authCheck" />
		<input type="hidden" name="menuCode" id="menuCode" value="${menuView eq 'emp' ? '' : menuView.menuCode }" />
		<input type="hidden" name="menuDepth" id="menuDepth" value="${menuView eq 'emp' ? '' : menuView.menuDepth }" />
		<!-- 메뉴 코드 공통 start -->
		<input type="hidden" name="gnbMenuCd" id="gnbMenuCd" value="${searchVO.gnbMenuCd }" />
		<!-- 메뉴 코드 공통 end -->  
		<div class="clear_b">
			<fieldset>
			<legend>메뉴 관리 등록</legend>
				<table class="tbl_submit">
					<caption>메뉴 관리 등록</caption> 		                   
					<colgroup>
						<col width="15%" />
						<col />
						<col width="15%" />
						<col width="35%" />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">메뉴 이름</th>
							<td>
								<input type="text" name="menuNm" id="menuNm" maxlength="50" />
							</td>
						</tr>
						<tr>
							<th scope="row">메뉴 설명</th>
							<td>
								<textarea name="menuExplain" id="menuExplain" rows="" cols=""></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row">메뉴 URL</th>
							<td>
								<input type="text" name="menuUrl" id="menuUrl" maxlength="300" size="100" />
							</td>
						</tr>
						<tr>
							<th scope="row">권한 설정</th>
							<td>
								<c:forEach var="authList" items="${authcodeList }" varStatus="j">
									<input type="checkbox" name="arrayAuthCheck" id="arrayAuthCheck" value="<c:out value="${authList.codeNm }" />" /> <c:out value="${authList.codeNm }" />
								</c:forEach>
							</td>
						</tr>
						<tr>
							<th scope="row">오픈 여부</th>
							<td>
								<select name="openYn" id="openYn">
									<option value="Y">사용</option>
									<option value="N">사용안함</option>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row">사용 구분</th>
							<td>
								<select name="useGubun" id="useGubun">
									<c:forEach var="useList" items="${useGubunList }" varStatus="j">
										<option value="${useList.codeNm }"><c:out value="${useList.codeNm }" /></option>
									</c:forEach>
								</select>
							</td>
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