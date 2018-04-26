package egovframework.home.commonBoard.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import egovframework.home.commonBoard.service.KwsCommonBoardService;

/**  
 * @Class Name : KwsCommonBoardController.java
 * @Description : 기와니샵 로그인 controller
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

@Controller
public class KwsCommonBoardController {
	
	/** KwsCommonBoardService */
    @Resource(name = "kwsCommonBoardService")
    private KwsCommonBoardService kwsCommonBoardService;
	
	
	
}
