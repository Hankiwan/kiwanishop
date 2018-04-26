package egovframework.admin.login.service;

import javax.servlet.http.HttpServletRequest;

/**  
 * @Class Name : KwsLoginManageService.java
 * @Description : KwsLoginManageService Class
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
public interface KwsLoginManageService {

	/**
	 * 회원인지 체크
	 * @param vo - 로그인정보가 담긴 KwsLoginManageVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	int memberChk(KwsLoginManageVO kwsLoginManageVO) throws Exception;
	
	/**
     * 로그인여부를 체크 한다.
     * @param HttpServletRequest request
     * @return 로그인여부 true/false
     * @exception Exception
    */
    boolean isLogin(HttpServletRequest request) throws Exception;
	
}
