package egovframework.home.oilInfo.oilInfo.service;

/**  
 * @Class Name : OilInfoService.java
 * @Description : OilInfoService Class
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
public interface OilInfoService {

	/**
	 * 회원인지 체크
	 * @param vo - 주유소정보가 담긴 OilInfoVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	int oilInfo(OilInfoVO oilInfoVO) throws Exception;
	
}
