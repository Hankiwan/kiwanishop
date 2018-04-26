package egovframework.home.oilInfo.common.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.home.oilInfo.common.service.OilInfoIncludeService;
import egovframework.home.oilInfo.common.service.OilInfoIncludeVO;

/**  
 * @Class Name : OilInfoIncludeService.java
 * @Description : OilInfoIncludeService Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2016.11.11           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2016. 11.11
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */
@Controller
public class OilInfoIncludeControll {
	
	/** OilInfoIncludeService */
    @Resource(name = "oilInfoIncludeService")
    private OilInfoIncludeService oilInfoIncludeService;

   /**
    * 사용자 Header를조회 한다.
    * @param vo
    * @param request
    * @param model
    * @return 출력페이지정보   "/home/oilInfo/common/oilInfoHeader"
    * @exception Exception
    */
   @SuppressWarnings("unchecked")
   @RequestMapping(value="/home/oilInfo/common/oilInfoHeader.do")
	public String header(@ModelAttribute("searchVO") OilInfoIncludeVO includeVO,
							HttpServletRequest request,
							ModelMap model)
			throws Exception {
	   

		return "/home/oilInfo/common/oilInfoHeader";

	}

   /**
    * 사용자 Footer를조회 한다.
    * @param vo
    * @param request
    * @param model
    * @return 출력페이지정보   "/home/oilInfo/common/oilInfoFooter"
    * @exception Exception
    */
   @SuppressWarnings("unchecked")
   @RequestMapping(value="/home/oilInfo/common/oilInfoFooter.do")
	public String footer(@ModelAttribute("searchVO") OilInfoIncludeVO searchVO,
							HttpServletRequest request,
							ModelMap model)
			throws Exception {

		return "/home/oilInfo/common/oilInfoFooter";

	}

}