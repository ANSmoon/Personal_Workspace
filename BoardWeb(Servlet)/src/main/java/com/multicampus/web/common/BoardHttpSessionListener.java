package com.multicampus.web.common;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class BoardHttpSessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("---> HttpSession 객체가 생성됨");
    }
    
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("---> HttpSession 객체가 삭제됨");
    }
    
    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	System.out.println("---> HttpSession 객체에 " + event.getName() + "가 등록됨");
    }
    
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	System.out.println("---> HttpSession 객체에 " + event.getName() + "가 등록됨");
    }

    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	System.out.println("---> HttpSession 객체에 " + event.getName() + "가 등록됨");
    }

	
}
