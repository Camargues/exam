package com.javaclass.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaclass.model.MemberVO;

@Controller
public class ParamController {
	
	@RequestMapping("param")
	public String test(String id, String age) {
		return "04_param";
	}
	
	// 세션이 필요할때 그냥 인자로 HttpSession session 만 선언
	@RequestMapping("paramForm")
	public String param(MemberVO vo, HttpSession session) {
		String dbid = "kosmo";
		String dbname = "홍길자";
		// 로그인 처리
		if(vo.getId().equals(dbid) && vo.getName().equals(dbname)) {
			session.setAttribute("login", dbid+"님 접속");
		}
		else {
			session.setAttribute("login", "아이디가 일치하지 않습니다");
		}
		return "04_form";
	}
}
