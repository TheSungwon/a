package model_command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullHandler  implements CommandHandler{
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		
		return "/a/nullCommand.jsp";
	}

}
