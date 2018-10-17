package egovframework.com.cmm.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * 로그인 체크 aop
 */

@Aspect
public class LoginAspect{

//	@Pointcut("execution(* egovframework..web.*Controller.*(..))")
//	@Pointcut("execution(* *..impl.*Impl.*(..))")
//	@Around("execution(* egovframework..web.*Controller.*(..))")
	@Around("execution(* egovframework..web.*Controller.*(..))")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
	
		System.out.println("@@@@@@@@@@@@@@@@@@class name : " + joinPoint.getSignature().getDeclaringTypeName());
		
		try{
			String type = joinPoint.getSignature().getDeclaringTypeName();
			
			if(type.indexOf("Manage") > -1){	//관리자 관련 url
				if(type.indexOf("KwsLoginManageController") == -1){	//로그인 관련 controller는 패스
					HttpServletRequest request= null;
					
					for(Object o:joinPoint.getArgs()){
						if(o instanceof HttpServletRequest){
							request = (HttpServletRequest) o;
						}
					}
					if(request != null){
						HttpSession session = request.getSession();
						boolean isLogin = false;
						if(session != null && session.getAttribute("sAdminId") != null && !session.getAttribute("sAdminId").equals("")){
							isLogin = true;
						}else{
							isLogin = false;
						}
						
						System.out.println("@@@@@@@@@@@@@@@@@@isLogin : " + isLogin);
						
						// 로그인체크
				    	if(!isLogin) {
				    	      return "/admin/login/loginForm";
				    	}
					}
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		
		Object result = joinPoint.proceed();
		
		return result;
	}

}
