/*�� Ŭ������ �ռ� �ۼ��ߴ� ArticleCheckHelperŬ������ �̿��ؼ� �Խñ� ���� ���ο�
��ȣ ��ġ ���θ� Ȯ���ϰ�, ��ȣ�� ��ġ�ϸ� ArticleDao.delete �� �̿��ؼ� �Խñ��� ����*/

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
			//������ �Խñ��� �����ϴ����� ���ο� ��ȣ�� ��ġ�ϴ��� Ȯ��
			
			ArticleDao articleDao = ArticleDao.getInstance();
			articleDao.delete(conn, deleteRequest.getArticleId());
			//�Խñ� �����͸� DB���� ����
			
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
