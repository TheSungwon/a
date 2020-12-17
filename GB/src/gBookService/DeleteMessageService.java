package gBookService;

import java.sql.Connection;
import java.sql.SQLException;

import gBook.ConnectionProvider;
import gBook.Message;
import gBook.jdbcUtil;
import gBookDao.MessageDao;
import gBookDao.MessageDaoProvider;
import gBookException.InvalidMessagePassowrdException;
import gBookException.MessageNotFoundException;
import gBookException.ServiceException;

//1�����ѹ�ȣ�� �ش��ϴ� �޽����˻� MessageDao.select()
//2�޽������������������ ���ܹ߻�
//3�޽�������ȣ�� �����Ǿ��������� ��� ����
//4�޽����� �޽����� �Ķ���ͷ� ���޹��� ��ȣ�� �ٸ���� ����
//5�޽����� ���� MessageDao.select()
public class DeleteMessageService {
	private static DeleteMessageService instance = new DeleteMessageService();
	public static DeleteMessageService getInstance() {
		return instance;
	}
	private DeleteMessageService() {}
	
	
	public void deleteMessage(int messageId,String password) throws ServiceException, InvalidMessagePassowrdException, MessageNotFoundException
	{
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);	//Ʈ����� ����
			
			MessageDao messageDao = MessageDaoProvider.getInstance().getMessageDao();
			
			Message message = messageDao.select(conn, messageId);//������ �޽����� �ش��ϴ�Message��ü����
			
			if(message == null) {
				throw new MessageNotFoundException("�޽���"+messageId);
			}	//Message�� ������������ ��� ���ܹ߻�
			
			if(!message.hasPassword()) {
				throw new InvalidMessagePassowrdException();
			}	//Message��ü�� ��ȣ�����ų� �Ķ���ͷι��� ��ȣ�� Message��password������Ƽ���� �ٸ��鿹��
			
			messageDao.delete(conn, messageId); //messageDao.delete�޼��带�̿��ؼ� ������id�� �ش��ϴ� �޽�������
			conn.commit();	//Ʈ����� Ŀ��
			
		}catch(SQLException e) {
			jdbcUtil.rollback(conn);
			throw new ServiceException("��������"+e.getMessage());//ó�����߿��ܹ߻��ϸ� �ѹ��ϰ� ���ܹ߻�
		}catch(InvalidMessagePassowrdException e) {
			jdbcUtil.rollback(conn);//�� ��ȣif������ ��ȣ�� �����ʾ� ���ܹ߻��ϸ� Ʈ����Ƿѹ��� ���� ��߻�
			throw e;
		}catch(MessageNotFoundException e) {
			jdbcUtil.rollback(conn); //�� �޽���if������ �޽����� ���������ʾ� ���ܹ߻��ϸ� Ʈ����Ƿѹ��Ŀ�����߻�
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
