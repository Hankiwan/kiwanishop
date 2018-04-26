package egovframework.admin.common.include.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.admin.common.include.service.KwsIncludeManageService;
import egovframework.admin.common.include.service.KwsIncludeManageVO;
import egovframework.admin.menu.service.KwsMenuManageVO;
import egovframework.com.utl.util.Util;

/**  
 * @Class Name : KwsLoginManageService.java
 * @Description : KwsLoginManageService Class
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
public class KwsIncludeManageControll {
	
	/** KwsIncludeManageService */
    @Resource(name = "kwsIncludeManageService")
    private KwsIncludeManageService kwsIncludeManageService;

   /**
    * 관리자 Header를조회 한다.
    * @param vo
    * @param request
    * @param model
    * @return 출력페이지정보   "/admin/common/header"
    * @exception Exception
    */
   @SuppressWarnings("unchecked")
   @RequestMapping(value="/admin/common/header.do")
	public String header(@ModelAttribute("searchVO") KwsIncludeManageVO includeVO,
							KwsMenuManageVO menuVO,
							HttpServletRequest request,
							ModelMap model)
			throws Exception {
	   
	   Map<String, Object> menuGnbMap =  kwsIncludeManageService.menuGnbMap(menuVO);
	   
	   if("".equals(Util.isNull(includeVO.getGnbMenuCd()))){
		   includeVO.setGnbMenuCd(kwsIncludeManageService.minMenuCode(includeVO));
	   }
	   List<KwsMenuManageVO> menuLnbList = kwsIncludeManageService.menuLnbList(includeVO);	//lnb리스트
	   
	   String menuFirstNm = kwsIncludeManageService.menuFirstNm(includeVO);	//메뉴 제목
	   
	   model.addAttribute("menuGnbList", menuGnbMap.get("menuGnbList"));	//gnb 리스트
	   model.addAttribute("menuGnbListCnt", menuGnbMap.get("menuGnbListCnt"));	//gnb 리스트 갯수
	   model.addAttribute("menuLnbList", menuLnbList);	
	   model.addAttribute("menuFirstNm", menuFirstNm);	
	   model.addAttribute("includeVO", includeVO);
	   model.addAttribute("menuVO", menuVO);

		return "/admin/common/header";

	}

   /**
    * 관리자 Footer를조회 한다.
    * @param vo
    * @param request
    * @param model
    * @return 출력페이지정보   "/admin/common/footer"
    * @exception Exception
    */
   @SuppressWarnings("unchecked")
   @RequestMapping(value="/admin/common/footer.do")
	public String footer(@ModelAttribute("searchVO") KwsIncludeManageVO searchVO,
							HttpServletRequest request,
							ModelMap model)
			throws Exception {

		return "/admin/common/footer";

	}

}