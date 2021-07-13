package mvcboard.control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcboard.command.Command;
import mvcboard.command.CommandDelete;
import mvcboard.model.BoardException;
import mvcboard.command.CommandInput;
import mvcboard.command.CommandList;
import mvcboard.command.CommandNull;
import mvcboard.command.CommandView;
import mvcboard.command.CommandModify;

/**
 * Servlet implementation class GuestControl
 */
public class BoardControl extends HttpServlet {
	
	private HashMap commandMap;
	private String	jspDir = "/MVCBoard/";
	private String  error = "error.jsp";
	

    public BoardControl() {
    	super();       
		initCommand();
    }

	private void initCommand(){
		commandMap = new HashMap();

		commandMap.put("index",	new CommandNull("/BoardIndex.jsp") );
		commandMap.put("list",	new CommandList("/BoardList.jsp") );
		// 나머지도 추가하기		
		commandMap.put("input-form",new CommandNull("/BoardInputForm.jsp"));
		commandMap.put("input-do",new CommandInput("/BoardSave.jsp"));
		commandMap.put("delete-form",new CommandNull("/BoardDeleteForm.jsp"));
		commandMap.put("delete-do",new CommandDelete("/BoardDelete.jsp"));
		commandMap.put("modify",new CommandView("/BoardModifyForm.jsp"));
		commandMap.put("modify-do",new CommandModify("/BoardModify.jsp"));
		commandMap.put("view",new CommandView("/BoardView.jsp"));
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String nextPage = "";
		String cmdKey	= request.getParameter("cmd");
		if( cmdKey == null ){
			cmdKey = "index";
		}

		
		Command cmd = null;

		try{
			
			if( commandMap.containsKey( cmdKey ) ){
				cmd = (Command)commandMap.get( cmdKey);
			}else{
				throw new BoardException("지정할 명령어가 존재하지 않음");
			}

			nextPage = cmd.execute( request, response  );

		}catch( BoardException e ){
			request.setAttribute("javax.servlet.jsp.jspException", e );
			nextPage = error;
			System.out.println("오류 : " + e.getMessage() );
		}

		RequestDispatcher reqDp = getServletContext().getRequestDispatcher( jspDir + nextPage );
		reqDp.forward( request, response );
		
	}

}

