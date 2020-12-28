/*ReplyingRequest는 답변 쓰기 요청 정보를 표현하는 클래스로서 WritingRequest와 마찬가지로
제목, 작성자,이름,암호,내용을 포함하고 있으며 추가로 답변을 등록할 부모 게시글의 ID를포함
WritingRequest클래스를 상속받아 ReplyingRequest클래스 구현*/

package DTO_javaBean;

public class ReplyingRequest extends WritingRequest{
	
	private int parentArticleId;
	
	public int getParentArticleId() {
		return parentArticleId;
	}
	
	public void setParentArticleId(int parentArticleId) {
		this.parentArticleId = parentArticleId;
	}
}
