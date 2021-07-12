package mvcboard.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcboard.model.*;


public class CommandView implements Command {
	
	private String next;
	
	public CommandView() {
		
	}
	
	public CommandView(String _next) {
		next = _next;
	}

	private static CommandView instance;
	public static CommandView getInstance()  throws BoardException{
		if( instance == null )
		{
			instance = new CommandView();
		}
		return instance;
	}
	
	public String execute( HttpServletRequest request , HttpServletResponse response  ) throws BoardException{
	try{
		
		String id = request.getParameter("seq");
		int article_id = 0;
		if( id != null ) article_id = Integer.parseInt(id);
		BoardDao dao = BoardDao.getInstance();
		BoardVO rec = dao.selectById(article_id);		
		dao.increaseReadCount(article_id);
		 request.setAttribute("vo", rec );
	}catch(BoardException e){
			throw new BoardException("CommandView.java < 조회시 > " + e.toString() ); 
	}
		return next;
	}
}

