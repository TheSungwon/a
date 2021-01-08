package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NullAction implements CommandAction	{
	@Override
	public String pro(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		// TODO Auto-generated method stub
		return "/mvc/nullCommand.jsp";
	}

}
