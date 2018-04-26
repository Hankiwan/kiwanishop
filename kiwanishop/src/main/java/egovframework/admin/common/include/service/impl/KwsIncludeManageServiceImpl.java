package egovframework.admin.common.include.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.admin.common.include.service.KwsIncludeManageService;
import egovframework.admin.common.include.service.KwsIncludeManageVO;
import egovframework.admin.menu.service.KwsMenuManageVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**  
 * @Class Name : KwsIncludeManageServiceImpl.java
 * @Description : KwsIncludeManage Implement Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2014.06.05           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2014. 06.05
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */
@Service("kwsIncludeManageService")
public class KwsIncludeManageServiceImpl extends AbstractServiceImpl implements 
		KwsIncludeManageService {

	/** KwsIncludeManageDAO */
	@Resource(name="kwsIncludeManageDAO")
	private KwsIncludeManageDAO kwsIncludeManageDAO;
	
	@Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
	
	/**
	 * 관리자 메뉴 gnb 목록을 조회한다.
	 * @param vo - 메뉴 정보가 담긴 KwsMenuManageVO
	 * @exception Exception
	 */
	public Map<String, Object> menuGnbMap(KwsMenuManageVO menuVO) throws Exception{
		
		List<KwsMenuManageVO> menuGnbList = kwsIncludeManageDAO.menuGnbList(menuVO);
		
		int menuGnbListCnt = kwsIncludeManageDAO.menuGnbListCnt(menuVO);
		
		Map<String, Object> menuGnbMap = new HashMap<String, Object>();
		
		menuGnbMap.put("menuGnbList", menuGnbList);
		menuGnbMap.put("menuGnbListCnt", Integer.toString(menuGnbListCnt));
		
		return menuGnbMap;
	}
	
	/**
	 * 관리자 lnb 메뉴 목록을 조회한다.
	 * @param vo - include 정보가 담긴 KwsIncludeManageVO
	 * @exception Exception
	 */
	public List<KwsMenuManageVO> menuLnbList(KwsIncludeManageVO includeVO) throws Exception{
		return kwsIncludeManageDAO.menuLnbList(includeVO);
	}
	
	/**
	 * 관리자 선택된 메뉴 이름을 조회 한다.
	 * @param vo - include 정보가 담긴 KwsIncludeManageVO
	 * @exception Exception
	 */
	public String menuFirstNm(KwsIncludeManageVO includeVO) throws Exception{
		return kwsIncludeManageDAO.menuFirstNm(includeVO);
	}
	
	/**
	 * 관리자 최상위 메뉴 코드를 조회 한다.
	 * @param vo - include 정보가 담긴 KwsIncludeManageVO
	 * @exception Exception
	 */
	public String minMenuCode(KwsIncludeManageVO includeVO) throws Exception{
		return kwsIncludeManageDAO.minMenuCode(includeVO);
	}
	
}
