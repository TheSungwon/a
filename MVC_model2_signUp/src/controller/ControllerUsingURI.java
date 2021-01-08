package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import action.NullAction;

public class ControllerUsingURI  extends HttpServlet{
	
	private Map commandMap = new HashMap(); 
	//명령어와 명령어처리 클래스를 쌍으로 저장
	//명령어와 처리클래스가 매핑되어 있는 프로퍼티 파일을 읽어서 Map객체 안 commandMap에 저장
	//프로퍼티 파일은 CommandHandlerURI.properties ?
	
	
	@Override
	public void init(ServletConfig config) throws ServletException { //init초기화작업?
		
		String props = config.getInitParameter("configFile"); 
		//web.xml에서 propertyConfig에 해당하는 init-param의 값 읽어옴
		
		Properties pr = new Properties();
		//명령어와 처리클래스의 매핑정보를 저장할 프로퍼티객체 생성
		
		FileInputStream f = null;
		
		try {
			String configFilePath = config.getServletContext().getRealPath(props);
			
			f = new FileInputStream(configFilePath);
			//Command.properties파일의 내용을 읽어옴
			
			pr.load(f);
			//Command.properties파일의 정보를 Properties객체에 저장
		}catch(IOException e) {
			throw new ServletException(e);
		}finally {
			if( f != null)
				try {f.close();}catch(IOException e1) {}
		}
		
		Iterator keyIter = pr.keySet().iterator();
		//Iterator객체는 Enumeration객체를 확장시킨 개념의 객체...?
		
		while(keyIter.hasNext()) {
			//객체를 하나씩 꺼내석 그 객체명으로 Properties객체에 저장된 객체에 접근
			
			String command = (String)keyIter.next();
			String className = pr.getProperty(command);
			
			try {
				Class commandClass = Class.forName(className);
				//해당 문자열을 클래스로 만들기
				
				Object commandInstance = commandClass.newInstance();
				//해당 클래스의 객체를 생성
				
				commandMap.put(command, commandInstance);
				//Map객체인 commandMap에 객체 저장
			}catch(ClassNotFoundException e) {
				throw new ServletException(e);
			}catch(InstantiationException e) {
				throw new ServletException(e);
			}catch(IllegalAccessException e) {
				throw new ServletException(e);
			}
					
		}
				
	}
	
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		pro(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		pro(req, resp);
		
	}
	
	
	
	//사용자의 요청을 분석해서 해당 작업을 처리
	private void pro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String view = null;
		CommandAction com = null;
		
		try {
			String command = req.getRequestURI();
			if(command.indexOf(req.getContextPath()) == 0) {
				command = command.substring(req.getContextPath().length());
			}
			
			com = (CommandAction)commandMap.get(command);
			
			if(com == null) {
				com = new NullAction();
			}
			
			view = com.pro(req, resp);
			
			}catch(Throwable e) {
				throw new ServletException(e);
			}
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(view);
			dispatcher.forward(req, resp);
		}
	}
	
