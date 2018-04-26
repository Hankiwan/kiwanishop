package egovframework.home.commonBoard.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.home.login.service.KwsLoginVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**  
 * @Class Name : KwsCommonBoardDAO.java
 * @Description : KwsCommonBoardDAO Class
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

@Repository("kwsCommonBoardDAO")
public class KwsCommonBoardDAO extends EgovAbstractDAO {

	/**
	 * 회원인지 체크한다.
	 * @param vo - 로그인 정보가 담긴 KwsLoginVO
	 * @return 회원일 경우 return 1
	 * @exception Exception
	 */
	 public int memberChk(KwsLoginVO kwsLoginVO) throws Exception{
		 
		 return (Integer)getSqlMapClientTemplate().queryForObject("loginDAO.memberChk", kwsLoginVO);
	 }
	
}
