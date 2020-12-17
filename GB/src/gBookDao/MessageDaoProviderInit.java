package gBookDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class MessageDaoProviderInit extends HttpServlet{ 
	//초기화서블릿으로서 messageDaoProvider에 사용할 dbms타입설정
//MessageDaoProvider.setDbms()메소드 호출해서 초기화해주는 기능 제공
	
	public void init(ServletConfig config)throws ServletException{
		String dbms = config.getInitParameter("dbms");
		if(dbms != null) {
			MessageDaoProvider.getInstance().setDbms(dbms);
		}
	}
}
