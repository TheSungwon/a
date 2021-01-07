package model_command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandHandler { //인터페이스
	
	//추상메소드
	public String process(HttpServletRequest req, HttpServletResponse resp)throws Throwable;

}
