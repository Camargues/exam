package com.javaclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javaclass.model.MemberVO;

@Controller
public class AutoScanController {
	
	@Autowired
	private MemberVO memberVO;
	
	@RequestMapping("autoScan.do")
	public ModelAndView autoScan() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("01_autoScan");
		mv.addObject("name", "홍길자");
		mv.addObject("vo", memberVO);
		return mv;
	}
}
