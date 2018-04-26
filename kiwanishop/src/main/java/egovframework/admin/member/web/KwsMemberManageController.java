package egovframework.admin.member.web;

import java.util.List;
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
import egovframework.admin.member.service.KwsMemberManageService;
import egovframework.admin.member.service.KwsMemberManageVO;
import egovframework.admin.menu.service.KwsMenuManageService;
import egovframework.admin.menu.service.KwsMenuManageVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.utl.util.Util;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**  
 * @Class Name : KwsMemberManageController.java
 * @Description : 기와니샵 회원 controller
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2014.05.16           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2014. 05.16
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class KwsMemberManageController {
	
	/** KwsMemberManageService */
    @Resource(name = "kwsMemberManageService")
    private KwsMemberManageService kwsMemberManageService;
    
    /** KwsLoginManageService */
    @Resource(name = "kwsLoginManageService")
    private KwsLoginManageService kwsLoginManageService;
    
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
    
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertyService;
    
    /** KwsCodeManageService */
    @Resource(name = "kwsCodeManageService")
    private KwsCodeManageService kwsCodeManageService;
    
    /** KwsMenuManageService */
    @Resource(name = "kwsMenuManageService")
    private KwsMenuManageService kwsMenuManageService;

    /**
	 * 회원관리 리스트 페이지 이동
	 * @param searchVO - 회원 정보가 담긴 KwsMemberManageVO
	 * @param model
	 * @return "/admin/member/memberList"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/member/memberList.do")
	public String list(@ModelAttribute("searchVO") KwsMemberManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
			// 로그인체크
	    	if(!kwsLoginManageService.isLogin(request)) {
	    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
	    	       model.addAttribute("searchVO", new KwsMemberManageVO());
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
	    	
	    	Map<String, Object> memberMap = kwsMemberManageService.memberList(searchVO);
	    	
	    	int totCnt = Integer.parseInt((String)memberMap.get("totalCnt"));
	    	
	    	paginationInfo.setTotalRecordCount(totCnt);	//실적 총갯수
	    	
	    	model.addAttribute("memberList", memberMap.get("memberList"));	//회원 리스트
	    	model.addAttribute("totalCnt", memberMap.get("totalCnt"));	//회원 총갯수
	    	model.addAttribute("paginationInfo", paginationInfo);	//페이징 정보
	    	
	    	if(!Util.isNull(searchVO.getMsg()).equals("")){
		    	model.addAttribute("msg", new String(searchVO.getMsg().getBytes("8859_1"), "UTF-8"));
	    	}
		
			return "/admin/member/memberList";
	}
	
	/**
	 * 회원관리 상세 페이지 이동
	 * @param searchVO - 회원 정보가 담긴 KwsMemberManageVO
	 * @param model
	 * @return "/admin/member/memberView"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/member/memberView.do")
	public String memberView(@ModelAttribute("searchVO") KwsMemberManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsMemberManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	EgovMap view = kwsMemberManageService.selectMemberView(searchVO);
    	model.addAttribute("memberView", view);
    	
    	KwsCodeManageVO codeVO = new KwsCodeManageVO();
    	codeVO.setCodeId("authcode");
    	model.addAttribute("authCodeList", kwsCodeManageService.codeList(codeVO));
    	
    	return "/admin/member/memberView";
	}
	
	/**
	 * 회원관리 등록폼 페이지 이동
	 * @param searchVO - 회원 정보가 담긴 KwsMemberManageVO
	 * @param model
	 * @return "/admin/member/memberRegistForm"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/member/memberRegistForm.do")
	public String registForm(@ModelAttribute("searchVO") KwsMemberManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsMemberManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	KwsCodeManageVO codeVO = new KwsCodeManageVO();
    	codeVO.setCodeId("authcode");
    	model.addAttribute("authCodeList", kwsCodeManageService.codeList(codeVO));
		
		return "/admin/member/memberRegist";
	}
	
	/**
	 * 회원관리 등록
	 * @param searchVO - 회원 정보가 담긴 KwsMemberManageVO
	 * @param model
	 * @return "/admin/member/memberRegist"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/member/memberRegist.do")
	public String regist(@ModelAttribute("searchVO") KwsMemberManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsMemberManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	HttpSession session = request.getSession();
    	
    	String userId = (String)session.getAttribute("sAdminId");	//아이디
    	searchVO.setFrstRegistId(userId);
		searchVO.setLastUpdtId(userId);
    	
		String memberIp = request.getRemoteAddr();	//아이피
		searchVO.setFrstRegistIp(memberIp);
		searchVO.setLastUpdtIp(memberIp);
		
		String msg = kwsMemberManageService.insertMember(searchVO);
		
		model.addAttribute("msg", msg);
		model.addAttribute("gnbMenuCd", searchVO.getGnbMenuCd());
	
		return "redirect:/admin/member/memberList.do";
	}
	
	/**
	 * 회원관리 수정폼 페이지 이동
	 * @param searchVO - 회원 정보가 담긴 KwsMemberManageVO
	 * @param model
	 * @return "/admin/member/memberUpdateForm"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/member/memberUpdateForm.do")
	public String updateForm(@ModelAttribute("searchVO") KwsMemberManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsMemberManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	EgovMap view = kwsMemberManageService.selectMemberView(searchVO);
    	model.addAttribute("memberView", view);
    	
    	KwsCodeManageVO codeVO = new KwsCodeManageVO();
    	codeVO.setCodeId("authcode");
    	model.addAttribute("authCodeList", kwsCodeManageService.codeList(codeVO));
		
		return "/admin/member/memberUpdate";
	}
	
	/**
	 * 회원관리 수정
	 * @param searchVO - 회원 정보가 담긴 KwsMemberManageVO
	 * @param model
	 * @return "/admin/member/memberUpdate"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/member/memberUpdate.do")
	public String update(@ModelAttribute("searchVO") KwsMemberManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception{
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsMemberManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	HttpSession session = request.getSession();
    	
    	String userId = (String)session.getAttribute("sAdminId");	//아이디
		searchVO.setLastUpdtId(userId);
		
		String resultIp = request.getRemoteAddr();	//아이피
		searchVO.setLastUpdtIp(resultIp);
    	
    	String msg = kwsMemberManageService.updateMember(searchVO);
    	
    	model.addAttribute("msg", msg);
    	model.addAttribute("gnbMenuCd", searchVO.getGnbMenuCd());
    	
    	return "redirect:/admin/member/memberList.do";
	}
	
	/**
	 * 회원관리 삭제
	 * @param searchVO - 회원 정보가 담긴 KwsMemberManageVO
	 * @param model
	 * @return "/admin/member/memberDelete"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/member/memberDelete.do")
	public String delete(@ModelAttribute("searchVO") KwsMemberManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception{
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsMemberManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	HttpSession session = request.getSession();
    	
    	String userId = (String)session.getAttribute("sAdminId");	//아이디
		searchVO.setLastUpdtId(userId);
		
		String resultIp = request.getRemoteAddr();	//아이피
		searchVO.setLastUpdtIp(resultIp);
    	
    	String msg = kwsMemberManageService.deleteMember(searchVO);
    	
    	model.addAttribute("msg", msg);
    	model.addAttribute("gnbMenuCd", searchVO.getGnbMenuCd());
    	
    	return "redirect:/admin/member/memberList.do";
	}
	
	/**
	 * 아이디 중복 체크
	 * @param searchVO - 회원 정보가 담긴 KwsMemberManageVO
	 * @param model
	 * @return "/admin/member/memberRegist"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/member/memberIdOverlapChk.do")
	public String idOverlap(@ModelAttribute("searchVO") KwsMemberManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsMemberManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	String userId = request.getParameter("userId");
    	
    	String overlapStr = "";
    	
    	if(!"".equals(Util.isNull(userId))){
    		searchVO.setUserId(userId);
    		int overlapNum = kwsMemberManageService.idOverlapChk(searchVO);
    		if(overlapNum > 0){
    			overlapStr = "Y";
    		}else{
    			overlapStr = "N";
    		}
    	}
		
		model.addAttribute("overlapStr", overlapStr);
	
		return "/admin/member/memberIdOverlapAjax";
	}
	
	/**
	 * 회원관리 메뉴 권한 페이지 이동
	 * @param searchVO - 회원 정보가 담긴 KwsMemberManageVO
	 * @param model
	 * @return "/admin/member/memberMenuAuth"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/member/memberMenuAuthForm.do")
	public String menuAuth(@ModelAttribute("searchVO") KwsMemberManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
			// 로그인체크
	    	if(!kwsLoginManageService.isLogin(request)) {
	    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
	    	       model.addAttribute("searchVO", new KwsMemberManageVO());
	    	      return "/admin/login/loginForm";
	    	}
	    	
	    	KwsMenuManageVO kwsMenuManageVO = new KwsMenuManageVO();
	    	kwsMenuManageVO.setUseGubun("admin");
	    	
	    	List<KwsMenuManageVO> menuList = kwsMenuManageService.selectMenuList(kwsMenuManageVO);
	    	
	    	List<KwsMemberManageVO> menuAuthList = kwsMemberManageService.selectMenuAuthList(searchVO);
	    	
	    	model.addAttribute("selectMenuList", menuList);	//메뉴 리스트
	    	model.addAttribute("menuAuthList", menuAuthList);	//메뉴 권한 리스트
	    	
			return "/admin/member/memberMenuAuth";
	}
	
	/**
	 * 회원관리 메뉴 권한 변경
	 * @param searchVO - 회원 정보가 담긴 KwsMemberManageVO
	 * @param model
	 * @return "/admin/member/memberMenuAuth"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/member/memberMenuAuth.do")
	public String menuAuthUpdate(@ModelAttribute("searchVO") KwsMemberManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
			// 로그인체크
	    	if(!kwsLoginManageService.isLogin(request)) {
	    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
	    	       model.addAttribute("searchVO", new KwsMemberManageVO());
	    	      return "/admin/login/loginForm";
	    	}
	    	
	    	String userId = searchVO.getUserId();	//아이디
	    	searchVO.setUserId(userId);
	    	searchVO.setFrstRegistId(userId);
			searchVO.setLastUpdtId(userId);
	    	
			String memberIp = request.getRemoteAddr();	//아이피
			searchVO.setFrstRegistIp(memberIp);
			searchVO.setLastUpdtIp(memberIp);
			
			String msg = kwsMemberManageService.insertMenuAuth(searchVO);
	    	
	    	model.addAttribute("msg", msg);
			model.addAttribute("gnbMenuCd", searchVO.getGnbMenuCd());
	    	
	    	return "redirect:/admin/member/memberList.do";
	}
    
}
