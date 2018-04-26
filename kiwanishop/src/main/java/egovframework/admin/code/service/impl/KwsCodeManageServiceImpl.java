package egovframework.admin.code.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.admin.code.service.KwsCodeManageService;
import egovframework.admin.code.service.KwsCodeManageVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**  
 * @Class Name : KwsCodeManageServiceImpl.java
 * @Description : KwsCodeManage Implement Class
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
@Service("kwsCodeManageService")
public class KwsCodeManageServiceImpl extends AbstractServiceImpl implements 
		KwsCodeManageService {

	/** KwsCodeManageDAO */
	@Resource(name="kwsCodeManageDAO")
	private KwsCodeManageDAO kwsCodeManageDAO;
	
	@Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
	
	/**
	 * 코드 목록을 조회한다.
	 * @param vo - 코드 정보가 담긴 KwsCodeManageVO
	 * @exception Exception
	 */
	public Map<String, Object> selectCodeList(KwsCodeManageVO codeVO) throws Exception{
		Map<String, Object> codeMap = new HashMap<String, Object>();
	
		List<KwsCodeManageVO> selectCodeList = kwsCodeManageDAO.selectCodeList(codeVO);
		
		int totalCnt = kwsCodeManageDAO.selectCodeCnt(codeVO);
		
		codeMap.put("selectCodeList", selectCodeList);
		codeMap.put("totalCnt", Integer.toString(totalCnt));
		
		return codeMap;
	}
	
	/**
	 * 코드 상세 정보를 조회한다.
	 * @param vo - 코드 정보가 담긴 KwsCodeManageVO
	 * @exception Exception
	 */
	public EgovMap selectCodeView(KwsCodeManageVO codeVO) throws Exception{
		return kwsCodeManageDAO.selectCodeView(codeVO);
	}
	
    /**
	 * 코드 정보를 등록한다.
	 * @param vo - 코드 정보가 담긴 KwsCodeManageVO
	 * @exception Exception
	 */
    public String insertCode(KwsCodeManageVO codeVO) throws Exception {
    	
    	String msg = "";
    	
    	kwsCodeManageDAO.insertCode(codeVO);
	    	
    	msg = egovMessageSource.getMessage("Com.text.insert.success");	//등록되었습니다.
    	
    	return msg;
    	
    }
    
    /**
	 * 코드 정보를 수정 한다.
	 * @param vo - 코드 정보가 담긴 KwsCodeManageVO
	 * @exception Exception
	 */
    public String updateCode(KwsCodeManageVO codeVO) throws Exception {
    	String msg = "";
    	
    	kwsCodeManageDAO.updateCode(codeVO);
    	
    	msg = egovMessageSource.getMessage("Com.text.update.success");
    	
    	return msg;
    }
    
    /**
	 * 코드 정보를 삭제 한다.
	 * @param vo - 코드 정보가 담긴 KwsCodeManageVO
	 * @exception Exception
	 */
    public String deleteCode(KwsCodeManageVO codeVO) throws Exception{
    	
    	kwsCodeManageDAO.deleteCode(codeVO);	
    	
    	String msg = egovMessageSource.getMessage("Com.text.delete.success");	//삭제되었습니다.
    	return msg;
    }
    
    /**
	 * 아이디 중복 체크.
	 * @param vo - 코드 정보가 담긴 KwsCodeManageVO
	 * @exception Exception
	 */
    public int idOverlapChk(KwsCodeManageVO codeVO) throws Exception {
    	return kwsCodeManageDAO.idOverlapChk(codeVO);
    }
    
    /**
	 * 출력할 코드 목록을 조회한다.
	 * @param vo - 코드 정보가 담긴 KwsCodeManageVO
	 * @exception Exception
	 */
	public List<KwsCodeManageVO> codeList(KwsCodeManageVO codeVO) throws Exception{
		return kwsCodeManageDAO.codeList(codeVO);
	}

}
