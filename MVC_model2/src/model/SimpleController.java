package model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
		
	}
	
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException{
		//2�ܰ� ��û�ľ�// req��ü�κ��� ����� ��û �ľ��ڵ�
		String type = req.getParameter("type");
		
		
		//3�ܰ� ��û�� ��ɼ���/ ����ڿ�û�� ���� �˸��� �ڵ�..
		Object resultObj = null;
		if(type == null || type.equals("hh")) { //?type=hh || X
			resultObj = "����";
		}else if(type.equals("date")) { //?type=date 
			resultObj = new java.util.Date();
		}else { //?type=
			resultObj = "Invalid type";
		}
		
		
		//4. req�� session�� ó����� ����
		req.setAttribute("result", resultObj);
		
		//5. RequestDispatcher�� ����Ͽ� �˸��� �� ������
		RequestDispatcher dispatcher = req.getRequestDispatcher("simpleView.jsp");
		dispatcher.forward(req, resp);
		
	}

}
