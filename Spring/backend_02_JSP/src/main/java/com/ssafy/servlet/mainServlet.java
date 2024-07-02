package com.ssafy.servlet;

import java.io.IOException;

import com.ssafy.dto.Person;
import com.ssafy.manager.PersonManager;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mainServlet
 */
//@WebServlet("/main")
public class mainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "regist":
			doRegist(request, response);
			break;
		case "list":
			doList(request, response);
			break;
		}

	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("send");
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");

		Person p = new Person(name, age, gender, hobby);

		PersonManager pm = PersonManager.getInstance();

		pm.regist(p);

		request.setAttribute("person", p);

		RequestDispatcher disp = request.getRequestDispatcher("/12_result.jsp");
		disp.forward(request, response);

//		response.sendRedirect(request.getContextPath() + "/12_result.jsp");
	}
}