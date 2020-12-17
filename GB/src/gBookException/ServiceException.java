package gBookException;

public class ServiceException extends Exception{
	//dao실행 도중 sqlexception발생할경우 serviceexcpetion이 발생시키도록하는 클래스
	
	public ServiceException(String message, Exception cause) {
		super(message, cause);
	}
	
	public ServiceException(String message) {
		super(message);
	}
}
