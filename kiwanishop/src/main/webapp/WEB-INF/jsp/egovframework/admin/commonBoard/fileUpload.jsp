<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script language="javascript">
	var errMsg = '<c:out value="${errMsg }" />';
	var atchFileId = '<c:out value="${atchFileId}"/>';
	var fileName = '<c:out value="${fileName}"/>';
	var tempFileName = '<c:out value="${tempFileName}"/>';
	var fileStreCours = '<c:out value="${fileStreCours}"/>';
	var orignlFileNm = '<c:out value="${orignlFileNm}"/>';
	var fileExtsn = '<c:out value="${fileExtsn}"/>';
	var fileMg = '<c:out value="${fileMg}"/>';
	
	if(errMsg == ''){
		alert("사진이 등록되었습니다.");
		parent.fncFileAdd(atchFileId, fileName, tempFileName, fileStreCours, orignlFileNm, fileExtsn, fileMg);
	}else{
		alert(errMsg);
	}
</script>