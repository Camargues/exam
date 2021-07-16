package com.javassem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/getBoardList.do")
	public void getBoardList(Model m, String searchCondition, String searchKeyword) {
		m.addAttribute("boardList", boardService.getBoardList(searchCondition,searchKeyword) );
	}

	
	@RequestMapping("/insertBoard.do")
	public void insertBoard() {
		
	}
	
	@RequestMapping("/saveBoard.do")
	public String saveBoard(BoardVO vo) {
		System.out.println(vo.getTitle());
		boardService.insertBoard(vo);
		return "redirect:/getBoardList.do";
	}
	
//	@RequestMapping("/getBoard.do")
//	public void getBoard(String seq, Model m) {
//		BoardVO vo = new BoardVO();
//		vo.setSeq(Integer.parseInt(seq));
//		m.addAttribute("board", boardService.getBoard(vo));
//	}

	@RequestMapping("/getBoard.do")
	public void getBoard(BoardVO vo, Model m) {
		m.addAttribute("board", boardService.getBoard(vo));
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect:/getBoardList.do";
	}
		
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) {
		boardService.updateBoard(vo);
		return "redirect:/getBoardList.do";
		//	return "redirect:/getBoard.do?seq=" + vo.getSeq();
		// 상세보기로 리다이렉트 보내면 확인이 잘 안되서 글목록으로 리다이렉트 시킴
		
	}
	
	

}
