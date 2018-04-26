/**
 * linkId 로 구분하여 URL 링크를 처리한다
 * @param linkId
 */
function fncKwsLink(linkId, code) {
	
	var linkURL = linkId;
	
//	switch(linkId) {
//	
//		case "main" : linkURL = "/admin/main/main.do"; break;	//메인
//		case "login" : linkURL = "/admin/login/loginForm.do"; break;	//로그인
//		case "logout" : linkURL = "/admin/login/logout.do"; break;	//로그아웃
//		case "result" : linkURL = "/admin/result/resultList.do"; break;		//실적관리
//			case "resultCompare" : linkURL = "/admin/result/resultCompareForm.do"; break;	//실적비교
//		case "system" : linkURL = "/admin/member/memberList.do"; break;	//시스템
//			case "member" : linkURL = "/admin/member/memberList.do"; break;		//회원관리
//			case "code" : linkURL = "/admin/result/resultCompareForm.do"; break;		//코드관리
//			case "popup" : linkURL = "/admin/result/resultCompareForm.do"; break;		//팝업관리
////		case "join" : linkURL = "/home/join.do"; break;
////			case "appStore_1" : linkURL = "/home/rankApp.do?appType=B&nav=appStore_1"; break;
////			case "appStore_2" : linkURL = "/home/themaApp.do?appType=B&nav=appStore_2"; break;
////			case "appStore_3" : linkURL = "/home/recommendApp.do?appType=B&nav=appStore_3"; break;
////			case "appStore_4" : linkURL = "/home/openApp.do?appType=B&nav=appStore_4"; break;
////			case "appStore_5" : linkURL = "/home/nationApp.do?appType=B&nav=appStore_5"; break;
//
//		default : linkURL = "serviceFail"; break;
//	} 
	
	if(linkURL == "serviceFail" || linkURL == "") {
		alert("서비스 준비중 입니다.");
	} else if(linkURL.indexOf("http://") > -1) {
		window.open(linkURL, "", "", "");
	} else {
		location.href = linkURL + "?gnbMenuCd="+code;
	}
}