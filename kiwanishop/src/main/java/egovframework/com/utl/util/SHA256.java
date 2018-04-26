package egovframework.com.utl.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 
public class SHA256 {
    public String getSHA256(String val) throws Exception{
    	
    	String retVal = "";
    	
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256"); // 이 부분을 SHA-256, MD5로만 바꿔주면 된다.
            md.update(val.getBytes()); 
            
            byte byteData[] = md.digest();
 
            StringBuffer sb = new StringBuffer(); 
            
            for(int i=0; i<byteData.length; i++) {
                sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
            }
            
            retVal = sb.toString(); 
            
            retVal = retVal.toUpperCase().substring(0,32); // 대문자로 32자리만 쓴다고해서 자름 
            
        } catch(NoSuchAlgorithmException e){
//        	NLog.error(this.getClass(), "[Exception in " + this.getClass().getName() + "]" + e.getMessage());
        	e.printStackTrace();
        }
        
        return retVal;
    }
}
