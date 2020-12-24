//이 클래스는 ArticleDao클래스의 selectCount메서드와 select메서드를 이용해서 사용자가 요청한 페이지에
//해당하는 게시글 목록을 구한뒤 ArticleLsitModel 객체에 목록을 담아서 리턴

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
	
	public static final int COUNT_PER_PAGE=3; //한 페이지에 보여줄 게시글 수
	
	public ArticleListModel getArticleList(int requestPageNumber) {
		if(requestPageNumber<0) {
			throw new IllegalArgumentException("page number < 0 :"+ requestPageNumber);
		}
		
		ArticleDao articleDao = ArticleDao.getInstance();
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			int totalArticleCount = articleDao.selectCount(conn); //전체 게시글 개수 구함
			
			if(totalArticleCount == 0) {
				return new ArticleListModel(); //전체 게시글이 0인경우 기본ArticleListModel객체리턴
			}
			
			int totalPageCount = calculateTotalPageCount(totalArticleCount);
			//calculateTotalPageCount메서드를 호출해서 전체 페이지 개수를 구한다
			
			
			int firstRow = (requestPageNumber -1) * COUNT_PER_PAGE + 1;
			int endRow = firstRow + COUNT_PER_PAGE -1;
			
			if(endRow > totalArticleCount) {
				endRow = totalArticleCount;
			}//요청한 페이지 번호를 이용해서 읽어올 행의 시작 번호와 끝번호를 구한다.
			
			List<Article> articleList = articleDao.select(conn, firstRow, endRow);
			//articleDao.select()메서드를 이용해서 시작행과 끝행에 속하는 Article목록을 구한다
			
			ArticleListModel articleListView = new ArticleListModel(articleList, requestPageNumber,
					totalPageCount, firstRow, endRow);
			
			return articleListView; //Article목록,요청 페이지번호,전체페이지개수,시작행,끝행을 이용해서
			//ArticleListModel객체를 생성한뒤 리턴한다.
					
		}catch(SQLException e) {
			throw new RuntimeException("DB에러"+e.getMessage(),e);
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
		//전체 게시글 개수로부터 전체 페이지 개수를 구해주는 메서드
	}
	
}
