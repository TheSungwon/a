package gBookService;

import java.sql.Connection;
import java.sql.SQLException;

import gBook.jdbcUtil;
import gBook.ConnectionProvider;
import gBook.Message;
import gBookDao.MessageDao;
import gBookDao.MessageDaoProvider;
import gBookException.ServiceException;
import 	  gBook.ConnectionProvider;

public class WriteMessageService {
	private static WriteMessageService instance = new WriteMessageService();
	public static WriteMessageService getInstance() {
		return instance;
	}
	private WriteMessageService() {}
	
	
	
	public void write(Message message) throws ServiceException{
		Connection conn = null;
		
		try { 
			conn = ConnectionProvider.getConnection();
			MessageDao messageDao = MessageDaoProvider.getInstance().getMessageDao();
			
			messageDao.insert(conn, message);	//메소드를 이용해서 메시지삽입
			
		}catch(SQLException e) {
			throw new ServiceException(e.getMessage());
		}finally{
			jdbcUtil.close(conn);
			
		}
	}
}
