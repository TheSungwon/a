package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandAction {
	
	public String pro(HttpServletRequest req, HttpServletResponse resp)throws Throwable; 
	//��û�Ķ���ͷ� ��ɾ �����ϴ� ����� �����������̽�..?
}
