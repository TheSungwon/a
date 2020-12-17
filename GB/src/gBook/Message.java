package gBook;


//테이블에서 읽어온 값을 저장하거나 사용자가 입력한 값을 DAO에 전달할때 사용하는 클래스
public class Message {
	private int id;
	private String guestName;
	private String password;
	private String message;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean hasPassword() { //deleteMessageService클래스에서 삭제기능을 구현할때사용
		return password != null && !password.isEmpty();
	}

}
