package service_board;

import java.sql.Connection;
import java.sql.SQLException;

import DAO_bean.ArticleDao;
import DTO_javaBean.Article;
import DTO_javaBean.ArticleCheckHelper;
import DTO_javaBean.UpdateRequest;
import DTO_javaBean.jdbcUtil;
import Exception_board.ArticleNotFoundException;
import Exception_board.InvalidPasswordException;
import DTO_javaBean.ConnectionProvider;


public class UpdateArticleService {
	
	private static UpdateArticleService instance = new UpdateArticleService();
	public static UpdateArticleService getInstance() {
		return instance;
	}
	private UpdateArticleService() {}
	///////////////////////////////////////////
	
	public Article update(UpdateRequest updateRequest)throws ArticleNotFoundException,InvalidPasswordException{
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			ArticleCheckHelper checkHelper = new ArticleCheckHelper();
			checkHelper.checkExistsAndPassword(conn, updateRequest.getArticleId(), updateRequest.getPassword());
			//게시글 존재여부와 암호가 일치하는 여부 확인
			
			Article updateArticle = new Article();
			updateArticle.setId(updateRequest.getArticleId());
			updateArticle.setTitle(updateRequest.getTitle());
			updateArticle.setContent(updateRequest.getContent());
			//updateRequest로부터 Article생성
			
			ArticleDao articleDao = ArticleDao.getInstance();
			int updateCount = articleDao.update(conn, updateArticle); //DB Update실행
			if(updateCount == 0) {
				throw new ArticleNotFoundException("게시글없음 udpate"+updateRequest.getArticleId());
			}
			
			Article article = articleDao.selectById(conn, updateRequest.getArticleId());
			//수정된 Article객체 구함
			
			conn.commit();
			
			return article;
			
		}catch(SQLException e) {
			jdbcUtil.rollback(conn);
			throw new RuntimeException("db에러 update"+e.getMessage(),e);
		}catch(ArticleNotFoundException e) {
			jdbcUtil.rollback(conn);
			throw e;
		}catch(InvalidPasswordException e) {
			jdbcUtil.rollback(conn);
			throw e;
		}finally {
			if(conn!=null) {
				try {
					conn.setAutoCommit(true);
				}catch(SQLException e) {
					
				}
				jdbcUtil.close(conn);
			}
		}
	}
	

}
