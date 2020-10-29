package javaSE1029;

public class Overriding3 {
	public static void main(String[] args) {
		int r = 1;
		
		Overriding1 a = new Overriding1();
		System.out.println(a.circle(r));
		
		Overriding2 b = new Overriding2();
		System.out.println(b.circle(r));
	}

}
