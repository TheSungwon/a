package javaSE1026;

public class overloadingExample {
	public static void main(String[] args) {
		overloading a = new overloading(); //������ ����
		System.out.println(a.company);
		System.err.println();
		System.err.println();
		//		System.err.println(); ??
		
		overloading a2 = new overloading("��"); //������2 ����
		System.out.println(a2.company);
		System.out.println(a2.model);
		System.out.println(a2.color);
		
		System.err.println();
		
		overloading a3 = new overloading("��","aa");
		System.out.println(a3.company);
		System.out.println(a3.model);
		System.out.println(a3.color);
		System.out.println(a3.speed);

		System.err.println();
		
		overloading a4 = new overloading("d","ff",234);
		System.out.println(a4.model);
		System.out.println(a4.color);
		System.out.println(a4.speed);
		
		
	}

}
