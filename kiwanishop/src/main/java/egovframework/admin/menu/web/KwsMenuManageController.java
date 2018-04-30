package egovframework.admin.menu.web;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.admin.code.service.KwsCodeManageService;
import egovframework.admin.code.service.KwsCodeManageVO;
import egovframework.admin.login.service.KwsLoginManageService;
import egovframework.admin.menu.service.KwsMenuManageService;
import egovframework.admin.menu.service.KwsMenuManageVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.utl.util.Util;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**  
 * @Class Name : KwsMenuManageController.java
 * @Description : 기와니샵 메뉴 controller
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2014.05.28           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2014. 05.28
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class KwsMenuManageController {
	
	/** KwsMenuManageService */
    @Resource(name = "kwsMenuManageService")
    private KwsMenuManageService kwsMenuManageService;
    
    /** KwsLoginManageService */
    @Resource(name = "kwsLoginManageService")
    private KwsLoginManageService kwsLoginManageService;
    
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
    
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertyService;
    
    @Resource(name = "kwsCodeManageService")
    protected KwsCodeManageService kwsCodeManageService;

    /**
	 * 메뉴관리 페이지 이동
	 * @param searchVO - 코드 정보가 담긴 KwsMenuManageVO
	 * @param model
	 * @return "/admin/menu/menuList"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/menu/menuList.do")
	public String list(@ModelAttribute("searchVO") KwsMenuManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
			// 로그인체크
	    	if(!kwsLoginManageService.isLogin(request)) {
	    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
	    	       model.addAttribute("searchVO", new KwsMenuManageVO());
	    	      return "/admin/login/loginForm";
	    	}
	    	
	    	if("".equals(Util.isNull(searchVO.getUseGubun()))){
	    		searchVO.setUseGubun("admin");
	    	}
	    	
	    	List<KwsMenuManageVO> menuList = kwsMenuManageService.selectMenuList(searchVO);
	    	
	    	model.addAttribute("selectMenuList", menuList);	//코드 리스트
	    	
	    	KwsCodeManageVO codeVO = new KwsCodeManageVO();
	    	codeVO.setCodeId("useGubun");	//사용구분
	    	model.addAttribute("useGubunList", kwsCodeManageService.codeList(codeVO));
	    	
	    	if(!Util.isNull(searchVO.getMsg()).equals("")){
		    	model.addAttribute("msg", new String(searchVO.getMsg().getBytes("8859_1"), "UTF-8"));
	    	}
		
			return "/admin/menu/menuList";
	}
	
	/**
	 * 메뉴관리 상세 페이지 이동
	 * @param searchVO - 메뉴 정보가 담긴 KwsMenuManageVO
	 * @param model
	 * @return "/admin/menu/menuView"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/menu/menuView.do")
	public String view(@ModelAttribute("searchVO") KwsMenuManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsMenuManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	EgovMap view = kwsMenuManageService.selectMenuView(searchVO);
    	model.addAttribute("menuView", view);
    	
    	return "/admin/menu/menuView";
	}
	
	/**
	 * 메뉴관리 등록폼 페이지 이동
	 * @param searchVO - 메뉴 정보가 담긴 KwsMenuManageVO
	 * @param model
	 * @return "/admin/menu/menuRegistForm"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/menu/menuRegistForm.do")
	public String registForm(@ModelAttribute("searchVO") KwsMenuManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsMenuManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	if(!"".equals(Util.isNull(searchVO.getMenuCode()))){	//2뎁스 이상에서 등록폼으로 들어왔을 경우
    		EgovMap view = kwsMenuManageService.selectMenuView(searchVO);
        	model.addAttribute("menuView", view);    		
    	}else{
    		model.addAttribute("menuView", "emp");
    	}
    	
    	KwsCodeManageVO codeVO = new KwsCodeManageVO();
    	codeVO.setCodeId("useGubun");	//사용구분
    	model.addAttribute("useGubunList", kwsCodeManageService.codeList(codeVO));
    	codeVO.setCodeId("authcode");	//권한 설정
    	model.addAttribute("authcodeList", kwsCodeManageService.codeList(codeVO));
		
		return "/admin/menu/menuRegist";
	}
	
	/**
	 * 메뉴관리 등록
	 * @param searchVO - 메뉴 정보가 담긴 KwsMenuManageVO
	 * @param model
	 * @return "/admin/menu/menuRegist"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/menu/menuRegist.do")
	public String regist(@ModelAttribute("searchVO") KwsMenuManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsMenuManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	HttpSession session = request.getSession();
    	
    	String userId = (String)session.getAttribute("sAdminId");	//아이디
    	searchVO.setFrstRegistId(userId);
		searchVO.setLastUpdtId(userId);
    	
		String menuIp = request.getRemoteAddr();	//아이피
		searchVO.setFrstRegistIp(menuIp);
		searchVO.setLastUpdtIp(menuIp);
		
		String menuCode = "";
		if("1".equals(searchVO.getMenuDepth())){	//메뉴 1 뎁스
			searchVO.setStartNum("1");
			searchVO.setEndNum("4");
			menuCode = addZero(kwsMenuManageService.getMenuDepthMax(searchVO));
			menuCode += "000000000000";
		}else if("2".equals(searchVO.getMenuDepth())){	//메뉴 2 뎁스
			menuCode = searchVO.getMenuCode().substring(0, 4);
			searchVO.setStartNum("5");
			searchVO.setEndNum("4");
			searchVO.setMenuCode(menuCode);
			menuCode += addZero(kwsMenuManageService.getMenuDepthMax(searchVO));
			menuCode += "00000000";
		}else if("3".equals(searchVO.getMenuDepth())){	//메뉴 3 뎁스
			menuCode = searchVO.getMenuCode().substring(0, 8);
			searchVO.setStartNum("9");
			searchVO.setEndNum("4");
			searchVO.setMenuCode(menuCode);
			menuCode += addZero(kwsMenuManageService.getMenuDepthMax(searchVO));
			menuCode += "0000";
		}else if("4".equals(searchVO.getMenuDepth())){	//메뉴 4 뎁스
			menuCode = searchVO.getMenuCode().substring(0, 12);
			searchVO.setStartNum("13");
			searchVO.setEndNum("4");
			searchVO.setMenuCode(menuCode);
			menuCode += addZero(kwsMenuManageService.getMenuDepthMax(searchVO));
		}
		searchVO.setMenuCode(menuCode);
		String msg = kwsMenuManageService.insertMenu(searchVO);
		
		model.addAttribute("msg", msg);
		model.addAttribute("gnbMenuCd", searchVO.getGnbMenuCd());
		model.addAttribute("useGubun", searchVO.getUseGubunP());
	
		return "redirect:/admin/menu/menuList.do";
	}
	
	public String addZero(String menuCode) throws Exception{
		
		String str = "";
		
		if(menuCode.length() == 1){
			str += "000" + menuCode;
		}else if(menuCode.length() == 2){
			str += "00" + menuCode;
		}else if(menuCode.length() == 3){
			str += "0" + menuCode;
		}else if(menuCode.length() == 4){
			str = menuCode;
		}
		
		return str;
	}
	
	/**
	 * 메뉴관리 수정폼 페이지 이동
	 * @param searchVO - 수정 정보가 담긴 KwsMenuManageVO
	 * @param model
	 * @return "/admin/menu/menuUpdateForm"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/menu/menuUpdateForm.do")
	public String updateForm(@ModelAttribute("searchVO") KwsMenuManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsMenuManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	EgovMap view = kwsMenuManageService.selectMenuView(searchVO);
    	model.addAttribute("menuView", view);
    	
    	KwsCodeManageVO codeVO = new KwsCodeManageVO();
    	codeVO.setCodeId("useGubun");	//사용구분
    	model.addAttribute("useGubunList", kwsCodeManageService.codeList(codeVO));
    	codeVO.setCodeId("authcode");	//권한 설정
    	model.addAttribute("authcodeList", kwsCodeManageService.codeList(codeVO));
		
		return "/admin/menu/menuUpdate";
	}
	
	/**
	 * 메뉴관리 수정
	 * @param searchVO - 메뉴 정보가 담긴 KwsMenuManageVO
	 * @param model
	 * @return "/admin/menu/menuUpdate"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/menu/menuUpdate.do")
	public String update(@ModelAttribute("searchVO") KwsMenuManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception{
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsMenuManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	HttpSession session = request.getSession();
    	
    	String userId = (String)session.getAttribute("sAdminId");	//아이디
		searchVO.setLastUpdtId(userId);
		
		String menuIp = request.getRemoteAddr();	//아이피
		searchVO.setLastUpdtIp(menuIp);
    	
    	String msg = kwsMenuManageService.updateMenu(searchVO);
    	
    	model.addAttribute("msg", msg);
    	model.addAttribute("gnbMenuCd", searchVO.getGnbMenuCd());
    	model.addAttribute("useGubun", searchVO.getUseGubunP());
    	
    	return "redirect:/admin/menu/menuList.do";
	}
	
	/**
	 * 메뉴관리 삭제
	 * @param searchVO - 메뉴 정보가 담긴 KwsMenuManageVO
	 * @param model
	 * @return "/admin/menu/menuDelete"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/menu/menuDelete.do")
	public String delete(@ModelAttribute("searchVO") KwsMenuManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception{
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsMenuManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	String msg = kwsMenuManageService.deleteMenu(searchVO);
    	
    	model.addAttribute("msg", msg);
    	model.addAttribute("gnbMenuCd", searchVO.getGnbMenuCd());
    	model.addAttribute("useGubun", searchVO.getUseGubun());
    	
    	return "redirect:/admin/menu/menuList.do";
	}
	
	/**
	 * ajax 코드값 가져오기
	 * @param searchVO - 코드 정보가 담긴 KwsMenuManageVO
	 * @param model
	 * @return "/admin/menu/ajaxSelectMenu"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/menu/ajaxSelectMenu.do")
	public String ajaxSelectMenu(@ModelAttribute("searchVO") KwsMenuManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
	    	
	    	List<KwsMenuManageVO> ajaxSelectMenu = kwsMenuManageService.ajaxSelectMenu(searchVO);
	    	
	    	model.addAttribute("ajaxSelectMenu", ajaxSelectMenu);	//ajax 코드값 리스트
		
			return "/admin/menu/selectMenuAjax";
	}
	
	/**
	 * ajax Menu MAX, MIN 값 가져오기
	 * @param searchVO - 코드 정보가 담긴 KwsMenuManageVO
	 * @param model
	 * @return "/admin/menu/ajaxMenuMaxMin"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/menu/ajaxMenuMaxMin.do")
	public String ajaxMenuMaxMin(@ModelAttribute("searchVO") KwsMenuManageVO searchVO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	    	
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out=response.getWriter();
		
	    	String ajaxMenuMaxMin = kwsMenuManageService.ajaxMenuMaxMin(searchVO);
	    	
	    	out.print(ajaxMenuMaxMin);   
	    	
			return null;
	}
	
	/**
	 * 메뉴 이동
	 * @param searchVO - 코드 정보가 담긴 KwsMenuManageVO
	 * @param model
	 * @return "/admin/menu/menuChange"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/menu/menuChange.do")
	public String menuChange(@ModelAttribute("searchVO") KwsMenuManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
			// 로그인체크
	    	if(!kwsLoginManageService.isLogin(request)) {
	    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
	    	       model.addAttribute("searchVO", new KwsMenuManageVO());
	    	      return "/admin/login/loginForm";
	    	}
	    	
	    	HttpSession session = request.getSession();
			String userId = (String)session.getAttribute("sAdminId");	//아이디
			searchVO.setLastUpdtId(userId);
			String memberIp = request.getRemoteAddr();	//아이피
			searchVO.setLastUpdtIp(memberIp);
	    	
			String originMenuCode = searchVO.getMenuCode();	//원 메뉴코드
			String changeMenuCode = kwsMenuManageService.getMenuDepthOne(searchVO);	//메뉴 이동되는 코드 앞4자리값 가져오기
			String emptyCode = "9999";	//임시 메뉴 코드 앞4자리
			
			searchVO.setMenuCode(changeMenuCode);
			
			List<EgovMap> changeMenuCodeList = kwsMenuManageService.getMenuDepthOneList(searchVO);	//이동되는 메뉴 코드 리스트
			
			EgovMap map = new EgovMap();
			String str = "";
			//이동되는 메뉴의 앞4자리를 9999로 변경
			for(int i=0; i<changeMenuCodeList.size(); i++){
				map = changeMenuCodeList.get(i);
				str = (String)map.get("menuCode");
				str = emptyCode + str.substring(4, 16);
				searchVO.setMenuCodeChange(str);
				searchVO.setMenuCode((String)map.get("menuCode"));
				kwsMenuManageService.menuChange(searchVO);
			}
			
			searchVO.setMenuCode(originMenuCode);
			List<EgovMap> originMenuCodeList = kwsMenuManageService.getMenuDepthOneList(searchVO);	//원 메뉴 코드 리스트
			
			map = new EgovMap();
			str = "";
			//원 코드값을 바뀌는 코드값으로 변경
			for(int i=0; i<originMenuCodeList.size(); i++){
				map = originMenuCodeList.get(i);
				str = (String)map.get("menuCode");
				str = changeMenuCode + str.substring(4, 16);
				searchVO.setMenuCodeChange(str);
				searchVO.setMenuCode((String)map.get("menuCode"));
				kwsMenuManageService.menuChange(searchVO);
			}
			
			searchVO.setMenuCode(emptyCode);
			List<EgovMap> emptyMenuCodeList = kwsMenuManageService.getMenuDepthOneList(searchVO);	//임시 메뉴 코드 리스트
			
			map = new EgovMap();
			str = "";
			//임시메뉴 코드값(9999)을 원 코드값으로 변경
			for(int i=0; i<emptyMenuCodeList.size(); i++){
				map = emptyMenuCodeList.get(i);
				str = (String)map.get("menuCode");
				str = originMenuCode + str.substring(4, 16);
				searchVO.setMenuCodeChange(str);
				searchVO.setMenuCode((String)map.get("menuCode"));
				kwsMenuManageService.menuChange(searchVO);
			}
			
	    	model.addAttribute("msg", egovMessageSource.getMessage("Com.text.menuchange.success"));
	    	model.addAttribute("useGubun", searchVO.getUseGubun());
	    	model.addAttribute("gnbMenuCd", searchVO.getGnbMenuCd());
	    	
	    	return "redirect:/admin/menu/menuList.do";
	}
}
