package egovframework.admin.result.service;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.util.EgovMap;

/**  
 * @Class Name : KwsResultManageService.java
 * @Description : KwsResultManageService Class
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
public interface KwsResultManageService {

	/**
     * 실적 목록을 조회 한다.
     *
     * @param vo - 실적정보가 담긴 KwsResultManageVO
     * @throws Exception
     */
	public Map<String, Object> resultList(KwsResultManageVO resultVO) throws Exception;
	
	/**
     * 실적 상세 정보를 조회 한다.
     *
     * @param vo - 실적정보가 담긴 KwsResultManageVO
     * @throws Exception
     */
	public List<KwsResultManageVO> resultDetailView(KwsResultManageVO resultVO) throws Exception;
	
	/**
     * 실적 정보을 등록 한다.
     *
     * @param vo - 실적정보가 담긴 KwsResultManageVO
     * @throws Exception
     */
    public String resultInsert(KwsResultManageVO resultVO) throws Exception;
    
    /**
     * 실적 마스터 및 상세정보를 삭제 한다.
     *
     * @param vo - 실적정보가 담긴 KwsResultManageVO
     * @throws Exception
     */
	public String resultDelete(KwsResultManageVO resultVO) throws Exception;
    
	/**
     * 비교할 실적 상세 조회 한다.
     *
     * @param vo - 실적정보가 담긴 KwsResultManageVO
     * @throws Exception
     */
	public List<EgovMap> resultCompareView(KwsResultManageVO resultVO) throws Exception;
}
