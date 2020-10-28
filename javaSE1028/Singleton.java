package javaSE1028;

public class Singleton {
	
	//정적필드..?
	private static Singleton a = new Singleton();
	
	//생성자
	private Singleton() {
		
	}
	
	//정적 메소드
	static Singleton get() {
		return a; //외부에서 객체를 얻는 유일한 방법 get호출
	}
}
