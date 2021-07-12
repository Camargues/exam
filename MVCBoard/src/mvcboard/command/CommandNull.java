package mvcboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcboard.model.BoardException;

public class CommandNull implements Command{
	private String next;

	public CommandNull( String _next ){
		next = _next;
	}

	public String execute( HttpServletRequest request, HttpServletResponse response   ) throws BoardException{
		return next;
	}

}
