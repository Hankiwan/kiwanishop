package egovframework.home.oilInfo.oilInfo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.home.oilInfo.oilInfo.service.OilInfoService;
import egovframework.home.oilInfo.oilInfo.service.OilInfoVO;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**  
 * @Class Name : OilInfoServiceImpl.java
 * @Description : OilInfo Implement Class
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
@Service("oilInfoService")
public class OilInfoServiceImpl extends AbstractServiceImpl implements 
		OilInfoService {

	/** OilInfoDAO */
	@Resource(name="oilInfoDAO")
	private OilInfoDAO oilInfoDAO;
	
	/**
	 * 회원인지 체크한다.
	 * @param vo - 로그인 정보가 담긴 KwsLoginVO
	 * @return 회원일시 return 1
	 * @exception Exception
	 */
    public int oilInfo(OilInfoVO oilInfoVO) throws Exception {
    	log.debug(oilInfoVO.toString());
    	
    	return oilInfoDAO.oilInfo(oilInfoVO);
    	    	
    }
	
	
}
