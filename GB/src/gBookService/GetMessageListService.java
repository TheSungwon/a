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

//전체페이지 개수 MessageDao.selectCount호출
//요청한페이지번호에 해당하는 메시지의 시작행 끝행 구한다
//시작행 끝행에 포함된 메시지 목록 구한다 MessageDao.SelectList
//MessageViewList객체리턴
public class GetMessageListService {

	private static GetMessageListService instance = new GetMessageListService();
	public static GetMessageListService getInstance() {
		return instance;
	}
	private GetMessageListService() {}
	
	private static final int MESSAGE_COUNT_PER_PAGE = 3;	//한 페이지 메시지개수 3
	
	public MessageListView getMessageList(int pageNumber) throws ServiceException{
		Connection conn = null;
		int currentPageNumber = pageNumber;
		
		try {
			conn = ConnectionProvider.getConnection();
			MessageDao messageDao = MessageDaoProvider.getInstance().getMessageDao();
			
			int messageTotalCount = messageDao.selectCount(conn); //전체메시지 개수 구하기
			List<Message> messageList = null;
			int firstRow = 0;
			int endRow = 0;
			if(messageTotalCount > 0) {
				firstRow = (pageNumber -1) * MESSAGE_COUNT_PER_PAGE +1;
				endRow = firstRow + MESSAGE_COUNT_PER_PAGE -1;
				messageList = messageDao.selectList(conn, firstRow, endRow);//시작행 끝행 속하는 메시지목록
			}else {
				currentPageNumber = 0; //count 0이면 빈List를 messageList에할당
				messageList = Collections.emptyList();
			}
			return new MessageListView(messageList,messageTotalCount,currentPageNumber,
					MESSAGE_COUNT_PER_PAGE,firstRow,endRow); 	//MessageViewList객체리턴
			
		}catch(SQLException e){
			throw new ServiceException("실패"+e.getMessage(),e);
		}finally {
			jdbcUtil.close(conn);
		}
	}
}
