//���ο� ��Ʈ�Խñ��� ������ִ� ����� ����
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
		
		int groupId = IdGenerator.getInstance().generateNextId("article"); //���ο� �׷��ȣ����
		
		Article article = writingRequest.toArticle(); //WritingRequest�κ��� Article��ü����
		
		article.setGroupId(groupId);
		article.setPostingDate(new Date());
		DecimalFormat decimalFormat = new DecimalFormat("0000000000");
		article.setSequenceNumber(decimalFormat.format(groupId) + "999999"); //��Ʈ�Խñۿ� �ش��ϴ� 16�ڸ�������ȣ����
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			int articleId = ArticleDao.getInstance().insert(conn, article); //������������
			if(articleId == -1) { //���Ե� �Խñ��� ��������������� ���ܹ߻�
				jdbcUtil.rollback(conn);
				throw new RuntimeException("db���Ծȵ�"+articleId);
			}
			conn.commit();
			
			article.setId(articleId); //���Ե� �Խñ��� Ű ����
			return article;			//Article��ü�� ������ �� Article��ü�� ����
			
		}catch(SQLException e) {
			jdbcUtil.rollback(conn);
			throw new RuntimeException("DB����" + e.getLocalizedMessage(),e);
			
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
