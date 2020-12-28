/*�� Ŭ������ �Խñ� ��ȸȭ���� �����ֱ� ���� ���Ǵ� readArticle()�޼���� �Խñۼ��� ȭ�鿡��
				  �Խñ� ������ �����ֱ� ���� ���Ǵ� getArticle()�޼��带 ����*/

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
		return selectArticle(articleId, true); //�Խñ��� ��ȸ�ϰ� ��ȸ���� ���������ִ� �޼���
	}	  									   //���������� selectArticleȣ��
	//�� �� selectArticle()�� �ι�° �Ķ������ increaseCount�� ������ true�� ���������ν�
	//��ȸ���� ������Ų��.
	
	
	private Article selectArticle(int articleId, boolean increaseCount)throws ArticleNotFoundException{
		Connection conn = null;				//���� �Խñ� ��ȸ ����� ������ �޼���
		
		try {
			conn = ConnectionProvider.getConnection();
			ArticleDao articleDao = ArticleDao.getInstance();
			Article article = articleDao.selectById(conn, articleId);
			//ArticleDao�� �̿��ؼ� ������ID�� Article�� ���Ѵ�
			
			if(article == null) {
				throw new ArticleNotFoundException("�Խñ۾���"+articleId);
				//Article�� �������� ������� ���ܹ߻�
			}
			if(increaseCount) {		
				articleDao.increaseReadCount(conn, articleId);
				article.setReadCount(article.getReadCount() + 1);
			}
			return article;
			//increaseCount�� true�� ��� ��ȸ���� ������Ų��
			//ȭ�鿡 ������ ��ȸ���� 1 ������Ų��.
			
			
		}catch(SQLException e) {
			throw new RuntimeException("DB����"+e.getMessage(),e);
		}finally {
			jdbcUtil.close(conn);
		}
		
	}
	
		public Article getArticle(int articleId)throws ArticleNotFoundException{
			
			return selectArticle(articleId,false);
		}	//�Խñ۸� ��ȸ�ϰ� ��ȸ���� ������������ �ʴ� �޼���
			//�� �޼��带 �����ϴ� ������ ����ȭ�鿡�� �����Խñ� ������ �����־���ϱ� ����
			//�Խñ� ����ȭ���� �����ֱ� ���� Article��ü�� �о��µ� ��ȸ���� �����Ǹ�
			//�������� �̻��ϹǷ� getArticle()�޼���� selectArticle()�޼��带 ȣ�� �� ��
		// �� ��° �Ķ���� ������ false�� �༭ ��ȸ���� �������� �ʵ��� �Ѵ�.

}
