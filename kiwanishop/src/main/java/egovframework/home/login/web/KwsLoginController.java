package egovframework.home.login.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.utl.util.Util;
import egovframework.home.login.service.KwsLoginService;
import egovframework.home.login.service.KwsLoginVO;

/**  
 * @Class Name : KwsLoginController.java
 * @Description : 기와니샵 로그인 controller
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
public class KwsLoginController {
	
	/** KwsLoginService */
    @Resource(name = "kwsLoginService")
    private KwsLoginService kwsLoginService;
    
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
	
	/**
	 * 로그인 폼 이동
	 * @param searchVO - 로그인 정보가 담긴 KwsLoginVO
	 * @param model
	 * @return "/home/login/loginForm"
	 * @exception Exception
	 */
	@RequestMapping(value="/home/login/loginForm.do")
	public String loginForm(@ModelAttribute("searchVO") KwsLoginVO searchVO,
			ModelMap model)
			throws Exception {
		
			if(!Util.isNull(searchVO.getMsg()).equals("")){
		    	model.addAttribute("msg", new String(searchVO.getMsg().getBytes("8859_1"), "UTF-8"));
	    	}
		
			return "/home/login/loginForm";
	}
	
	/**
	 * 로그인 처리
	 * @param searchVO - 로그인 정보가 담긴 KwsLoginVO
	 * @param model
	 * @return "redirect:/home/main/main.do"
	 * @exception Exception
	 */
	@RequestMapping(value="/home/login/login.do")
	public String login(@ModelAttribute("searchVO") KwsLoginVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model)
			throws Exception{
		
			HttpSession session = request.getSession();
			
			String loginChk = "";
			
			int memberChk = kwsLoginService.memberChk(searchVO);

			if(memberChk > 0){
				session.setAttribute("sessionId", searchVO.getUserId());
				loginChk =  "redirect:/home/main/main.do";
			}else{
				model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.idpw"));
				loginChk =  "redirect:/home/login/loginForm.do";
			}
			
			return loginChk;
	}
	
	/**
	 * 로그아웃 처리
	 * @param searchVO - 로그인 정보가 담긴 KwsLoginVO
	 * @param model
	 * @return "redirect:/login/loginForm.do"
	 * @exception Exception
	 */
	@RequestMapping(value="/home/login/logout.do")
	public String logout(@ModelAttribute("searchVO") KwsLoginVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model)
			throws Exception{
		
			HttpSession session = request.getSession();
			
			session.invalidate();

			
			return "redirect:/home/main/main.do";
	}
	
}
