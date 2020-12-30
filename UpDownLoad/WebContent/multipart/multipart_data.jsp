<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="java.io.InputStream"%>
<%@page import="java.io.IOException"%>
<%@page trimDirectiveWhitespaces="true"%>

<% InputStream is = null; 
	
	out.print(request.getContentType()); //웹브라우저가 전송한 데이터를 그대로출력
	
	try{
		is=request.getInputStream();
		int data = -1;
		
		while( (data = is.read()) != -1){
			out.print((char)data);
		}
	}finally{
		if(is != null)try{is.close();} catch(IOException e){}
	}
%>