
//import cordova.js - iphone
if(navigator.userAgent.toLowerCase().indexOf('iphone') > -1){
	var jsfile = $("<script type='text/javascript' src='"+ web_path + '/static/js/cordova_ios/cordova.js'+"'>");
	$("head").append(jsfile); 
}

//import cordova.js - android
if(navigator.userAgent.toLowerCase().indexOf('android') > -1){
	var jsfile = $("<script type='text/javascript' src='"+ web_path + '/static/js/cordova_android/cordova.js'+"'>");
	$("head").append(jsfile); 
}

//import cordova.js - windows
if(navigator.userAgent.toLowerCase().indexOf('windows') > -1){
//	var jsfile = $("<script type='text/javascript' src='"+ web_path + '/static/js/cordova_ios/cordova.js'+"'>");
//	$("head").append(jsfile); 
}


//APNS receive
function onNotificationAPN(e) {
    if(e.foreground == 0){
    	//APP background
    	location.href = e.url; 
	}else{
		//APP ing...
	}
}


//GCM receive
function onNotification(e) {
	if(e.event == 'message'){
		if(e.foreground == 0){
			//APP background
			location.href = e.payload.url;   
		}else{
			//APP ing...
		}
	}
}



//message from iframe
var eventMethod = window.addEventListener ? "addEventListener" : "attachEvent";
var eventer = window[eventMethod];
var messageEvent = eventMethod == "attachEvent" ? "onmessage" : "message";

//take a message -> open new browser
eventer(messageEvent, function (e) {
	window.open(e.data, '_system', 'location=yes');
}, false); 



// online and offline 확인을 위한 이벤트 감지
document.addEventListener("online", onOnline, false);
document.addEventListener("offline", onOffline, false);

var isConnected = false;

function fnOnOffAlert(){
	
	if(document.getElementById('divModal') !=  'null' && document.getElementById('divModal') != null)
		fnModalOff();
	
	if(isConnected == true){
		//연결되었습니다.
	} else{
		fnModalOn();
		//alert('네트워크에 연결되어 있지 않습니다.');
		//fnOnOffAlert();
	}

}


function onOnline() {
	isConnected = true;
	//fnOnOffAlert();
}
	
function onOffline() {
	isConnected = false;
	fnOnOffAlert();
}


function fnModalOn(){

	
	if(document.getElementById('divModal') !=  'null' && document.getElementById('divModal') != null)
		return;
	
	var win = $(window);
	var font = "";
	var padding = "";
	var btnHeight = "";
	
	if(win.width() <  500){
		font = "12";
		padding = "10";
		btnHeight = "40";
	} else if(win.width() < 700){
		font = "25";
		padding = "10";
		btnHeight = "40";
	} else if(win.width() < 900){
		font = "32";
		padding = "10";
		btnHeight = "60";
	}else if(win.width() < 1100){
		font = "40";
		padding = "10";
		btnHeight = "80";
	}else{
		font = "50";
		padding = "10";
		btnHeight = "100";
	}
	
	var layerHeight = win.height() * 0.3;
	var topMargin = win.height() * 0.3;
	var layerHeight2 = layerHeight * 0.5;
	
	
	var div = document.createElement("div");
	div.id = 'divModal';
	var str = "";
	str += '	<div id="modal01" style="padding-top:'+topMargin+'px; z-index:1;display:block;position:fixed; left:0;top:0;width:100%;height:100%;overflow:auto;background-color:rgb(0,0,0);background-color:rgba(0,0,0,0.4)">';
	str += '	  <div style="position:center; margin:auto; background-color:#f3f3f3;position:relative;padding:0;outline:0;border:1px #555 solid; width:85%; height:'+ layerHeight +'px">';
	str += '	    <div style="text-align: center; padding-top:'+padding+'%">';
	str += '         <p align="center" style="font-size: '+font+'px;" ><Strong>네트워크에 접속할 수 없습니다. <br/> 네트워크 연결상태를 확인해 주세요.</Strong></p>';
	str += '			<button style="width: 30%; height:'+btnHeight+'px; font-size: '+font+'px;" onclick="fnOnOffAlert();">재시도</button>';
	str += '	    </div>';
	str += '	  </div>';
	str += '	</div>';

	div.innerHTML  = str;
	document.body.appendChild(div);
	
	//document.getElementById('modal01').style.display='block';
	//document.getElementById('modal01').style.display='none';
		
	
}

function fnModalOff(){
	document.getElementById('divModal').remove();
}

