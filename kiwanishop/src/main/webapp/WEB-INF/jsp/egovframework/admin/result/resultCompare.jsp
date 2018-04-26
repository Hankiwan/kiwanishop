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
		jQuery("#resultForm").attr("action", "/admin/result/resultCompareForm.do");
		jQuery("#resultForm").submit();
	}

</script>
<!-- Content Start -->
<div id="container">
	<!-- title Start -->
	<div class="location">
		<h2 class="tit_h2">실적 관리 비교 상세</h2>
	</div>
	<!-- title End -->	
	<!-- BOARD Start -->
	<div>
		<fieldset>
			<legend>실적 관리 비교 상세</legend>
			<form name="resultForm" id="resultForm" method="post" >
				<input type="hidden" name="resultMasterSn" id="resultMasterSn" />
				<!-- 메뉴 코드 공통 start -->
				<input type="hidden" name="gnbMenuCd" id="gnbMenuCd" value="${searchVO.gnbMenuCd }" />
				<!-- 메뉴 코드 공통 end -->  
				<span style="color:blue;"><c:out value="${firstCompareYear}" /> 년 <c:out value="${firstCompareMonth}" /> 월 / <c:out value="${secondCompareYear}" /> 년 <c:out value="${secondCompareMonth}" /> 월 비교</span> 
				<table class="bbs_list_result">
					<caption>실적 관리 비교 상세</caption>
					<colgroup>
						<col width="6%" />
						<col width="12%" />
						<col width="19%"/>
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
					</colgroup>
					<thead>
					<tr>
						<th colspan="3" rowspan="2" scope="col" class="bottom">구분</th>
						<th colspan="5" scope="col">VOLUME</th>
						<th rowspan="2" scope="col" class="bottom">건수</th>
						<th scope="col">PROFIT</th>
					</tr>
					<tr>
						<th scope="col" class="bottom">WEIGHT</th>
						<th scope="col" class="bottom">실화주</th>
						<th scope="col" class="bottom">FWD</th>
						<th scope="col" class="bottom">TOTAL</th>
						<th scope="col" class="bottom">TEU</th>
						<th scope="col" class="bottom">USD</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach var="resultView" items="${compareList}" varStatus="status">
					<tr>
						<td><c:out value="${resultView.gubunOne}" /></td>
						<td><c:out value="${resultView.gubunTwo}" /></td>
						<td><c:out value="${resultView.gubunThree}" /></td>
						<c:choose>
							<c:when test="${resultView.gubunTwo eq 'SUB.TOTAL'}">
								<td class="txtcolor">${resultView.totalOne}</td>
								<td class="txtcolor">${resultView.totalTwo}</td>
								<td class="txtcolor">${resultView.totalThree}</td>
								<td class="txtcolor">${resultView.totalFour}</td>
								<td class="txtcolor">${resultView.totalFive}</td>
								<td class="txtcolor">${resultView.totalSix}</td>
								<td class="txtcolor">${resultView.totalSeven}</td>
							</c:when>
							<c:otherwise>
								<td>${resultView.weight}</td>
								<td>${resultView.silwhaju}</td>
								<td>${resultView.fwd}</td>
								<td>${resultView.volumeTotal}</td>
								<td>${resultView.teu}</td>
								<td>${resultView.count}</td>
								<td>${resultView.profitUsd}</td>
							</c:otherwise>
						</c:choose>
					</tr>
					</c:forEach>
					</tbody>
				</table>
				<div class="paging"><!-- PAGING START -->
					<div class='r_btn'><a href="javascript:fncList();"><img src="/static/admin/images/common/btn/btn_list.gif"</a></div>
				</div><!-- //PAGING END --> 
			</form>
		</fieldset>
	</div>
	<!-- BOARD End -->
</div>
<!-- Content End -->
<jsp:include page="/admin/common/footer.do" />