package logon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class LogonInputFormAction  implements CommandAction{ //회원가입 폼 처리
	
	@Override
	public String pro(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		
		return "logon/inputForm.jsp";
	}

}
