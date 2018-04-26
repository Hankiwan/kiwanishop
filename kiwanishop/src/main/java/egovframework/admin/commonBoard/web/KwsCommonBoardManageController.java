package egovframework.admin.commonBoard.web;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.admin.board.service.KwsBoardManageVO;
import egovframework.admin.commonBoard.service.KwsCommonBoardManageService;
import egovframework.admin.commonBoard.service.KwsCommonBoardManageVO;
import egovframework.admin.login.service.KwsLoginManageService;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.service.FileVO;
import egovframework.com.utl.util.Util;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**  
 * @Class Name : KwsCommonBoardManageController.java
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
public class KwsCommonBoardManageController {
	
	/** KwsCommonBoardManageService */
    @Resource(name = "kwsCommonBoardManageService")
    private KwsCommonBoardManageService kwsCommonBoardManageService;
    
    /** KwsLoginManageService */
    @Resource(name = "kwsLoginManageService")
    private KwsLoginManageService kwsLoginManageService;
    
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
    
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertyService;
    
    @Resource(name = "EgovFileMngUtil")
    private EgovFileMngUtil fileUtil;

    /**
	 * 공통 게시판 리스트 페이지 이동
	 * @param searchVO - 공통 게시판 정보가 담긴 KwsCommonBoardManageVO
	 * @param model
	 * @return "/admin/commonBoard/boardCommonManageList"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/commonBoard/commonBoardManageList.do")
	public String list(@ModelAttribute("searchVO") KwsCommonBoardManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
			// 로그인체크
	    	if(!kwsLoginManageService.isLogin(request)) {
	    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
	    	       model.addAttribute("searchVO", new KwsBoardManageVO());
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
	    	
	    	Map<String, Object> codeMap = kwsCommonBoardManageService.selectCommonBoardManageList(searchVO);
	    	
	    	int totCnt = Integer.parseInt((String)codeMap.get("totalCnt"));
	    	
	    	paginationInfo.setTotalRecordCount(totCnt);	//실적 총갯수
	    	
	    	List<KwsBoardManageVO> selectBoardManageList = kwsCommonBoardManageService.selectMasterBoardManageList(searchVO);
	    	
	    	model.addAttribute("selectBoardManageList", selectBoardManageList);	//마스터 게시판 관리 리스트
	    	model.addAttribute("selectCommonBoardManageList", codeMap.get("selectCommonBoardManageList"));	//공통 게시판 관리 리스트
	    	model.addAttribute("totalCnt", codeMap.get("totalCnt"));	//코드 총갯수
	    	model.addAttribute("paginationInfo", paginationInfo);	//페이징 정보
	    	
	    	if(!Util.isNull(searchVO.getMsg()).equals("")){
		    	model.addAttribute("msg", new String(searchVO.getMsg().getBytes("8859_1"), "UTF-8"));
	    	}
	    	
			return "/admin/commonBoard/commonBoardManageList";
	}
	
	/**
	 * 공통 게시판 상세 페이지 이동
	 * @param searchVO - 공통 게시판 정보가 담긴 KwsCommonBoardManageVO
	 * @param model
	 * @return "/admin/commonBoard/commonBoardManageView"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/commonBoard/commonBoardManageView.do")
	public String view(@ModelAttribute("searchVO") KwsCommonBoardManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsBoardManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	EgovMap view = kwsCommonBoardManageService.selectCommonBoardManageView(searchVO);
    	model.addAttribute("boardManageView", view);
    	
    	return "/admin/commonBoard/commonBoardManageView";
	}
	
	/**
	 * 공통 게시판 등록폼 페이지 이동
	 * @param searchVO - 공통 게시판 정보가 담긴 KwsCommonBoardManageVO
	 * @param model
	 * @return "/admin/commonBoard/commonBoardRegistForm"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/commonBoard/commonBoardManageRegistForm.do")
	public String registForm(@ModelAttribute("searchVO") KwsCommonBoardManageVO searchVO,
			@RequestParam(value="searchMasterSn", required=false) String searchMasterSn,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsBoardManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	searchVO.setMasterSn(searchMasterSn); 
    	
    	EgovMap selectMasterBoardManageView = kwsCommonBoardManageService.selectMasterBoardManageView(searchVO);
    	
    	model.addAttribute("selectMasterBoardManageView", selectMasterBoardManageView);	//마스터 게시판 상세 정보
		
		return "/admin/commonBoard/commonBoardManageRegist";
	}
	
	/**
	 * 공통 게시판 등록
	 * @param searchVO - 공통 게시판 정보가 담긴 KwsCommonBoardManageVO
	 * @param model
	 * @return "/admin/commonBoard/commonBoardManageRegist"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/commonBoard/commonBoardManageRegist.do")
	public String regist(@ModelAttribute("searchVO") KwsCommonBoardManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsBoardManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	HttpSession session = request.getSession();
    	
    	String userId = (String)session.getAttribute("sAdminId");	//아이디
    	searchVO.setFrstRegistId(userId);
		searchVO.setLastUpdtId(userId);
    	
		String codeIp = request.getRemoteAddr();	//아이피
		searchVO.setFrstRegistIp(codeIp);
		searchVO.setLastUpdtIp(codeIp);
		
		String atchFileId = Util.isNull(request.getParameter("atchFileId"));
    	String tempFileName = Util.isNull(request.getParameter("tempFileName"));
    	String fileStreCourse = Util.isNull(request.getParameter("fileStreCourse"));
    	String orignlFileNm = Util.isNull(request.getParameter("orignlFileNm"));
    	String fileExtsn = Util.isNull(request.getParameter("fileExtsn"));
    	String fileMg = Util.isNull(request.getParameter("fileMg"));
		
    	String fileName = "";

    	List<FileVO> fileList = null;

    	//파일 첨부
    	if(!"".equals(atchFileId)) {

			FileVO inputFileVO = new FileVO();
    		inputFileVO.setAtchFileId(atchFileId);
    		inputFileVO.setFileSn("0");
    		inputFileVO.setFileStreCours(fileStreCourse);
    		inputFileVO.setStreFileNm(tempFileName);
    		inputFileVO.setOrignlFileNm(orignlFileNm);
    		inputFileVO.setFileExtsn(fileExtsn);
    		inputFileVO.setFileMg(fileMg);
    		
    		inputFileVO.setFrstRegistId(userId);
    		inputFileVO.setLastUpdtId(userId);
    		inputFileVO.setFrstRegistIp(codeIp);
    		inputFileVO.setLastUpdtIp(codeIp);

    		searchVO.setFile(inputFileVO);
    	}
		
		String msg = kwsCommonBoardManageService.insertCommonBoardManage(searchVO);
		
		model.addAttribute("msg", msg);
		model.addAttribute("gnbMenuCd", searchVO.getGnbMenuCd());
	
		return "redirect:/admin/commonBoard/commonBoardManageList.do";
	}
	
	/**
	 * 공통 게시판 수정폼 페이지 이동
	 * @param searchVO - 공통 게시판 정보가 담긴 KwsCommonBoardManageVO
	 * @param model
	 * @return "/admin/commonBoard/commonBoardUpdateForm"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/commonBoard/commonBoardManageUpdateForm.do")
	public String updateForm(@ModelAttribute("searchVO") KwsCommonBoardManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsBoardManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	EgovMap view = kwsCommonBoardManageService.selectCommonBoardManageView(searchVO);
    	model.addAttribute("commonBoardManageView", view);
		
		return "/admin/commonBoard/commonBoardManageUpdate";
	}
	
	/**
	 * 공통 게시판 수정
	 * @param searchVO - 공통 게시판 정보가 담긴 KwsCommonBoardManageVO
	 * @param model
	 * @return "/admin/commonBoard/commonBoardManageUpdate"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/commonBoard/commonBoardManageUpdate.do")
	public String update(@ModelAttribute("searchVO") KwsCommonBoardManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception{
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsBoardManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	HttpSession session = request.getSession();
    	
    	String userId = (String)session.getAttribute("sAdminId");	//아이디
		searchVO.setLastUpdtId(userId);
		
		String codeIp = request.getRemoteAddr();	//아이피
		searchVO.setLastUpdtIp(codeIp);
    	
    	String msg = kwsCommonBoardManageService.updateCommonBoardManage(searchVO);
    	
    	model.addAttribute("msg", msg);
    	model.addAttribute("gnbMenuCd", searchVO.getGnbMenuCd());
    	
    	return "redirect:/admin/commonBoard/commonBoardManageList.do";
	}
	
	/**
	 * 공통 게시판 삭제
	 * @param searchVO - 공통 게시판 정보가 담긴 KwsCommonBoardManageVO
	 * @param model
	 * @return "/admin/commonBoard/commonBoardManageDelete"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/commonBoard/commonBoardManageDelete.do")
	public String delete(@ModelAttribute("searchVO") KwsCommonBoardManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception{
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsBoardManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	String msg = kwsCommonBoardManageService.deleteCommonBoardManage(searchVO);
    	
    	model.addAttribute("msg", msg);
    	model.addAttribute("gnbMenuCd", searchVO.getGnbMenuCd());
    	
    	return "redirect:/admin/commonBoard/commonBoardManageList.do";
	}
	
	/**
    * 파일첨부
    * @param KwsCommonBoardManageVO
    * @param multiRequest
    * @param request
    * @param model
    * @return
    * @throws Exception
    * @return 출력페이지정보 ""
    * @exception Exception
    */
    @RequestMapping(value="/admin/commonBoard/fileUpload.do")
	public String boardFileUpload(
			final MultipartHttpServletRequest multiRequest,
			HttpServletRequest request,
			ModelMap model) throws Exception {

    	String atchFileId = Util.isNull(request.getParameter("atchFileId"));

    	List<FileVO> result = null;
	    FileVO fileVO  = new FileVO();
	    String _fileName = "";
	    int fileSize = 0;

	    final Map<String, MultipartFile> files = multiRequest.getFileMap();
	    if (!files.isEmpty()) {

	    	SortedMap sm0 = new TreeMap(files);

	    	Iterator<Entry<String, MultipartFile>> itr = sm0.entrySet().iterator();
	    	MultipartFile file;
	    	String filePath = "";
	    	FileVO fvo;

	    	boolean isNext = true;

	    	while (itr.hasNext()) {
	    	    Entry<String, MultipartFile> entry = itr.next();

	    	    file = entry.getValue();

	    	    String errMsg = "";
	    	    String fileName = file.getOriginalFilename();

	    	    if(fileName!=null){
	    		    //if (!fileName.endsWith(".jpg") && !fileName.endsWith(".jpeg") && !fileName.endsWith(".gif") && !fileName.endsWith(".png")) {
	    			   //errMsg = "허용하지 않는 확장자 입니다.";
	    			   //model.addAttribute("errMsg", errMsg);

	    			   //isNext = false;
	    	   		//} else {
	    				if (file.getSize() > 524288) {
	    					errMsg = "50KB 이상의 파일은 저장하실 수 없습니다.";
	    					model.addAttribute("errMsg", errMsg);

	    					isNext = false;
	    				}
	    	   		//}
	    		}
	    	}

	    	if(isNext) {

				result = fileUtil.parseFileInf(files, "BOARD_", 0, atchFileId, "", "board");

				request.setAttribute("atchFileId", result.get(0).getAtchFileId());
				request.setAttribute("fileName", result.get(0).getOrignlFileNm());
				request.setAttribute("tempFileName", result.get(0).getStreFileNm());
				request.setAttribute("fileStreCours", result.get(0).getFileStreCours());
				request.setAttribute("orignlFileNm", result.get(0).getOrignlFileNm());
				request.setAttribute("fileExtsn", result.get(0).getFileExtsn());
				request.setAttribute("fileMg", result.get(0).getFileMg());

	    	}

	    }

		return "/admin/commonBoard/fileUpload";
	}
    
    /**
     * 첨부파일 삭제
     * @param KwsCommonBoardManageVO
     * @param multiRequest
     * @param request
     * @param model
     * @return
     * @throws Exception
     * @return 출력페이지정보 ""
     * @exception Exception
     */
     @RequestMapping(value="/admin/commonBoard/fileDelete.do")
 	public String boardFileDelete(
 			HttpServletRequest request,
 			ModelMap model) throws Exception {

     	String tempFileName = Util.isNull(request.getParameter("deleteFileId"));

     	String filePath = Util.isNull(EgovProperties.getProperty("Globals.fileStorePath"));
     	
     	filePath = filePath + "board";
     	if(!tempFileName.equals("") && !filePath.equals("")) {

     		File file = new File(filePath, tempFileName);

     		if(file.exists()) {
     			if(file.isFile()) {
     				file.delete();
     			}
     		}
     	}

 		return null;
 	}
    
}
