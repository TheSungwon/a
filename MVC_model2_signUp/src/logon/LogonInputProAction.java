package logon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import board.LogonDBBean;
import board.LogonDataBean;

import java.sql.Timestamp;

public class LogonInputProAction  implements CommandAction{ //ȸ������ ó��
	
	@Override
	public String pro(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		
		req.setCharacterEncoding("euc-kr");
		
		LogonDataBean member = new LogonDataBean(); //������ ó�� ��
		
		member.setId(req.getParameter("id"));
		member.setPasswd(req.getParameter("passwd"));
		member.setName(req.getParameter("name"));
		member.setJumin1(req.getParameter("jumin1"));
		member.setJumin2(req.getParameter("jumin2"));
		member.setEmail(req.getParameter("email"));
		member.setBlog(req.getParameter("blog"));
		member.setReg_date(new Timestamp(System.currentTimeMillis()));
		
		LogonDBBean dbPro = LogonDBBean.getInstance(); //DBó��
		
		dbPro.insertMember(member);
		
		return "/logon/inputPro.jsp";
	}

}
