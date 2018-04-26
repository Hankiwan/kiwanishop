package egovframework.com.utl.poi;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import egovframework.com.cmm.service.Globals;
import egovframework.com.utl.util.Util;
 
public class POIUtil{
	 public static ArrayList<String> applyExcel (String fileNm, String cbcode){
		  String excelFile = Globals.FILE_STORE_PATH + cbcode + "/" + fileNm; //excel파일의 경로와 파일명
		  ArrayList<String> list = new ArrayList<String>();
		  
		  try{
		      POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(excelFile)); //엑셀파일의 경로와 이름을 통해 POIFSFileSystem을 생성
		     
		      //워크북을 생성!
		      HSSFWorkbook workbook = new HSSFWorkbook(fs); //파일에 대한 워크북을 생성
		      int sheetNum = workbook.getNumberOfSheets(); //그파일의 워크시트의 수를 가져온다
		      for(int k = 0;k < sheetNum; k++){    //시트를 돌면서 모든 데이터를 얻는다.
			       //시트이름과 시트번호를 추출
			      // System.out.println(k);      //시트의 index를 콘솔에 출력
			      // System.out.println(workbook.getSheetName(k)); //시트의 이름을 콘솔에 출력
			       HSSFSheet sheet = workbook.getSheetAt(k);  //한개의 시트에대한 정보를 HSSFSheet형의 변수에 담는다.
			       int rows = sheet.getPhysicalNumberOfRows();  //시트별 몇개의 row가 있는지 알아낸다.
			      
			       String poiStr = "";
			       
			       for(int r= 1; r<rows;r++){
				        //시트에 대한 행을 하나씩 추출
				       
				    	   //HashMap<String, String> map = new HashMap<String ,String>();
				    	   
				    	   
				        HSSFRow row = sheet.getRow(r);  //한개의 시트에 몇개의 로우가 있는지 체크 
				        if(row != null){    //로우가 비어있지않다면
				         int cells = row.getPhysicalNumberOfCells();  //한개의 로우마다 몇개의 cell이 있는지 체크
				      //   System.out.print(row.getRowNum());   //row의 index를 콘솔에 출력
				      //   System.out.println(cells);     //해당 row에 대한 cell의 갯수를 콘솔에 출력
				        
				      //   for(short c = 0; c < cells; c++){ //셀의 마지막까지 잡는다. 이 부분은 오류가있어 사용하지않는다.
					         for(short c = 0; c < 10; c++){ //5개의 칸까지 잡는다.
					          //행에대한 셀을 하나씩 추출하여 셀 타입에 따라 처리
					          HSSFCell cell = row.getCell(c);  //cell의 index
					         
					          //System.out.println("cell :"+cell);
					          
						          if(cell != null){
							           String value = null;
							           switch(cell.getCellType()){       //셀의 type에 대해 체크하고 type을 설정해준다.
								           case HSSFCell.CELL_TYPE_FORMULA:    
								            //value = cell.getCellFormula();	//셀 수식 자체를 가져 올때
							        	    //value = cell.getStringCellValue();	//셀 수식 반환값이 문자일 때
							        	    value = String.valueOf(cell.getNumericCellValue());	//셀 수식 반환값이 숫자일 때
								            break;
								           case HSSFCell.CELL_TYPE_NUMERIC:
								            value = String.valueOf(cell.getNumericCellValue());
								            break;
								           case HSSFCell.CELL_TYPE_STRING:
								            value = cell.getStringCellValue();
								            break;
								           case HSSFCell.CELL_TYPE_BLANK:
								            value = null;
								            break;
								           case HSSFCell.CELL_TYPE_BOOLEAN:
								            value = String.valueOf(cell.getBooleanCellValue());
								            break;
								           case HSSFCell.CELL_TYPE_ERROR:
								            value = String.valueOf(cell.getErrorCellValue());
								            break;
								            default:
							           }
						          
							           //System.out.println("CELL col="+cell.getCellNum() + " VALUE="+value); //셀에대한 값을 콘솔에 출력해준다.
							           
							           if(c == 9){
							        	  poiStr += Util.isNullZero(value);  
							           }else{
							        	  poiStr += Util.isNullZero(value) + ",";
							           }
						          
						          }
					          
					          
					         }
				        }
				        
				          list.add(poiStr);
				          
				          poiStr = "";
			        
			       }
		      }
		     }catch(Exception e){
		      e.printStackTrace();
		     }
		     
		     return list;
	 }
 

 }//class
