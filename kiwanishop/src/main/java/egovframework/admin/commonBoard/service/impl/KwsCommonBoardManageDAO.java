package egovframework.admin.commonBoard.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.admin.board.service.KwsBoardManageVO;
import egovframework.admin.commonBoard.service.KwsCommonBoardManageVO;
import egovframework.com.cmm.service.FileVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**  
 * @Class Name : KwsCommonBoardManageDAO.java
 * @Description : KwsCommonBoardManage DAO DAO Class
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

@Repository("kwsCommonBoardManageDAO")
public class KwsCommonBoardManageDAO extends EgovAbstractDAO {

	/**
     * 마스터 게시판 목록을 조회 한다.
     *
     * @param KwsCommonBoardManageVO
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<KwsBoardManageVO> selectMasterBoardManageList(KwsCommonBoardManageVO boardVO) throws Exception{
		return list("commonBoardManageDAO.selectMasterBoardManageList", boardVO);
	}
	
	/**
     * 마스터 게시판 상세정보를 조회 한다.
     *
     * @param KwsCommonBoardManageVO
     * @return
     * @throws Exception
     */
	public EgovMap selectMasterBoardManageView(KwsCommonBoardManageVO boardVO) throws Exception{
		return (EgovMap)selectByPk("commonBoardManageDAO.selectMasterBoardManageView", boardVO);
	}
	
	/**
     * 공통 게시판 목록을 조회 한다.
     *
     * @param KwsCommonBoardManageVO
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<EgovMap> selectCommonBoardManageList(KwsCommonBoardManageVO boardVO) throws Exception{
		return list("commonBoardManageDAO.selectCommonBoardManageList", boardVO);
	}
	
	/**
     * 공통 게시판 총갯수 조회 한다.
     *
     * @param KwsCommonBoardManageVO
     * @return
     * @throws Exception
     */
	public int selectCommonBoardManageCnt(KwsCommonBoardManageVO boardVO) throws Exception{
		return (Integer)getSqlMapClientTemplate().queryForObject("commonBoardManageDAO.selectCommonBoardManageCnt", boardVO);
	}
	
	/**
     * 공통 게시판 상세 정보를 조회 한다.
     *
     * @param KwsCommonBoardManageVO
     * @return
     * @throws Exception
     */
	public EgovMap selectCommonBoardManageView(KwsCommonBoardManageVO boardVO) throws Exception{
		return (EgovMap)selectByPk("commonBoardManageDAO.selectCommonBoardManageView", boardVO);
	}
	
	/**
     * 공통 게시판 정보를 등록한다.
     *
     * @param KwsCommonBoardManageVO
     * @throws Exception
     */
    public void insertCommonBoardManage(KwsCommonBoardManageVO boardVO) throws Exception {
    	insert("commonBoardManageDAO.insertCommonBoardManage", boardVO);
    }
    
    /**
     * 공통 게시판 정보를 수정한다.
     *
     * @param KwsCommonBoardManageVO
     * @throws Exception
     */
    public void updateCommonBoardManage(KwsCommonBoardManageVO boardVO) throws Exception {
    	update("commonBoardManageDAO.updateCommonBoardManage", boardVO);
    }
    
    /**
     * 공통 게시판 정보를 삭제한다.
     *
     * @param KwsCommonBoardManageVO
     * @throws Exception
     */
    public void deleteCommonBoardManage(KwsCommonBoardManageVO boardVO) throws Exception {
    	delete("commonBoardManageDAO.deleteCommonBoardManage", boardVO);
    }
    
    /**
     * 파일 정보를 등록한다.
     *
     * @param KwsCommonBoardManageVO
     * @throws Exception
     */
    public void insertFile(FileVO fileVO) throws Exception {
    	insert("commonBoardManageDAO.insertFile", fileVO);
    }
    
    /**
     * 상세파일 정보를 등록한다.
     *
     * @param KwsCommonBoardManageVO
     * @throws Exception
     */
    public void insertFileDetail(FileVO fileVO) throws Exception {
    	insert("commonBoardManageDAO.insertFileDetail", fileVO);
    }
    
    /**
     * 파일 정보를 삭제한다.
     *
     * @param KwsCommonBoardManageVO
     * @throws Exception
     */
    public void deleteFile(FileVO fileVO) throws Exception {
    	delete("commonBoardManageDAO.deleteFile", fileVO);
    }
    
    /**
     * 상세파일 정보를 삭제한다.
     *
     * @param KwsCommonBoardManageVO
     * @throws Exception
     */
    public void deleteFileDetail(FileVO fileVO) throws Exception {
    	delete("commonBoardManageDAO.deleteFileDetail", fileVO);
    }
    
    /**
     * 상세파일 정보를 조회 한다.
     *
     * @param KwsCommonBoardManageVO
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<EgovMap> selectFileList(String fileId) throws Exception{
		return list("commonBoardManageDAO.selectFileList", fileId);
	}
	
}
