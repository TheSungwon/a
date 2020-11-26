package Servlet1126;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowSv extends HttpServlet{
	//override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html; charset=euc-kr");
		Date now = new Date();
		
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head><title>현재시간</title></head>");
		writer.println("<body>");
		writer.println("현재시간:");
		writer.println(now.toString());
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close();
	}
	
	
}