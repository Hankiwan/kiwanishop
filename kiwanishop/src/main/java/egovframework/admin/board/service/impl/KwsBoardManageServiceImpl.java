package egovframework.admin.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.admin.board.service.KwsBoardManageService;
import egovframework.admin.board.service.KwsBoardManageVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**  
 * @Class Name : KwsBoardManageServiceImpl.java
 * @Description : KwsBoardManage Implement Class
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
@Service("kwsBoardManageService")
public class KwsBoardManageServiceImpl extends AbstractServiceImpl implements 
		KwsBoardManageService {

	/** KwsBoardManageDAO */
	@Resource(name="kwsBoardManageDAO")
	private KwsBoardManageDAO kwsBoardManageDAO;
	
	@Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
	
	/**
	 * 게시판 관리 목록을 조회한다.
	 * @param vo - 게시판 관리 정보가 담긴 KwsBoardManageVO
	 * @exception Exception
	 */
	public Map<String, Object> selectBoardManageList(KwsBoardManageVO boardVO) throws Exception{
		Map<String, Object> boardMap = new HashMap<String, Object>();
	
		List<KwsBoardManageVO> selectBoardManageList = kwsBoardManageDAO.selectBoardManageList(boardVO);
		
		int totalCnt = kwsBoardManageDAO.selectBoardManageCnt(boardVO);
		
		boardMap.put("selectBoardManageList", selectBoardManageList);
		boardMap.put("totalCnt", Integer.toString(totalCnt));
		
		return boardMap;
	}
	
	/**
	 * 게시판 관리 상세 정보를 조회한다.
	 * @param vo - 게시판 관리 정보가 담긴 KwsBoardManageVO
	 * @exception Exception
	 */
	public EgovMap selectBoardManageView(KwsBoardManageVO boardVO) throws Exception{
		return kwsBoardManageDAO.selectBoardManageView(boardVO);
	}
	
    /**
	 * 게시판 관리 정보를 등록한다.
	 * @param vo - 게시판 관리 정보가 담긴 KwsBoardManageVO
	 * @exception Exception
	 */
    public String insertBoardManage(KwsBoardManageVO boardVO) throws Exception {
    	
    	String msg = "";
    	
    	kwsBoardManageDAO.insertBoardManage(boardVO);
	    	
    	msg = egovMessageSource.getMessage("Com.text.insert.success");	//등록되었습니다.
    	
    	return msg;
    	
    }
    
    /**
	 * 게시판 관리 정보를 수정 한다.
	 * @param vo - 게시판 관리 정보가 담긴 KwsBoardManageVO
	 * @exception Exception
	 */
    public String updateBoardManage(KwsBoardManageVO boardVO) throws Exception {
    	String msg = "";
    	
    	kwsBoardManageDAO.updateBoardManage(boardVO);
    	
    	msg = egovMessageSource.getMessage("Com.text.update.success");
    	
    	return msg;
    }
    
    /**
	 * 게시판 관리 정보를 삭제 한다.
	 * @param vo - 게시판 관리 정보가 담긴 KwsBoardManageVO
	 * @exception Exception
	 */
    public String deleteBoardManage(KwsBoardManageVO boardVO) throws Exception{
    	
    	kwsBoardManageDAO.deleteBoardManage(boardVO);	
    	
    	String msg = egovMessageSource.getMessage("Com.text.delete.success");	//삭제되었습니다.
    	return msg;
    }

}
