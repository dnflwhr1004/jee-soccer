package com.soccer.web.command;
import javax.servlet.http.HttpServletRequest;
import com.soccer.web.enums.Action;

public class Commander {

	public static Command direct(HttpServletRequest request) {
		Command cmd = null;
		System.out.println("커멘더");
		switch(Action.valueOf(request.getParameter("action").toUpperCase())) {
		case CREATE :  cmd = new CreateCommand(request); break;
		case SEARCH : cmd = new SearchCommand(request);  break;
		case UPDATE : break;
		case DELETE : break;
		case MOVE : cmd =  new MoveCommand(request); break;
		case LOGIN :cmd =  new LoginCommand(request);  break;
		default:
			break;
		}
		
		return cmd;
	}
}