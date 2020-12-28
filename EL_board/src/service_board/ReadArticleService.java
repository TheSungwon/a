/*이 클래스는 게시글 조회화면을 보여주기 위해 사용되는 readArticle()메서드와 게시글수정 화면에서
				  게시글 원문을 보여주기 위해 사용되는 getArticle()메서드를 제공*/

package service_board;

import java.sql.Connection;
import java.sql.SQLException;

import DAO_bean.ArticleDao;
import DTO_javaBean.Article;
import DTO_javaBean.jdbcUtil;
import Exception_board.ArticleNotFoundException;
import DTO_javaBean.ConnectionProvider;

public class ReadArticleService {
	
	private static ReadArticleService instance = new ReadArticleService();
	public static ReadArticleService getInstance() {
		return instance;
	}
	private ReadArticleService() {}
	
	/////////////////////////////////////////////////
	
	public Article readArticle(int articleId)throws ArticleNotFoundException{
		return selectArticle(articleId, true); //게시글을 조회하고 조회수를 증가시켜주는 메서드
	}	  									   //내부적으로 selectArticle호출
	//이 때 selectArticle()의 두번째 파라미터인 increaseCount의 값으로 true를 전달함으로써
	//조회수를 증가시킨다.
	
	
	private Article selectArticle(int articleId, boolean increaseCount)throws ArticleNotFoundException{
		Connection conn = null;				//실제 게시글 조회 기능을 구현한 메서드
		
		try {
			conn = ConnectionProvider.getConnection();
			ArticleDao articleDao = ArticleDao.getInstance();
			Article article = articleDao.selectById(conn, articleId);
			//ArticleDao를 이용해서 지정한ID의 Article을 구한다
			
			if(article == null) {
				throw new ArticleNotFoundException("게시글없음"+articleId);
				//Article이 존재하지 않을경우 예외발생
			}
			if(increaseCount) {		
				articleDao.increaseReadCount(conn, articleId);
				article.setReadCount(article.getReadCount() + 1);
			}
			return article;
			//increaseCount가 true인 경우 조회수를 증가시킨다
			//화면에 보여질 조회수도 1 증가시킨다.
			
			
		}catch(SQLException e) {
			throw new RuntimeException("DB에러"+e.getMessage(),e);
		}finally {
			jdbcUtil.close(conn);
		}
		
	}
	
		public Article getArticle(int articleId)throws ArticleNotFoundException{
			
			return selectArticle(articleId,false);
		}	//게시글만 조회하고 조회수는 증가시켜주지 않는 메서드
			//이 메서드를 제공하는 이유는 수정화면에서 원본게시글 내용을 보여주어야하기 때문
			//게시글 수정화면을 보여주기 위해 Article객체를 읽었는데 조회수가 증가되면
			//논리적으로 이상하므로 getArticle()메서드는 selectArticle()메서드를 호출 할 때
		// 두 번째 파라미터 값으로 false를 줘서 조회수가 증가되지 않도록 한다.

}
