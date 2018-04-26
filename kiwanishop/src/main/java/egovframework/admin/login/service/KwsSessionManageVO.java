package egovframework.admin.login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import egovframework.admin.common.include.service.KwsIncludeManageVO;

/**  
 * @Class Name : KwsSessionManageVO.java
 * @Description : 세션 정보를 담고있는 Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2014.05.08           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2014. 05.08
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */

public class KwsSessionManageVO extends KwsIncludeManageVO {

	private static final long serialVersionUID = 1L;
	
	/** 아이디 */
	private String sUserId;
	
	/** 로그인 여부 */
	private boolean isLogin;

	public String getsUserId() {
		return sUserId;
	}

	public void setsUserId(String sUserId) {
		this.sUserId = sUserId;
	}
	
	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	/**
	 * 세션에 있는 사용자정보를 SessionVO에 셋팅하는 생성자
	 * @param request
	 */
	public KwsSessionManageVO(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute("sAdminId") != null && !session.getAttribute("sAdminId").equals("")){
			isLogin = true;
		}else{
			isLogin = false;
		}
	}
	
	
}
