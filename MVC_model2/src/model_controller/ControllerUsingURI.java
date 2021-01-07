package model_controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
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

public class ControllerUsingURI extends HttpServlet{
	
	private Map commandHandlerMap = new java.util.HashMap();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		String configFile = config.getInitParameter("configFile2");
		
		Properties prop = new Properties();
		
		FileInputStream fis = null;
		
		try {
			String configFilePath = config.getServletContext().getRealPath(configFile);
			
			fis = new FileInputStream(configFilePath);
			
			prop.load(fis);
		}catch(IOException e) {
			throw new ServletException(e);
			
		}finally{
			if (fis != null)
				try {
					fis.close();
					
				}catch(IOException e) {
					
				}
		}
		Iterator keyIter = prop.keySet().iterator();
		while(keyIter.hasNext()) {
			String command =(String)keyIter.next();
			String handlerClassName = prop.getProperty(command);
			
			try {
				Class handlerClass = Class.forName(handlerClassName);
				Object handlerInstance = handlerClass.newInstance();
				commandHandlerMap.put(command, handlerInstance);
				
			}catch(ClassNotFoundException e	) {
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
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
		
	}
	
	
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//http://local~~/hello.do ??
		String command = req.getRequestURI(); // MVC_model2/hello.do
		if(command.indexOf(req.getContextPath()) == 0) { //  /MVC_model2
			command = command.substring(req.getContextPath().length()); //hello.do /length
			
		}
		
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
