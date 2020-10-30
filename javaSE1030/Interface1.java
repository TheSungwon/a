package javaSE1030;

public interface Interface1 {
	
	//상수필드선언 . 인터페이스는 데이터를 저장할 수 없기 때문에 데이터를 저장할 인스턴스, 정적 필드를 선언할 수 없다. 대신 상수 필드만 선언할 수 있다.
	// 상수는 public static final로 선언. 인터페이스에 선언된 필드는 모두 이 특성을 갖는다. 생략하더라도 자동적으로 컴파일 과정에서 붙는다.
	
	int MAX_V = 10;	//public static final 생략
	int MIN_V = 0;	//인터페이스 상수는 static{}블록으로 초기화할 수 없다. 선언과 동시에 초기값 지정.
	
	//추상메소드. 인터페이스를 통해 호출된 메소드는 최종적으로 객체에서 실행. 인터페이스의 메소드는 실행 블록이 필요 없는 추상메소드로 선언
	//리턴타입. 메소드명. 매개변수.만 {}붙이지 않는다. public abstract 특성을 갖기 때문에 생략하더라도 자동적으로 컴파일 과정에서 붙는다.
	
	//추상메소드
	
	void on();
	void off();
	void set(int volume);
	
	//디폴트 메소드
	//디폴트 메소드 선언 .자바 8에서 추가된 새로운 멤버. 클래스의 인스턴스 메소드와 동일. public 특성을 갖는다 생략해도 붙는다
	default void mute(boolean m) {
		if(m) {
			System.out.println("무음");
		}else {
			System.out.println("무음해제");
		}
	}
	
	//정적 메소드
	//정적 메소드 선언. 자바 8에서 추가. 클래스의 정적 메소드와 동일. 생략해도 붙는다.
	static void change() {
		System.out.println("교환");
	
	}
}
