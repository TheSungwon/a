//게시글 목록 화면 구성하는데 필요한 정보 저장/ 게시글(article)목록, 요청페이지번호, 전체페이지개수 등
package DTO_javaBean;

import java.util.ArrayList;
import java.util.List;

public class ArticleListModel {
	
	private List<Article> articleList; //화면에 보여줄 게시글 목록
	private int requestPage; //사용자가 요청한 페이지번호
	private int totalPageCount; //전체 페이지개수
	private int startRow; //현재게시글목록의 시작행
	private int endRow; //현재게시글목록의 끝행
	
	public ArticleListModel() {
		this(new ArrayList<Article>(),0,0,0,0);
	}
	
	public ArticleListModel(List<Article> articleList, int requestPageNumber, int totalPageCount,
			int startRow, int endRow) {
		this.articleList = articleList;
		this.requestPage = requestPageNumber;
		this.totalPageCount = totalPageCount;
		this.startRow = startRow;
		this.endRow = endRow;
	}
	
	
	public boolean isHasArticle() {
		return !articleList.isEmpty();
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public int getRequestPage() {
		return requestPage;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}

}
