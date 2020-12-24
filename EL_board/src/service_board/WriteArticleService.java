//새로운 루트게시글을 등록해주는 기능을 제공
package service_board;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;

import DAO_bean.ArticleDao;
import DTO_javaBean.Article;
import DTO_javaBean.WritingRequest;
import DTO_javaBean.jdbcUtil;
import Exception_board.IdGenerationFailedException;
import DTO_javaBean.ConnectionProvider;


public class WriteArticleService {
	private static WriteArticleService instance = new WriteArticleService();
	public static WriteArticleService getInstance() {
		return instance;
	}
	private WriteArticleService() {}
	///////////////////////////////////////
	
	public Article write(WritingRequest writingRequest) throws IdGenerationFailedException{
		
		int groupId = IdGenerator.getInstance().generateNextId("article"); //새로운 그룹번호생성
		
		Article article = writingRequest.toArticle(); //WritingRequest로부터 Article객체구함
		
		article.setGroupId(groupId);
		article.setPostingDate(new Date());
		DecimalFormat decimalFormat = new DecimalFormat("0000000000");
		article.setSequenceNumber(decimalFormat.format(groupId) + "999999"); //루트게시글에 해당하는 16자리순서번호생성
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			int articleId = ArticleDao.getInstance().insert(conn, article); //삽입쿼리실행
			if(articleId == -1) { //삽입된 게시글이 존재하지않을경우 예외발생
				jdbcUtil.rollback(conn);
				throw new RuntimeException("db삽입안됨"+articleId);
			}
			conn.commit();
			
			article.setId(articleId); //삽입된 게시글의 키 값을
			return article;			//Article객체에 저장한 뒤 Article객체를 리턴
			
		}catch(SQLException e) {
			jdbcUtil.rollback(conn);
			throw new RuntimeException("DB에러" + e.getLocalizedMessage(),e);
			
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

}
