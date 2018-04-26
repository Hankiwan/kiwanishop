package egovframework.home.oilInfo.oilInfo.service;

/**  
 * @Class Name : OilInfoVO.java
 * @Description : 주유소 정보를 담고있는 Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2016.11.11           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2016. 11.11
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */

public class OilInfoVO {

	private static final long serialVersionUID = 1L;
	
	/** 아이디 */
	private String userId;
	
	/** 패스워드 */
	private String passwd; 

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
	
	
	
	
	
	
}
