package egovframework.com.utl.jcaptcha.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaptchaServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response){
		//텍스트 생성
		CaptchaText captchaText = new CaptchaText();
		String text = captchaText.createText();

		//세션에 저장
		request.getSession().setAttribute("captchaText", text);

		//이미지 생성
		CaptchaImage captchaImage = new CaptchaImage();
		BufferedImage bImage = captchaImage.createImage(text);

		if(bImage == null){ //실패

			response.setContentType("text/html; charset=utf-8");
			String message = "Error! Please try later.";

			try{
				PrintWriter out = response.getWriter();
				out.println(message);
				out.flush();
			} catch (Exception e){
				e.printStackTrace();
			}
		} else {	//성공

			try {
				//png 파일 설정
				response.setContentType("image/png; charset=utf-8");

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(bImage, "png", baos);

				byte buffer[] = baos.toByteArray();

				ServletOutputStream sos = response.getOutputStream();

				sos.write(buffer);
				sos.flush();
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}