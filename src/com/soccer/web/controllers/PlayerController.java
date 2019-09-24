package com.soccer.web.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.soccer.web.domains.PlayerBean;
import com.soccer.web.serviceimpls.PlayerServiceImpl;


@WebServlet("/player.do")
public class PlayerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("action은 " + request.getParameter("action"));
		System.out.println("page는 " + request.getParameter("page"));
		//String action = request.getParameter("action");
		RequestDispatcher rd = null;
		
		PlayerBean player = new PlayerBean();
		switch(request.getParameter("action")) {
		case "move" : break;
		case "find2" : 
			request.setAttribute("positions", 
					PlayerServiceImpl.getInstance().findPositions());
			break;
		case "find4" :
			player = new PlayerBean();
			player.setTeamId(request.getParameter("teamId"));
			player.setPosition(request.getParameter("position"));			
			request.setAttribute("player", player);
			break;
			
		case "find5" : 
			player = new PlayerBean();
			player.setTeamId(request.getParameter("teamId"));
			player.setHeight(request.getParameter("height"));
			player.setPlayerName(request.getParameter("playerName"));
	
			System.out.println("teamId" + player.getTeamId());
			System.out.println("height" + player.getHeight());
			System.out.println("playerName" + player.getPlayerName());
			
			request.setAttribute("player", player);
			PlayerServiceImpl.getInstance().findByTeamIdHeightPlayerName(player);
			break;
		}
	rd = request.getRequestDispatcher(String.format("WEB-INF/views/%s.jsp", request.getParameter("page")));
			rd.forward(request, response);
	}
}
