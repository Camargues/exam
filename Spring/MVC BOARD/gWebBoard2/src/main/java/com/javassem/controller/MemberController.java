package com.javassem.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.javassem.domain.MemberVO;
import com.javassem.service.MemberService;

@Controller
@RequestMapping("/user/")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/{url}.do")
	public String viewPage(@PathVariable String url) {
		return "/user/"+url;
	}
	
	@RequestMapping("userInsert.do")
	public ModelAndView insert(MemberVO vo) {
		int result = memberService.userInsert(vo);
		String message = "가입되지 않았습니다";
		
		if (result > 0)
		message = vo.getUserName() + "님 가입을 축하드립니다";
		
		ModelAndView m = new ModelAndView();
		m.setViewName("user/userJoin_ok");
		m.addObject("message", message);
		return m;
	}
	
	@RequestMapping("login.do")
	public ModelAndView login(MemberVO vo, HttpSession session) {
		ModelAndView m = new ModelAndView();
		MemberVO result = memberService.idCheck_Login(vo);
		if(result == null) {
			m.setViewName("/user/userLogin");
		}
		else {
			m.setViewName("/user/Main");
			session.setAttribute("sessionTime", new Date());
			session.setAttribute("userName", result.getUserName());
		}
		return m;
	}
	
	// ID 중복 체크
	@RequestMapping(value="idCheck.do", produces = "application/text;charset=UTF-8")
	@ResponseBody	//	AJAX 사용시 필수
	public String idCheck(MemberVO vo) throws Exception {
		MemberVO result = memberService.idCheck_Login(vo);
		String message;

		if (result != null) {
			message = "이미 사용중인 아이디입니다";
			System.out.println(message);
		}
		else {
			message = "사용가능한 아이디입니다";
			System.out.println(message);
		}
		return message;
	}
}
