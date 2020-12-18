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
			conn.setAutoCommit(false);	//트랜잭션 시작
			
			MessageDao messageDao = MessageDaoProvider.getInstance().getMessageDao();
			
			Message message1 = messageDao.select(conn, messageId);
			
			if(message1 == null) {
				throw new MessageNotFoundException("메시지"+messageId);
			}
			if(!message1.hasPassword()) {
				throw new InvalidMessagePasswordException();
			}	//Message객체가 암호가없거나 파라미터로받은 암호와 Message의password프로퍼티값이 다르면예외
			
			messageDao.update(conn, message);
			conn.commit();	//트랜잭션 커밋
			
		}catch(SQLException e) {
			jdbcUtil.rollback(conn);
			throw new ServiceException("에러"+e.getMessage());//처리도중예외발생하면 롤백하고 예외발생
		}catch(InvalidMessagePasswordException e) {
			jdbcUtil.rollback(conn);//위 암호if문에서 암호가 맞지않아 예외발생하면 트랜잭션롤백후 예외 재발생
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
