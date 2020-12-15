package egovframework.admin.commonBoard.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.admin.board.service.KwsBoardManageVO;
import egovframework.admin.commonBoard.service.KwsCommonBoardManageService;
import egovframework.admin.commonBoard.service.KwsCommonBoardManageVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.service.FileVO;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**  
 * @Class Name : KwsCommonBoardManageServiceImpl.java
 * @Description : KwsCommonBoardManage Implement Class
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
@Service("kwsCommonBoardManageService")
public class KwsCommonBoardManageServiceImpl extends AbstractServiceImpl implements 
		KwsCommonBoardManageService {

	/** KwsCommonBoardManageDAO */
	@Resource(name="kwsCommonBoardManageDAO")
	private KwsCommonBoardManageDAO kwsCommonBoardManageDAO;
	
	@Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
	
	/**
	 * 마스터 게시판 목록을 조회한다.
	 * @param vo - 마스터 게시판 정보가 담긴 KwsBoardManageVO
	 * @exception Exception
	 */
	public List<KwsBoardManageVO> selectMasterBoardManageList(KwsCommonBoardManageVO boardVO) throws Exception{
		return kwsCommonBoardManageDAO.selectMasterBoardManageList(boardVO);
	}
	
	/**
	 * 마스터 게시판 상세 정보를 조회한다.
	 * @param vo - 공통 게시판 정보가 담긴 KwsCommonBoardManageVO
	 * @exception Exception
	 */
	public EgovMap selectMasterBoardManageView(KwsCommonBoardManageVO boardVO) throws Exception{
		return kwsCommonBoardManageDAO.selectMasterBoardManageView(boardVO);
	}
	
	/**
	 * 공통 게시판 목록을 조회한다.
	 * @param vo - 공통 게시판 정보가 담긴 KwsCommonBoardManageVO
	 * @exception Exception
	 */
	public Map<String, Object> selectCommonBoardManageList(KwsCommonBoardManageVO boardVO) throws Exception{
		Map<String, Object> boardMap = new HashMap<String, Object>();
	
		List<EgovMap> selectCommonBoardManageList = kwsCommonBoardManageDAO.selectCommonBoardManageList(boardVO);
		
		for(int i = 0; i < selectCommonBoardManageList.size(); i++){
			EgovMap commonBoardMap = selectCommonBoardManageList.get(i);
			if(commonBoardMap.get("fileId") != null){
				List<EgovMap> fileMap = kwsCommonBoardManageDAO.selectFileList((String)commonBoardMap.get("fileId"));
				selectCommonBoardManageList.get(i).put("setFiles", fileMap);	
			}
		}
		
		int totalCnt = kwsCommonBoardManageDAO.selectCommonBoardManageCnt(boardVO);
		
		boardMap.put("selectCommonBoardManageList", selectCommonBoardManageList);
		boardMap.put("totalCnt", Integer.toString(totalCnt));
		
		return boardMap;
	}
	
	/**
	 * 공통 게시판 상세 정보를 조회한다.
	 * @param vo - 공통 게시판 정보가 담긴 KwsCommonBoardManageVO
	 * @exception Exception
	 */
	public EgovMap selectCommonBoardManageView(KwsCommonBoardManageVO boardVO) throws Exception{
		return kwsCommonBoardManageDAO.selectCommonBoardManageView(boardVO);
	}
	
    /**
	 * 공통 게시판 정보를 등록한다.
	 * @param vo - 공통 게시판 정보가 담긴 KwsBoardManageVO
	 * @exception Exception
	 */
    public String insertCommonBoardManage(KwsCommonBoardManageVO boardVO) throws Exception {
    	
    	String msg = "";
    	
    	if(boardVO.getFile() != null){
    		kwsCommonBoardManageDAO.insertFile(boardVO.getFile());
    		kwsCommonBoardManageDAO.insertFileDetail(boardVO.getFile());
    	}
    	
    	kwsCommonBoardManageDAO.insertCommonBoardManage(boardVO);
	    	
    	msg = egovMessageSource.getMessage("Com.text.insert.success");	//등록되었습니다.
    	
    	return msg;
    	
    }
    
    /**
	 * 공통 게시판 정보를 수정 한다.
	 * @param vo - 공통 게시판 정보가 담긴 KwsCommonBoardManageVO
	 * @exception Exception
	 */
    public String updateCommonBoardManage(KwsCommonBoardManageVO boardVO) throws Exception {
    	String msg = "";
    	
    	kwsCommonBoardManageDAO.updateCommonBoardManage(boardVO);
    	
    	msg = egovMessageSource.getMessage("Com.text.update.success");
    	
    	return msg;
    }
    
    /**
	 * 공통 게시판 정보를 삭제 한다.
	 * @param vo - 공통 게시판 정보가 담긴 KwsCommonBoardManageVO
	 * @exception Exception
	 */
    public String deleteCommonBoardManage(KwsCommonBoardManageVO boardVO) throws Exception{
    	
    	kwsCommonBoardManageDAO.deleteCommonBoardManage(boardVO);	
    	
    	String msg = egovMessageSource.getMessage("Com.text.delete.success");	//삭제되었습니다.
    	return msg;
    }
	
}
