/*답변 글을 99개 등록해서 더 이상 답변 글 등록할 수 없는 경우 예외발생*/

package Exception_board;

public class LastChildAleadyExistsException extends Exception{
	
	public LastChildAleadyExistsException(String message) {
		super(message);
	}

}
