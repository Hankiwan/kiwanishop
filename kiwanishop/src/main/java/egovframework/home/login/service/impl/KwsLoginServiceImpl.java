package egovframework.home.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.home.login.service.KwsLoginService;
import egovframework.home.login.service.KwsLoginVO;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**  
 * @Class Name : KwsLoginServiceImpl.java
 * @Description : KwsLogin Implement Class
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
@Service("kwsLoginService")
public class KwsLoginServiceImpl extends AbstractServiceImpl implements 
		KwsLoginService {

	/** KwsLoginDAO */
	@Resource(name="kwsLoginDAO")
	private KwsLoginDAO kwsLoginDAO;
	
	/**
	 * 회원인지 체크한다.
	 * @param vo - 로그인 정보가 담긴 KwsLoginVO
	 * @return 회원일시 return 1
	 * @exception Exception
	 */
    public int memberChk(KwsLoginVO kwsLoginVO) throws Exception {
    	log.debug(kwsLoginVO.toString());
    	
    	return kwsLoginDAO.memberChk(kwsLoginVO);
    	    	
    }
	
	
}
