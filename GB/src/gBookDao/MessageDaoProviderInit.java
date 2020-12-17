package gBookDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class MessageDaoProviderInit extends HttpServlet{ 
	//�ʱ�ȭ�������μ� messageDaoProvider�� ����� dbmsŸ�Լ���
//MessageDaoProvider.setDbms()�޼ҵ� ȣ���ؼ� �ʱ�ȭ���ִ� ��� ����
	
	public void init(ServletConfig config)throws ServletException{
		String dbms = config.getInitParameter("dbms");
		if(dbms != null) {
			MessageDaoProvider.getInstance().setDbms(dbms);
		}
	}
}
