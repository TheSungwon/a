package javaSE1102;

public class InnerA {
	
	InnerA() {System.out.println("A객체생성");} //생성자?
	
	
	
	//인스턴스멤버 클래스
	
	class InnerB{
		InnerB(){System.out.println("B객체생성");} //생성자
		int field1;
		void method1() {}
		
		//static int field2;				static사용할수없음 A 안에 있지않기때문
		//static void method2(){}
		
	}
	
	
	//정적멤버 클래스
	
	static class InnerC{
		InnerC(){System.out.println("C객체생성");}
		int field1;
		void method1() {}
		
		static int field2;
		static void method2() {}
		
	}

	
	//로컬 클래스
void method() {
	class InnerD{
		InnerD(){System.out.println("D객체생성");}
		int field1;
		void method1() {}
		
		//static int field2;
		//static void method() {}
		}
	
	InnerD d = new InnerD();
	d.field1 = 123;
	d.method1();
	}
}

