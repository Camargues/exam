package com.javaclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaclass.model.MemberVO;

@Controller
@RequestMapping("re")
public class RequestMappingController {

	// 여러개 매핑할 경우 value= 뒤에 {} 사용
	@RequestMapping(value= {"/a.do", "/b.do"})
	public String requestMapping() {
		System.out.println("a.do 요청확인");
		// 1) ModelAndView 리턴
		// ---------------------------
		// 2) return 형이 String인 경우
		// 뷰 페이지 지정임
		return "start";
	}
	
	@RequestMapping(value= {"/c.do"})
	public void requestMapping2(String id) {
		// 3) return형이 void인 경우
		// 요청명과 동일한 viewpage를 지정함 ex) re/c.do
		System.out.println("클라이언트로 부터 아이디값 받은 데이터 : " + id);
	}
	
	@RequestMapping(value="/request.do", method = RequestMethod.POST)
	// 이전 화면(폼 안)에서 사용자 입력값을 얻어와서 MemberVO 객체에 멤버로 저장
	// public void requestMapping3(@ModelAttribute("vo") MemberVO vo) 로 넘기면
	// 뷰페이지에서 vo로 선언할수 있음
	public void requestMapping3(MemberVO vo) {
		System.out.println("멤버의 아이디 : " + vo.getId());
		System.out.println("멤버의 이름 : " + vo.getName());
		System.out.println("멤버의 나이 : " + vo.getAge());
	}
	
	@RequestMapping(value="/model.do")
	public void requestMapping4(Model m) {
		// 4) 뷰페이지로 Model 객체에 데이터 저장하여 전송
		// 모델 변수 선언이 인자로 지정
		m.addAttribute("message", "오늘도 힘듦");
		m.addAttribute("data", "스프링");
	}
}

