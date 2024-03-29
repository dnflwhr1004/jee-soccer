package com.soccer.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sender {
	public static void forward(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			System.out.println("★★★ 6. Sender 들어옴 ★★★ ");
			System.out.println(String.format("request 값 출력 : %s, %s, %s, %s ",
					request.getParameter("playerId"), 
					request.getParameter("solar"),
					request.getParameter("action"),
					request.getParameter("page")));
		
			request
			.getRequestDispatcher(Receiver.cmd.getView())
			.forward(request, response);
			System.out.println("센더 cmd" + Receiver.cmd);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	public static void redirect(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response
			.sendRedirect("");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
}