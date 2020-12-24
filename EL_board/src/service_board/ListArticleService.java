//�� Ŭ������ ArticleDaoŬ������ selectCount�޼���� select�޼��带 �̿��ؼ� ����ڰ� ��û�� ��������
//�ش��ϴ� �Խñ� ����� ���ѵ� ArticleLsitModel ��ü�� ����� ��Ƽ� ����

package service_board;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DAO_bean.ArticleDao;
import DTO_javaBean.Article;
import DTO_javaBean.ArticleListModel;
import DTO_javaBean.jdbcUtil;
import DTO_javaBean.ConnectionProvider;

public class ListArticleService {
	private static ListArticleService instance = new ListArticleService();
	public static ListArticleService getInstance() {
		return instance;
	}
////////////////////////
	
	public static final int COUNT_PER_PAGE=3; //�� �������� ������ �Խñ� ��
	
	public ArticleListModel getArticleList(int requestPageNumber) {
		if(requestPageNumber<0) {
			throw new IllegalArgumentException("page number < 0 :"+ requestPageNumber);
		}
		
		ArticleDao articleDao = ArticleDao.getInstance();
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			int totalArticleCount = articleDao.selectCount(conn); //��ü �Խñ� ���� ����
			
			if(totalArticleCount == 0) {
				return new ArticleListModel(); //��ü �Խñ��� 0�ΰ�� �⺻ArticleListModel��ü����
			}
			
			int totalPageCount = calculateTotalPageCount(totalArticleCount);
			//calculateTotalPageCount�޼��带 ȣ���ؼ� ��ü ������ ������ ���Ѵ�
			
			
			int firstRow = (requestPageNumber -1) * COUNT_PER_PAGE + 1;
			int endRow = firstRow + COUNT_PER_PAGE -1;
			
			if(endRow > totalArticleCount) {
				endRow = totalArticleCount;
			}//��û�� ������ ��ȣ�� �̿��ؼ� �о�� ���� ���� ��ȣ�� ����ȣ�� ���Ѵ�.
			
			List<Article> articleList = articleDao.select(conn, firstRow, endRow);
			//articleDao.select()�޼��带 �̿��ؼ� ������� ���࿡ ���ϴ� Article����� ���Ѵ�
			
			ArticleListModel articleListView = new ArticleListModel(articleList, requestPageNumber,
					totalPageCount, firstRow, endRow);
			
			return articleListView; //Article���,��û ��������ȣ,��ü����������,������,������ �̿��ؼ�
			//ArticleListModel��ü�� �����ѵ� �����Ѵ�.
					
		}catch(SQLException e) {
			throw new RuntimeException("DB����"+e.getMessage(),e);
		}finally {
			jdbcUtil.close(conn);
		}
	}
	
	///////////
	
	private int calculateTotalPageCount(int totalArticleCount) {
		if(totalArticleCount == 0) {
			return 0;
		}
		int pageCount = totalArticleCount / COUNT_PER_PAGE;
		if(totalArticleCount % COUNT_PER_PAGE > 0) {
			pageCount++;
		}
		return pageCount;
		//��ü �Խñ� �����κ��� ��ü ������ ������ �����ִ� �޼���
	}
	
}
