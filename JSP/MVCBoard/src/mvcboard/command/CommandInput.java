package mvcboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcboard.model.*;

public class CommandInput implements Command {
	private String next;

	public CommandInput( String _next ){
		next = _next;
	}
	public CommandInput() {
		
	}
	
	private static CommandInput instance;
	public static CommandInput getInstance()  throws BoardException{
		if( instance == null )
		{
			instance = new CommandInput();
		}
		return instance;
	}
	
	public String execute( HttpServletRequest request , HttpServletResponse response  ) throws BoardException{
		
		try {
			BoardVO rec = new BoardVO();
			rec.setWriter(request.getParameter("writer"));
			rec.setTitle(request.getParameter("title"));
			rec.setPass(request.getParameter("pass"));
			rec.setContent(request.getParameter("content"));
			BoardDao dao = BoardDao.getInstance();
			dao.insert(rec);
		}
		catch(BoardException e){
			throw new BoardException("CommandInput.java < 글 저장시 > " + e.toString() ); 
		}
		return next;
		
	}
}
