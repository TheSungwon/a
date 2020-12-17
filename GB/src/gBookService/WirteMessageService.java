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

public class WirteMessageService {
	private static WirteMessageService instance = new WirteMessageService();
	public static WirteMessageService getInstance() {
		return instance;
	}
	private WirteMessageService() {}
	
	
	
	public void write(Message message) throws ServiceException{
		Connection conn = null;
		
		try { 
			conn = ConnectionProvider.getConnection();
			MessageDao messageDao = MessageDaoProvider.getInstance().getMessageDao();
			
			messageDao.insert(conn, message);	//�޼ҵ带 �̿��ؼ� �޽�������
			
		}catch(SQLException e) {
			throw new ServiceException(e.getMessage());
		}finally{
			jdbcUtil.close(conn);
			
		}
	}
}
