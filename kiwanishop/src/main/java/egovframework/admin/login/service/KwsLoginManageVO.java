package egovframework.admin.login.service;

import egovframework.admin.common.include.service.KwsIncludeManageVO;

/**  
 * @Class Name : KwsLoginManageVO.java
 * @Description : 로그인 정보를 담고있는 Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2014.04.21           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2014. 04.21
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */

public class KwsLoginManageVO extends KwsIncludeManageVO {

	private static final long serialVersionUID = 1L;
	
	/** 아이디 */
	private String userId;
	
	/** 패스워드 */
	private String passwd; 
	
	/** 메세지 */
	private String msg; 
	
	/** 권한 구분 */
	private String authGubun;
	
	public String getAuthGubun() {
		return authGubun;
	}

	public void setAuthGubun(String authGubun) {
		this.authGubun = authGubun;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

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
