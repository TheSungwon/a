package gBookService;

import java.sql.Connection;
import java.sql.SQLException;

import gBook.ConnectionProvider;
import gBook.Message;
import gBook.jdbcUtil;
import gBookDao.MessageDao;
import gBookDao.MessageDaoProvider;
import gBookException.InvalidMessagePasswordException;
import gBookException.MessageNotFoundException;
import gBookException.ServiceException;

public class UpdateMessageService {
	private static UpdateMessageService instance = new UpdateMessageService();
	public static UpdateMessageService getInstance() {
		return instance;
	}
	private UpdateMessageService() {}
	////////////////////////
	
	public void updateMessage(Message message, int messageId) throws ServiceException, InvalidMessagePasswordException, MessageNotFoundException
	{
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);	//Ʈ����� ����
			
			MessageDao messageDao = MessageDaoProvider.getInstance().getMessageDao();
			
			Message message1 = messageDao.select(conn, messageId);
			
			if(message1 == null) {
				throw new MessageNotFoundException("�޽���"+messageId);
			}
			if(!message1.hasPassword()) {
				throw new InvalidMessagePasswordException();
			}	//Message��ü�� ��ȣ�����ų� �Ķ���ͷι��� ��ȣ�� Message��password������Ƽ���� �ٸ��鿹��
			
			messageDao.update(conn, message);
			conn.commit();	//Ʈ����� Ŀ��
			
		}catch(SQLException e) {
			jdbcUtil.rollback(conn);
			throw new ServiceException("����"+e.getMessage());//ó�����߿��ܹ߻��ϸ� �ѹ��ϰ� ���ܹ߻�
		}catch(InvalidMessagePasswordException e) {
			jdbcUtil.rollback(conn);//�� ��ȣif������ ��ȣ�� �����ʾ� ���ܹ߻��ϸ� Ʈ����Ƿѹ��� ���� ��߻�
			throw e;
		}finally {
			if(conn != null) {
				try {
					conn.setAutoCommit(false);
				}catch(SQLException e) {
					
				}
				jdbcUtil.close(conn);
			}
		}
		
	}

}
