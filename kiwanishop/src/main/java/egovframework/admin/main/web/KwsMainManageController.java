package egovframework.admin.main.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.admin.login.service.KwsLoginManageService;
import egovframework.admin.main.service.KwsMainManageVO;
import egovframework.admin.result.service.KwsResultManageVO;
import egovframework.com.cmm.EgovMessageSource;

/**  
 * @Class Name : KwsMainManageController.java
 * @Description : 기와니샵 관리자 메인 controller
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

@Controller
public class KwsMainManageController {
	
	/** KwsLoginManageService */
    @Resource(name = "kwsLoginManageService")
    private KwsLoginManageService kwsLoginManageService;
    
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
	
	/**
	 * 메인 이동
	 * @param searchVO - 메인 정보가 담긴 KwsMainManageVO
	 * @param model
	 * @return "/admin/main/main"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/main/main.do")
	public String main(@ModelAttribute("searchVO") KwsMainManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsResultManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	model.addAttribute("msg", "mainChk");
		
		return "/admin/main/main";
	}
	
}
