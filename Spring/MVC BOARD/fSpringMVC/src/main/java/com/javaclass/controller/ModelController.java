package com.javaclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaclass.model.MemberVO;

@Controller
public class ModelController {

	@ModelAttribute(value="message")
	public String attr1() {
		return "결과를 전송";
	}
	
	@ModelAttribute("vo")
	public MemberVO attr2() {
		MemberVO vo = new MemberVO();
		vo.setId("1234");
		vo.setName("박길자");
		vo.setAge(23);
		return vo;
	}
	
	@RequestMapping("modelAttr")
	public String test() {		
		return "modelAttrResult";
	}
	
	@RequestMapping("insert")
	public String insert() {
		// 추후에 DB에 입력
		// Controller -> 다른 Controller
		// 리다이렉트
		return "redirect:select.do";
	}
	
	@RequestMapping("select")
	public void select() {
		// 추후에 DB에서 데이터를 가져옴
	}
}
