package egovframework.admin.result.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.admin.result.service.KwsResultManageService;
import egovframework.admin.result.service.KwsResultManageVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**  
 * @Class Name : KwsResultManageServiceImpl.java
 * @Description : KwsResultManage Implement Class
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
@Service("kwsResultManageService")
public class KwsResultManageServiceImpl extends AbstractServiceImpl implements 
		KwsResultManageService {

	/** KwsResultManageDAO */
	@Resource(name="kwsResultManageDAO")
	private KwsResultManageDAO kwsResultManageDAO;
	
	@Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
	
	/**
	 * 실적 목록을 조회한다.
	 * @param vo - 실적 정보가 담긴 KwsResultManageVO
	 * @exception Exception
	 */
	public Map<String, Object> resultList(KwsResultManageVO resultVO) throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
	
		List<KwsResultManageVO> resultList = kwsResultManageDAO.resultMasterList(resultVO);
		
		int totalCnt = kwsResultManageDAO.resultMasterListCnt(resultVO);
		
		resultMap.put("resultList", resultList);
		resultMap.put("totalCnt", Integer.toString(totalCnt));
		
		return resultMap;
	}
	
	/**
	 * 실적 상세 정보를 조회한다.
	 * @param vo - 실적 정보가 담긴 KwsResultManageVO
	 * @exception Exception
	 */
	public List<KwsResultManageVO> resultDetailView(KwsResultManageVO resultVO) throws Exception{
		return kwsResultManageDAO.resultDetailView(resultVO);
	}
	
    /**
	 * 실적 정보를 등록한다.
	 * @param vo - 실적 정보가 담긴 KwsResultManageVO
	 * @exception Exception
	 */
    public String resultInsert(KwsResultManageVO resultVO) throws Exception {
    	
    	String msg = "";
    	
    	if(kwsResultManageDAO.resultOverlapChk(resultVO) < 1){	//실적 중복 등록 체크
    	
	    	ArrayList<String> list = resultVO.getResultList();
	
	    	kwsResultManageDAO.resultMasterInsert(resultVO);
	    	
	    	String resultMasterSn = kwsResultManageDAO.getResultMasterSn(resultVO);		//실적 현재 마스터 일련번호 구하기
	    	
	    	resultVO.setResultMasterSn(resultMasterSn);
	    	
	    	boolean totalChk = false;	//SUB.TOTAL 인 셀 체크
	    	String[] arrayResult = null;
	    	
	    	for(int i=0; i<list.size(); i++){
	    		arrayResult = list.get(i).split(",");
	    		if(arrayResult[1].equals("SUB.TOTAL")){		//총계인 row일 경우
					resultVO.setGubunOne(arrayResult[0]);    				
					resultVO.setGubunTwo(arrayResult[1]);
					resultVO.setGubunThree(arrayResult[2]);
					resultVO.setTotalOne(arrayResult[3]);
					resultVO.setTotalTwo(arrayResult[4]);
					resultVO.setTotalThree(arrayResult[5]);
					resultVO.setTotalFour(arrayResult[6]);
					resultVO.setTotalFive(arrayResult[7]);
					resultVO.setTotalSix(arrayResult[8]);
					resultVO.setTotalSeven(arrayResult[9]);
	    		}else{
	    			resultVO.setGubunOne(arrayResult[0]);    				
	    			resultVO.setGubunTwo(arrayResult[1]);
	    			resultVO.setGubunThree(arrayResult[2]);
	    			resultVO.setWeight(arrayResult[3]); 
	    			resultVO.setSilwhaju(arrayResult[4]);
	    			resultVO.setFwd(arrayResult[5]);
	    			resultVO.setVolumeTotal(arrayResult[6]);
	    			resultVO.setTeu(arrayResult[7]);
	    			resultVO.setCount(arrayResult[8]);
	    			resultVO.setProfitUsd(arrayResult[9]);
	    		}
				
	    		kwsResultManageDAO.resultDetailInsert(resultVO);
	    		
	    		resultVO.setGubunOne("");
				resultVO.setGubunTwo("");
				resultVO.setGubunThree("");
				resultVO.setWeight("");
				resultVO.setSilwhaju("");
				resultVO.setFwd("");
				resultVO.setVolumeTotal("");
				resultVO.setTeu("");
				resultVO.setCount("");
				resultVO.setProfitUsd("");
				resultVO.setTotalOne("");
				resultVO.setTotalTwo("");
				resultVO.setTotalThree("");
				resultVO.setTotalFour("");
				resultVO.setTotalFive("");
				resultVO.setTotalSix("");
				resultVO.setTotalSeven("");
	    		
	    	}
	    	
	    	msg = egovMessageSource.getMessage("Com.text.insert.success");	//등록되었습니다.
	    	
    	}else{
    		msg = egovMessageSource.getMessage("Com.text.insert.already");	//이미 등록되었습니다.
    	}
    	
    	return msg;
    	
    }
    
    /**
	 * 실적 마스터 및 상세정보를 삭제 한다.
	 * @param vo - 실적 정보가 담긴 KwsResultManageVO
	 * @exception Exception
	 */
    public String resultDelete(KwsResultManageVO resultVO) throws Exception{
    	
    	kwsResultManageDAO.resultMasterDelete(resultVO);	//실적 마스터를 삭제한다.
    	
    	kwsResultManageDAO.resultDetailDelete(resultVO);	//실적 상세 정보를 삭제한다.
    	
    	String msg = egovMessageSource.getMessage("Com.text.delete.success");	//삭제되었습니다.
    	return msg;
    }
    
    /**
	 * 비교할 실적 상세 조회 한다.
	 * @param vo - 실적 정보가 담긴 KwsResultManageVO
	 * @exception Exception
	 */
    public List<EgovMap> resultCompareView(KwsResultManageVO resultVO) throws Exception{
    	return kwsResultManageDAO.resultCompareView(resultVO);
    }
}
