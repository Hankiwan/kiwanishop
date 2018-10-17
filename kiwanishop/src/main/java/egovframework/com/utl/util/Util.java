/**
 * @(#)LobData.java     2005. 02. 18.
 *
 * Copyright 2005 IPARTNERS, Inc. All rights reserved
 */
package egovframework.com.utl.util;

import java.io.File;
import java.io.Reader;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TimeZone;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * <B>Util</B>
 * - 공통 Utility 클래스
 */
public class Util {
    public Util() {

    }
    
    /**
     * CLOB Type의 Data를 Table에서 읽어 온다.
     * @param reader ResultSet에서 읽어온 Clob 객체 ( rs.getCharacterStream(int index) )
     * @return CLOB Data
     */
    public static String getClob(Reader rd)
    	throws Exception{
    	 // CLOB column에 대한 스트림을 얻는다.

		StringBuffer sb = new StringBuffer();
        char[] buf = new char[1024];
        int readcnt;

        if (rd != null) {
	        while ((readcnt = rd.read(buf, 0, 1024)) != -1) {
				// 스트림으로부터 읽어서 스트링 버퍼에 넣는다.
				sb.append(buf, 0, readcnt);
	        }
	        rd.close();
        }

        //return UtilLang.ko(sb.toString());
        return sb.toString();

    }

    /**
     * 제한된 글자수 만큼 잘라내고 '...'을 붙인다.
     * @param String 문자열
     * @param int 글자수
     * @return void
     */
    public static synchronized String cutString(String str,int maxNum) {
        int tLen = str.length();
        int count = 0;
        char c;
        int s=0;
        for(s=0;s<tLen;s++){ 
            c = str.charAt(s);
            if(count > maxNum) break;
            if(c>127) count +=2;
            else count ++;
        }
        return (tLen >s)? str.substring(0,s)+"..." : str;
    }

    /**
     * 캐리지 리턴을 br 태그로 replace한다.
     * @param String 문자열
     * @return br태그로 변경된 문자열
     */
    public static synchronized String N2Br(String s)
    {
        return replaceString("\n", "<BR>", s);
    }

    public static synchronized String convertFlashString(String s) {
        String temp = s;
        /*
        temp = replaceString(" ", "%20", temp);
        temp = replaceString("!", "%21", temp);
        temp = replaceString("\"", "%22", temp);
        temp = replaceString("#", "%23", temp);
        temp = replaceString("$", "%24", temp);
        temp = replaceString("%", "%25", temp);
        */
        temp = replaceString("&", "%26", temp);

        return temp;
    }

    public static synchronized String replaceString(String s, String s1, String s2)
    {
        int i = 0;
        int j = 0;
        StringBuffer stringbuffer = new StringBuffer();

        while((j = s2.indexOf(s, i)) >= 0)
        {
            stringbuffer.append(s2.substring(i, j));
            stringbuffer.append(s1);
            i = j + s.length();
        }

        stringbuffer.append(s2.substring(i));

        return stringbuffer.toString();
    }

    /**
     * yyyyMMddhh24miss 를 yyyy-MM-dd hh24:mi:ss 로 변경하여 리턴한다.
     * @param 문자열
     * @return 변경된 문자열
     */
    public static String convertDate1(String date) {
        if (date.length() == 14) {
            return date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8) + " " + date.substring(8, 10) + ":" + date.substring(10, 12) + ":" + date.substring(12);
        } else if (date.length() == 8) {
            return date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
        } else {
            return "";
        }
    }

    /**
     * yyyyMMddhh24miss 를 yyyy년 MM월dd일로 변경하여 리턴한다.
     * @param 문자열
     * @return 변경된 문자열
     */
    public static String convertDate2(String date) {
        if (date.length() == 14) {
            return date.substring(0, 4) + "년 " + Integer.parseInt(date.substring(4, 6)) + "월 " + Integer.parseInt(date.substring(6, 8)) + "일" ;
        } else if (date.length() == 8) {
            return date.substring(0, 4) + "년 " + Integer.parseInt(date.substring(4, 6)) + "월 " + Integer.parseInt(date.substring(6, 8)) + "일";
        } else {
            return "";
        }
    }

    /**
     * yyyyMMddhh24miss 를 yyyy년 MM월dd일로 변경하여 리턴한다.
     * @param 문자열
     * @return 변경된 문자열
     */
    public static String convertDate4(String date) {
        if (date.length() == 14) {
            return Integer.parseInt(date.substring(4, 6)) + "월" + Integer.parseInt(date.substring(6, 8)) + "일" ;
        } else if (date.length() == 8) {
            return Integer.parseInt(date.substring(4, 6)) + "월 " + Integer.parseInt(date.substring(6, 8)) + "일";
        } else {
            return "";
        }
    }

    /**
     * yyyyMMddhh24 를 yyyy년 MM월dd일 오후 2시로 변경하여 리턴한다.
     * @param 문자열
     * @return 변경된 문자열
     */
    public static String convertDate5(String date) {

         String divideDate = date.replaceAll("-","");

        if (date.length() == 10) {
            divideDate = date.substring(0, 4) + "년 " + Integer.parseInt(date.substring(4, 6)) + "월" + Integer.parseInt(date.substring(6, 8)) + "일" ;

            if ( Integer.parseInt(date.substring(8, 10)) < 12 )
            {
                divideDate = divideDate + " 오전 "+Integer.parseInt(date.substring(8, 10))+ "시";
            } else if ( Integer.parseInt(date.substring(8, 10)) >= 12 )
            {
                divideDate = divideDate + " 오후 "+ (Integer.parseInt(date.substring(8, 10))-12 ) +  "시";
            }
        } else {
            return "";
        }

        return divideDate;
    }

    /**
     * 문자형 한자리 숫자에 0 + 숫자 리턴한다.
     * @param 문자열
     * @return 변경된 문자열
     */
    public static String plusZero(String number) {
        if (number.length() == 1) {
            return "0"+number;
        } else {
            return number;
        }
    }

    /**
     * 넘어온 휴대전화번호를 쪼개준다.
     * @param 문자열
     * @return 변경된 문자열
     */
    public static String[] divideMPhone(String phone) {

        String[] mphone = { "", "", ""} ;

        if (phone != null){
	        StringTokenizer st = new StringTokenizer(phone,"-");
	        boolean blnTolen = false;

	        while (st.hasMoreTokens()) {
	        	if (st.countTokens() == 1){
	        		String phoneNumber = phone.replace(".","");
	        		phoneNumber = phoneNumber.replace("\\)","");
	                phoneNumber = phoneNumber.replace(" ","");

	                if (phoneNumber.length() == 11) {
	                    if ( phoneNumber.substring(0, 3).equals("013") || phoneNumber.substring(0, 3).equals("050") ) {
	                        mphone[0] = phoneNumber.substring(0, 4);
	                        mphone[1] = phoneNumber.substring(4, 7);
	                        mphone[2] = phoneNumber.substring(7, 11);
	                    } else {
	                        mphone[0] = phoneNumber.substring(0, 3);
	                        mphone[1] = phoneNumber.substring(3, 7);
	                        mphone[2] = phoneNumber.substring(7, 11);
	                    }
	                } else if (phoneNumber.length() == 10) {
	                    mphone[0] = phoneNumber.substring(0, 3);
	                    mphone[1] = phoneNumber.substring(3, 6);
	                    mphone[2] = phoneNumber.substring(6, 10);
	                } else if  (phoneNumber.length() == 12)  {
	                    mphone[0] = phoneNumber.substring(0, 4);
	                    mphone[1] = phoneNumber.substring(4, 8);
	                    mphone[2] = phoneNumber.substring(8, 12);
	                } else {
	                	if (phoneNumber.length() < 3) {
	    	            	mphone[0] = phoneNumber.substring(0, phoneNumber.length());
	                	}else if (phoneNumber.length() >= 3 && phoneNumber.length() < 6) {
	                		mphone[0] = phoneNumber.substring(0, 3);
	    	                mphone[1] = phoneNumber.substring(3, phoneNumber.length());
	                	}else if (phoneNumber.length() > 6) {
	                		mphone[0] = phoneNumber.substring(0, 3);
	                        mphone[1] = phoneNumber.substring(3, 6);
	                        mphone[2] = phoneNumber.substring(6, phoneNumber.length());
	                	}
	                }
	                st.nextToken();
	        	}else if (st.countTokens() == 2){
	        		mphone[0] = st.nextToken();
	        		mphone[1] = st.nextToken();
	        	}else if (st.countTokens() == 3){
	        		mphone[0] = st.nextToken();
	        		mphone[1] = st.nextToken();
	        		mphone[2] = st.nextToken();
	        	}else if (st.countTokens() == 4){
	        		mphone[0] = st.nextToken();
	        		mphone[1] = st.nextToken();
	        		mphone[2] = st.nextToken()+st.nextToken();
	        	}
	        }
        }
        return mphone;
    }

    /**
     * 넘어온 전화번호를 쪼개준다.
     * @param 문자열
     * @return 변경된 문자열
     */
    public static String[] divideHPhone(String hphone) {

        String[] phone = { "", "", "" } ;

        if (hphone != null){
	        StringTokenizer st = new StringTokenizer(hphone,"-");
	        boolean blnTolen = false;

	        while (st.hasMoreTokens()) {
	        	if (st.countTokens() == 1){
	        		String phoneNumber = hphone.replace(".","");
	        		phoneNumber = phoneNumber.replace("\\)","");
	                phoneNumber = phoneNumber.replace(" ","");

			        if ( phoneNumber.length() > 2 )
			        {
			        	if ( phoneNumber.substring(0, 2).equals("02") ) {

			                if ( phoneNumber.length() == 10 )
			                {
			                    phone[0] = phoneNumber.substring(0, 2);
			                    phone[1] = phoneNumber.substring(2, 6);
			                    phone[2] = phoneNumber.substring(6, 10);
			                }
			                else if ( phoneNumber.length() == 9 )
			                {
			                    phone[0] = phoneNumber.substring(0, 2);
			                    phone[1] = phoneNumber.substring(2, 5);
			                    phone[2] = phoneNumber.substring(5, 9);
			                }
			            }

			            if ( phoneNumber.length() == 12 )
			            {
			                phone[0] = phoneNumber.substring(0, 4);
			                phone[1] = phoneNumber.substring(4, 8);
			                phone[2] = phoneNumber.substring(8, 12);
			            }
			            else if ( phoneNumber.length() == 11 )
			            {
			                if ( phoneNumber.substring(0, 3).equals("013") || phoneNumber.substring(0, 3).equals("050") )
			                {
			                        phone[0] = phoneNumber.substring(0, 4);
			                        phone[1] = phoneNumber.substring(4, 7);
			                        phone[2] = phoneNumber.substring(7, 11);
			                }
			                else if ( !phoneNumber.substring(0, 3).equals("013") || !phoneNumber.substring(0, 3).equals("050"))
			                {
			                        phone[0] = phoneNumber.substring(0, 3);
			                        phone[1] = phoneNumber.substring(3, 7);
			                        phone[2] = phoneNumber.substring(7, 11);
			                }
			            }
			            else if ( !phoneNumber.substring(0, 2).equals("02") && phoneNumber.length() == 10 )
			            {
			                phone[0] = phoneNumber.substring(0, 3);
			                phone[1] = phoneNumber.substring(3, 6);
			                phone[2] = phoneNumber.substring(6, 10);
			            }
			        }else{
			        	phone[0] = phoneNumber;
			        }

			        st.nextToken();
	        	}else if (st.countTokens() == 2){
	        		phone[0] = st.nextToken();
	        		phone[1] = st.nextToken();
	        	}else if (st.countTokens() == 3){
	        		phone[0] = st.nextToken();
	        		phone[1] = st.nextToken();
	        		phone[2] = st.nextToken();
	        	}else if (st.countTokens() == 4){
	        		phone[0] = st.nextToken();
	        		phone[1] = st.nextToken();
	        		phone[2] = st.nextToken()+st.nextToken();
	        	}
	        }
        }


        return phone;
    }

     /**
     * yyyyMMddhh24miss 를 영문요일로 변경하여 리턴한다.
     * @param 문자열
     * @return 변경된 문자열
     */
    public static String convertDate3() {

            Calendar now   = Calendar.getInstance();

            int day = now.get(Calendar.DAY_OF_WEEK);
            now.set(Calendar.YEAR,Calendar.MONTH,Calendar.DATE);

            String   today = "";

            switch(day) {

	            case 1: today = "SUN"; break;
	            case 2: today = "MON"; break;
	            case 3: today = "TUE"; break;
	            case 4: today = "WED"; break;
	            case 5: today = "THU"; break;
	            case 6: today = "FRI"; break;
	            case 7: today = "SAT";
            }

            return today;
    }


    /**
     * 해당날짜를 요일정보[1,2,3,4,5,6,7]로 변경하여 리턴한다.
     * @param 문자열
     * @return 변경된 문자열
     */
    public static int startDayOfWeek(int Year, int Month) {

    	int year = Year; //Integer.parseInt(Year);
    	int month = Month; //Integer.parseInt(Month);

    	int START_DAY_OF_WEEK = 0;

    	Calendar sDay = Calendar.getInstance();
    	sDay.set(year, month-1, 1);

    	START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);

            Calendar now   = Calendar.getInstance();

            int day = now.get(Calendar.DAY_OF_WEEK);
            now.set(Calendar.YEAR,Calendar.MONTH,Calendar.DATE);

            String   todayInt = "";



            return START_DAY_OF_WEEK;
    }

    /**
     * 해당월의 마지막날짜를 리턴한다.
     * @param 문자열
     * @return 변경된 문자열
     */
    public static int monthEndDay(int Year, int Month) {

    	int year = Year;//Integer.parseInt(Year);
    	int month = Month;//Integer.parseInt(Month);

    	int END_DAY = 0;

    	Calendar eDay = Calendar.getInstance();
    	eDay.set(year, month, 1);
    	eDay.add(Calendar.DAY_OF_MONTH, -1);

    	END_DAY = eDay.get(Calendar.DAY_OF_MONTH);


    	return END_DAY;
    }


    /**
     * yyyyMMddhh24miss 를 yyyy-MM-dd hh24:mi:ss 로 변경하여 리턴한다.
     * @param 문자열
     * @return 변경된 문자열
     */
    public static String convertDate4(String date, String sep) {
        if (date.length() > 7) {
            return date.substring(0, 4) + sep + date.substring(4, 6) + sep + date.substring(6, 8) ;
        } else {
            return "";
        }
    }

    /**
     * 복수의 파일 삭제
     * @param String path 	삭제할 파일의 경로
     * @param String[] fileName 삭제할 파일명
     */
    public static void deleteFiles(String path, String[] fileName) {
	    for (int i=0 ; i < fileName.length; i++) {
	        deleteFiles(path, fileName[i]);
	    }
    }

    /**
     * 파일 삭제
     * @param String path 	삭제할 파일의 경로
     * @param String fileName 삭제할 파일명
     */
    public static void deleteFiles(String path, String fileName) {
        File file = new File(path+File.separator+fileName);
        file.delete();
    }



    public static String getNextWeek() {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE, 7);
        Date date = now.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        return formatter.format(date);
    }

 	public static String formatNumber(long number, String format) {
		DecimalFormat formatter = new DecimalFormat(format);
		return formatter.format(number);
	}

	/**
     * 문자를 ###,###,###,### format으로 변환
     * @param 문자열
     * @return 변경된 문자열
     */
	public static String commaFormat(String number) {
		return formatNumber(Long.parseLong(number), "###,###,###,###");
	}

	/**
     * 문자를 특정 format으로 변환
     * @param 문자열
     * @param format
     * @return 변경된 문자열
     */
	public static String commaFormat(String number, String format) {
		return formatNumber(Long.parseLong(number), format);
	}

	/**
     * null 값이 아닌 string을 주어진 길이 만큼 space 문자를 채운후 반환
     * @param 문자열
     * @param 길이
     * @return 변경된 문자열
     */
	public static String fixString( String str, int len )
	{
		String 		temp1;
		StringBuffer temp;
		int	i,j;

		i = str.length();
		temp = new StringBuffer( str );
		if ( i < len ){
			for ( j = 1; j <= ( len - i ); j ++ ){
				temp.append(" ");
			}
			temp1 = new String(temp);
		} else {
			if ( i > len ) {
				temp1 = str.substring( 0, len );
			} else	temp1 =  str;
		}

		return temp1;
	}

   /**
    * 금액데이타 123,345,567 형식으로 보여주기
    * @param n
    * @return
    */
    public static String moneyFormValue(String n)
    {
        boolean nFlag=true;

        String o     = "";
        String p     = "";
        String minus = "";

        if ( n.substring(0,1).equals("-") ) {
            minus = n.substring(0,1);
            n     = n.substring(1);
        }

        if ( n.indexOf(".")>0 ) {
            o = n.substring(0, n.indexOf("."));
            p = n.substring(n.indexOf(".")+1, n.length());
        }
        else    {
            o = n;
        }

        o = Util.replace(o," ","");
        o = Util.replace(o,",","");
        o = Util.replace(o,"+","");

        int tLen = o.length();
        String tMoney = "";
        for(int i=0;i<tLen;i++){
            if (i!=0 && ( i % 3 == tLen % 3) ) tMoney += ",";
            if(i < tLen ) tMoney += o.charAt(i);
        }

        if ( p.length()>0 )     tMoney += "."+p;
        if ( nFlag == false )   tMoney = "-"+tMoney;

        if ( minus.equals("-") ) {
            tMoney = minus + tMoney;
        }

        return tMoney;
    }

    /**
     * 문자열대 문자열로 바꿔준다.
     * @param line
     * @param oldString
     * @param newString
     * @return
     */
    public static String replace(String line, String oldString, String newString)
    {
        line = isNull(line);
        for(int index = 0; (index = line.indexOf(oldString, index)) >= 0; index += newString.length())
            line = line.substring(0, index) + newString + line.substring(index + oldString.length());

        return line;
    }

    /**
     * 문자열을 받아서 null이면 공백 문자열로 리턴
     * @param str
     * @return
    */
    public static String isNull(String str)
    {
        if ((str == null) || (str.trim().equals("")) || (str.trim().equals("null")))
            return "";
        else
            return str;
    }
    
    /**
     * 문자열을 받아서 null이면 0을 리턴
     * @param str
     * @return
    */
    public static String isNullZero(String str)
    {
        if ((str == null) || (str.trim().equals("")) || (str.trim().equals("null")))
            return "0";
        else
            return str;
    }

    public static String getCookie(HttpServletRequest httpservletrequest, String s) throws Exception {
	    Cookie acookie[] = httpservletrequest.getCookies();
	    String s1 = "";

	    if(acookie != null) {
	        for(int i = 0; i < acookie.length; i++) {
	            Cookie cookie = acookie[i];

	            if(cookie.getName().equals(s))
	                return URLDecoder.decode(cookie.getValue());
	        }
	    }

	    return s1;
	}

	public static String getTime(String format)
	{
		if ( format == null || format.equals("") == true )
			format = "yyyyMMddHHmmss";

		TimeZone tz = TimeZone.getDefault();
		tz.setRawOffset((60*60*1000) * 9);
		TimeZone.setDefault(tz);
		Calendar cal = Calendar.getInstance(tz);
		Date date = cal.getTime();
		SimpleDateFormat formater = new SimpleDateFormat(format);
		String timestamp = formater.format(date);

		return timestamp;
	}

	public static String getNoScript(String chkStr)
	{
		String rtnStr = chkStr;

		rtnStr = rtnStr.replaceAll("<script", "&lt; script");
		rtnStr = rtnStr.replaceAll("</script", "&lt; /script");
		rtnStr = rtnStr.replaceAll("<iframe", "&lt; iframe");

		return rtnStr;
	}

	public static String convertChar(String s)
	{

	        s = replace(s, "&", "&amp;");
	 //       s = replace(s, " ", "&nbsp;");
	        s = replace(s, "<", "&lt;");
	        s = replace(s, ">", "&gt;");
	        s = replace(s, "'", "&#39;");
	        s = replace(s, "|", "&#124;");
	        s = replace(s, "\n", "<br>");
	        s = replace(s, "\"", "&quot;");
	        s = replace(s, "<script", "<!--script");
	        s = replace(s, "</script", "</script--!>");
	        s = replace(s, "<iframe>", "<!--iframe>");
	        return s;

	}
	//랜덤한 숫자 가져오기
	public static String RandomNumber(int jari) {
        Random rand = new Random(System.currentTimeMillis());
        return LPad(Math.abs(rand.nextInt(jari))+"", (jari+"").length(), "0");
    }

    //왼쪽에 자리수만큼 채운다
	public static String LPad(String str, int size, String fStr){
		 byte[] b = str.getBytes();
		 int len = b.length;
		 int tmp = size - len;

		 for (int i=0; i < tmp ; i++){
			 str = fStr + str;
		 }
		 return str;
	}
	
	//오른쪽에 자리수만큼 채운다
	public static String RPad(String str, int size, String fStr){
		 byte[] b = str.getBytes();
		 int len = b.length;
		 int tmp = size - len;

		 for (int i=0; i < tmp ; i++){
			 str = str + fStr;
		 }
		 return str;
	}


	//16자리 시퀀스
    public static String getSequence() {
    	return System.currentTimeMillis()+""+RandomNumber(999);
    }
}