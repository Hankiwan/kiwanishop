package egovframework.home.common.include.service;

import java.util.List;
import java.util.Map;

import egovframework.home.menu.service.KwsMenuVO;

/**  
 * @Class Name : KwsIncludeService.java
 * @Description : KwsIncludeService Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2014.08.18           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2014. 08.18
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */
public interface KwsIncludeService {

	/**
     * 사용자 메뉴 Gnb 목록을 조회 한다.
     *
     * @param vo - 메뉴정보가 담긴 KwsIncludeVO
     * @throws Exception
     */
	public Map<String, Object> menuGnbMap(KwsMenuVO menuVO) throws Exception;
	
	/**
     * 사용자 lnb 메뉴 목록을 조회 한다.
     *
     * @param vo - include정보가 담긴 KwsIncludeVO
     * @throws Exception
     */
	public List<KwsMenuVO> menuLnbList(KwsIncludeVO includeVO) throws Exception;
	
	/**
     * 사용자 선택된 메뉴 이름을 조회 한다.
     *
     * @param vo - include정보가 담긴 KwsIncludeVO
     * @throws Exception
     */
	public String menuFirstNm(KwsIncludeVO includeVO) throws Exception;
	
	/**
     * 사용자 최상위 메뉴 코드를 조회 한다.
     *
     * @param vo - include정보가 담긴 KwsIncludeVO
     * @throws Exception
     */
	public String minMenuCode(KwsIncludeVO includeVO) throws Exception;
	
}
