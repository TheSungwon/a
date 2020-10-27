package javaSE1027;

public class ThisExample {
	public static void main(String[] args) {
		
		//This(String model){this.model=model}; 이니까
		This a = new This("이젠");
		This b = new This("자바");
		
		a.run();
		b.run();
		
				
	}

}
