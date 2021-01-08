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
	//��ɾ�� ��ɾ�ó�� Ŭ������ ������ ����
	//��ɾ�� ó��Ŭ������ ���εǾ� �ִ� ������Ƽ ������ �о Map��ü �� commandMap�� ����
	//������Ƽ ������ CommandHandlerURI.properties ?
	
	
	@Override
	public void init(ServletConfig config) throws ServletException { //init�ʱ�ȭ�۾�?
		
		String props = config.getInitParameter("configFile"); 
		//web.xml���� propertyConfig�� �ش��ϴ� init-param�� �� �о��
		
		Properties pr = new Properties();
		//��ɾ�� ó��Ŭ������ ���������� ������ ������Ƽ��ü ����
		
		FileInputStream f = null;
		
		try {
			String configFilePath = config.getServletContext().getRealPath(props);
			
			f = new FileInputStream(configFilePath);
			//Command.properties������ ������ �о��
			
			pr.load(f);
			//Command.properties������ ������ Properties��ü�� ����
		}catch(IOException e) {
			throw new ServletException(e);
		}finally {
			if( f != null)
				try {f.close();}catch(IOException e1) {}
		}
		
		Iterator keyIter = pr.keySet().iterator();
		//Iterator��ü�� Enumeration��ü�� Ȯ���Ų ������ ��ü...?
		
		while(keyIter.hasNext()) {
			//��ü�� �ϳ��� ������ �� ��ü������ Properties��ü�� ����� ��ü�� ����
			
			String command = (String)keyIter.next();
			String className = pr.getProperty(command);
			
			try {
				Class commandClass = Class.forName(className);
				//�ش� ���ڿ��� Ŭ������ �����
				
				Object commandInstance = commandClass.newInstance();
				//�ش� Ŭ������ ��ü�� ����
				
				commandMap.put(command, commandInstance);
				//Map��ü�� commandMap�� ��ü ����
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
	
	
	
	//������� ��û�� �м��ؼ� �ش� �۾��� ó��
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
	
