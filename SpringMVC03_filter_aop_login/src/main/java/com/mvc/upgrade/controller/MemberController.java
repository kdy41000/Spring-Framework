package com.mvc.upgrade.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.biz.MemberBiz;
import com.mvc.upgrade.model.dto.MemberDto;

@Controller
public class MemberController {
	
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberBiz biz;
	
	@RequestMapping(value = "/loginform.do")
	public String loginForm() {
		logger.info("LOGIN FORM");
		return "mvclogin";
	}
	
	@RequestMapping(value = "/ajaxlogin.do", method = RequestMethod.POST)
	@ResponseBody    //viewResolver를 거치지 않고 에이작스로 return해준다.
	public Map<String, Boolean> ajaxLogin(HttpSession session, @RequestBody MemberDto dto){ //json타입의 문자열을 MemberDto에 대입시킨다.
		/*
		 * @ResponseBody : java 객체를 response 객체에 binding(viewResolver를 거치지 않는다.)
		 * @RequestBody : request 객체에 담겨져 넘어오는 데이터를 java 객체에 binding(RequestBody가 찾아준다.)
		 */
		logger.info("AJAX LOGIN");
		MemberDto res = biz.login(dto);
		boolean check = false;
		if(res != null) {
			session.setAttribute("login", res);
			session.setAttribute("logininfo", res.getMemberid());
			check = true;
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);   //로그인 성공 시 true / 실패 시 false 
		
		return map;
		
	}
	
	@RequestMapping(value = "/signupform.do", method = RequestMethod.GET)
	public String signupForm() {
		logger.info("SIGNUP FORM");
		return "mvcsignup";
	}
	
	@RequestMapping(value = "/signupres.do", method = RequestMethod.POST)
	public String signupRes(Model model, MemberDto dto, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		logger.info("SIGN UP RES");
	
		int res = biz.signup(dto);
	
		model.addAttribute("res", res);
	
		return "alertsignup";
		
	}
	
}
