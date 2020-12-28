//게시글을 수정할 때에 게시글을 등록할 때 사용한 암호를 입력하도록 되어 있는데
//UpdateRequest클래스는 이때 입력한 암호를 저장해서 UpdateRequestService가 올바른 암호를
//입력했는지 확인할 수 있도록 했다.

package DTO_javaBean;

public class UpdateRequest {
	
	private int articleId;
	private String title;
	private String content;
	private String password;
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
