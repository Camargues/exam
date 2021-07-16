package com.javaclass.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReviewController {

	/*
 	  1) 리턴형이 String인 경우 return에 뷰페이지 지정
	  2) 데이터 전송 방식
	  	- Model
	  	- ModelAndView
	  	- Map
	 */
	
//	@RequestMapping("review")
//	public ModelAndView review() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("message", "좋은 아침");
//		mv.addObject("greeting", "너무 졸려");
//		mv.setViewName("09_exercise");
//		return mv;
//	}
	
	@RequestMapping("review")
	public Map review() {
		Map<String, String> m = new HashMap<String, String>();
		m.put("message", "좋은 아침");
		m.put("greeting", "너무 졸려");
		return m;
	}
	// 뷰 페이지를 지정하지 않으면 
	// 매핑 요청들오면 이름으로 뷰페이지 지정됨
}
