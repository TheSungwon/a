package javaSE1026;

public class overloading {
	//Field
	
	String company = "�����ڵ���";
	String model;
	String color;
	int speed;
	
	
	//������
	
	overloading(){}//������1
	overloading(String model){
		this.model = model;
	} //������2
	overloading(String model, String color){
		this.model = model;
		this.color = color;
	}//������3
	overloading(String model, String color, int speed){
		this.model = model;
		this.color = color;
		this.speed = speed;
	}//������4
	

}
