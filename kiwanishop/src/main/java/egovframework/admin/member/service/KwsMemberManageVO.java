package egovframework.admin.member.service;

import egovframework.admin.common.KwsPageVO;

/**  
 * @Class Name : KwsMemberManageVO.java
 * @Description : 회원 정보를 담고있는 Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2014.05.16           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2014. 05.16
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */

public class KwsMemberManageVO extends KwsPageVO {

	/** 아이디 */
	private String userId;
	
	/** 이름 */
	private String userNm;
	
	/** 비밀번호  */
	private String passwd;
	
	/** 권한 구분  */
	private String authGubun;
	
	/** 삭제여부  */
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
    
    /** 메뉴 권한 체크 값 */
    private String[] chkbxMenu;
    
    /** 메뉴 코드 */
    private String menuCode;
    
    /** 메뉴 오픈 여부 */
    private String openYn;
    
    

	public String getOpenYn() {
		return openYn;
	}

	public void setOpenYn(String openYn) {
		this.openYn = openYn;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String[] getChkbxMenu() {
		return chkbxMenu;
	}

	public void setChkbxMenu(String[] chkbxMenu) {
		this.chkbxMenu = chkbxMenu;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getAuthGubun() {
		return authGubun;
	}

	public void setAuthGubun(String authGubun) {
		this.authGubun = authGubun;
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

}
