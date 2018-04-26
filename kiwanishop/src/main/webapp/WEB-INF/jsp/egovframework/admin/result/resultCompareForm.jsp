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

	jQuery(document).ready(function(){
		if("${msg}" != ""){
			alert("${msg}");
		}
	});

	//비교페이지 이동
	function fnc_compare(){
		var selectDate = jQuery("#selectDate").val();
		
		if(selectDate == ""){
			alert("선택된 년월이 1개이거나 없습니다.");
			return;
		}
		
		if(selectDate.indexOf(",") == -1){
			alert("비교년월 두개를 선택하세요.");
			return;
		}
		jQuery("#resultForm").attr("action", "/admin/result/resultCompare.do");
		jQuery("#resultForm").submit();
	}
	
	//년월 선택
	function fnc_select(){
		var registYear = jQuery("#registYear").val();
		var registMonth = jQuery("#registMonth").val();
		var selectDate = jQuery("#selectDate").val();
		
		if(selectDate != ""){
			if(selectDate.indexOf(",") != -1){
				alert("이미 두개의 비교년월이 선택되었습니다.");
				return;
			}else{
				if((registYear + registMonth) == selectDate){
					alert("이미 선택된 비교년월입니다. \n 다시 선택해주세요.");
					return;
				}else{
					jQuery("#selectDate").val(selectDate + "," + registYear + registMonth);	
				}
			}
		}else{
			jQuery("#selectDate").val(registYear + registMonth);
		}
	}
	
	function fnc_cancel(){
		jQuery("#selectDate").val("");
	}
</script>
<!-- Content Start -->
	<div id="container">
	<!-- title Start -->
	<div class="location">
		<h2 class="tit_h2">실적 관리 비교</h2>
	</div>
	<!-- title End -->
	<!-- BOARD Start -->
	<form name="resultForm" id="resultForm" method="post">
	<!-- 메뉴 코드 공통 start -->
	<input type="hidden" name="gnbMenuCd" id="gnbMenuCd" value="${searchVO.gnbMenuCd }" />
	<!-- 메뉴 코드 공통 end -->  
		<div class="clear_b">
			<fieldset>
			<legend>실적 관리 비교</legend>
				<table class="tbl_submit">
					<caption>실적 관리 비교</caption> 		                   
					<colgroup>
						<col width="15%" />
						<col />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">비교년월 선택</th>
							<td>
								<select name="registYear" id="registYear">
									<option value="2013">2013</option>
									<option value="2014">2014</option>
								</select>
								<select name="registMonth" id="registMonth">
									<option value="01">01</option>
									<option value="02">02</option>
									<option value="03">03</option>
									<option value="04">04</option>
									<option value="05">05</option>
									<option value="06">06</option>
									<option value="07">07</option>
									<option value="08">08</option>
									<option value="09">09</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
								</select>
								<a href="javascript:fnc_select();"><img src="/static/admin/images/common/btn/btn_select.gif" /></a>	
								<a href="javascript:fnc_cancel();"><img src="/static/admin/images/common/btn/btn_cancel.gif" /></a>							
							</td>
						</tr>
						<tr>
							<th scope="row">선택된 비교년월</th>
							<td><input type="text" name="selectDate" id="selectDate" readonly /></td>
						</tr>
					</tbody>
				</table>
				<!-- bbs btn Start -->
				<div class="overflow_h margin_t10">
					<div class="float_r"><a href="javascript:fnc_compare();"><img src="/static/admin/images/common/btn/btn_compare.gif" /></a></div>
				</div>
				<!-- bbs btn End -->
			</fieldset>
		</div>
		<!-- BOARD End -->
	</form>
	</div>
<!-- Content End -->
<jsp:include page="/admin/common/footer.do" />