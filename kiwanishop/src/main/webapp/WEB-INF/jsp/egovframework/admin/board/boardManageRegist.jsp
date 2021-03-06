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
		
		if(jQuery("#masterNm").val() == ""){
			alert("게시판 이름을 작성해 주세요.");
			jQuery("#masterNm").focus();
			return;
		}
		
		if(jQuery("#masterCn").val() == ""){
			alert("게시판 설명을 작성해 주세요.");
			jQuery("#masterCn").focus();
			return;
		}
		
		if(confirm("등록하시겠습니까?")){
			jQuery("#boardForm").attr("action", "/admin/board/boardManageRegist.do");
			jQuery("#boardForm").submit();	
		}
	}
	
</script>
<!-- Content Start -->
	<div id="container">
	<!-- title Start -->
	<div class="location">
		<h2 class="tit_h2">게시판 관리 등록</h2>
	</div>
	<!-- title End -->
	<!-- BOARD Start -->
	<form name="boardForm" id="boardForm" method="post" >
	<!-- 메뉴 코드 공통 start -->
	<input type="hidden" name="gnbMenuCd" id="gnbMenuCd" value="${searchVO.gnbMenuCd }" />
	<!-- 메뉴 코드 공통 end -->  
		<div class="clear_b">
			<fieldset>
			<legend>게시판 관리 등록</legend>
				<table class="tbl_submit">
					<caption>게시판 관리 등록</caption> 		                   
					<colgroup>
						<col width="15%" />
						<col />
						<col width="15%" />
						<col width="15%" />
						<col width="15%" />
						<col width="15%" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">게시판 이름</th>
							<td>
								<input type="text" name="masterNm" id="masterNm" size="110" maxlength="33" />
							</td>
						</tr>
						<tr>
							<th scope="row">게시판 설명</th>
							<td>
								<textarea name="masterCn" id="masterCn" rows="5" cols=""></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row">비밀글 사용 여부</th>
							<td>
								<select name="secretYn">
									<option value="Y">사용</option>
									<option value="N">사용안함</option>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row">에디터 사용 여부</th>
							<td>
								<select name="editorYn">
									<option value="Y">사용</option>
									<option value="N">사용안함</option>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row">댓글 사용 여부</th>
							<td>
								<select name="commentYn">
									<option value="Y">사용</option>
									<option value="N">사용안함</option>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row">답글 사용 여부</th>
							<td>
								<select name="replyYn">
									<option value="Y">사용</option>
									<option value="N">사용안함</option>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row">파일첨부 사용 여부</th>
							<td>
								<select name="fileYn">
									<option value="Y">사용</option>
									<option value="N">사용안함</option>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row">키워드 사용 여부</th>
							<td>
								<select name="keywordYn">
									<option value="Y">사용</option>
									<option value="N">사용안함</option>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row">삭제 여부</th>
							<td>
								<select name="deleteYn">
									<option value="Y">사용</option>
									<option value="N">사용안함</option>
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