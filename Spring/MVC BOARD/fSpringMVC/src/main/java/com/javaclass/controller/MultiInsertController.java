package com.javaclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaclass.model.MemberVO;
import com.javaclass.model.MemberVOList;

@Controller
public class MultiInsertController {

	@RequestMapping("multiInsert")
	public void test(MemberVOList memberVOList) {
		
	}
}
