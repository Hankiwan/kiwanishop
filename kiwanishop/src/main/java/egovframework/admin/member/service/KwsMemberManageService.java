package egovframework.admin.member.service;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.util.EgovMap;

/**  
 * @Class Name : KwsMemberManageService.java
 * @Description : KwsMemberManageService Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2014.05.16           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2014. 05.16
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */
public interface KwsMemberManageService {

	/**
     * 회원 목록을 조회 한다.
     *
     * @param vo - 회원정보가 담긴 KwsMemberManageVO
     * @throws Exception
     */
	public Map<String, Object> memberList(KwsMemberManageVO memberVO) throws Exception;
	
	/**
     * 회원 상세 정보를 조회한다.
     *
     * @param vo - 회원정보가 담긴 KwsMemberManageVO
     * @throws Exception
     */
	public EgovMap selectMemberView(KwsMemberManageVO memberVO) throws Exception;
	
	/**
     * 회원 등록 여부 체크
     *
     * @param vo - 회원정보가 담긴 KwsMemberManageVO
     * @throws Exception
     */
	public String MemberChk(KwsMemberManageVO memberVO) throws Exception;
	
	/**
     * 회원 정보를 등록한다.
     *
     * @param vo - 회원정보가 담긴 KwsMemberManageVO
     * @throws Exception
     */
    public String insertMember(KwsMemberManageVO memberVO) throws Exception;
    
    /**
     * 회원 정보를 수정한다.
     *
     * @param vo - 회원정보가 담긴 KwsMemberManageVO
     * @throws Exception
     */
    public String updateMember(KwsMemberManageVO memberVO) throws Exception;
    
    /**
     * 회원 정보를 삭제한다.
     *
     * @param vo - 회원정보가 담긴 KwsMemberManageVO
     * @throws Exception
     */
	public String deleteMember(KwsMemberManageVO memberVO) throws Exception;
	
	/**
     * 아이디 중복 체크.
     *
     * @param vo - 회원정보가 담긴 KwsMemberManageVO
     * @throws Exception
     */
	public int idOverlapChk(KwsMemberManageVO memberVO) throws Exception;
	
	/**
     * 메뉴 권한 등록
     *
     * @param vo - 회원정보가 담긴 KwsMemberManageVO
     * @throws Exception
     */
    public String insertMenuAuth(KwsMemberManageVO memberVO) throws Exception;
    
    /**
     * 메뉴 권한 목록 조회
     *
     * @param vo - 회원정보가 담긴 KwsMemberManageVO
     * @throws Exception
     */
	public List<KwsMemberManageVO> selectMenuAuthList(KwsMemberManageVO memberVO) throws Exception;

}
