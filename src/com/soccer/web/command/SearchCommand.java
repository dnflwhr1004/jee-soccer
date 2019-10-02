package com.soccer.web.command;
import javax.servlet.http.HttpServletRequest;

import com.soccer.web.serviceimpls.PlayerServiceImpl;

public class SearchCommand extends Command{

	public SearchCommand(HttpServletRequest request) {
		System.out.println("★★★  SearchCommand 들어옴 ★★★ ");
		System.out.println(String.format("request 값 출력 : %s, %s, %s, %s ",
				request.getParameter("playerId"), 
				request.getParameter("solar"),
				request.getParameter("action"),
				request.getParameter("page")));
		setRequest(request);
		setDomain(request.getServletPath()
				.substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		setPage(request.getParameter("page"));
	request.setAttribute("positions", PlayerServiceImpl.getInstance().findPositions().toString());
	
	super.execute();
	}

}