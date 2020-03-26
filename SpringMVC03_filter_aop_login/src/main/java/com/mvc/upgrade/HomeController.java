package com.mvc.upgrade;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.biz.BoardBizImpl;
import com.mvc.upgrade.model.dto.BoardDto;

@Controller
public class HomeController {
	
	@Autowired
	private BoardBiz boardbiz = new BoardBizImpl();
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String selectList(Model model) {

		model.addAttribute("boardlist", boardbiz.selectList());
		
		return "boardlist";
		
	}
	
	@RequestMapping(value = "/boarddetail.do", method = RequestMethod.GET)
	public String selectDetail(Model model, int myno) {
		
		BoardDto dto = boardbiz.selectOne(myno);
		
		//조회수 update
		dto.setMycnt(dto.getMycnt()+1);
		dto.setMyno(myno);
		
		int res = boardbiz.updatecnt(dto);
		//---------------------------------------
		
		model.addAttribute("boarddetail", dto);
		
		return "boardDetail";
		
	}
	
	@RequestMapping(value = "/boardwrite.do", method = RequestMethod.GET)
	public String insert(Model model, HttpServletRequest request) {
		int res = 0;
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("logininfo")+"::*******************************");
		model.addAttribute("writeinfo", session.getAttribute("logininfo"));
		return "insert";
	}
	
	@RequestMapping(value = "/writeres.do", method = RequestMethod.POST)
	public String writeres(Model model, @ModelAttribute BoardDto dto, HttpServletRequest request, HttpServletResponse response) throws IOException {
		 response.setContentType("text/html; charset=UTF-8");
		 
		int res = 0;
		
		res = boardbiz.insert(dto);
		
		 PrintWriter out = response.getWriter();
		
		if(res > 0) {
	        out.println("<script>alert('게시글이 등록되었습니다..'); location.href='list.do';</script>");
		}else {
			out.println("<script>alert('게시글이 등록을 실패하였습니다.');</script>");
			return "insert";
		}
		return null;
	
	}
	
	@RequestMapping(value = "/boardupdate.do", method = RequestMethod.GET)
	public String update(Model model,int myno) {
		
		model.addAttribute("updatedto", boardbiz.selectOne(myno));
		
		return "update";
		
	}
	
	@RequestMapping(value = "/updateres.do", method = RequestMethod.POST)
	public String updateres(Model model, @ModelAttribute BoardDto dto, HttpServletRequest request, HttpServletResponse response) throws IOException {
		 response.setContentType("text/html; charset=UTF-8");
		int res = 0;
		res = boardbiz.update(dto);
		
		PrintWriter out = response.getWriter();
		if(res > 0) {   //return "redirect:detail.do?myno="+dto.getMyno(); 로 사용해도 된다.
			out.println("<script>alert('게시글이 수정되었습니다.'); location.href='boarddetail.do?myno="+dto.getMyno()+"';</script>");
		}else {
			out.println("<script>alert('게시글이 수정을 실패하였습니다.'); location.href='boardupdate.do?myno="+dto.getMyno()+"';</script>");
		}
		
		return null;
		
	}
	
	@RequestMapping(value = "/boarddelete.do", method = RequestMethod.GET)
	public String delete(Model model, int myno, HttpServletRequest request, HttpServletResponse response) throws IOException {
		 response.setContentType("text/html; charset=UTF-8");
		 
		int res = 0;
		res = boardbiz.delete(myno);
		//logger.info(myno+"::삭제 컨트롤러 myno");
		PrintWriter out = response.getWriter();
		
		if(res > 0) {
			  out.println("<script>alert('게시글이 삭제되었습니다.'); location.href='list.do';</script>");
		}else {
			return "boarddetail.do?myno= " + myno;
		}
		return null;
	}
	
}
