package javaSE1027;

public class PracticeExmaple {
	public static void main(String[] args) {
		Practice a = new Practice();
		
		a.method1();
		
		System.out.println();
		
		a.method2(123);
		
		System.out.println();
		
		a.method3();
		int b = a.method3();
		System.out.println(b+"method3");
		
		System.out.println();
		
		a.method4(50, 500);
		System.out.println();
		
		//a.method5(123); »ý·«
		int c = a.method5(111);
		System.out.println(c);
	}

}
