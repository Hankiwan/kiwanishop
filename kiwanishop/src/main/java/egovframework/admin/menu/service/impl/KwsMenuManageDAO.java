package egovframework.admin.menu.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.admin.menu.service.KwsMenuManageVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**  
 * @Class Name : KwsMenuManageDAO.java
 * @Description : KwsMenuManage DAO DAO Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2014.05.28           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2014. 05.28
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */

@Repository("kwsMenuManageDAO")
public class KwsMenuManageDAO extends EgovAbstractDAO {

	/**
     * 메뉴 목록을 조회 한다.
     *
     * @param KwsMenuManageVO
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<KwsMenuManageVO> selectMenuList(KwsMenuManageVO menuVO) throws Exception{
		return list("menuManageDAO.selectMenuList", menuVO);
	}
	
	/**
     * 메뉴 상세 정보를 조회 한다.
     *
     * @param KwsMenuManageVO
     * @return
     * @throws Exception
     */
	public EgovMap selectMenuView(KwsMenuManageVO menuVO) throws Exception{
		return (EgovMap)selectByPk("menuManageDAO.selectMenuView", menuVO);
	}
	
	/**
     * 메뉴 정보을 등록한다.
     *
     * @param KwsMenuManageVO
     * @throws Exception
     */
    public void insertMenu(KwsMenuManageVO menuVO) throws Exception {
    	insert("menuManageDAO.insertMenu", menuVO);
    }
    
    /**
     * 메뉴 정보을 수정한다.
     *
     * @param KwsMenuManageVO
     * @throws Exception
     */
    public void updateMenu(KwsMenuManageVO menuVO) throws Exception {
    	update("menuManageDAO.updateMenu", menuVO);
    }
    
    /**
     * 메뉴 정보을 삭제한다.
     *
     * @param KwsMenuManageVO
     * @throws Exception
     */
    public void deleteMenu(KwsMenuManageVO menuVO) throws Exception {
    	delete("menuManageDAO.deleteMenu", menuVO);
    }
    
    /**
     * 메뉴 뎁스의 max값 + 1 을 조회 한다.
     *
     * @param KwsMenuManageVO
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public String getMenuDepthMax(KwsMenuManageVO menuVO) throws Exception{
		return (String)getSqlMapClientTemplate().queryForObject("menuManageDAO.getMenuDepthMax", menuVO);
	}
	
	/**
     * ajax 코드값 가져오기
     *
     * @param KwsMenuManageVO
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<KwsMenuManageVO> ajaxSelectMenu(KwsMenuManageVO menuVO) throws Exception{
		return list("menuManageDAO.ajaxSelectMenu", menuVO);
	}
	
	/**
     * ajax Menu MAX, MIN 값 가져오기
     *
     * @param KwsMenuManageVO
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public String ajaxMenuMaxMin(KwsMenuManageVO menuVO) throws Exception{
		return (String)getSqlMapClientTemplate().queryForObject("menuManageDAO.ajaxMenuMaxMin", menuVO);
	}
	
	/**
     * 메뉴 이동되는 코드 앞4자리값
     *
     * @param KwsMenuManageVO
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public String getMenuDepthOne(KwsMenuManageVO menuVO) throws Exception{
		return (String)getSqlMapClientTemplate().queryForObject("menuManageDAO.getMenuDepthOne", menuVO);
	}
	
	/**
     * 메뉴 이동되는 코드 리스트
     *
     * @param KwsMenuManageVO
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<EgovMap> getMenuDepthOneList(KwsMenuManageVO menuVO) throws Exception{
		return list("menuManageDAO.getMenuDepthOneList", menuVO);
	}
	
	/**
     * 메뉴 이동되는 코드값을 수정한다.
     *
     * @param KwsMenuManageVO
     * @throws Exception
     */
    public void updateMenuChange(KwsMenuManageVO menuVO) throws Exception {
    	update("menuManageDAO.updateMenuChange", menuVO);
    }
	
}
