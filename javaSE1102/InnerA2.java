package javaSE1102;

public class InnerA2 {
	public static void main(String[] args) {
		InnerA a = new InnerA();
		
		//인스턴스멤버클래스 객체생성
		
		InnerA.InnerB b = a.new InnerB();
		b.field1 = 123;
		b.method1();
		
		//로컬클래스 객체생성을 위한 메소드 호출
		a.method();
	}

}
