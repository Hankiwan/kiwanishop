package egovframework.com.utl.jcaptcha.service;

public class CaptchaText {
	protected static int dEFAULTTEXTLENGTH = 4;	//기본 글자수 4
	protected static String aLPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //알파벳 대문자 중에서

	//문자열 생성
	public String createText(){
		return createText(dEFAULTTEXTLENGTH);
	}

	//문자열 생서 pram
	public String createText(int textlength){
		StringBuffer text = new StringBuffer();

		for(int i=0; i<textlength; i++){
			int index = Math.abs((int)(Math.random() * aLPHABET.length()));	//랜덤으로 추출
			char ch = aLPHABET.charAt(index);
			text.append(ch);
		}

		return text.toString();
	}
}
