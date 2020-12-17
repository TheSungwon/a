package gBookService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import gBookDao.MessageDao;
import gBookDao.MessageDaoProvider;
import gBookException.ServiceException;
import gBook.Message;
import gBookService.MessageListView;
import gBook.jdbcUtil;
import gBook.ConnectionProvider;

//��ü������ ���� MessageDao.selectCountȣ��
//��û����������ȣ�� �ش��ϴ� �޽����� ������ ���� ���Ѵ�
//������ ���࿡ ���Ե� �޽��� ��� ���Ѵ� MessageDao.SelectList
//MessageViewList��ü����
public class GetMessageListService {

	private static GetMessageListService instance = new GetMessageListService();
	public static GetMessageListService getInstance() {
		return instance;
	}
	private GetMessageListService() {}
	
	private static final int MESSAGE_COUNT_PER_PAGE = 3;	//�� ������ �޽������� 3
	
	public MessageListView getMessageList(int pageNumber) throws ServiceException{
		Connection conn = null;
		int currentPageNumber = pageNumber;
		
		try {
			conn = ConnectionProvider.getConnection();
			MessageDao messageDao = MessageDaoProvider.getInstance().getMessageDao();
			
			int messageTotalCount = messageDao.selectCount(conn); //��ü�޽��� ���� ���ϱ�
			List<Message> messageList = null;
			int firstRow = 0;
			int endRow = 0;
			if(messageTotalCount > 0) {
				firstRow = (pageNumber -1) * MESSAGE_COUNT_PER_PAGE +1;
				endRow = firstRow + MESSAGE_COUNT_PER_PAGE -1;
				messageList = messageDao.selectList(conn, firstRow, endRow);//������ ���� ���ϴ� �޽������
			}else {
				currentPageNumber = 0; //count 0�̸� ��List�� messageList���Ҵ�
				messageList = Collections.emptyList();
			}
			return new MessageListView(messageList,messageTotalCount,currentPageNumber,
					MESSAGE_COUNT_PER_PAGE,firstRow,endRow); 	//MessageViewList��ü����
			
		}catch(SQLException e){
			throw new ServiceException("����"+e.getMessage(),e);
		}finally {
			jdbcUtil.close(conn);
		}
	}
}
