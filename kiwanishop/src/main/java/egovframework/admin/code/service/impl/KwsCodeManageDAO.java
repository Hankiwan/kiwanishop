package egovframework.admin.code.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.admin.code.service.KwsCodeManageVO;
import egovframework.admin.member.service.KwsMemberManageVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**  
 * @Class Name : KwsCodeManageDAO.java
 * @Description : KwsCodeManage DAO DAO Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2014.05.26           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2014. 05.26
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */

@Repository("kwsCodeManageDAO")
public class KwsCodeManageDAO extends EgovAbstractDAO {

	/**
     * 코드 목록을 조회 한다.
     *
     * @param KwsCodeManageVO
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<KwsCodeManageVO> selectCodeList(KwsCodeManageVO codeVO) throws Exception{
		return list("codeManageDAO.selectCodeList", codeVO);
	}
	
	/**
     * 코드 총갯수 조회 한다.
     *
     * @param KwsCodeManageVO
     * @return
     * @throws Exception
     */
	public int selectCodeCnt(KwsCodeManageVO codeVO) throws Exception{
		return (Integer)getSqlMapClientTemplate().queryForObject("codeManageDAO.selectCodeCnt", codeVO);
	}
	
	/**
     * 코드 상세 정보를 조회 한다.
     *
     * @param KwsCodeManageVO
     * @return
     * @throws Exception
     */
	public EgovMap selectCodeView(KwsCodeManageVO codeVO) throws Exception{
		return (EgovMap)selectByPk("codeManageDAO.selectCodeView", codeVO);
	}
	
	/**
     * 코드 정보을 등록한다.
     *
     * @param KwsCodeManageVO
     * @throws Exception
     */
    public void insertCode(KwsCodeManageVO codeVO) throws Exception {
    	insert("codeManageDAO.insertCode", codeVO);
    }
    
    /**
     * 코드 정보을 수정한다.
     *
     * @param KwsCodeManageVO
     * @throws Exception
     */
    public void updateCode(KwsCodeManageVO codeVO) throws Exception {
    	update("codeManageDAO.updateCode", codeVO);
    }
    
    /**
     * 코드 정보을 삭제한다.
     *
     * @param KwsCodeManageVO
     * @throws Exception
     */
    public void deleteCode(KwsCodeManageVO codeVO) throws Exception {
    	delete("codeManageDAO.deleteCode", codeVO);
    }
    
    /**
     * 아이디 중복 체크
     *
     * @param KwsCodeManageVO
     * @return
     * @throws Exception
     */
    public int idOverlapChk(KwsCodeManageVO codeVO) throws Exception {
    	return (Integer)getSqlMapClientTemplate().queryForObject("codeManageDAO.idOverlapChk", codeVO);
    }
    
    /**
     * 출력할 코드 목록을 조회 한다.
     *
     * @param KwsCodeManageVO
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<KwsCodeManageVO> codeList(KwsCodeManageVO codeVO) throws Exception{
		return list("codeManageDAO.codeList", codeVO);
	}
	
}
