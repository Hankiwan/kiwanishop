package egovframework.admin.common.include.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.admin.common.include.service.KwsIncludeManageVO;
import egovframework.admin.member.service.KwsMemberManageVO;
import egovframework.admin.menu.service.KwsMenuManageVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**  
 * @Class Name : KwsIncludeManageDAO.java
 * @Description : KwsIncludeManage DAO DAO Class
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

@Repository("kwsIncludeManageDAO")
public class KwsIncludeManageDAO extends EgovAbstractDAO {

	/**
     * 관리자 메뉴 gnb 목록을 조회 한다.
     *
     * @param KwsMenuManageVO
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<KwsMenuManageVO> menuGnbList(KwsMenuManageVO menuVO) throws Exception{
		return list("includeManageDAO.menuGnbList", menuVO);
	}
	
	/**
     * 관리자 메뉴 gnb의 총갯수를 구한다.
     *
     * @param KwsMenuManageVO
     * @return
     * @throws Exception
     */
	public int menuGnbListCnt(KwsMenuManageVO menuVO) throws Exception{
		return (Integer)getSqlMapClientTemplate().queryForObject("includeManageDAO.menuGnbListCnt", menuVO);
	}
	
	/**
     * 관리자 lnb 메뉴 목록을 조회 한다.
     *
     * @param KwsIncludeManageVO
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<KwsMenuManageVO> menuLnbList(KwsIncludeManageVO includeVO) throws Exception{
		return list("includeManageDAO.menuLnbList", includeVO);
	}
	
	/**
     * 관리자 선택된 메뉴 이름을 조회 한다.
     *
     * @param KwsIncludeManageVO
     * @return
     * @throws Exception
     */
	public String menuFirstNm(KwsIncludeManageVO includeVO) throws Exception{
		return (String)getSqlMapClientTemplate().queryForObject("includeManageDAO.menuFirstNm", includeVO);
	}
	
	/**
     * 관리자 최상위 메뉴 코드를 조회 한다.
     *
     * @param KwsIncludeManageVO
     * @return
     * @throws Exception
     */
	public String minMenuCode(KwsIncludeManageVO includeVO) throws Exception{
		return (String)getSqlMapClientTemplate().queryForObject("includeManageDAO.minMenuCode", includeVO);
	}
}
