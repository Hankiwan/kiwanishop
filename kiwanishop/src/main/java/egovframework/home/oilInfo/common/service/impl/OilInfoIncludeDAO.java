package egovframework.home.oilInfo.common.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.home.common.include.service.KwsIncludeVO;
import egovframework.home.menu.service.KwsMenuVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**  
 * @Class Name : OilInfoIncludeDAO.java
 * @Description : OilInfoInclude DAO DAO Class
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

@Repository("oilInfoIncludeDAO")
public class OilInfoIncludeDAO extends EgovAbstractDAO {

	/**
     * 사용자 메뉴 gnb 목록을 조회 한다.
     *
     * @param KwsMenuVO
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<KwsMenuVO> menuGnbList(KwsMenuVO menuVO) throws Exception{
		return list("includeDAO.menuGnbList", menuVO);
	}
	
	/**
     * 사용자 메뉴 gnb의 총갯수를 구한다.
     *
     * @param KwsMenuVO
     * @return
     * @throws Exception
     */
	public int menuGnbListCnt(KwsMenuVO menuVO) throws Exception{
		return (Integer)getSqlMapClientTemplate().queryForObject("includeDAO.menuGnbListCnt", menuVO);
	}
	
	/**
     * 사용자 lnb 메뉴 목록을 조회 한다.
     *
     * @param KwsIncludeVO
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<KwsMenuVO> menuLnbList(KwsIncludeVO includeVO) throws Exception{
		return list("includeDAO.menuLnbList", includeVO);
	}
	
	/**
     * 사용자 선택된 메뉴 이름을 조회 한다.
     *
     * @param KwsIncludeVO
     * @return
     * @throws Exception
     */
	public String menuFirstNm(KwsIncludeVO includeVO) throws Exception{
		return (String)getSqlMapClientTemplate().queryForObject("includeDAO.menuFirstNm", includeVO);
	}
	
	/**
     * 사용자 최상위 메뉴코드를 조회 한다.
     *
     * @param KwsIncludeVO
     * @return
     * @throws Exception
     */
	public String minMenuCode(KwsIncludeVO includeVO) throws Exception{
		return (String)getSqlMapClientTemplate().queryForObject("includeDAO.minMenuCode", includeVO);
	}
}
