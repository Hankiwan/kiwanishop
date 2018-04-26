package egovframework.com.utl.jcaptcha.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class CaptchaImage {
	private int imageWidth = 200;	//이미지 가로
	private int imageHeight = 100;	//이미지 세로
	private int textSize = 30;		//텍스트 크기
	private String fontFamilyName = "Verdana";	//기본 폰트

	//CAPTCHA 이미지 생성
	public BufferedImage createImage(String text){

		BufferedImage bImg = null;

		try{
			//이미지 생성
			bImg = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
			Graphics g = bImg.getGraphics();

			//배경색 칠하기
			g.setColor(getRandomColor(220,240));
			g.fillRect(0, 0, imageWidth, imageHeight);

			//폰트 설정
			Font font = new Font(fontFamilyName, Font.BOLD|Font.ITALIC, textSize);
			g.setFont(font);

			//텍스트 그리기
			g.setColor(getRandomColor(150, 200));

			char[] chars = text.toCharArray();
			int x = 10;
			int y = imageHeight/2+textSize/2;

			for(int i=0; i<chars.length; i++){
				char ch = chars[i];
				g.drawString(String.valueOf(ch), x+font.getSize()*i, y+(int)Math.pow(-1, i)*(textSize/6));	//각 문자의 위치를 다르게
			}

			//리소스 해제
			g.dispose();
		} catch (Exception e){
			bImg = null;
		}

		return bImg;
	}

	/**색상 한계 범위 내에서 무작위로 색상 조회
	 * @param from 색상 시작 범위
	 * @param to 색상 한계 범위
	 * @return
	 */
	private Color getRandomColor(int fro, int t){

		int from = fro;
		int to = t;

		if(from < 0) from = 0;
		if(from > 255) from = 255;
		if(to < 0) to = 0;
		if(to > 255) to = 255;
		if(from > to) return Color.BLACK;

		Color color = null;

		int red = Math.abs((int)(Math.random() * (to-from))) + from;
		int green = Math.abs((int)(Math.random() * (to-from))) + from;
		int blue = Math.abs((int)(Math.random() * (to-from))) + from;

		color = new Color(red, green, blue);

		return color;
	}

	public void setImageSize(int imageWidth, int imageHeight){
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
	}

	public int getImageWidth(){
		return imageWidth;
	}

	public int getImageHeight(){
		return imageHeight;
	}

	public int getTextSize(){
		return textSize;
	}

	public void setTextSize(int textSize){
		this.textSize = textSize;
	}

	public String getFontFamilyName(){
		return fontFamilyName;
	}

	public void setFontFamilyName(String fontFamilyName){
		this.fontFamilyName = fontFamilyName;
	}
}
