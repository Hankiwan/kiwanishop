/**
 * linkId 로 구분하여 URL 링크를 처리한다
 * @param linkId
 */
function fncKwsLink(linkId, code) {
	
	var linkURL = linkId;
	
//	switch(linkId) {
//	
//		case "main" : linkURL = "/home/main/main.do"; break;
//		case "login" : linkURL = "/home/login/loginForm.do"; break;
//		case "logout" : linkURL = "/home/login/logout.do"; break;
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
		if(linkURL.indexOf("?") > -1){
			location.href = linkURL + "&gnbMenuCd="+code;
		}else{
			location.href = linkURL + "?gnbMenuCd="+code;
		}
	}
}