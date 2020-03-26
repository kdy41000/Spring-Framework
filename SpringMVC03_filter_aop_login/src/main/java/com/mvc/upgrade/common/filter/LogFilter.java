package com.mvc.upgrade.common.filter;

import java.io.IOException;

import javax.servlet.Filter;    //javax.servlet import 받을 것
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;

public class LogFilter implements Filter{

	private Logger logger = LoggerFactory.getLogger(LogFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {  //초기화
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		HttpServletRequest req = (HttpServletRequest)request;   //형변환(ServletRequest를 상속받아 확장)
		
		String remoteAddr = req.getRemoteAddr();  //클라이언트의 원 IP주소를 가져온다.
		String uri = req.getRequestURI();         //요청 URI중 포트번호와 쿼리 사이의 부분을 가져온다.(컨텍스트경로 + 서블릿경로)
		String url = req.getRequestURL().toString();   //쿼리를 제외한 프로토콜+도메인+포트번호+컨텍스트경로+서블릿 경로를 가져온다.
		String queryString = req.getQueryString();     //쿼리를 가져온다.
		
		String referer = req.getHeader("referer");  //이전 페이지의 URL을 가져오는데 파라미터도 같이 얻어올 수 있다.
		String agent = req.getHeader("User-Agent");  //접속자의 OS 및 IP 주소 등을 얻어온다.
		
		StringBuffer sb = new StringBuffer();  //문자열 데이터가 계속해서 변경 되어야 하기 때문에 String보다 StringBuffer의 사용이 더 좋다.
		sb.append("* remoteAddr : " + remoteAddr + "\n")
		  .append("* uri : " + uri + "\n")
		  .append("* url : " + url + "\n")
		  .append("* queryString : " + queryString + "\n")
		  .append("* referer : " + referer + "\n")
		  .append("* agent : " + agent);
		  
		
		System.out.println("LOG FILTER\n" + sb);
		chain.doFilter(req, response);
		
	}

	@Override
	public void destroy() {  //종료시
	
	}

	

}
