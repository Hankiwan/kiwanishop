package egovframework.home.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.home.main.service.KwsMainVO;

/**  
 * @Class Name : KwsMainController.java
 * @Description : 기와니샵 메인 controller
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

@Controller
public class KwsMainController {
	
	/**
	 * 메인 이동
	 * @param searchVO - 메인 정보가 담긴 KwsMainVO
	 * @param model
	 * @return "/home/main/main"
	 * @exception Exception
	 */
	@RequestMapping(value="/home/main/main.do")
	public String main(@ModelAttribute("searchVO") KwsMainVO searchVO,
			ModelMap model)
			throws Exception {
		
			return "/home/main/main";
	}
	
}
