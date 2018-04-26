package egovframework.admin.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.admin.board.service.KwsBoardManageVO;
import egovframework.admin.code.service.KwsCodeManageVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**  
 * @Class Name : KwsBoardManageDAO.java
 * @Description : KwsBoardManage DAO DAO Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2014.06.17           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2014. 06.17
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */

@Repository("kwsBoardManageDAO")
public class KwsBoardManageDAO extends EgovAbstractDAO {

	/**
     * 게시판 관리 목록을 조회 한다.
     *
     * @param KwsBoardManageVO
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<KwsBoardManageVO> selectBoardManageList(KwsBoardManageVO boardVO) throws Exception{
		return list("boardManageDAO.selectBoardManageList", boardVO);
	}
	
	/**
     * 게시판 관리 총갯수 조회 한다.
     *
     * @param KwsBoardManageVO
     * @return
     * @throws Exception
     */
	public int selectBoardManageCnt(KwsBoardManageVO boardVO) throws Exception{
		return (Integer)getSqlMapClientTemplate().queryForObject("boardManageDAO.selectBoardManageCnt", boardVO);
	}
	
	/**
     * 게시판 관리 상세 정보를 조회 한다.
     *
     * @param KwsBoardManageVO
     * @return
     * @throws Exception
     */
	public EgovMap selectBoardManageView(KwsBoardManageVO boardVO) throws Exception{
		return (EgovMap)selectByPk("boardManageDAO.selectBoardManageView", boardVO);
	}
	
	/**
     * 게시판 관리 정보를 등록한다.
     *
     * @param KwsBoardManageVO
     * @throws Exception
     */
    public void insertBoardManage(KwsBoardManageVO boardVO) throws Exception {
    	insert("boardManageDAO.insertBoardManage", boardVO);
    }
    
    /**
     * 게시판 관리 정보를 수정한다.
     *
     * @param KwsBoardManageVO
     * @throws Exception
     */
    public void updateBoardManage(KwsBoardManageVO boardVO) throws Exception {
    	update("boardManageDAO.updateBoardManage", boardVO);
    }
    
    /**
     * 게시판 관리 정보를 삭제한다.
     *
     * @param KwsBoardManageVO
     * @throws Exception
     */
    public void deleteBoardManage(KwsBoardManageVO boardVO) throws Exception {
    	delete("boardManageDAO.deleteBoardManage", boardVO);
    }
	
}
