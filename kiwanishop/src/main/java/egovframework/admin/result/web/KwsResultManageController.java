package egovframework.admin.result.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.admin.code.service.KwsCodeManageService;
import egovframework.admin.code.service.KwsCodeManageVO;
import egovframework.admin.login.service.KwsLoginManageService;
import egovframework.admin.result.service.KwsResultManageService;
import egovframework.admin.result.service.KwsResultManageVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.Globals;
import egovframework.com.utl.poi.POIUtil;
import egovframework.com.utl.util.Util;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**  
 * @Class Name : KwsResultManageController.java
 * @Description : 기와니샵 실적 controller
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
public class KwsResultManageController {
	
	/** KwsResultManageService */
    @Resource(name = "kwsResultManageService")
    private KwsResultManageService kwsResultManageService;
    
    /** KwsLoginManageService */
    @Resource(name = "kwsLoginManageService")
    private KwsLoginManageService kwsLoginManageService;
    
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
    
    @Resource(name = "EgovFileMngUtil")
    private EgovFileMngUtil fileUtil;
    
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertyService;
    
    /** KwsCodeManageService */
    @Resource(name = "kwsCodeManageService")
    private KwsCodeManageService kwsCodeManageService;

    /**
	 * 실적관리 리스트 이동
	 * @param searchVO - 실적 정보가 담긴 KwsResultManageVO
	 * @param model
	 * @return "/admin/result/resultList"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/result/resultList.do")
	public String list(@ModelAttribute("searchVO") KwsResultManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
			// 로그인체크
	    	if(!kwsLoginManageService.isLogin(request)) {
	    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
	    	       model.addAttribute("searchVO", new KwsResultManageVO());
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
	    	
	    	Map<String, Object> resultMap = kwsResultManageService.resultList(searchVO);
	    	
	    	int totCnt = Integer.parseInt((String)resultMap.get("totalCnt"));
	    	
	    	paginationInfo.setTotalRecordCount(totCnt);	//실적 총갯수
	    	
	    	model.addAttribute("resultList", resultMap.get("resultList"));	//실적 리스트
	    	model.addAttribute("totalCnt", resultMap.get("totalCnt"));	//실적 총갯수
	    	model.addAttribute("paginationInfo", paginationInfo);	//페이징 정보
	    	
	    	if(!Util.isNull(searchVO.getMsg()).equals("")){
		    	model.addAttribute("msg", new String(searchVO.getMsg().getBytes("8859_1"), "UTF-8"));
	    	}
		
			return "/admin/result/resultList";
	}
	
	/**
	 * 실적관리 상세 이동
	 * @param searchVO - 실적 정보가 담긴 KwsResultManageVO
	 * @param model
	 * @return "/admin/result/resultView"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/result/resultView.do")
	public String registView(@ModelAttribute("searchVO") KwsResultManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsResultManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	List<KwsResultManageVO> list = kwsResultManageService.resultDetailView(searchVO);
    	
    	model.addAttribute("resultDetailList", list);
    	
    	return "/admin/result/resultView";
	}
	
	/**
	 * 실적관리 등록폼 페이지 이동
	 * @param searchVO - 실적 정보가 담긴 KwsResultManageVO
	 * @param model
	 * @return "/admin/result/resultRegistForm"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/result/resultRegistForm.do")
	public String registForm(@ModelAttribute("searchVO") KwsResultManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsResultManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	KwsCodeManageVO codeVO = new KwsCodeManageVO();
    	codeVO.setCodeId("resultYear");
    	model.addAttribute("yearCodeList", kwsCodeManageService.codeList(codeVO));
    	codeVO.setCodeId("resultMonth");
    	model.addAttribute("monthCodeList", kwsCodeManageService.codeList(codeVO));
    	
		return "/admin/result/resultRegist";
	}
	
	/**
	 * 실적관리 등록
	 * @param searchVO - 실적 정보가 담긴 KwsResultManageVO
	 * @param model
	 * @return "/admin/result/resultRegist"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/result/resultRegist.do")
	public String regist(final MultipartHttpServletRequest multiRequest, @ModelAttribute("searchVO") KwsResultManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception {
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsResultManageVO());
    	      return "/admin/login/loginForm";
    	}

		final Map<String, MultipartFile> files = multiRequest.getFileMap();

	    if (!files.isEmpty()) {
			fileUtil.parseFileResultInfo(files, Globals.SSAMBIN_FILE, 0, "1", "Globals.fileStorePath", "ssambin");		//실적 엑셀 물리적 파일 등록
	    
	
			ArrayList<String> list = POIUtil.applyExcel(Globals.SSAMBIN_FILE, Globals.SSAMBIN_FOLDER);	//실적 엑셀 파일(result.xls) 읽어 list에 담아줌.
			
			HttpSession session = multiRequest.getSession();
			
			if(list.size() > 0){
				String userId = (String)session.getAttribute("sAdminId");	//아이디
				searchVO.setFrstRegistId(userId);
				searchVO.setLastUpdtId(userId);
				
				String resultIp = multiRequest.getRemoteAddr();	//아이피
				searchVO.setFrstRegistIp(resultIp);
				searchVO.setLastUpdtIp(resultIp);
				
				searchVO.setResultList(list);
				String msg = kwsResultManageService.resultInsert(searchVO);
				
				model.addAttribute("msg", msg);
			}else{
				// 엑셀 데이터가 없습니다.
				model.addAttribute("msg", egovMessageSource.getMessage("Com.text.excel.fail"));
			}
	    }else{
	    	// 파일이 존재하지 않습니다.
	    	model.addAttribute("msg", egovMessageSource.getMessage("Com.text.file.fail"));
	    }
	    
	    model.addAttribute("gnbMenuCd", searchVO.getGnbMenuCd());
	    
	
		return "redirect:/admin/result/resultList.do";
	}
	
	/**
	 * 실적관리 삭제
	 * @param searchVO - 실적 정보가 담긴 KwsResultManageVO
	 * @param model
	 * @return "/admin/result/resultDelete"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/result/resultDelete.do")
	public String delete(@ModelAttribute("searchVO") KwsResultManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception{
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsResultManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	String msg = kwsResultManageService.resultDelete(searchVO);
    	
    	model.addAttribute("msg", msg);
    	model.addAttribute("gnbMenuCd", searchVO.getGnbMenuCd());
    	
    	return "redirect:/admin/result/resultList.do";
	}
	
	/**
	 * 실적관리 비교폼 페이지 이동
	 * @param searchVO - 실적 정보가 담긴 KwsResultManageVO
	 * @param model
	 * @return "/admin/result/resultCompare"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/result/resultCompareForm.do")
	public String compareForm(@ModelAttribute("searchVO") KwsResultManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception{
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsResultManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	if(!Util.isNull(searchVO.getMsg()).equals("")){
	    	model.addAttribute("msg", new String(searchVO.getMsg().getBytes("8859_1"), "UTF-8"));
    	}
		
		return "/admin/result/resultCompareForm";
	}
	
	/**
	 * 실적관리 비교 페이지 이동
	 * @param searchVO - 실적 정보가 담긴 KwsResultManageVO
	 * @param model
	 * @return "/admin/result/resultCompare"
	 * @exception Exception
	 */
	@RequestMapping(value="/admin/result/resultCompare.do")
	public String compare(@ModelAttribute("searchVO") KwsResultManageVO searchVO,
			ModelMap model, HttpServletRequest request)
			throws Exception{
		
		// 로그인체크
    	if(!kwsLoginManageService.isLogin(request)) {
    	       model.addAttribute("msg", egovMessageSource.getMessage("Com.text.login.fail"));
    	       model.addAttribute("searchVO", new KwsResultManageVO());
    	      return "/admin/login/loginForm";
    	}
    	
    	String selectDate = Util.isNull(searchVO.getSelectDate());
    	    
    	List<EgovMap> firstList = new ArrayList<EgovMap>();
    	List<EgovMap> secondList = new ArrayList<EgovMap>();
    	List<KwsResultManageVO> compareList = new ArrayList<KwsResultManageVO>();
    	
    	String[] arrayDate = null;
    	if(!"".equals(selectDate)){
    		arrayDate = selectDate.split(",");
    		
    		//비교년월 조회
    		for(int i=0; i < arrayDate.length; i++){
    			searchVO.setRegistYear(arrayDate[i].substring(0, 4));
        		searchVO.setRegistMonth(arrayDate[i].substring(4, 6));
        		
        		if(i == 0){
        			firstList = kwsResultManageService.resultCompareView(searchVO);
        			model.addAttribute("firstCompareYear", arrayDate[i].substring(0, 4));
        			model.addAttribute("firstCompareMonth", arrayDate[i].substring(4, 6));
        		}else{
        			secondList = kwsResultManageService.resultCompareView(searchVO);
        			model.addAttribute("secondCompareYear", arrayDate[i].substring(0, 4));
        			model.addAttribute("secondCompareMonth", arrayDate[i].substring(4, 6));
        		}
    		}
    		
    		EgovMap arrayfirst = new EgovMap();
    		EgovMap arraysecond = new EgovMap();
    		
    		//조회된 두 비교년월의 각 항목들을 비교
    		if(firstList.size() > 0 && secondList.size() > 0){
    			for(int j=0; j<firstList.size(); j++){
    				arrayfirst = firstList.get(j);
    				arraysecond = secondList.get(j);
    				
    				KwsResultManageVO compareVO = new KwsResultManageVO();
    				
    				compareVO.setGubunOne((String)arrayfirst.get("gubunOne"));
    				compareVO.setGubunTwo((String)arrayfirst.get("gubunTwo"));
    				compareVO.setGubunThree((String)arrayfirst.get("gubunThree"));
    				
    				String str = "";
    				
    				if(arrayfirst.get("gubunTwo").equals("SUB.TOTAL")){
        				compareVO.setTotalOne(compareProcess(arrayfirst.get("totalOne").toString(), arraysecond.get("totalOne").toString()));	
       					compareVO.setTotalTwo(compareProcess(arrayfirst.get("totalTwo").toString(), arraysecond.get("totalTwo").toString()));
       					compareVO.setTotalThree(compareProcess(arrayfirst.get("totalThree").toString(), arraysecond.get("totalThree").toString()));
       					compareVO.setTotalFour(compareProcess(arrayfirst.get("totalFour").toString(), arraysecond.get("totalFour").toString()));
       					compareVO.setTotalFive(compareProcess(arrayfirst.get("totalFive").toString(), arraysecond.get("totalFive").toString()));
       					compareVO.setTotalSix(compareProcess(arrayfirst.get("totalSix").toString(), arraysecond.get("totalSix").toString()));
       					compareVO.setTotalSeven(compareProcess(arrayfirst.get("totalSeven").toString(), arraysecond.get("totalSeven").toString()));
    				}else{
        				compareVO.setWeight(compareProcess(arrayfirst.get("weight").toString(), arraysecond.get("weight").toString()));	
       					compareVO.setSilwhaju(compareProcess(arrayfirst.get("silwhaju").toString(), arraysecond.get("silwhaju").toString()));
       					compareVO.setFwd(compareProcess(arrayfirst.get("fwd").toString(), arraysecond.get("fwd").toString()));
       					compareVO.setVolumeTotal(compareProcess(arrayfirst.get("volumeTotal").toString(), arraysecond.get("volumeTotal").toString()));
       					compareVO.setTeu(compareProcess(arrayfirst.get("teu").toString(), arraysecond.get("teu").toString()));
       					compareVO.setCount(compareProcess(arrayfirst.get("count").toString(), arraysecond.get("count").toString()));
       					compareVO.setProfitUsd(compareProcess(arrayfirst.get("profitUsd").toString(), arraysecond.get("profitUsd").toString()));
    				}
				
   					compareList.add(compareVO);
        		}	
    			
    			model.addAttribute("compareList", compareList);
    		}else{
    			model.addAttribute("msg", egovMessageSource.getMessage("Com.text.compare.notinsert"));		//선택한 비교년월이 등록되지 않았습니다.
    			model.addAttribute("gnbMenuCd", searchVO.getGnbMenuCd());
        		return "redirect:/admin/result/resultCompareForm.do";
    		}
    	}else{
    		model.addAttribute("msg", egovMessageSource.getMessage("fail.common.msg"));		//에러가 발생했습니다.
    		model.addAttribute("gnbMenuCd", searchVO.getGnbMenuCd());
    		return "redirect:/admin/result/resultCompareForm.do";
    	}
		
		return "/admin/result/resultCompare";
	}
	
	//비교 계산하기
	public String compareProcess(String arrayfirst, String arraysecond){
		double double1 = 0.0;
		double double2 = 0.0;
		
		double1 = Double.parseDouble(arraysecond) - Double.parseDouble(arrayfirst);
		if(arrayfirst.equals("0.0") && arraysecond.equals("0.0")){
			double2 = 0.0;
		}else{
			if(arrayfirst.equals("0.0")){
				double2 = 100.00;
			}else if(arraysecond.equals("0.0")){
				double2 = -100.00;
			}else{
				double2 = ((Double.parseDouble(arraysecond) - Double.parseDouble(arrayfirst)) / Double.parseDouble(arrayfirst)) * 100;
			}
		}
		
		BigDecimal bd1 = new BigDecimal(String.valueOf(double1));
		BigDecimal bd2 = new BigDecimal(String.valueOf(double2));
		BigDecimal result = null;
		
		result = bd1.setScale(2, BigDecimal.ROUND_DOWN);		//소수 둘째자리에서 내림
		String str = String.valueOf(result);
		result = bd2.setScale(2, BigDecimal.ROUND_DOWN);		//소수 둘째자리에서 내림
		str += "<br /> (" + String.valueOf(result) + "%)";
		return str;
	}
    
}
