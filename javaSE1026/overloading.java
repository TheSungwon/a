package javaSE1026;

public class overloading {
	//Field
	
	String company = "薄企切疑託";
	String model;
	String color;
	int speed;
	
	
	//持失切
	
	overloading(){}//持失切1
	overloading(String model){
		this.model = model;
	} //持失切2
	overloading(String model, String color){
		this.model = model;
		this.color = color;
	}//持失切3
	overloading(String model, String color, int speed){
		this.model = model;
		this.color = color;
		this.speed = speed;
	}//持失切4
	

}
