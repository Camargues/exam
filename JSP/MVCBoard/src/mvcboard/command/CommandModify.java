package mvcboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcboard.model.*;

public class CommandModify implements Command {
	
	private String next;

	public CommandModify( String _next ){
		next = _next;
	}
	
	public CommandModify() {
		
	}
	
	private static CommandModify instance;
	public static CommandModify getInstance()  throws BoardException{
		if( instance == null )
		{
			instance = new CommandModify();
		}
		return instance;
	}
	
	public String execute( HttpServletRequest request , HttpServletResponse response  ) throws BoardException{
		
		try {
			BoardVO rec = new BoardVO();
			rec.setSeq(Integer.parseInt(request.getParameter("seq")));
			rec.setTitle(request.getParameter("title"));
			rec.setPass(request.getParameter("pass"));
			rec.setContent(request.getParameter("content"));
			int result = BoardDao.getInstance().update(rec);
			request.setAttribute("result", result);
		}
		catch(BoardException e){
			throw new BoardException("CommandInput.java < 글 수정시 > " + e.toString() ); 
		}
		return next;
		
	}
}
