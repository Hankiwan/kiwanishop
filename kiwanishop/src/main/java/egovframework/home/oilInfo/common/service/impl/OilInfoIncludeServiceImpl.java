package egovframework.home.oilInfo.common.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.home.common.include.service.KwsIncludeVO;
import egovframework.home.menu.service.KwsMenuVO;
import egovframework.home.oilInfo.common.service.OilInfoIncludeService;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**  
 * @Class Name : OilInfoIncludeServiceImpl.java
 * @Description : OilInfoInclude Implement Class
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
@Service("oilInfoIncludeService")
public class OilInfoIncludeServiceImpl extends AbstractServiceImpl implements 
		OilInfoIncludeService {

	/** OilInfoIncludeDAO */
	@Resource(name="oilInfoIncludeDAO")
	private OilInfoIncludeDAO oilInfoIncludeDAO;
	
	@Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
	
	
	
}
