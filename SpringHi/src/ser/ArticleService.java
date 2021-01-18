package ser;

public class ArticleService {
	
	public void writeArticle(NewArticleCommand command) {
		System.out.println("신규게시글"+command);
	}
	

}
