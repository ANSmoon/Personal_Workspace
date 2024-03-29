package com.ssafy.mvc.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyListener2 implements ServletContextListener {
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Web Application이 종료할 때 호출 2");
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Web Application이 시작할 때 호출 2");
		ServletContext context = sce.getServletContext();
		System.out.println("Welcome : " + context.getInitParameter("welcome"));
	}
}