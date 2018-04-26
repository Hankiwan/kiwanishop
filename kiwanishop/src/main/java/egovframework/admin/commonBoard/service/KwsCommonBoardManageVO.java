package egovframework.admin.commonBoard.service;

import java.util.List;

import egovframework.admin.common.KwsPageVO;
import egovframework.com.cmm.service.FileVO;

/**  
 * @Class Name : KwsCommonBoardManageVO.java
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
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */

public class KwsCommonBoardManageVO extends KwsPageVO {

	/** 공통 게시판 관련 일련번호 */
	private String boardSn;
	
	/** 게시판 관련 일련번호 */
	private String masterSn;
	
	/** 공통 게시판 제목 */
	private String title;
	
	/** 공통 게시판 내용 */
	private String boardCn;
	
	/** 비밀글 사용 여부 */
	private String secretUseYn;
	
	/** 파일 아이디 */
	private String fileId;
	
	/** 키워드  */
	private String keyword;
	
	/** 카운트  */
	private String cnt;
	
	/** 답글 플래그  */
	private String replyFlag;
	
	/** 부모 일련번호  */
	private String parentNum;
	
	/** 답글 lc  */
	private String replyLc;
	
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
	
	/** well order */
    private String wellOrder;
    
    /** 삭제 여부 */
    private String deleteYn;
    
    /** board no */
    private String boardNo;
    
    /** 검색 타입 */
    private String searchType;
    
    /** 검색 값 */
    private String searchValue;
    
    /** 비밀글 비밀번호 */
    private String secretNum;
    
    /** 파일정보 리스트 */
    private List<FileVO> files = null;
    
    /** 파일정보 */
    private FileVO file = null;
    
	/** 첨부파일ID */
	private String atchFileId = "";
    

	public FileVO getFile() {
		return file;
	}

	public void setFile(FileVO file) {
		this.file = file;
	}

	public String getAtchFileId() {
		return atchFileId;
	}

	public void setAtchFileId(String atchFileId) {
		this.atchFileId = atchFileId;
	}

	public List<FileVO> getFiles() {
		return files;
	}

	public void setFiles(List<FileVO> files) {
		this.files = files;
	}

	public String getSecretNum() {
		return secretNum;
	}

	public void setSecretNum(String secretNum) {
		this.secretNum = secretNum;
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

	public String getBoardSn() {
		return boardSn;
	}

	public void setBoardSn(String boardSn) {
		this.boardSn = boardSn;
	}

	public String getMasterSn() {
		return masterSn;
	}

	public void setMasterSn(String masterSn) {
		this.masterSn = masterSn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBoardCn() {
		return boardCn;
	}

	public void setBoardCn(String boardCn) {
		this.boardCn = boardCn;
	}

	public String getSecretUseYn() {
		return secretUseYn;
	}

	public void setSecretUseYn(String secretUseYn) {
		this.secretUseYn = secretUseYn;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCnt() {
		return cnt;
	}

	public void setCnt(String cnt) {
		this.cnt = cnt;
	}

	public String getReplyFlag() {
		return replyFlag;
	}

	public void setReplyFlag(String replyFlag) {
		this.replyFlag = replyFlag;
	}

	public String getParentNum() {
		return parentNum;
	}

	public void setParentNum(String parentNum) {
		this.parentNum = parentNum;
	}

	public String getReplyLc() {
		return replyLc;
	}

	public void setReplyLc(String replyLc) {
		this.replyLc = replyLc;
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

	public String getWellOrder() {
		return wellOrder;
	}

	public void setWellOrder(String wellOrder) {
		this.wellOrder = wellOrder;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

}
