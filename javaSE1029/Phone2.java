package javaSE1029;

public class Phone2 extends Phone1{
	//Field
	
	int channel;
	
	//Constructor
	
	Phone2(String model, String color, int channel){
	
		this.model = model;	//��ӹ����ʵ�
		this.color = color; //��ӹ����ʵ�
		this.channel = channel;
		
	}
	
	//Method

	void turnOn() {
		System.out.println("channel"+channel);
	}
	
	void changeChannel(int channel) {
		System.out.println("change channel"+channel);
	}
	
}
