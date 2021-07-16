package com.javaclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	// start.do 가 실행됐을때 요청
	@RequestMapping("start.do")
	public ModelAndView test() {
		System.out.println("start.do 요청");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("start"); //	/WEB-INF/views/ + 'start' + .jsp
		mv.addObject("test", "Hello Spring");
		return mv;
	}
}
