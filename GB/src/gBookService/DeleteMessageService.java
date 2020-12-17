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

//1지정한번호에 해당하는 메시지검색 MessageDao.select()
//2메시지존재하지않을경우 예외발생
//3메시지에암호가 지정되어있지않을 경우 예외
//4메시지의 메시지와 파라미터로 전달받은 암호가 다를경우 예외
//5메시지를 삭제 MessageDao.select()
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
			conn.setAutoCommit(false);	//트랜잭션 시작
			
			MessageDao messageDao = MessageDaoProvider.getInstance().getMessageDao();
			
			Message message = messageDao.select(conn, messageId);//삭제할 메시지에 해당하는Message객체구함
			
			if(message == null) {
				throw new MessageNotFoundException("메시지"+messageId);
			}	//Message가 존재하지않을 경우 예외발생
			
			if(!message.hasPassword()) {
				throw new InvalidMessagePassowrdException();
			}	//Message객체가 암호가없거나 파라미터로받은 암호와 Message의password프로퍼티값이 다르면예외
			
			messageDao.delete(conn, messageId); //messageDao.delete메서드를이용해서 지정한id에 해당하는 메시지삭제
			conn.commit();	//트랜잭션 커밋
			
		}catch(SQLException e) {
			jdbcUtil.rollback(conn);
			throw new ServiceException("삭제에러"+e.getMessage());//처리도중예외발생하면 롤백하고 예외발생
		}catch(InvalidMessagePassowrdException e) {
			jdbcUtil.rollback(conn);//위 암호if문에서 암호가 맞지않아 예외발생하면 트랜잭션롤백후 예외 재발생
			throw e;
		}catch(MessageNotFoundException e) {
			jdbcUtil.rollback(conn); //위 메시지if문에서 메시지가 존재하지않아 예외발생하면 트랜잭션롤백후예외재발생
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
