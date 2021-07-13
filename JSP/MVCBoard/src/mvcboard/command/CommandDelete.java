package mvcboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcboard.model.*;

public class CommandDelete implements Command {
	
	
	private String next;

	public CommandDelete( String _next ){
		next = _next;
	}
	
	public CommandDelete() {
		
	}
	
	private static CommandDelete instance;
	public static CommandDelete getInstance()  throws BoardException{
		if( instance == null )
		{
			instance = new CommandDelete();
		}
		return instance;
	}
	
	public String execute( HttpServletRequest request , HttpServletResponse response  ) throws BoardException{
		try {
			
			String id = request.getParameter("seq");
			String password = request.getParameter("password");
		// DB에서 delete
		int article_id = 0;
		if( id!=null ) article_id = Integer.parseInt( id );
		int result = BoardDao.getInstance().delete(article_id, password);
	
		request.setAttribute("result", result);
		}catch(BoardException e){
			throw new BoardException("CommandDelete.java < 글 삭제시 > " + e.toString() ); 
		}
		return next;
	}


}
