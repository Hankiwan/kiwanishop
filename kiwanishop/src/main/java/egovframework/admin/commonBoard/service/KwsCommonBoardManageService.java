package egovframework.admin.commonBoard.service;

import java.util.List;
import java.util.Map;

import egovframework.admin.board.service.KwsBoardManageVO;
import egovframework.admin.code.service.KwsCodeManageVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**  
 * @Class Name : KwsCommonBoardManageService.java
 * @Description : KwsCommonBoardManageService Class
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
public interface KwsCommonBoardManageService {

	/**
     * 마스터 게시판 목록을 조회 한다.
     *
     * @param vo - 공통 게시판 정보가 담긴 KwsCommonBoardManageVO
     * @throws Exception
     */
	public List<KwsBoardManageVO> selectMasterBoardManageList(KwsCommonBoardManageVO boardVO) throws Exception;
	
	/**
     * 마스터 게시판 상세 정보를 조회한다.
     *
     * @param vo - 공통 게시판 정보가 담긴 KwsCommonBoardManageVO
     * @throws Exception
     */
	public EgovMap selectMasterBoardManageView(KwsCommonBoardManageVO boardVO) throws Exception;
	
	/**
     * 공통 게시판 목록을 조회 한다.
     *
     * @param vo - 공통 게시판 정보가 담긴 KwsCommonBoardManageVO
     * @throws Exception
     */
	public Map<String, Object> selectCommonBoardManageList(KwsCommonBoardManageVO boardVO) throws Exception;
	
	/**
     * 공통 게시판 상세 정보를 조회한다.
     *
     * @param vo - 공통 게시판 정보가 담긴 KwsCommonBoardManageVO
     * @throws Exception
     */
	public EgovMap selectCommonBoardManageView(KwsCommonBoardManageVO boardVO) throws Exception;
	
	/**
     * 공통 게시판 정보를 등록한다.
     *
     * @param vo - 공통 게시판 정보가 담긴 KwsCommonBoardManageVO
     * @throws Exception
     */
    public String insertCommonBoardManage(KwsCommonBoardManageVO boardVO) throws Exception;
    
    /**
     * 공통 게시판 정보를 수정한다.
     *
     * @param vo - 공통 게시판 정보가 담긴 KwsCommonBoardManageVO
     * @throws Exception
     */
    public String updateCommonBoardManage(KwsCommonBoardManageVO boardVO) throws Exception;
    
    /**
     * 공통 게시판 정보를 삭제한다.
     *
     * @param vo - 게시판 관리 정보가 담긴 KwsCommonBoardManageVO
     * @throws Exception
     */
	public String deleteCommonBoardManage(KwsCommonBoardManageVO boardVO) throws Exception;

}
