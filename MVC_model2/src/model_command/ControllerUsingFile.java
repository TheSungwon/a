package model_command;

import java.io.FileInputStream;
import java.io.IOException;

import java.net.URL; //?

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model_command.CommandHandler;
import model_command.NullHandler;

public class ControllerUsingFile extends HttpServlet{ //init-doget,dopost -process
	
	//<command, handler instance> 매핑정보저장...
	private Map commandHandlerMap = new java.util.HashMap();
	
	@Override
		public void init(ServletConfig config) throws ServletException { //config-web.xml
		
		String configFile = config.getInitParameter("configFile"); //string으로 경로저장
		
		Properties prop = new Properties();
		FileInputStream fis = null;
		
		try {
			String configFilePath = config.getServletContext().getRealPath(configFile); //상대경로를 절대경로로 리턴
			
			fis = new FileInputStream(configFilePath);
			
			prop.load(fis); //hello=k , =v 저장
			
		}catch(IOException e) {
			throw new ServletException(e);
		}finally {
			if(fis != null) {
				try {
					fis.close();
				}catch(IOException e1) {
					
				}
			}
			Iterator keyIter = prop.keySet().iterator();
			while(keyIter.hasNext()) {
				String command = (String)keyIter.next(); //hello
				
				String handlerClassName = prop.getProperty(command); //model_command.HelloHandler ..?
				
				try {
					Class handlerClass = Class.forName(handlerClassName);//class로 변경
					
					Object handlerInstance = handlerClass.newInstance(); //객체생성
					commandHandlerMap.put(command, handlerInstance);
				}catch(ClassNotFoundException e) {
					throw new ServletException(e);
					
				}catch(InstantiationException e	) {
					throw new ServletException(e);
					
				}catch(IllegalAccessException e) {
					throw new ServletException(e);
				}
						
					}//...프로퍼티...init
				}
			}
	
	
	
	@Override
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		process(req, resp);
		
		}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		process(req, resp);
		
	}
	
	
	
	private void process(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
		
		String command = req.getParameter("cmd");
		
		CommandHandler handler = ((CommandHandler) commandHandlerMap.get(command));
		
		if(handler == null) {
			handler = new NullHandler();
		}
		
		String viewPage = null;
		try {
			viewPage = handler.process(req, resp);
		}catch(Throwable e) {
			throw new ServletException(e);
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
		dispatcher.forward(req, resp);
		
		
		}
}
