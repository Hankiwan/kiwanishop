package egovframework.admin.common.include.service;

import java.util.List;
import java.util.Map;

import egovframework.admin.menu.service.KwsMenuManageVO;

/**  
 * @Class Name : KwsIncludeManageService.java
 * @Description : KwsIncludeManageService Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2014.06.05           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2014. 06.05
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */
public interface KwsIncludeManageService {

	/**
     * 관리자 메뉴 Gnb 목록을 조회 한다.
     *
     * @param vo - 메뉴정보가 담긴 KwsIncludeManageVO
     * @throws Exception
     */
	public Map<String, Object> menuGnbMap(KwsMenuManageVO menuVO) throws Exception;
	
	/**
     * 관리자 lnb 메뉴 목록을 조회 한다.
     *
     * @param vo - include정보가 담긴 KwsIncludeManageVO
     * @throws Exception
     */
	public List<KwsMenuManageVO> menuLnbList(KwsIncludeManageVO includeVO) throws Exception;
	
	/**
     * 관리자 선택된 메뉴 이름을 조회 한다.
     *
     * @param vo - include정보가 담긴 KwsIncludeManageVO
     * @throws Exception
     */
	public String menuFirstNm(KwsIncludeManageVO includeVO) throws Exception;
	
	/**
     * 관리자 최상위 메뉴 코드를 조회 한다.
     *
     * @param vo - include정보가 담긴 KwsIncludeManageVO
     * @throws Exception
     */
	public String minMenuCode(KwsIncludeManageVO includeVO) throws Exception;
	
}
