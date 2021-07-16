package sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	// start.do 가 불러졌을때 함수 실행
	@RequestMapping("/start.do")
	public ModelAndView test() {
		System.out.println("start.do 요청됨");
		// 데이터와 화면(뷰)을 같이 지정하는 객체 선언
		ModelAndView mv = new ModelAndView();
		// 뷰 지정
		// mv.setViewName("/WEB-INF/view/hello.jsp");
		mv.setViewName("hello");
		// 데이터 지정 (데이터 이름, 데이터 값)
		mv.addObject("name", "홍길동");
		mv.addObject("message", "오늘 뭐먹지");
		return mv;
	}
}
