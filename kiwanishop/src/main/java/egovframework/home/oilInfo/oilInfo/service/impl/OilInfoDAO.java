package egovframework.home.oilInfo.oilInfo.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.home.oilInfo.oilInfo.service.OilInfoVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**  
 * @Class Name : OilInfoDAO.java
 * @Description : OilInfo DAO Class
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

@Repository("oilInfoDAO")
public class OilInfoDAO extends EgovAbstractDAO {

	/**
	 * 회원인지 체크한다.
	 * @param vo - 주유소 정보가 담긴 OilInfoVO
	 * @return 회원일 경우 return 1
	 * @exception Exception
	 */
	 public int oilInfo(OilInfoVO oilInfoVO) throws Exception{
		 
		 return (Integer)getSqlMapClientTemplate().queryForObject("oilInfoDAO.oilInfo", oilInfoVO);
	 }
	
}
