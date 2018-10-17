package egovframework.admin.board.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.admin.board.service.KwsBoardManageService;
import egovframework.admin.board.service.KwsBoardManageVO;
import egovframework.admin.code.service.KwsCodeManageVO;
import egovframework.admin.login.service.KwsLoginManageService;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.utl.util.Util;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**  
 * @Class Name : KwsBoardManageController.java
 * @Description : 기와니샵 코드 controller
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2014.06.17           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2014. 06.17
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class KwsBoardManageController {
	
	/** KwsBoardManageService */
    @Resource(name = "kwsBoardManageService")
    private KwsBoardManageService kwsBoardManageService;
    
    /** KwsLoginManageService */
    @Resource(name = "kwsLoginManageService")
    private KwsLoginManageService kwsLoginManageService;
    
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
    
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertyService;

    /**
	 * 게시판 관리 리스트 페이지 이동
	 * @param searchVO - 게시판 관리 정보가 담긴 KwsBoardManageVO
	 * @param model
	 * @return "/admin/board/boardManageList"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/board/boardManageList.do")
	public String list(@ModelAttribute("searchVO") KwsBoardManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
	    	searchVO.setPageUnit(propertyService.getInt("pageUnit"));
	    	searchVO.setPageSize(propertyService.getInt("pageSize"));
	    	
	    	PaginationInfo paginationInfo = new PaginationInfo();
	    	
	    	paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
			paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
			paginationInfo.setPageSize(searchVO.getPageSize());
			
			searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
			searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
			searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
	    	
	    	Map<String, Object> codeMap = kwsBoardManageService.selectBoardManageList(searchVO);
	    	
	    	int totCnt = Integer.parseInt((String)codeMap.get("totalCnt"));
	    	
	    	paginationInfo.setTotalRecordCount(totCnt);	//실적 총갯수
	    	
	    	model.addAttribute("selectBoardManageList", codeMap.get("selectBoardManageList"));	//게시판 관리 리스트
	    	model.addAttribute("totalCnt", codeMap.get("totalCnt"));	//코드 총갯수
	    	model.addAttribute("paginationInfo", paginationInfo);	//페이징 정보
	    	
	    	if(!Util.isNull(searchVO.getMsg()).equals("")){
		    	model.addAttribute("msg", new String(searchVO.getMsg().getBytes("8859_1"), "UTF-8"));
	    	}
		
			return "/admin/board/boardManageList";
	}
	
	/**
	 * 게시판 관리 상세 페이지 이동
	 * @param searchVO - 게시판 관리 정보가 담긴 KwsBoardManageVO
	 * @param model
	 * @return "/admin/board/boardManageView"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/board/boardManageView.do")
	public String view(@ModelAttribute("searchVO") KwsBoardManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
    	EgovMap view = kwsBoardManageService.selectBoardManageView(searchVO);
    	model.addAttribute("boardManageView", view);
    	
    	return "/admin/board/boardManageView";
	}
	
	/**
	 * 게시판 관리 등록폼 페이지 이동
	 * @param searchVO - 게시판 관리 정보가 담긴 KwsBoardManageVO
	 * @param model
	 * @return "/admin/board/boardRegistForm"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/board/boardManageRegistForm.do")
	public String registForm(@ModelAttribute("searchVO") KwsBoardManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		return "/admin/board/boardManageRegist";
	}
	
	/**
	 * 게시판 관리 등록
	 * @param searchVO - 게시판 관리 정보가 담긴 KwsBoardManageVO
	 * @param model
	 * @return "/admin/board/boardManageRegist"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/board/boardManageRegist.do")
	public String regist(@ModelAttribute("searchVO") KwsBoardManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
    	HttpSession session = request.getSession();
    	
    	String userId = (String)session.getAttribute("sAdminId");	//아이디
    	searchVO.setFrstRegistId(userId);
		searchVO.setLastUpdtId(userId);
    	
		String codeIp = request.getRemoteAddr();	//아이피
		searchVO.setFrstRegistIp(codeIp);
		searchVO.setLastUpdtIp(codeIp);
		
		String msg = kwsBoardManageService.insertBoardManage(searchVO);
		
		model.addAttribute("msg", msg);
		model.addAttribute("gnbMenuCd", searchVO.getGnbMenuCd());
	
		return "redirect:/admin/board/boardManageList.do";
	}
	
	/**
	 * 게시판 관리 수정폼 페이지 이동
	 * @param searchVO - 게시판 관리 정보가 담긴 KwsBoardManageVO
	 * @param model
	 * @return "/admin/board/boardUpdateForm"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/board/boardManageUpdateForm.do")
	public String updateForm(@ModelAttribute("searchVO") KwsBoardManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
    	EgovMap view = kwsBoardManageService.selectBoardManageView(searchVO);
    	model.addAttribute("boardManageView", view);
		
		return "/admin/board/boardManageUpdate";
	}
	
	/**
	 * 게시판 관리 수정
	 * @param searchVO - 게시판 관리 정보가 담긴 KwsBoardManageVO
	 * @param model
	 * @return "/admin/board/boardManageUpdate"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/board/boardManageUpdate.do")
	public String update(@ModelAttribute("searchVO") KwsBoardManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception{
    	
    	HttpSession session = request.getSession();
    	
    	String userId = (String)session.getAttribute("sAdminId");	//아이디
		searchVO.setLastUpdtId(userId);
		
		String codeIp = request.getRemoteAddr();	//아이피
		searchVO.setLastUpdtIp(codeIp);
    	
    	String msg = kwsBoardManageService.updateBoardManage(searchVO);
    	
    	model.addAttribute("msg", msg);
    	model.addAttribute("gnbMenuCd", searchVO.getGnbMenuCd());
    	
    	return "redirect:/admin/board/boardManageList.do";
	}
	
	/**
	 * 게시판 관리 삭제
	 * @param searchVO - 게시판 관리 정보가 담긴 KwsBoardManageVO
	 * @param model
	 * @return "/admin/board/boardManageDelete"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/board/boardManageDelete.do")
	public String delete(@ModelAttribute("searchVO") KwsBoardManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception{

		String msg = kwsBoardManageService.deleteBoardManage(searchVO);
    	
    	model.addAttribute("msg", msg);
    	model.addAttribute("gnbMenuCd", searchVO.getGnbMenuCd());
    	
    	return "redirect:/admin/board/boardManageList.do";
	}
    
}
