package egovframework.home.commonBoard.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.home.commonBoard.service.KwsCommonBoardService;
import egovframework.home.login.service.KwsLoginVO;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**  
 * @Class Name : KwsCommonBoardServiceImpl.java
 * @Description : KwsCommonBoard Implement Class
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
@Service("kwsCommonBoardService")
public class KwsCommonBoardServiceImpl extends AbstractServiceImpl implements 
		KwsCommonBoardService {

	/** KwsCommonBoardDAO */
	@Resource(name="kwsCommonBoardDAO")
	private KwsCommonBoardDAO kwsBoardDAO;
	

	
	
}
