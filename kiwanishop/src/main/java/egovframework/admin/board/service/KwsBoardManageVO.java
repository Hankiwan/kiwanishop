package egovframework.admin.board.service;

import egovframework.admin.common.KwsPageVO;

/**  
 * @Class Name : KwsBoardManageVO.java
 * @Description : 게시판관리 정보를 담고있는 Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2014.06.17           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2014. 06.17
 * @version 1.0
 * @see
 * fffff
 *  Copyright (C) by MOPAS All right reserved.
 */

public class KwsBoardManageVO extends KwsPageVO {

	/** 게시판 관맂 일련번호 */
	private String masterSn;
	
	/** 게시판 관리 이름 */
	private String masterNm;
	
	/** 게시판 관리 설명 */
	private String masterCn;
	
	/** 비밀글 사용 여부 */
	private String secretYn;
	
	/** 에디터 사용 여부  */
	private String editorYn;
	
	/** 댓글 사용여부  */
	private String commentYn;
	
	/** 답글 사용여부  */
	private String replyYn;
	
	/** 파일 사용여부  */
	private String fileYn;
	
	/** 키워드 사용여부  */
	private String keywordYn;
	
	/** 삭제 여부  */
	private String deleteYn;
	
	/** 최초등록일  */
	private String frstRegistDt;

	/** 최초등록아이디  */
	private String frstRegistId;
	
	/** 최초등록아이피  */
	private String frstRegistIp;
	
	/** 최종수정일  */
	private String lastUpdtDt;
	
	/** 최종수정아이디  */
	private String lastUpdtId;
	
	/** 최종수정아이피  */
	private String lastUpdtIp;
	
	/** 검색 타입 */
    private String searchType;
    
    /** 검색 값 */
    private String searchValue;

	public String getMasterSn() {
		return masterSn;
	}

	public void setMasterSn(String masterSn) {
		this.masterSn = masterSn;
	}

	public String getMasterNm() {
		return masterNm;
	}

	public void setMasterNm(String masterNm) {
		this.masterNm = masterNm;
	}

	public String getMasterCn() {
		return masterCn;
	}

	public void setMasterCn(String masterCn) {
		this.masterCn = masterCn;
	}

	public String getSecretYn() {
		return secretYn;
	}

	public void setSecretYn(String secretYn) {
		this.secretYn = secretYn;
	}

	public String getEditorYn() {
		return editorYn;
	}

	public void setEditorYn(String editorYn) {
		this.editorYn = editorYn;
	}

	public String getCommentYn() {
		return commentYn;
	}

	public void setCommentYn(String commentYn) {
		this.commentYn = commentYn;
	}

	public String getReplyYn() {
		return replyYn;
	}

	public void setReplyYn(String replyYn) {
		this.replyYn = replyYn;
	}

	public String getFileYn() {
		return fileYn;
	}

	public void setFileYn(String fileYn) {
		this.fileYn = fileYn;
	}

	public String getKeywordYn() {
		return keywordYn;
	}

	public void setKeywordYn(String keywordYn) {
		this.keywordYn = keywordYn;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	public String getFrstRegistDt() {
		return frstRegistDt;
	}

	public void setFrstRegistDt(String frstRegistDt) {
		this.frstRegistDt = frstRegistDt;
	}

	public String getFrstRegistId() {
		return frstRegistId;
	}

	public void setFrstRegistId(String frstRegistId) {
		this.frstRegistId = frstRegistId;
	}

	public String getFrstRegistIp() {
		return frstRegistIp;
	}

	public void setFrstRegistIp(String frstRegistIp) {
		this.frstRegistIp = frstRegistIp;
	}

	public String getLastUpdtDt() {
		return lastUpdtDt;
	}

	public void setLastUpdtDt(String lastUpdtDt) {
		this.lastUpdtDt = lastUpdtDt;
	}

	public String getLastUpdtId() {
		return lastUpdtId;
	}

	public void setLastUpdtId(String lastUpdtId) {
		this.lastUpdtId = lastUpdtId;
	}

	public String getLastUpdtIp() {
		return lastUpdtIp;
	}

	public void setLastUpdtIp(String lastUpdtIp) {
		this.lastUpdtIp = lastUpdtIp;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

}
