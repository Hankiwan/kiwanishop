package egovframework.admin.code.service;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.util.EgovMap;

/**  
 * @Class Name : KwsCodeManageService.java
 * @Description : KwsCodeManageService Class
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
public interface KwsCodeManageService {

	/**
     * 코드 목록을 조회 한다.
     *
     * @param vo - 코드정보가 담긴 KwsCodeManageVO
     * @throws Exception
     */
	public Map<String, Object> selectCodeList(KwsCodeManageVO codeVO) throws Exception;
	
	/**
     * 코드 상세 정보를 조회한다.
     *
     * @param vo - 코드정보가 담긴 KwsCodeManageVO
     * @throws Exception
     */
	public EgovMap selectCodeView(KwsCodeManageVO codeVO) throws Exception;
	
	/**
     * 코드 정보를 등록한다.
     *
     * @param vo - 코드정보가 담긴 KwsCodeManageVO
     * @throws Exception
     */
    public String insertCode(KwsCodeManageVO codeVO) throws Exception;
    
    /**
     * 코드 정보를 수정한다.
     *
     * @param vo - 코드정보가 담긴 KwsCodeManageVO
     * @throws Exception
     */
    public String updateCode(KwsCodeManageVO codeVO) throws Exception;
    
    /**
     * 코드 정보를 삭제한다.
     *
     * @param vo - 코드정보가 담긴 KwsCodeManageVO
     * @throws Exception
     */
	public String deleteCode(KwsCodeManageVO codeVO) throws Exception;
	
	/**
     * 아이디 중복 체크.
     *
     * @param vo - 코드정보가 담긴 KwsCodeManageVO
     * @throws Exception
     */
	public int idOverlapChk(KwsCodeManageVO codeVO) throws Exception;
	
	/**
     * 출력할 코드 목록을 조회 한다.
     *
     * @param vo - 코드정보가 담긴 KwsCodeManageVO
     * @throws Exception
     */
	public List<KwsCodeManageVO> codeList(KwsCodeManageVO codeVO) throws Exception;

}
