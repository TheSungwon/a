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
		//2단계 요청파악// req객체로부터 사용자 요청 파악코드
		String type = req.getParameter("type");
		
		
		//3단계 요청한 기능수행/ 사용자요청에 따라 알맞은 코드..
		Object resultObj = null;
		if(type == null || type.equals("hh")) { //?type=hh || X
			resultObj = "ㅎㅇ";
		}else if(type.equals("date")) { //?type=date 
			resultObj = new java.util.Date();
		}else { //?type=
			resultObj = "Invalid type";
		}
		
		
		//4. req나 session에 처리결과 저장
		req.setAttribute("result", resultObj);
		
		//5. RequestDispatcher를 사용하여 알맞은 뷰 포워딩
		RequestDispatcher dispatcher = req.getRequestDispatcher("simpleView.jsp");
		dispatcher.forward(req, resp);
		
	}

}
