package forName;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.util.StringTokenizer;

public class forNameLoader extends HttpServlet { //���
	
	public void init(ServletConfig config) throws ServletException{ //������ �ʱ�ȭ�� �� ȣ��Ǵ� init�޼��屸��
		try {
			String drivers = config.getInitParameter("jdbc");//jdbcdirver �ʱ�ȭ �Ķ���� ��
			StringTokenizer st = new StringTokenizer(drivers,","); // �ʱ�ȭ�Ķ������ ���� �޸��� �и�
			while(st.hasMoreTokens()) {			//�޸��� �и��� �� ���ڿ��� jdbc����̹� Ŭ������ �̸����� ����ؼ� jdbc����̹��� �ε�
				String jdbcDriver = st.nextToken();
				Class.forName(jdbcDriver);
			}
		}catch(Exception e) {				//jdbc����̹� �ε� �������� ������ ������� ���ܹ߻�
			throw new ServletException(e);
		}
	}

}
