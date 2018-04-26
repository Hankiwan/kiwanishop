package egovframework.admin.menu.service;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.util.EgovMap;

/**  
 * @Class Name : KwsMenuManageService.java
 * @Description : KwsMenuManageService Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2014.05.28           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2014. 05.28
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */
public interface KwsMenuManageService {

	/**
     * 메뉴 목록을 조회 한다.
     *
     * @param vo - 메뉴정보가 담긴 KwsMenuManageVO
     * @throws Exception
     */
	public List<KwsMenuManageVO> selectMenuList(KwsMenuManageVO menuVO) throws Exception;
	
	/**
     * 메뉴 상세 정보를 조회한다.
     *
     * @param vo - 메뉴정보가 담긴 KwsMenuManageVO
     * @throws Exception
     */
	public EgovMap selectMenuView(KwsMenuManageVO menuVO) throws Exception;
	
	/**
     * 메뉴 정보를 등록한다.
     *
     * @param vo - 메뉴정보가 담긴 KwsMenuManageVO
     * @throws Exception
     */
    public String insertMenu(KwsMenuManageVO menuVO) throws Exception;
    
    /**
     * 메뉴 정보를 수정한다.
     *
     * @param vo - 메뉴정보가 담긴 KwsMenuManageVO
     * @throws Exception
     */
    public String updateMenu(KwsMenuManageVO menuVO) throws Exception;
    
    /**
     * 메뉴 정보를 삭제한다.
     *
     * @param vo - 메뉴정보가 담긴 KwsMenuManageVO
     * @throws Exception
     */
	public String deleteMenu(KwsMenuManageVO menuVO) throws Exception;
	
	/**
     * 메뉴 뎁스의 max값 + 1 을 조회 한다.
     *
     * @param vo - 메뉴정보가 담긴 KwsMenuManageVO
     * @throws Exception
     */
	public String getMenuDepthMax(KwsMenuManageVO menuVO) throws Exception;
	
	/**
     * ajax 코드값 가져오기
     *
     * @param vo - 메뉴정보가 담긴 KwsMenuManageVO
     * @throws Exception
     */
	public List<KwsMenuManageVO> ajaxSelectMenu(KwsMenuManageVO menuVO) throws Exception;
	
	/**
     * ajax Menu MAX, MIN 값 가져오기
     *
     * @param vo - 메뉴정보가 담긴 KwsMenuManageVO
     * @throws Exception
     */
	public String ajaxMenuMaxMin(KwsMenuManageVO menuVO) throws Exception;
	
	/**
     * 메뉴 이동되는 코드 앞4자리값
     *
     * @param vo - 메뉴정보가 담긴 KwsMenuManageVO
     * @throws Exception
     */
	public String getMenuDepthOne(KwsMenuManageVO menuVO) throws Exception;
	
	/**
     * 메뉴 이동
     *
     * @param vo - 메뉴정보가 담긴 KwsMenuManageVO
     * @throws Exception
     */
	public String menuChange(KwsMenuManageVO menuVO) throws Exception;
	
	/**
     * 메뉴 코드 리스트
     *
     * @param vo - 메뉴정보가 담긴 KwsMenuManageVO
     * @throws Exception
     */
	public List<EgovMap> getMenuDepthOneList(KwsMenuManageVO menuVO) throws Exception;

}
