package egovframework.home.menu.service;

import egovframework.admin.common.KwsPageVO;

/**  
 * @Class Name : KwsMenuVO.java
 * @Description : 코드 정보를 담고있는 Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2014.08.18           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2014. 08.18
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */

public class KwsMenuVO extends KwsPageVO {

	/** 메뉴 코드 */
	private String menuCode;
	
	/** 메뉴 뎁스 */
	private String menuDepth;
	
	/** 메뉴 이름 */
	private String menuNm;
	
	/** 메뉴 설명  */
	private String menuExplain;
	
	/** 메뉴 오픈 권한 체크  */
	private String authCheck;
	
	/** 메뉴 오픈 여부  */
	private String openYn;
	
	/** 사용자, 관리자 메뉴 구분  */
	private String useGubun;
	
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
	
	/** 메뉴 코드 조회 시작 넘버 */
    private String startNum;
    
    /** 메뉴 코드 조회 종료 넘버 */
    private String endNum;
    
    /** 메뉴 URL */
	private String menuUrl;
	
	

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuDepth() {
		return menuDepth;
	}

	public void setMenuDepth(String menuDepth) {
		this.menuDepth = menuDepth;
	}

	public String getMenuNm() {
		return menuNm;
	}

	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}

	public String getMenuExplain() {
		return menuExplain;
	}

	public void setMenuExplain(String menuExplain) {
		this.menuExplain = menuExplain;
	}

	public String getAuthCheck() {
		return authCheck;
	}

	public void setAuthCheck(String authCheck) {
		this.authCheck = authCheck;
	}

	public String getOpenYn() {
		return openYn;
	}

	public void setOpenYn(String openYn) {
		this.openYn = openYn;
	}

	public String getUseGubun() {
		return useGubun;
	}

	public void setUseGubun(String useGubun) {
		this.useGubun = useGubun;
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

	public String getStartNum() {
		return startNum;
	}

	public void setStartNum(String startNum) {
		this.startNum = startNum;
	}

	public String getEndNum() {
		return endNum;
	}

	public void setEndNum(String endNum) {
		this.endNum = endNum;
	}
	
}
