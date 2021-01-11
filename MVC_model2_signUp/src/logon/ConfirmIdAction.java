package logon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import board.LogonDBBean;

public class ConfirmIdAction implements CommandAction{ //입력 된 글 처리
	
	@Override
	public String pro(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		
		req.setCharacterEncoding("euc-kr");
		
		String id = req.getParameter("id"); //사용자입력 아이디
		
		LogonDBBean dbPro = LogonDBBean.getInstance();
		int check = dbPro.confirmId(id);
		
		req.setAttribute("id", id);
		req.setAttribute("check", new Integer(check));
		
		return "/logon/confirmId.jsp";
	}

}
