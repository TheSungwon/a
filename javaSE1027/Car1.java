package javaSE1027;

public class Car1 {
	//Field
	
	int speed;
	
	//Constructor
	
	//Method
	
	int getSpeed() {
		return speed;
	}
	
	void On() {
		System.out.println("Ω√¿€");
		
	}
	
	void run() {
		for(int i=0; i<=50; i+=10) {
			speed = i;
			System.out.println(speed);
		}
	}

}
