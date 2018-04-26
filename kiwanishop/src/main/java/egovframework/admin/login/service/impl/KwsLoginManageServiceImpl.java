package egovframework.admin.login.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import egovframework.admin.login.service.KwsLoginManageService;
import egovframework.admin.login.service.KwsLoginManageVO;
import egovframework.admin.login.service.KwsSessionManageVO;
import egovframework.com.uat.uia.service.SessionVO;
import egovframework.com.utl.util.SHA256;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**  
 * @Class Name : KwsLoginManageServiceImpl.java
 * @Description : KwsLoginManage Implement Class
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
@Service("kwsLoginManageService")
public class KwsLoginManageServiceImpl extends AbstractServiceImpl implements 
		KwsLoginManageService {

	/** KwsLoginManageDAO */
	@Resource(name="kwsLoginManageDAO")
	private KwsLoginManageDAO kwsLoginManageDAO;
	
	/**
	 * 회원인지 체크한다.
	 * @param vo - 로그인 정보가 담긴 KwsLoginManageVO
	 * @return 회원일시 return 1
	 * @exception Exception
	 */
    public int memberChk(KwsLoginManageVO kwsLoginManageVO) throws Exception {
    	log.debug(kwsLoginManageVO.toString());
    	
    	SHA256 sha256 = new SHA256();
    	kwsLoginManageVO.setPasswd(sha256.getSHA256(kwsLoginManageVO.getPasswd()));
    	
    	return kwsLoginManageDAO.memberChk(kwsLoginManageVO);
    	    	
    }
    
    /**
	 * 로그인여부를 체크 한다.
	 * @param HttpServletRequest request
	 * @return 로그인여부 true/false
	 * @exception Exception
	 */
	public boolean isLogin(HttpServletRequest request) throws Exception {

		boolean isLogin = false;

		KwsSessionManageVO sVO = new KwsSessionManageVO(request);
    	if(sVO.isLogin()) {
    		isLogin = true; // 로그인 되었을경우
    	}else{
    		isLogin = false; // 로그인 안되었을경우
    	}

		return isLogin;
	}
	
	
}
