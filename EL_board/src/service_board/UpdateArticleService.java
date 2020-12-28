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
			//�Խñ� ���翩�ο� ��ȣ�� ��ġ�ϴ� ���� Ȯ��
			
			Article updateArticle = new Article();
			updateArticle.setId(updateRequest.getArticleId());
			updateArticle.setTitle(updateRequest.getTitle());
			updateArticle.setContent(updateRequest.getContent());
			//updateRequest�κ��� Article����
			
			ArticleDao articleDao = ArticleDao.getInstance();
			int updateCount = articleDao.update(conn, updateArticle); //DB Update����
			if(updateCount == 0) {
				throw new ArticleNotFoundException("�Խñ۾��� udpate"+updateRequest.getArticleId());
			}
			
			Article article = articleDao.selectById(conn, updateRequest.getArticleId());
			//������ Article��ü ����
			
			conn.commit();
			
			return article;
			
		}catch(SQLException e) {
			jdbcUtil.rollback(conn);
			throw new RuntimeException("db���� update"+e.getMessage(),e);
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
