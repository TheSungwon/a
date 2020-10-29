package javaSE1029;

public class Plane3 {
	public static void main(String[] args) {
		
		Plane2 a = new Plane2();
		
		a.takeOff();
		a.fly();
		a.flyMode = Plane2.SUPERSONIC;
		a.fly();
		a.land();
		
	}

}
