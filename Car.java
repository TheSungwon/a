package ddddd;

public class Car {
	
	protected int speed;
	protected String name;
	
	Car(){}	
	Car(int Speed, String name){
		this.speed = speed;
		this.name = name;
		
		
	}
	
	public void speedUp() {
		speed++;
	}
	public void speedDown() {
		speed--;
	}
	public void stop() {
		speed=0;
	}
	public void display() {
		System.out.println(name);
		System.out.println(speed);
	}
	

}
