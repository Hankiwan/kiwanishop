package egovframework.admin.member.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.admin.member.service.KwsMemberManageService;
import egovframework.admin.member.service.KwsMemberManageVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.utl.util.SHA256;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**  
 * @Class Name : KwsMemberManageServiceImpl.java
 * @Description : KwsMemberManage Implement Class
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
@Service("kwsMemberManageService")
public class KwsMemberManageServiceImpl extends AbstractServiceImpl implements 
		KwsMemberManageService {

	/** KwsMemberManageDAO */
	@Resource(name="kwsMemberManageDAO")
	private KwsMemberManageDAO kwsMemberManageDAO;
	
	@Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
	
	/**
	 * 회원 목록을 조회한다.
	 * @param vo - 회원 정보가 담긴 KwsMemberManageVO
	 * @exception Exception
	 */
	public Map<String, Object> memberList(KwsMemberManageVO memberVO) throws Exception{
		Map<String, Object> memberMap = new HashMap<String, Object>();
	
		List<KwsMemberManageVO> memberList = kwsMemberManageDAO.selectMemberList(memberVO);
		
		int totalCnt = kwsMemberManageDAO.selectMemberCnt(memberVO);
		
		memberMap.put("memberList", memberList);
		memberMap.put("totalCnt", Integer.toString(totalCnt));
		
		return memberMap;
	}
	
	/**
	 * 회원 상세 정보를 조회한다.
	 * @param vo - 회원 정보가 담긴 KwsMemberManageVO
	 * @exception Exception
	 */
	public EgovMap selectMemberView(KwsMemberManageVO memberVO) throws Exception{
		return kwsMemberManageDAO.selectMemberView(memberVO);
	}
	
	/**
	 * 회원 등록 여부 체크
	 * @param vo - 회원 정보가 담긴 KwsMemberManageVO
	 * @exception Exception
	 */
	public String MemberChk(KwsMemberManageVO memberVO) throws Exception {
		return kwsMemberManageDAO.MemberChk(memberVO);
	}
	
    /**
	 * 회원 정보를 등록한다.
	 * @param vo - 회원 정보가 담긴 KwsMemberManageVO
	 * @exception Exception
	 */
    public String insertMember(KwsMemberManageVO memberVO) throws Exception {
    	
    	String msg = "";
    	
    	SHA256 sha256 = new SHA256();
    	memberVO.setPasswd(sha256.getSHA256(memberVO.getPasswd()));
    	
    	kwsMemberManageDAO.insertMember(memberVO);
	    	
    	msg = egovMessageSource.getMessage("Com.text.insert.success");	//등록되었습니다.
    	
    	return msg;
    	
    }
    
    /**
	 * 회원 정보를 수정 한다.
	 * @param vo - 회원 정보가 담긴 KwsMemberManageVO
	 * @exception Exception
	 */
    public String updateMember(KwsMemberManageVO memberVO) throws Exception {
    	String msg = "";
    	
    	SHA256 sha256 = new SHA256();
    	memberVO.setPasswd(sha256.getSHA256(memberVO.getPasswd()));
    	
    	kwsMemberManageDAO.updateMember(memberVO);
    	
    	msg = egovMessageSource.getMessage("Com.text.update.success");
    	
    	return msg;
    }
    
    /**
	 * 회원 정보를 삭제 한다.
	 * @param vo - 회원 정보가 담긴 KwsMemberManageVO
	 * @exception Exception
	 */
    public String deleteMember(KwsMemberManageVO memberVO) throws Exception{
    	
    	kwsMemberManageDAO.deleteMember(memberVO);	
    	
    	String msg = egovMessageSource.getMessage("Com.text.delete.success");	//삭제되었습니다.
    	return msg;
    }
    
    /**
	 * 아이디 중복 체크.
	 * @param vo - 회원 정보가 담긴 KwsMemberManageVO
	 * @exception Exception
	 */
    public int idOverlapChk(KwsMemberManageVO memberVO) throws Exception {
    	return kwsMemberManageDAO.idOverlapChk(memberVO);
    }
    
    /**
	 * 메뉴 권한 등록
	 * @param vo - 회원 정보가 담긴 KwsMemberManageVO
	 * @exception Exception
	 */
    public String insertMenuAuth(KwsMemberManageVO memberVO) throws Exception {
    	
    	String msg = "";
    	
    	kwsMemberManageDAO.deleteMenuAuth(memberVO);	//메뉴 권한 삭제
    	
    	if(memberVO.getChkbxMenu() != null){
	    	String[] chkbxMenuArr = memberVO.getChkbxMenu();
	    	if(chkbxMenuArr.length > 0){
	    		memberVO.setOpenYn("Y");
	    		for(int i=0; i<chkbxMenuArr.length; i++){
	    			memberVO.setMenuCode(chkbxMenuArr[i]);
	    			kwsMemberManageDAO.insertMenuAuth(memberVO);	//메뉴 권한 등록
	    		}
	    	}
    	}
    	
    	msg = egovMessageSource.getMessage("Com.text.insert.success");	//등록되었습니다.
    	
    	return msg;
    	
    }
    
    /**
	 * 메뉴 권한 목록 조회
	 * @param vo - 회원 정보가 담긴 KwsMemberManageVO
	 * @exception Exception
	 */
	public List<KwsMemberManageVO> selectMenuAuthList(KwsMemberManageVO memberVO) throws Exception{
		return kwsMemberManageDAO.selectMenuAuthList(memberVO);
	}

}
