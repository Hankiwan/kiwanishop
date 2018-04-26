package egovframework.home.login.service;

/**  
 * @Class Name : KwsLoginVO.java
 * @Description : 로그인 정보를 담고있는 Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2013.04.12           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2013. 04.12
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */

public class KwsLoginVO {

	private static final long serialVersionUID = 1L;
	
	/** 아이디 */
	private String userId;
	
	/** 패스워드 */
	private String passwd; 

	public String getUserId() {
		return userId;
	}
	
	/** 메세지 */
	private String msg; 

	
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
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
