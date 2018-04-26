package egovframework.admin.member.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.admin.member.service.KwsMemberManageVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**  
 * @Class Name : KwsMemberManageDAO.java
 * @Description : KwsMemberManage DAO DAO Class
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

@Repository("kwsMemberManageDAO")
public class KwsMemberManageDAO extends EgovAbstractDAO {

	/**
     * 회원 목록을 조회 한다.
     *
     * @param KwsMemberManageVO
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<KwsMemberManageVO> selectMemberList(KwsMemberManageVO memberVO) throws Exception{
		return list("memberManageDAO.selectMemberList", memberVO);
	}
	
	/**
     * 회원 총갯수 조회 한다.
     *
     * @param KwsResultManageVO
     * @return
     * @throws Exception
     */
	public int selectMemberCnt(KwsMemberManageVO memberVO) throws Exception{
		return (Integer)getSqlMapClientTemplate().queryForObject("memberManageDAO.selectMemberCnt", memberVO);
	}
	
	/**
     * 회원 상세 정보를 조회 한다.
     *
     * @param KwsMemberManageVO
     * @return
     * @throws Exception
     */
	public EgovMap selectMemberView(KwsMemberManageVO memberVO) throws Exception{
		return (EgovMap)selectByPk("memberManageDAO.selectMemberView", memberVO);
	}
	
	/**
     * 회원 등록 여부 체크
     *
     * @param KwsMemberManageVO
     * @return
     * @throws Exception
     */
	public String MemberChk(KwsMemberManageVO memberVO) throws Exception {
		return (String)selectByPk("memberManageDAO.MemberChk", memberVO);
	}
	
	/**
     * 회원 정보을 등록한다.
     *
     * @param KwsMemberManageVO
     * @throws Exception
     */
    public void insertMember(KwsMemberManageVO memberVO) throws Exception {
    	insert("memberManageDAO.insertMember", memberVO);
    }
    
    /**
     * 회원 정보을 수정한다.
     *
     * @param KwsMemberManageVO
     * @throws Exception
     */
    public void updateMember(KwsMemberManageVO memberVO) throws Exception {
    	update("memberManageDAO.updateMember", memberVO);
    }
    
    /**
     * 회원 정보을 삭제한다.
     *
     * @param KwsMemberManageVO
     * @throws Exception
     */
    public void deleteMember(KwsMemberManageVO memberVO) throws Exception {
    	delete("memberManageDAO.deleteMember", memberVO);
    }
    
    /**
     * 아이디 중복 체크
     *
     * @param KwsResultManageVO
     * @return
     * @throws Exception
     */
    public int idOverlapChk(KwsMemberManageVO memberVO) throws Exception {
    	return (Integer)getSqlMapClientTemplate().queryForObject("memberManageDAO.idOverlapChk", memberVO);
    }
    
    /**
     * 메뉴 권한 목록 조회
     *
     * @param KwsMemberManageVO
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<KwsMemberManageVO> selectMenuAuthList(KwsMemberManageVO memberVO) throws Exception{
		return list("memberManageDAO.selectMenuAuthList", memberVO);
	}
    
    /**
     * 메뉴 권한 등록 
     *
     * @param KwsMemberManageVO
     * @throws Exception
     */
    public void insertMenuAuth(KwsMemberManageVO memberVO) throws Exception {
    	insert("memberManageDAO.insertMenuAuth", memberVO);
    }
    
    /**
     * 메뉴 권한 삭제
     *
     * @param KwsMemberManageVO
     * @throws Exception
     */
    public void deleteMenuAuth(KwsMemberManageVO memberVO) throws Exception {
    	delete("memberManageDAO.deleteMenuAuth", memberVO);
    }
	
}
