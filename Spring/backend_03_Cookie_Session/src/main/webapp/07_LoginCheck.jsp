<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 화면에 보여줄게 아니기 때문에 구조 필요 X -> 로그인 처리만 실시 -->
    
    <%
    String id = request.getParameter("id");
    String pw = request.getParameter("password");
    
    
    // 실제로는 id / pw를 이용해 DB에 저장되어 있는 유저가 맞는지 체크 필요
    // 적어도 Manager라도 있어야 함.
    // 
    /* if("ssafy".equals(id) && "1234".equals(pw)){
    	
    } */
    
    if(id.equals("ssafy") && pw.equals("1234")){
    	// login
    	/* request.getCookies() */ // 반복문 돌면서 JSESSIONID 쿠키를 찾아 값을 이용해 메모리에 접근?
    	
    	// 위의 문제 : 코드가 너무 길어짐, 비효율적
    	// mySeesion을 session이라 하면 오류 발생
    	/* HttpSession mySession = request.getSession();
    	mySession.setAttribute("id", id); */
    	
    	// 이미 선언되어 있는 session 사용
    	session.setAttribute("id", id);
    	response.sendRedirect("08_Main.jsp");
    	
    	/* request.getRequestDispatcher("08_Main.jsp").forward(request, response); */
    			
    }else{
    	// login 실패
    	response.sendRedirect("07_Logout.jsp");
    	
    }
    
    
    %>
    
    