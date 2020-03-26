package com.mvc.upgrade.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	// controller로 보내기 전에 처리하는 인터셉터
	// 반환이 false라면 controller로 요청을 안함
	// 매개변수 Object는 핸들러 정보를 의미한다. ( RequestMapping , DefaultServletHandler ) 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("[INTERCEPTOR]:preHandle");
		
		if(request.getRequestURI().contains("/loginform.do") ||
				request.getRequestURI().contains("/ajaxlogin.do") ||
				request.getRequestURI().contains("/signupform.do") ||
				request.getRequestURI().contains("/signupres.do") ||
				request.getRequestURI().contains("/writeres.do") ||
				request.getSession().getAttribute("login") != null) {  //세션에 저장된 값이 null이 아니면 list.do로 이동
			return true;
		}
		
		if(request.getSession().getAttribute("login") == null) {  //세션에 저장된 값이 null이면 loginform.do로 이동
			response.sendRedirect("loginform.do");
		}
		return false;
	}

	// controller의 handler가 끝나면 처리됨
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("[INTERCEPTOR]:postHandle");
	
	
	}

	// view까지 처리가 끝난 후에 처리됨
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("[INTERCEPTOR]:afterCompletion");
		
	}

}