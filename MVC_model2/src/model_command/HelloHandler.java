package model_command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloHandler implements CommandHandler{
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		
		req.setAttribute("hello", "�ȳ�");
		
		return "/a/hello.jsp";
	}

}
