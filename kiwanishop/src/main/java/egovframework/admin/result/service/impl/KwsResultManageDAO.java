package egovframework.admin.result.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.admin.result.service.KwsResultManageVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**  
 * @Class Name : KwsResultManageDAO.java
 * @Description : KwsResultManage DAO DAO Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2014.04.21           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2014. 04.21
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */

@Repository("kwsResultManageDAO")
public class KwsResultManageDAO extends EgovAbstractDAO {

	/**
     * 실적 목록을 조회 한다.
     *
     * @param KwsResultManageVO
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<KwsResultManageVO> resultMasterList(KwsResultManageVO resultVO) throws Exception{
		return list("kwsResultManageVO.resultMasterList", resultVO);
	}
	
	/**
     * 실적 총갯수 조회 한다.
     *
     * @param KwsResultManageVO
     * @return
     * @throws Exception
     */
	public int resultMasterListCnt(KwsResultManageVO resultVO) throws Exception{
		return (Integer)getSqlMapClientTemplate().queryForObject("kwsResultManageVO.resultMasterListCnt", resultVO);
	}
	
	/**
     * 실적 상세 정보를 조회 한다.
     *
     * @param KwsResultManageVO
     * @return
     * @throws Exception
     */
	public List<KwsResultManageVO> resultDetailView(KwsResultManageVO resultVO) throws Exception{
		return list("kwsResultManageVO.resultDetailView", resultVO);
	}
	
	/**
     * 실적 중복 등록 체크
     *
     * @param KwsResultManageVO
     * @return 
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public int resultOverlapChk(KwsResultManageVO resultVO) throws Exception {
    	return (Integer)getSqlMapClientTemplate().queryForObject("kwsResultManageVO.resultOverlapChk", resultVO);
    }
	
	/**
     * 실적의 마스터 정보을 등록 한다.
     *
     * @param KwsResultManageVO
     * @throws Exception
     */
    public void resultMasterInsert(KwsResultManageVO resultVO) throws Exception {
    	insert("kwsResultManageVO.resultMasterInsert", resultVO);
    }
    
    /**
     * 실적의 상세 정보을 등록 한다.
     *
     * @param KwsResultManageVO
     * @throws Exception
     */
    public void resultDetailInsert(KwsResultManageVO resultVO) throws Exception {
    	insert("kwsResultManageVO.resultDetailInsert", resultVO);
    }
    
    /**
     * 실적 현재 마스터 일련번호 구하기
     *
     * @param KwsResultManageVO
     * @return 
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public String getResultMasterSn(KwsResultManageVO resultVO) throws Exception {
    	return (String)selectByPk("kwsResultManageVO.getResultMasterSn", resultVO);
    }
    
    /**
     * 실적 마스터를 삭제한다.
     *
     * @param KwsResultManageVO
     * @return
     * @throws Exception
     */
    public void resultMasterDelete(KwsResultManageVO resultVO) throws Exception{
    	delete("kwsResultManageVO.resultMasterDelete", resultVO);
    }
    
    /**
     * 실적 상세 정보를 삭제한다.
     *
     * @param KwsResultManageVO
     * @return
     * @throws Exception
     */
    public void resultDetailDelete(KwsResultManageVO resultVO) throws Exception{
    	delete("kwsResultManageVO.resultDetailDelete", resultVO);
    }
    
    /**
     * 비교할 실적 상세 조회한다.
     *
     * @param KwsResultManageVO
     * @return
     * @throws Exception
     */
    public List<EgovMap> resultCompareView(KwsResultManageVO resultVO) throws Exception{
    	return list("kwsResultManageVO.resultCompareView", resultVO);
    }
	
}
