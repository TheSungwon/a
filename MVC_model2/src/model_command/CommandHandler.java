package model_command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandHandler { //�������̽�
	
	//�߻�޼ҵ�
	public String process(HttpServletRequest req, HttpServletResponse resp)throws Throwable;

}
