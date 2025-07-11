package com.multicampus.web.common;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class BoardServletContextListner implements ServletContextListener, ServletContextAttributeListener {

    public BoardServletContextListner() {
    	System.out.println("===> BoardServletContextListener created~!");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("===> Servlet Container created~!");
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("===> Servlet Container closed~!");
    }
    
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
    	System.out.println("===> " + event.getName() + " registered on Servlet Context Object");
    }
    
    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
    	System.out.println("===> " + event.getName() + " replaced on Servlet Context Object");
    }
    
    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
    	System.out.println("===> " + event.getName() + " removed on Servlet Context Object");
    }
    
    
}