package egovframework.admin.board.service;

import java.util.List;
import java.util.Map;

import egovframework.admin.code.service.KwsCodeManageVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**  
 * @Class Name : KwsBoardManageService.java
 * @Description : KwsBoardManageService Class
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
public interface KwsBoardManageService {

	/**
     * 게시판 관리 목록을 조회 한다.
     *
     * @param vo - 게시판 관리 정보가 담긴 KwsBoardManageVO
     * @throws Exception
     */
	public Map<String, Object> selectBoardManageList(KwsBoardManageVO boardVO) throws Exception;
	
	/**
     * 게시판 관리 상세 정보를 조회한다.
     *
     * @param vo - 게시판 관리 정보가 담긴 KwsBoardManageVO
     * @throws Exception
     */
	public EgovMap selectBoardManageView(KwsBoardManageVO boardVO) throws Exception;
	
	/**
     * 게시판 관리 정보를 등록한다.
     *
     * @param vo - 게시판 관리 정보가 담긴 KwsBoardManageVO
     * @throws Exception
     */
    public String insertBoardManage(KwsBoardManageVO boardVO) throws Exception;
    
    /**
     * 게시판 관리 정보를 수정한다.
     *
     * @param vo - 게시판 관리 정보가 담긴 KwsBoardManageVO
     * @throws Exception
     */
    public String updateBoardManage(KwsBoardManageVO boardVO) throws Exception;
    
    /**
     * 게시판 관리 정보를 삭제한다.
     *
     * @param vo - 게시판 관리 정보가 담긴 KwsBoardManageVO
     * @throws Exception
     */
	public String deleteBoardManage(KwsBoardManageVO boardVO) throws Exception;

}
