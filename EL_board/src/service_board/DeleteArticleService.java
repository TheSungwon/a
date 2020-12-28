/*이 클래스는 앞서 작성했던 ArticleCheckHelper클래스를 이용해서 게시글 존재 여부와
암호 일치 여부를 확인하고, 암호가 일치하면 ArticleDao.delete 를 이용해서 게시글을 삭제*/

package service_board;

import java.sql.Connection;
import java.sql.SQLException;

import DAO_bean.ArticleDao;
import DTO_javaBean.DeleteRequest;
import DTO_javaBean.jdbcUtil;
import Exception_board.ArticleNotFoundException;
import Exception_board.InvalidPasswordException;
import DTO_javaBean.ArticleCheckHelper;
import DTO_javaBean.ConnectionProvider;

public class DeleteArticleService {
	
	private static DeleteArticleService instance = new DeleteArticleService();
	public static DeleteArticleService getInstance() {
		return instance;
	}
	private DeleteArticleService() {}
	////////////////////////////////
	
	public void deleteArticle(DeleteRequest deleteRequest)throws ArticleNotFoundException,
	InvalidPasswordException{
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			ArticleCheckHelper checkHelper = new ArticleCheckHelper();
			checkHelper.checkExistsAndPassword(conn, deleteRequest.getArticleId(), deleteRequest.getPassword());
			//삭제할 게시글이 존재하는지의 여부와 암호가 일치하는지 확인
			
			ArticleDao articleDao = ArticleDao.getInstance();
			articleDao.delete(conn, deleteRequest.getArticleId());
			//게시글 데이터를 DB에서 삭제
			
			conn.commit();
		}catch(SQLException e) {
			jdbcUtil.rollback(conn);
			throw new RuntimeException();
		}catch(ArticleNotFoundException e) {
			jdbcUtil.rollback(conn);
			throw e;
		}catch(InvalidPasswordException e) {
			jdbcUtil.rollback(conn);
			throw e;
		}finally {
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
