package com.ssafy.mvc.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyListener1
 *
 */

@WebListener
public class MyListener1 implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Web Application이 시작할 때 호출 1");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Web Application이 종료할 때 호출 1");
	}

}
