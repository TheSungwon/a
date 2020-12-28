/*글 삭제 요청 정보를 저장하는 DeleteRequest클래스*/

package DTO_javaBean;

public class DeleteRequest {
	
	private int articleId;
	private String password;
	
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
