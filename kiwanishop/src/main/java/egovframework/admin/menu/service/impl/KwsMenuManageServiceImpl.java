package egovframework.admin.menu.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import egovframework.admin.menu.service.KwsMenuManageService;
import egovframework.admin.menu.service.KwsMenuManageVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**  
 * @Class Name : KwsMenuManageServiceImpl.java
 * @Description : KwsMenuManage Implement Class
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
@Service("kwsMenuManageService")
public class KwsMenuManageServiceImpl extends AbstractServiceImpl implements 
		KwsMenuManageService {

	/** KwsMenuManageDAO */
	@Resource(name="kwsMenuManageDAO")
	private KwsMenuManageDAO kwsMenuManageDAO;
	
	@Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
	
	/**
	 * 메뉴 목록을 조회한다.
	 * @param vo - 메뉴 정보가 담긴 KwsMenuManageVO
	 * @exception Exception
	 */
	public List<KwsMenuManageVO> selectMenuList(KwsMenuManageVO menuVO) throws Exception{
		return kwsMenuManageDAO.selectMenuList(menuVO);
	}
	
	/**
	 * 메뉴 상세 정보를 조회한다.
	 * @param vo - 메뉴 정보가 담긴 KwsMenuManageVO
	 * @exception Exception
	 */
	public EgovMap selectMenuView(KwsMenuManageVO menuVO) throws Exception{
		return kwsMenuManageDAO.selectMenuView(menuVO);
	}
	
    /**
	 * 메뉴 정보를 등록한다.
	 * @param vo - 메뉴 정보가 담긴 KwsMenuManageVO
	 * @exception Exception
	 */
    public String insertMenu(KwsMenuManageVO menuVO) throws Exception {
    	
    	String msg = "";
    	
    	kwsMenuManageDAO.insertMenu(menuVO);
	    	
    	msg = egovMessageSource.getMessage("Com.text.insert.success");	//등록되었습니다.
    	
    	return msg;
    	
    }
    
    /**
	 * 메뉴 정보를 수정 한다.
	 * @param vo - 메뉴 정보가 담긴 KwsMenuManageVO
	 * @exception Exception
	 */
    public String updateMenu(KwsMenuManageVO menuVO) throws Exception {
    	String msg = "";
    	
    	kwsMenuManageDAO.updateMenu(menuVO);
    	
    	msg = egovMessageSource.getMessage("Com.text.update.success");
    	
    	return msg;
    }
    
    /**
	 * 메뉴 정보를 삭제 한다.
	 * @param vo - 메뉴 정보가 담긴 KwsMenuManageVO
	 * @exception Exception
	 */
    public String deleteMenu(KwsMenuManageVO menuVO) throws Exception{
    	
    	kwsMenuManageDAO.deleteMenu(menuVO);	
    	
    	String msg = egovMessageSource.getMessage("Com.text.delete.success");	//삭제되었습니다.
    	return msg;
    }
    
    /**
	 * 메뉴 뎁스의 max값 + 1 을 조회 한다.
	 * @param vo - 메뉴 정보가 담긴 KwsMenuManageVO
	 * @exception Exception
	 */
	public String getMenuDepthMax(KwsMenuManageVO menuVO) throws Exception{
		return kwsMenuManageDAO.getMenuDepthMax(menuVO);
	}
	
	/**
	 * ajax 코드값 가져오기
	 * @param vo - 메뉴 정보가 담긴 KwsMenuManageVO
	 * @exception Exception
	 */
	public List<KwsMenuManageVO> ajaxSelectMenu(KwsMenuManageVO menuVO) throws Exception{
		return kwsMenuManageDAO.ajaxSelectMenu(menuVO);
	}
	
	/**
	 * ajax Menu MAX, MIN 값 가져오기
	 * @param vo - 메뉴 정보가 담긴 KwsMenuManageVO
	 * @exception Exception
	 */
	public String ajaxMenuMaxMin(KwsMenuManageVO menuVO) throws Exception{
		return kwsMenuManageDAO.ajaxMenuMaxMin(menuVO);
	}
	
	/**
	 * 메뉴 이동되는 코드 앞4자리값
	 * @param vo - 메뉴 정보가 담긴 KwsMenuManageVO
	 * @exception Exception
	 */
	public String getMenuDepthOne(KwsMenuManageVO menuVO) throws Exception{
		return kwsMenuManageDAO.getMenuDepthOne(menuVO);
	}
	
	/**
	 * 메뉴 코드 리스트
	 * @param vo - 메뉴 정보가 담긴 KwsMenuManageVO
	 * @exception Exception
	 */
	public List<EgovMap> getMenuDepthOneList(KwsMenuManageVO menuVO) throws Exception{
		return kwsMenuManageDAO.getMenuDepthOneList(menuVO);
	}
	
	/**
	 * 메뉴 이동
	 * @param vo - 메뉴 정보가 담긴 KwsMenuManageVO
	 * @exception Exception
	 */
	public String menuChange(KwsMenuManageVO menuVO) throws Exception{
		
		kwsMenuManageDAO.updateMenuChange(menuVO);
		
		String msg = egovMessageSource.getMessage("Com.text.menuchange.success");	//메뉴 이동에 성공하였습니다.
    	return msg;
	}
}
