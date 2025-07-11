package hello;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/b.do")
public class BServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		
		context.setAttribute("nickName", "Legend");
		context.setAttribute("address", "Seoul");
		context.setAttribute("nickName", "Faker");
		context.removeAttribute("address");
		
		String nickName = (String) context.getAttribute("nickName");
		
		PrintWriter out = response.getWriter();
		out.println("<h1>Nick Name : " + nickName + "</h1>");
		
		out.close();
	}

}






