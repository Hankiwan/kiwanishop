package egovframework.admin.code.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.admin.code.service.KwsCodeManageService;
import egovframework.admin.code.service.KwsCodeManageVO;
import egovframework.admin.login.service.KwsLoginManageService;
import egovframework.admin.member.service.KwsMemberManageVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.utl.util.Util;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**  
 * @Class Name : KwsCodeManageController.java
 * @Description : 기와니샵 코드 controller
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2014.05.26           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2014. 05.26
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class KwsCodeManageController {
	
	/** KwsCodeManageService */
    @Resource(name = "kwsCodeManageService")
    private KwsCodeManageService kwsCodeManageService;
    
    /** KwsLoginManageService */
    @Resource(name = "kwsLoginManageService")
    private KwsLoginManageService kwsLoginManageService;
    
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
    
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertyService;

    /**
	 * 코드관리 리스트 페이지 이동
	 * @param searchVO - 코드 정보가 담긴 KwsCodeManageVO
	 * @param model
	 * @return "/admin/code/codeList"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/code/codeList.do")
	public String list(@ModelAttribute("searchVO") KwsCodeManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
			// 로그인체크
	    	if(!kwsLoginManageService.isLogin(request)) {
	    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
	    	       model.addAttribute("searchVO", new KwsCodeManageVO());
	    	      return "/admin/login/loginForm";
	    	}
	    	
	    	searchVO.setPageUnit(propertyService.getInt("pageUnit"));
	    	searchVO.setPageSize(propertyService.getInt("pageSize"));
	    	
	    	PaginationInfo paginationInfo = new PaginationInfo();
	    	
	    	paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
			paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
			paginationInfo.setPageSize(searchVO.getPageSize());
			
			searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
			searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
			searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
	    	
	    	Map<String, Object> codeMap = kwsCodeManageService.selectCodeList(searchVO);
	    	
	    	int totCnt = Integer.parseInt((String)codeMap.get("totalCnt"));
	    	
	    	paginationInfo.setTotalRecordCount(totCnt);	//실적 총갯수
	    	
	    	model.addAttribute("selectCodeList", codeMap.get("selectCodeList"));	//코드 리스트
	    	model.addAttribute("totalCnt", codeMap.get("totalCnt"));	//코드 총갯수
	    	model.addAttribute("paginationInfo", paginationInfo);	//페이징 정보
	    	
	    	if(!Util.isNull(searchVO.getMsg()).equals("")){
		    	model.addAttribute("msg", new String(searchVO.getMsg().getBytes("8859_1"), "UTF-8"));
	    	}
		
			return "/admin/code/codeList";
	}
	
	/**
	 * 코드관리 상세 페이지 이동
	 * @param searchVO - 코드 정보가 담긴 KwsCodeManageVO
	 * @param model
	 * @return "/admin/code/codeView"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/code/codeView.do")
	public String codeView(@ModelAttribute("searchVO") KwsCodeManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsCodeManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	EgovMap view = kwsCodeManageService.selectCodeView(searchVO);
    	model.addAttribute("codeView", view);
    	
    	return "/admin/code/codeView";
	}
	
	/**
	 * 코드관리 등록폼 페이지 이동
	 * @param searchVO - 코드 정보가 담긴 KwsCodeManageVO
	 * @param model
	 * @return "/admin/code/codeRegistForm"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/code/codeRegistForm.do")
	public String registForm(@ModelAttribute("searchVO") KwsCodeManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsCodeManageVO());
    	      return "/admin/login/loginForm";
    	}
		
		return "/admin/code/codeRegist";
	}
	
	/**
	 * 코드관리 등록
	 * @param searchVO - 코드 정보가 담긴 KwsCodeManageVO
	 * @param model
	 * @return "/admin/code/codeRegist"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/code/codeRegist.do")
	public String regist(@ModelAttribute("searchVO") KwsCodeManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsCodeManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	HttpSession session = request.getSession();
    	
    	String userId = (String)session.getAttribute("sAdminId");	//아이디
    	searchVO.setFrstRegistId(userId);
		searchVO.setLastUpdtId(userId);
    	
		String codeIp = request.getRemoteAddr();	//아이피
		searchVO.setFrstRegistIp(codeIp);
		searchVO.setLastUpdtIp(codeIp);
		
		String msg = kwsCodeManageService.insertCode(searchVO);
		
		model.addAttribute("msg", msg);
		model.addAttribute("gnbMenuCd", searchVO.getGnbMenuCd());
	
		return "redirect:/admin/code/codeList.do";
	}
	
	/**
	 * 코드관리 수정폼 페이지 이동
	 * @param searchVO - 코드 정보가 담긴 KwsCodeManageVO
	 * @param model
	 * @return "/admin/code/codeUpdateForm"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/code/codeUpdateForm.do")
	public String updateForm(@ModelAttribute("searchVO") KwsCodeManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsCodeManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	EgovMap view = kwsCodeManageService.selectCodeView(searchVO);
    	model.addAttribute("codeView", view);
		
		return "/admin/code/codeUpdate";
	}
	
	/**
	 * 코드관리 수정
	 * @param searchVO - 코드 정보가 담긴 KwsCodeManageVO
	 * @param model
	 * @return "/admin/code/codeUpdate"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/code/codeUpdate.do")
	public String update(@ModelAttribute("searchVO") KwsCodeManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception{
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsCodeManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	HttpSession session = request.getSession();
    	
    	String userId = (String)session.getAttribute("sAdminId");	//아이디
		searchVO.setLastUpdtId(userId);
		
		String codeIp = request.getRemoteAddr();	//아이피
		searchVO.setLastUpdtIp(codeIp);
    	
    	String msg = kwsCodeManageService.updateCode(searchVO);
    	
    	model.addAttribute("msg", msg);
    	model.addAttribute("gnbMenuCd", searchVO.getGnbMenuCd());
    	
    	return "redirect:/admin/code/codeList.do";
	}
	
	/**
	 * 코드관리 삭제
	 * @param searchVO - 코드 정보가 담긴 KwsCodeManageVO
	 * @param model
	 * @return "/admin/code/codeDelete"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/code/codeDelete.do")
	public String delete(@ModelAttribute("searchVO") KwsCodeManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception{
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsCodeManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	String msg = kwsCodeManageService.deleteCode(searchVO);
    	
    	model.addAttribute("msg", msg);
    	model.addAttribute("gnbMenuCd", searchVO.getGnbMenuCd());
    	
    	return "redirect:/admin/code/codeList.do";
	}
	
	/**
	 * 아이디 중복 체크
	 * @param searchVO - 코드 정보가 담긴 KwsCodeManageVO
	 * @param model
	 * @return "/admin/code/codeRegist"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/code/codeIdOverlapChk.do")
	public String idOverlap(@ModelAttribute("searchVO") KwsCodeManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsCodeManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	String codeId = request.getParameter("codeId");
    	
    	String overlapStr = "";
    	
    	if(!"".equals(Util.isNull(codeId))){
    		searchVO.setCodeId(codeId);
    		int overlapNum = kwsCodeManageService.idOverlapChk(searchVO);
    		if(overlapNum > 0){
    			overlapStr = "Y";
    		}else{
    			overlapStr = "N";
    		}
    	}
		
		model.addAttribute("overlapStr", overlapStr);
	
		return "/admin/code/codeIdOverlapAjax";
	}
    
}
