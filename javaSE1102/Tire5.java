package javaSE1102;

public class Tire5 {
	public static void main(String[] arguemtns) {
		Tire4 a = new Tire4();
		
		a.run();
		
		System.out.println("--------");
		a.a = new Tire3();
		a.b = new Tire3();
		
		a.run();
		
		
	}

}
