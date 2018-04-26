package egovframework.home.login.service;

/**  
 * @Class Name : KwsLoginService.java
 * @Description : KwsLoginService Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2013.04.16           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2013. 04.16
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */
public interface KwsLoginService {

	/**
	 * 회원인지 체크
	 * @param vo - 로그인정보가 담긴 KwsLoginVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	int memberChk(KwsLoginVO kwsLoginVO) throws Exception;
	
}
