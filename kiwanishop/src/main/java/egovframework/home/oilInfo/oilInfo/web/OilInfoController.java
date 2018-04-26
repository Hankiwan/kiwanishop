package egovframework.home.oilInfo.oilInfo.web;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import egovframework.home.oilInfo.oilInfo.service.OilInfoService;
import egovframework.home.oilInfo.oilInfo.service.OilInfoVO;


/**  
 * @Class Name : OilInfoController.java
 * @Description : 기와니샵 주유소정보 controller
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2016.11.11           최초생성
 * 
 * @author 기와니샵 개발팀 한기완
 * @since 2016. 11.11
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class OilInfoController {
	
	/** OilInfoService */
    @Resource(name = "oilInfoService")
    private OilInfoService oilInfoService;
	
	/**
	 * 주유소 맵 페이지 이동
	 * @param searchVO - 주유소 정보가 담긴 OilInfoVO
	 * @param model
	 * @return "/home/oilInfo/oilInfo"
	 * @exception Exception
	 */
	@RequestMapping(value="/home/oilInfo/oilInfo.do")
	public String oilInfo(@ModelAttribute("searchVO") OilInfoVO searchVO,
			ModelMap model)
			throws Exception {
		
			return "/home/oilInfo/oilInfo";
	}
	
	/**
	 * 주유소 정보 가져오기 ajax
	 * @param model
	 * @return "/home/oilInfo/oilInfoAjax"
	 * @exception Exception
	 */
	@RequestMapping(value="/home/oilInfo/oilInfoAjax.do")
	public String oilInfoAjax(@ModelAttribute("searchVO") OilInfoVO searchVO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response, @RequestParam String ktmX, @RequestParam String ktmY, @RequestParam String zoomVal)
			throws Exception {
		
		JSONParser paser = new JSONParser();
		
//		System.out.println("#################1 : " + ktmX);
//		System.out.println("#################2 : " + ktmY);
		System.out.println("#################3 : " + zoomVal);
		
		String zoom = "";
		switch(Integer.parseInt(zoomVal)){
			case 1 : zoom = "5000";	break;
			case 2 : zoom = "4500";	break;
			case 3 : zoom = "4000";	break;
			case 4 : zoom = "3500";	break;
			case 5 : zoom = "3000";	break;
			case 6 : zoom = "2500";	break;
			case 7 : zoom = "2000";	break;
			case 8 : zoom = "1500";	break;
			case 9 : zoom = "1000";	break;
			case 10 : zoom = "900";	break;
			case 11 : zoom = "800";	break;
			case 12 : zoom = "700";	break;
			case 13 : zoom = "600";	break;
			case 14 : zoom = "500";	break;
		}
		
		//오피넷 주유소 리스트 가져오기
		HttpResponse<JsonNode> responseAccess = Unirest.post("http://www.opinet.co.kr/api/aroundAll.do?code=F085161115&x=" + ktmX + "&y=" + ktmY + "&radius=" + zoom + "&order=1&prodcd=B027&out=json")
        .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
        .asJson();
	
		JSONObject objAccess = (JSONObject) paser.parse(responseAccess.getBody().toString());
		
		System.out.println("###############objAccess : " + objAccess.toJSONString());
		
		model.addAttribute("oilList", objAccess.toJSONString());
	
		response.setContentType("text/javascript;charset=UTF-8");
		
		return "/home/oilInfo/oilInfoAjax";
	}
	
	/**
	 * 주유소 상세 정보 가져오기 ajax
	 * @param model
	 * @return "/home/oilInfo/oilInfoDetailAjax"
	 * @exception Exception
	 */
	@RequestMapping(value="/home/oilInfo/oilInfoDetailAjax.do")
	public String oilInfoDetailAjax(@ModelAttribute("searchVO") OilInfoVO searchVO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response, @RequestParam String oilId)
			throws Exception {
		
		JSONParser paser = new JSONParser();
		
		System.out.println("#################1 : " + oilId);
		
		URL url; //URL 주소 객체
        InputStream is; //URL접속에서 내용을 읽기위한 Stream
        BufferedReader br;
        
        //내용을 읽어서 리턴한다.
        String retBuf = "";
        String URL = "http://www.opinet.co.kr/api/detailById.do?code=F085161115&id=" + oilId + "&out=json";
        
        try{		
			//URL객체를 생성하고 해당 URL로 접속한다..
            url = new URL(URL);
            
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));            
            
            String buf = null;
            while(true){
                buf = br.readLine();
                if(buf == null) {
                	break;
                }
                retBuf += buf;
            }

        } catch ( Exception e ) {
	    	System.err.println("Couldn't connect to url : " + URL);
	    	return retBuf;
        }
        
        System.out.println("!!!!!!!!!!!!!!!! : " + retBuf);
        
        JSONObject objAccess = (JSONObject) paser.parse(retBuf);
        
		model.addAttribute("oilDetail", objAccess.toJSONString());
	
		response.setContentType("text/javascript;charset=UTF-8");
		
		return "/home/oilInfo/oilInfoDetailAjax";
	}
}
