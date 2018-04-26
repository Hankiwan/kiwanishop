package egovframework.admin.login.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.admin.login.service.KwsLoginManageService;
import egovframework.admin.login.service.KwsLoginManageVO;
import egovframework.admin.member.service.KwsMemberManageService;
import egovframework.admin.member.service.KwsMemberManageVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.utl.util.Util;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**  
 * @Class Name : KwsLoginManageController.java
 * @Description : 기와니샵 관리자 로그인 controller
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
public class KwsLoginManageController {
	
	/** KwsLoginManageService */
    @Resource(name = "kwsLoginManageService")
    private KwsLoginManageService kwsLoginManageService;
    
    /** KwsMemberManageService */
    @Resource(name = "kwsMemberManageService")
    private KwsMemberManageService kwsMemberManageService;
    
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
	
	/**
	 * 로그인 폼 이동
	 * @param searchVO - 로그인 정보가 담긴 KwsLoginManageVO
	 * @param model
	 * @return "/admin/login/loginForm"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/login/loginForm.do")
	public String loginForm(@ModelAttribute("searchVO") KwsLoginManageVO searchVO,
			ModelMap model)
			throws Exception {
		
			if(!Util.isNull(searchVO.getMsg()).equals("")){
		    	model.addAttribute("msg", new String(searchVO.getMsg().getBytes("8859_1"), "UTF-8"));
	    	}
		
			return "/admin/login/loginForm";
	}
	
	/**
	 * 로그인 처리
	 * @param searchVO - 로그인 정보가 담긴 KwsLoginManageVO
	 * @param model
	 * @return "redirect:/admin/main/main.do"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/login/login.do")
	public String login(@ModelAttribute("searchVO") KwsLoginManageVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model)
			throws Exception{
		
			HttpSession session = request.getSession();
			
			String loginChk = "";
			
			int memberChk = kwsLoginManageService.memberChk(searchVO);
			
			KwsMemberManageVO memberVO = new KwsMemberManageVO();
			memberVO.setUserId(searchVO.getUserId());
			EgovMap memberView = kwsMemberManageService.selectMemberView(memberVO);

			if(memberChk > 0){
				session.setAttribute("sAdminId", memberView.get("userId"));
				session.setAttribute("sessionAuth", memberView.get("authGubun"));
				loginChk = "redirect:/admin/main/main.do";
			}else{
				model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.idpw"));
				loginChk =  "redirect:/admin/login/loginForm.do";
			}
			
			return loginChk;
	}
	
	/**
	 * 로그아웃 처리
	 * @param searchVO - 로그인 정보가 담긴 KwsLoginManageVO
	 * @param model
	 * @return "redirect:/admin/login/loginout.do"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/login/logout.do")
	public String logout(@ModelAttribute("searchVO") KwsLoginManageVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model)
			throws Exception{
		
			HttpSession session = request.getSession();
			
			session.invalidate();

			
			return "redirect:/admin/login/loginForm.do";
	}
	
}
