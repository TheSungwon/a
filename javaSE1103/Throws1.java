package javaSE1103;

public class Throws1 {
	public static void main(String[] args) {
	
		try {
			a();
		} catch(ClassNotFoundException e) {
			System.out.println("존재하지않습니다");
		}
	}
	
	
	
	
	public static void a() throws ClassNotFoundException{
		Class b = Class.forName("java.lang.String2");
	}

}
/*자바api도큐먼트에서 forName()메소드를 보면 메소드 선언부뒤에 throws ClassNotFoundException 이 붙어있다
forname 메소드를 호출할때 try catch 블록으로 예외처리하거나 throws로 예외를 떠넘겨야 한다

여기에서 a()메소드는 예외를 떠넘겼고 a()를 호출하는 main()메소드에서 try catch 블록으로 예외처리 했다.*/