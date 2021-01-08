package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandAction {
	
	public String pro(HttpServletRequest req, HttpServletResponse resp)throws Throwable; 
	//요청파라미터로 명령어를 전달하는 방식의 슈퍼인터페이스..?
}
