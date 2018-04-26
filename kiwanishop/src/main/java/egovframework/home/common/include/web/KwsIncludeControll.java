package egovframework.home.common.include.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.utl.util.Util;
import egovframework.home.common.include.service.KwsIncludeService;
import egovframework.home.common.include.service.KwsIncludeVO;
import egovframework.home.menu.service.KwsMenuVO;

/**  
 * @Class Name : KwsLoginService.java
 * @Description : KwsLoginService Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2013.04.17           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2013. 04.17
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */
@Controller
public class KwsIncludeControll {
	
	/** KwsIncludeService */
    @Resource(name = "kwsIncludeService")
    private KwsIncludeService kwsIncludeService;

   /**
    * 사용자 Header를조회 한다.
    * @param vo
    * @param request
    * @param model
    * @return 출력페이지정보   "/home/common/header"
    * @exception Exception
    */
   @SuppressWarnings("unchecked")
   @RequestMapping(value="/home/common/header.do")
	public String header(@ModelAttribute("searchVO") KwsIncludeVO includeVO,
							KwsMenuVO menuVO,
							HttpServletRequest request,
							ModelMap model)
			throws Exception {
	   
	   Map<String, Object> menuGnbMap =  kwsIncludeService.menuGnbMap(menuVO);
	   
	   if("".equals(Util.isNull(includeVO.getGnbMenuCd()))){
		   includeVO.setGnbMenuCd(kwsIncludeService.minMenuCode(includeVO));
	   }
	   List<KwsMenuVO> menuLnbList = kwsIncludeService.menuLnbList(includeVO);	//lnb리스트
	   
	   String menuFirstNm = kwsIncludeService.menuFirstNm(includeVO);	//메뉴 제목
	   
	   model.addAttribute("menuGnbList", menuGnbMap.get("menuGnbList"));	//gnb 리스트
	   model.addAttribute("menuGnbListCnt", menuGnbMap.get("menuGnbListCnt"));	//gnb 리스트 갯수
	   model.addAttribute("menuLnbList", menuLnbList);	
	   model.addAttribute("menuFirstNm", menuFirstNm);	
	   model.addAttribute("includeVO", includeVO);
	   model.addAttribute("menuVO", menuVO);

		return "/home/common/header";

	}

   /**
    * 사용자 Footer를조회 한다.
    * @param vo
    * @param request
    * @param model
    * @return 출력페이지정보   "/home/common/footer"
    * @exception Exception
    */
   @SuppressWarnings("unchecked")
   @RequestMapping(value="/home/common/footer.do")
	public String footer(@ModelAttribute("searchVO") KwsIncludeVO searchVO,
							HttpServletRequest request,
							ModelMap model)
			throws Exception {

		return "/home/common/footer";

	}

}