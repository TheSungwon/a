package gBookException;

public class ServiceException extends Exception{
	//dao���� ���� sqlexception�߻��Ұ�� serviceexcpetion�� �߻���Ű�����ϴ� Ŭ����
	
	public ServiceException(String message, Exception cause) {
		super(message, cause);
	}
	
	public ServiceException(String message) {
		super(message);
	}
}
