package forName;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.util.StringTokenizer;

public class forNameLoader extends HttpServlet { //상속
	
	public void init(ServletConfig config) throws ServletException{ //서블릿이 초기화될 때 호출되는 init메서드구현
		try {
			String drivers = config.getInitParameter("jdbc");//jdbcdirver 초기화 파라미터 값
			StringTokenizer st = new StringTokenizer(drivers,","); // 초기화파라미터의 값을 콤마로 분리
			while(st.hasMoreTokens()) {			//콤마로 분리된 각 문자열을 jdbc드라이버 클래스의 이름으로 사용해서 jdbc드라이버를 로딩
				String jdbcDriver = st.nextToken();
				Class.forName(jdbcDriver);
			}
		}catch(Exception e) {				//jdbc드라이버 로딩 과정에서 문제가 있을경우 예외발생
			throw new ServletException(e);
		}
	}

}
