/*ReplyArticleService 클래스의 reply() 메서드는 레벨3인 글에 답변글을 등록하려고 할 때 이 예외발생*/

package Exception_board;

public class CannotReplyArticleException extends Exception{
	
	public CannotReplyArticleException(String message) {
		super(message);
	}

}
