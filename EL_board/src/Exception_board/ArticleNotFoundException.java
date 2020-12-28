package Exception_board;

//ReadArticleService 클래스나 UpdateArticleService클래스 등에서 게시글이 존재하지 않을경우 발생
public class ArticleNotFoundException  extends Exception{
	
	public ArticleNotFoundException(String msg) {
		super(msg);
	}

}
