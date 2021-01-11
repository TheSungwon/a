package logon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import board.LogonDBBean;

public class ConfirmIdAction implements CommandAction{ //�Է� �� �� ó��
	
	@Override
	public String pro(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		
		req.setCharacterEncoding("euc-kr");
		
		String id = req.getParameter("id"); //������Է� ���̵�
		
		LogonDBBean dbPro = LogonDBBean.getInstance();
		int check = dbPro.confirmId(id);
		
		req.setAttribute("id", id);
		req.setAttribute("check", new Integer(check));
		
		return "/logon/confirmId.jsp";
	}

}
