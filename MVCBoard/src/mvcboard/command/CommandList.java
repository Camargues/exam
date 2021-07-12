package mvcboard.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcboard.command.Command;
import mvcboard.model.*;

public class CommandList implements Command{
	
	private String next;

	public CommandList() {
		
	}
	
	public CommandList( String _next ){
		next = _next;
	}
	
	private int totalRecCount;		// 전체 레코드 수	
	private int pageTotalCount;		// 전체 페이지 수
	private int countPerPage = 3;	// 한페이지당 레코드 수
	
	private static CommandList instance;
	public static CommandList getInstance()  throws BoardException{
		if( instance == null )
		{
			instance = new CommandList();
		}
		return instance;
	}
	
	public String execute( HttpServletRequest request , HttpServletResponse response  ) throws BoardException {
		try {
		String pNum = request.getParameter("page");
		// 현재 페이지 받아오기
		int pageNum = 1;
		// 기본 페이지를 1로 설정
		if(pNum != null) pageNum = Integer.parseInt(pNum);
		// 현제 페이지가 null이 아닐 경우 현재 페이지로 변경
		int firstRow = (pageNum*countPerPage) - (countPerPage-1);
		// 페이지 그룹에서 첫번째로 보여줄 페이지
		int endRow = pageNum*countPerPage;
		// 페이지 그룹에서 마지막으로 보여줄 페이지
		 List <BoardVO> mList = BoardDao.getInstance().selectList(firstRow, endRow);	
		 request.setAttribute("mList", mList );
		}catch(BoardException e){
			throw new BoardException("CommandList.java < 조회시 > " + e.toString() ); 
		}
		totalRecCount = BoardDao.getInstance().getTotalCount();
		// 전체 페이지수 구하기
		pageTotalCount = (int)Math.ceil((double)totalRecCount / (double)countPerPage);

		request.setAttribute("total",pageTotalCount);
		
		return next;
	}
		
	
	/*public int getTotalCount() throws BoardException {
		// DB에서 실제 레코드 수를 얻어오기
		totalRecCount = BoardDao.getInstance().getTotalCount();
		// 전체 페이지수 구하기
		pageTotalCount = (int)Math.ceil((double)totalRecCount / (double)countPerPage);
		
		if(totalRecCount%3 == 0) {
			pageTotalCount = totalRecCount/3;
		}
		else {
			pageTotalCount = (totalRecCount/3)+1;
			}
		request.setAttribute("total",pageTotalCount);
		return pageTotalCount;
		
	}*/
	
}
