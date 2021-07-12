package mvcboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcboard.model.BoardException;

public interface Command {
	public String execute( HttpServletRequest request, HttpServletResponse response  ) throws BoardException;
}