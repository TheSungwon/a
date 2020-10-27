package javaSE1027;

public class This {

	//Field
	
	String model;
	int speed;
	
	//Constructor
	
	This(String model){
		this.model = model;
		
	}
	
	//Method
	
	void setSpeed(int speed) {
		this.speed = speed;
		
	}
	
	void run() {
		for(int i=0; i<=50; i+=10) {
			this.setSpeed(i);
			System.out.println(this.model+ this.speed);
		}
	}
}
