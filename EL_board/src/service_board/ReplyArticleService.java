/*이 클래스는 답변 게시글의 순서 번호를 구해야 하기 때문에 게시글 쓰기 기능에 비해 상대적으로
복잡한 로직

1. 답변 글을 등록할 부모 글을 구한다. 존재하지 않을 경우 예외 발생
2. 부모 글의 자식 글 중에서 순서번호가 가장 낮은 번호 구한다
3. 	[2]에서 구한 번호에서 답변 글의 레벨 값을 1 감소시킨 값을 순서 번호로 사용한다
4.  [3]에서 구한 순서 번호, 부모 글과 동일한 그룹 번호를 사용해서 답변 글을 삽입*/

package service_board;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;

import DAO_bean.ArticleDao;
import DTO_javaBean.Article;
import DTO_javaBean.ReplyingRequest;
import DTO_javaBean.jdbcUtil;
import Exception_board.ArticleNotFoundException;
import Exception_board.CannotReplyArticleException;
import Exception_board.LastChildAleadyExistsException;
import DTO_javaBean.ConnectionProvider;

public class ReplyArticleService {
	
	private static ReplyArticleService instance = new ReplyArticleService();
	public static ReplyArticleService getInstance() {
		return instance;
	}
	private ReplyArticleService() {}
	/////////////////////////////////////////////
	
	public Article reply(ReplyingRequest replyingRequest) throws ArticleNotFoundException, CannotReplyArticleException,
	LastChildAleadyExistsException{
		Connection conn = null;
		
		Article article = replyingRequest.toArticle(); //replyingRequest로부터 Article객체 생성
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			ArticleDao articleDao = ArticleDao.getInstance();
			Article parent = articleDao.selectById(conn, replyingRequest.getParentArticleId()); //부모 글 Article객체 구함
			
			try {
				checkParent(parent, replyingRequest.getParentArticleId()); //부모글이 존재하는지 여부와 답변 글을 등록할수있는지 확인
			}catch(Exception e) {	//checkParent가 예외발생시킬경우 트랜잭션 롤백하고 예외발생
				jdbcUtil.rollback(conn);
				if(e instanceof ArticleNotFoundException) {
					throw (ArticleNotFoundException)e;
				}else if(e instanceof CannotReplyArticleException) {
					throw (CannotReplyArticleException)e;
				}else if(e instanceof LastChildAleadyExistsException) {
					throw (LastChildAleadyExistsException)e;
				}
			}
			
			String searchMaxSeqNum = parent.getSequenceNumber();
			String searchMinSeqNum = getSearchMinSeqNum(parent);	//자식글의 최대,최소 순서번호구함
			
			String lastChildSeq = articleDao.selectLastSequenceNumber(conn, searchMaxSeqNum, searchMinSeqNum);
			//최대최소 순서번호 내에서 가장작은 값을 갖는 자식 글의 순서번호 구한다
			
			String sequenceNumber = getSequenceNumber(parent,lastChildSeq);
			//가장 작은 자식 글번호를 이용해서 새 자식 글의 순서번호를 구한다
			
			article.setGroupId(parent.getGroupId());
			article.setSequenceNumber(sequenceNumber); //답변 글의 그룹번호와 순서번호 설정
			article.setPostingDate(new Date());
			
			int articleId = articleDao.insert(conn, article); //답변 글을 테이블에 삽입
			if(articleId == -1) {
				throw new RuntimeException("DB없음"+articleId);
			}
			conn.commit();
			article.setId(articleId);
			return article;
		}catch(SQLException e	) {
			jdbcUtil.rollback(conn);
			throw new RuntimeException("DB실패"+e.getMessage(),e);
		}finally{
			if(conn != null) {
				try {
					conn.setAutoCommit(true);
				}catch(SQLException e) {
					
				}
			}
			jdbcUtil.close(conn);
		}
	}
	
	private void checkParent(Article parent,int parentId)throws ArticleNotFoundException, CannotReplyArticleException{
		if(parent == null) {
			throw new ArticleNotFoundException("부모글 없음"+parentId);
		}
		
		int parentLevel = parent.getLevel();
		if(parentLevel == 3) {
			throw new CannotReplyArticleException("마지막레벨"+parent.getId());
		}
	}
	
	private String getSearchMinSeqNum(Article parent) {
		String parentSeqNum = parent.getSequenceNumber();
		DecimalFormat decimalFormat = new DecimalFormat("0000000000000000");
		
		long parentSeqLongValue = Long.parseLong(parentSeqNum);
		long searchMinLongValue = 0;
		
		switch(parent.getLevel()) {
		case 0:
			searchMinLongValue = parentSeqLongValue / 1000000L * 1000000L;
			break;
			
		case 1:
			searchMinLongValue = parentSeqLongValue / 10000L * 10000L;
			break;
			
		case 2:
			searchMinLongValue = parentSeqLongValue / 100L * 100L;
			break;

		}
		return decimalFormat.format(searchMinLongValue);
	}
	
	
	private String getSequenceNumber(Article parent, String lastChildSeq)throws LastChildAleadyExistsException{
		
		long parentSeqLong = Long.parseLong(parent.getSequenceNumber());
		int parentLevel = parent.getLevel();
		
		long decUnit = 0;
		
		if(parentLevel == 0) {
			decUnit = 10000L;
		}else if(parentLevel == 1) {
			decUnit = 100L;
		}else if(parentLevel == 2) {
			decUnit = 1L;
		}
		
		String sequenceNumber = null;
		
		DecimalFormat decimalFormat = new DecimalFormat("0000000000000000");
		
		if(lastChildSeq == null) { //답변글없음
			sequenceNumber = decimalFormat.format(parentSeqLong - decUnit);
		}else {//답변글있음
			//마지막 답변글인지 확인
			String orderOfLastChildSeq = null;
			if(parentLevel == 0) {
				orderOfLastChildSeq = lastChildSeq.substring(10,12);
				sequenceNumber = lastChildSeq.substring(0,12)+"9999";
			}else if(parentLevel ==1) {
				orderOfLastChildSeq = lastChildSeq.substring(12,14);
				sequenceNumber = lastChildSeq.substring(0,14)+"99";
			}else if(parentLevel == 2) {
				orderOfLastChildSeq = lastChildSeq.substring(14,16);
				sequenceNumber = lastChildSeq;
			}
			if(orderOfLastChildSeq.equals("00")) {
				throw new LastChildAleadyExistsException("마지막 자식글 존재"+lastChildSeq);
			}
			long seq = Long.parseLong(sequenceNumber) - decUnit;
			sequenceNumber = decimalFormat.format(seq);
		}
		return sequenceNumber;
	}

}
