package egovframework.admin.result.service;

import java.util.ArrayList;

import egovframework.admin.common.KwsPageVO;

/**  
 * @Class Name : KwsResultManageVO.java
 * @Description : 로그인 정보를 담고있는 Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2014.04.21           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2014. 04.21
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */

public class KwsResultManageVO extends KwsPageVO {

	/** 등록 년 */
	private String registYear;
	
	/** 등록 월 */
	private String registMonth;
	
	/** 마스터 일련번호  */
	private String resultMasterSn;
	
	/** 마스터 삭제 여부  */
	private String deleteYn;
	
	/** 최초등록일  */
	private String frstRegistDt;

	/** 최초등록아이디  */
	private String frstRegistId;
	
	/** 최초등록아이피  */
	private String frstRegistIp;
	
	/** 최종수정일  */
	private String lastUpdtDt;
	
	/** 최종수정아이디  */
	private String lastUpdtId;
	
	/** 최종수정아이피  */
	private String lastUpdtIp;
	
	/** 상세 일련번호  */
	private String resultDetailSn;
	
	/** gubun1  */
	private String gubunOne;
	
	/** gubun2  */
	private String gubunTwo;
	
	/** gubun3  */
	private String gubunThree;
	
	/** weight  */
	private String weight;
	
	/** silwhaju  */
	private String silwhaju;
	
	/** fwd  */
	private String fwd;
	
	/** volume_total  */
	private String volumeTotal;
	
	/** teu  */
	private String teu;
	
	/** count  */
	private String count;
	
	/** profit_usd  */
	private String profitUsd;
	
	/** total_one  */
	private String totalOne;
	
	/** total_two  */
	private String totalTwo;
	
	/** total_three  */
	private String totalThree;
	
	/** total_four  */
	private String totalFour;
	
	/** total_five  */
	private String totalFive;
	
	/** total_six  */
	private String totalSix;
	
	/** total_seven  */
	private String totalSeven;
	
	/** all_total  */
	private String allTotal;

	/** resultList  */
	private ArrayList<String> resultList;
	
    /** 선택된 년월 */
    private String selectDate;
    
    /** 검색 타입 */
    private String searchType;
    
    /** 검색 값 */
    private String searchValue;

    
	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getSelectDate() {
		return selectDate;
	}

	public void setSelectDate(String selectDate) {
		this.selectDate = selectDate;
	}

	public ArrayList<String> getResultList() {
		return resultList;
	}

	public void setResultList(ArrayList<String> resultList) {
		this.resultList = resultList;
	}

	public String getResultMasterSn() {
		return resultMasterSn;
	}

	public void setResultMasterSn(String resultMasterSn) {
		this.resultMasterSn = resultMasterSn;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	public String getFrstRegistDt() {
		return frstRegistDt;
	}

	public void setFrstRegistDt(String frstRegistDt) {
		this.frstRegistDt = frstRegistDt;
	}

	public String getFrstRegistId() {
		return frstRegistId;
	}

	public void setFrstRegistId(String frstRegistId) {
		this.frstRegistId = frstRegistId;
	}

	public String getFrstRegistIp() {
		return frstRegistIp;
	}

	public void setFrstRegistIp(String frstRegistIp) {
		this.frstRegistIp = frstRegistIp;
	}

	public String getLastUpdtDt() {
		return lastUpdtDt;
	}

	public void setLastUpdtDt(String lastUpdtDt) {
		this.lastUpdtDt = lastUpdtDt;
	}

	public String getLastUpdtId() {
		return lastUpdtId;
	}

	public void setLastUpdtId(String lastUpdtId) {
		this.lastUpdtId = lastUpdtId;
	}

	public String getLastUpdtIp() {
		return lastUpdtIp;
	}

	public void setLastUpdtIp(String lastUpdtIp) {
		this.lastUpdtIp = lastUpdtIp;
	}

	public String getResultDetailSn() {
		return resultDetailSn;
	}

	public void setResultDetailSn(String resultDetailSn) {
		this.resultDetailSn = resultDetailSn;
	}

	public String getGubunOne() {
		return gubunOne;
	}

	public void setGubunOne(String gubunOne) {
		this.gubunOne = gubunOne;
	}

	public String getGubunTwo() {
		return gubunTwo;
	}

	public void setGubunTwo(String gubunTwo) {
		this.gubunTwo = gubunTwo;
	}

	public String getGubunThree() {
		return gubunThree;
	}

	public void setGubunThree(String gubunThree) {
		this.gubunThree = gubunThree;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getSilwhaju() {
		return silwhaju;
	}

	public void setSilwhaju(String silwhaju) {
		this.silwhaju = silwhaju;
	}

	public String getFwd() {
		return fwd;
	}

	public void setFwd(String fwd) {
		this.fwd = fwd;
	}

	public String getVolumeTotal() {
		return volumeTotal;
	}

	public void setVolumeTotal(String volumeTotal) {
		this.volumeTotal = volumeTotal;
	}

	public String getTeu() {
		return teu;
	}

	public void setTeu(String teu) {
		this.teu = teu;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getProfitUsd() {
		return profitUsd;
	}

	public void setProfitUsd(String profitUsd) {
		this.profitUsd = profitUsd;
	}

	public String getTotalOne() {
		return totalOne;
	}

	public void setTotalOne(String totalOne) {
		this.totalOne = totalOne;
	}

	public String getTotalTwo() {
		return totalTwo;
	}

	public void setTotalTwo(String totalTwo) {
		this.totalTwo = totalTwo;
	}

	public String getTotalThree() {
		return totalThree;
	}

	public void setTotalThree(String totalThree) {
		this.totalThree = totalThree;
	}

	public String getTotalFour() {
		return totalFour;
	}

	public void setTotalFour(String totalFour) {
		this.totalFour = totalFour;
	}

	public String getTotalFive() {
		return totalFive;
	}

	public void setTotalFive(String totalFive) {
		this.totalFive = totalFive;
	}

	public String getTotalSix() {
		return totalSix;
	}

	public void setTotalSix(String totalSix) {
		this.totalSix = totalSix;
	}

	public String getTotalSeven() {
		return totalSeven;
	}

	public void setTotalSeven(String totalSeven) {
		this.totalSeven = totalSeven;
	}

	public String getAllTotal() {
		return allTotal;
	}

	public void setAllTotal(String allTotal) {
		this.allTotal = allTotal;
	}

	public String getRegistYear() {
		return registYear;
	}

	public void setRegistYear(String registYear) {
		this.registYear = registYear;
	}

	public String getRegistMonth() {
		return registMonth;
	}

	public void setRegistMonth(String registMonth) {
		this.registMonth = registMonth;
	}

}
