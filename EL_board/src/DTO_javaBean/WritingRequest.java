/*사용자의 게시글 쓰기 요청정보를 저장한다.
 * WritingRequest클래스는 글쓰기폼에 입력한 데이터(작성자이름 글암호 제목 내용)를
 * 보관하기 위한 용도로 사용되는 bean 클래스*/

package DTO_javaBean;


public class WritingRequest {
	
	private String writerName;
	private String password;
	private String title;
	private String content; //차례대로 작성자이름 글암호 제목 내용을 저장
	
	
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Article toArticle() {
		Article article = new Article();
		article.setWriterName(writerName);
		article.setPassword(password);
		article.setTitle(title);
		article.setContent(content);
		return article;	//이 메서드는 WritingRequest객체가 보관한 데이터로부터 Article객체를 생성하는데
		//이 메서드는 WriteArticleService클래스에서 ArticleDao에 전달한 Article객체를 생성할때 사용됨
	}

}//요청 정보로부터 Article객체를 생성
