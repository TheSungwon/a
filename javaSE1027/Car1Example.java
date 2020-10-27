package javaSE1027;

public class Car1Example {
	public static void main(String[] args) {
		Car1 a = new Car1();
		a.On();
		
		a.run();
		System.out.println();
		
		System.out.println(a.getSpeed());
		
		System.out.println();
		
		int speed = a.getSpeed();
		System.out.println(speed);
	}

}
