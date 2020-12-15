<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<jsp:include page="/admin/common/header.do" />

<!-- <script type="text/javascript" src="/static/admin/js/jquery.js"></script> -->
<script type="text/javascript" src="/static/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
	function fnc_regist(val){
		
		if(jQuery("#title").val() == ""){
			alert("제목을 작성해 주세요.");
			jQuery("#title").focus();
			return;
		}
		
		if(jQuery("input:checkbox[id='secUseYnChk']").is(":checked")){
			jQuery("#secretUseYn").val("Y");
			if(jQuery("#secretNum").val() == ""){
				alert("비밀번호를 작성해 주세요.");
				return;
			}
		}else{
			jQuery("#secretUseYn").val("N");
		}
		
		if(val == "1"){
			if(CKEDITOR.instances.boardCn.getData() == ""){
				alert("내용을 작성해 주세요.");
				jQuery("#boardCn").focus();
				return;
			}			
		}else{
			if(jQuery("#boardCn").val() == ""){
				alert("내용을 작성해 주세요.");
				jQuery("#boardCn").focus();
				return;
			}
		}
		
		if(confirm("등록하시겠습니까?")){
			<c:if test="${selectMasterBoardManageView.fileYn eq 'Y'}">
				$("#bFile").remove();
				$("#fileImage").remove();
				jQuery("#boardForm").attr("target", "");
			</c:if>
			$("#boardForm").attr("enctype", "");
			jQuery("#boardForm").attr("action", "/admin/commonBoard/commonBoardManageRegist.do");
			jQuery("#boardForm").submit();
		}
	}
	
	function fncFileUpload(){
		if(jQuery("#atchFileId").val() != ""){
			alert("이미 파일을 선택하셨습니다.");
			return;
		}
		
		if(jQuery("#bFile").val() == ""){
			alert("파일을 선택해 주세요.");
			return;
		}
		
		jQuery("#boardForm").attr("action", "/admin/commonBoard/fileUpload.do");
		jQuery("#boardForm").attr("target", "hiddenFrame").submit();
	}
	
	function fncFileAdd(atchFileId, fileName, tempFileName, fileStreCours, orignlFileNm, fileExtsn, fileMg) {

		$("#fileArea").append(
				'<p id="photoNm">'+
				fileName+
				'</p>'
			);

		$("#photoNm").append(
				' <a href="javascript:fncFileDel(\''+tempFileName+'\');"><img alt="삭제" src="<c:url value="/static/home/images/common/btn/btnt_filedel.gif" />" class="middle"></a>'
				+'<input type="hidden" name="tempFileName" value="'+tempFileName+'" />'
				+'<input type="hidden" name="fileStreCourse" value="'+fileStreCours+'" />'
				+'<input type="hidden" name="orignlFileNm" value="'+orignlFileNm+'" />'
				+'<input type="hidden" name="fileExtsn" value="'+fileExtsn+'" />'
				+'<input type="hidden" name="fileMg" value="'+fileMg+'" />'
			);
		$("#atchFileId").val(atchFileId);

		$("#bFile").remove();
		$("#fileImage").remove();
		$("#fileInputArea").append("<input type=\"file\" name=\"file\" id=\"bFile\" /><a href=\"javascript:fncFileUpload();\" id=\"fileImage\" > <img src=\"/static/admin/images/common/btn/btnt_fileplus.gif\" /></a>");
		
	}
	
	function fncFileDel(tempFileName) {
		
		$("#deleteFileId").val(tempFileName);
		
		jQuery("#boardForm").attr("action", "/admin/commonBoard/fileDelete.do");
		jQuery("#boardForm").attr("target", "hiddenFrame").submit();
		
		$("#photoNm").remove();
		alert('사진이 삭제 되었습니다.');

		$("#deleteFileId").val("");
		
		$('#atchFileId').val("");
		
	}
	
</script>
<!-- Content Start -->
	<div id="container">
	<!-- title Start -->
	<div class="location">
		<h2 class="tit_h2">공통 게시판 관리 등록</h2>
	</div>
	<!-- title End -->
	<!-- BOARD Start -->
	<form name="boardForm" id="boardForm" method="post" enctype="multipart/form-data" >
		<input type="hidden" id="atchFileId" name="atchFileId" value="" />
		<input type="hidden" id="deleteFileId" name="deleteFileId" value="" />
		<!-- 메뉴 코드 공통 start -->
		<input type="hidden" name="gnbMenuCd" id="gnbMenuCd" value="${searchVO.gnbMenuCd }" />
		<input type="hidden" name="masterSn" id="masterSn" value="${selectMasterBoardManageView.masterSn }" />
		<!-- 메뉴 코드 공통 end -->  
		<div class="clear_b">
			<fieldset>
			<legend>공통 게시판 관리 등록</legend>
				<table class="tbl_submit">
					<caption>공통 게시판 관리 등록</caption> 		                   
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
							<th scope="row">등록할 게시판</th>
							<td>
								<c:out value="${selectMasterBoardManageView.masterNm}" />
							</td>
						</tr>
						<tr>
							<th scope="row">제목</th>
							<td>
								<input type="text" name="title" id="title" size="110" maxlength="70" />
							</td>
						</tr>
						<c:choose>
							<c:when test="${selectMasterBoardManageView.secretYn eq 'Y'}">
								<tr>
									<th scope="row">비밀글</th>
									<td>
										<input type="checkbox" name="secUseYnChk" id="secUseYnChk" />
										<input type="hidden" name="secretUseYn" id="secretUseYn" />
										<input type="password" name="secretNum" id="secretNum" />
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<input type="hidden" name="secretUseYn" id="secretUseYn" value="N" />
								<input type="hidden" name="secretNum" id="secretNum" value="" />
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${selectMasterBoardManageView.editorYn eq 'Y'}">
								<tr>
									<th scope="row">내용</th>
									<td>
										<textarea name="boardCn" id="boardCn" rows="5" cols=""></textarea>
										<script type="text/javascript">
											CKEDITOR.replace('boardCn');
										</script>
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<th scope="row">내용</th>
									<td>
										<textarea name="boardCn" id="boardCn" rows="5" cols=""></textarea>
									</td>
								</tr>
							</c:otherwise>
						</c:choose>
						<c:if test="${selectMasterBoardManageView.fileYn eq 'Y'}">
							<tr>
								<th scope="row">파일첨부</th>
								<td>
									<span id="fileInputArea">
										<input type="file" name="file" id="bFile" /><a href="javascript:fncFileUpload();" id="fileImage" ><img src="/static/admin/images/common/btn/btnt_fileplus.gif" /></a>
									</span>
									<div id="fileArea"></div>
								</td>
							</tr>
						</c:if>
						<c:choose>
							<c:when test="${selectMasterBoardManageView.keywordYn eq 'Y'}">
								<tr>
									<th scope="row">키워드</th>
									<td>
										<input type="text" name="keyword" id="keyword" size="110" maxlength="70" />
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<input type="hidden" name="keyword" id="keyword" value="" />
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
				<!-- bbs btn Start -->
				<div class="overflow_h margin_t10">
					<c:choose>
						<c:when test="${selectMasterBoardManageView.editorYn eq 'Y'}">
							<div class="float_r"><a href="javascript:fnc_regist('1');"><img src="/static/admin/images/common/btn/btn_register.gif" /></a></div>
						</c:when>
						<c:otherwise>
							<div class="float_r"><a href="javascript:fnc_regist('2');"><img src="/static/admin/images/common/btn/btn_register.gif" /></a></div>
						</c:otherwise>
					</c:choose>
				</div>
				<!-- bbs btn End -->
			</fieldset>
		</div>
		<!-- BOARD End -->
	</form>
	</div>
<!-- Content End -->
<iframe src="#" name="hiddenFrame" width="100%" height="0" title="파일업로드용 아이프레임"></iframe>
<jsp:include page="/admin/common/footer.do" />