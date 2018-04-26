package egovframework.home.common.include.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.home.common.include.service.KwsIncludeService;
import egovframework.home.common.include.service.KwsIncludeVO;
import egovframework.home.menu.service.KwsMenuVO;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**  
 * @Class Name : KwsIncludeServiceImpl.java
 * @Description : KwsInclude Implement Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2014.08.18           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2014. 08.18
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */
@Service("kwsIncludeService")
public class KwsIncludeServiceImpl extends AbstractServiceImpl implements 
		KwsIncludeService {

	/** KwsIncludeDAO */
	@Resource(name="kwsIncludeDAO")
	private KwsIncludeDAO kwsIncludeDAO;
	
	@Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
	
	/**
	 * 사용자 메뉴 gnb 목록을 조회한다.
	 * @param vo - 메뉴 정보가 담긴 KwsMenuVO
	 * @exception Exception
	 */
	public Map<String, Object> menuGnbMap(KwsMenuVO menuVO) throws Exception{
		
		List<KwsMenuVO> menuGnbList = kwsIncludeDAO.menuGnbList(menuVO);
		
		int menuGnbListCnt = kwsIncludeDAO.menuGnbListCnt(menuVO);
		
		Map<String, Object> menuGnbMap = new HashMap<String, Object>();
		
		menuGnbMap.put("menuGnbList", menuGnbList);
		menuGnbMap.put("menuGnbListCnt", Integer.toString(menuGnbListCnt));
		
		return menuGnbMap;
	}
	
	/**
	 * 사용자 lnb 메뉴 목록을 조회한다.
	 * @param vo - include 정보가 담긴 KwsIncludeVO
	 * @exception Exception
	 */
	public List<KwsMenuVO> menuLnbList(KwsIncludeVO includeVO) throws Exception{
		return kwsIncludeDAO.menuLnbList(includeVO);
	}
	
	/**
	 * 사용자 선택된 메뉴 이름을 조회 한다.
	 * @param vo - include 정보가 담긴 KwsIncludeVO
	 * @exception Exception
	 */
	public String menuFirstNm(KwsIncludeVO includeVO) throws Exception{
		return kwsIncludeDAO.menuFirstNm(includeVO);
	}
	
	/**
	 * 사용자 최상위 메뉴 코드를 조회 한다.
	 * @param vo - include 정보가 담긴 KwsIncludeVO
	 * @exception Exception
	 */
	public String minMenuCode(KwsIncludeVO includeVO) throws Exception{
		return kwsIncludeDAO.minMenuCode(includeVO);
	}
	
}
