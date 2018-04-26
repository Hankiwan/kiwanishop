package egovframework.admin.common.include.service;

/**
 * include 관련 정보를 담고 있는 VO 클래스
 *
 * @author 기와니샵 개발팀 한기완
 * @since 2014. 04. 21.
 * @version 1.0
 * @see
 *
 * <pre>
 *  == 개정이력(Modification Information) ==
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2014. 04. 21.  한기완          최초 생성
 *
 * </pre>
 */
public class KwsIncludeManageVO {

	/** 세션그룹아이디 */
	private String sGroupId;
	/** gnb메뉴코드 */
	private String gnbMenuCd;
	/** lnb메뉴코드 */
	private String lnbMenuCd;
	
	
	public String getGnbMenuCd() {
		return gnbMenuCd;
	}
	public void setGnbMenuCd(String gnbMenuCd) {
		this.gnbMenuCd = gnbMenuCd;
	}
	public String getLnbMenuCd() {
		return lnbMenuCd;
	}
	public void setLnbMenuCd(String lnbMenuCd) {
		this.lnbMenuCd = lnbMenuCd;
	}
	/**
	 * sGroupId attribute 를 리턴한다.
	 * @return String
	 */
	public String getSGroupId() {
		return sGroupId;
	}
	/**
	 * sGroupId attribute 값을 설정한다.
	 * @param sGroupId String
	 */
	public void setSGroupId(String groupId) {
		sGroupId = groupId;
	}

}