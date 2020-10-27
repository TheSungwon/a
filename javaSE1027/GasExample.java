package javaSE1027;

public class GasExample {
	public static void main(String[] args) {
		
		Gas a = new Gas();
		///////////////
		a.setGas(6); //Gas의 setGas() 메소드 호출
		////////////
	
		////////////////
		boolean gasState = a.isLeftGas(); // Gas의 isLeftGas() 메소드의 호출
	////////////////
		
		if(gasState) {
			System.out.println("출발");
		
			
			/////////
			a.run(); //Gas 의 run()메소드 호출
		////////////////
		if(a.isLeftGas()) {	//Gas의 isLeftGas() 메소드 호출
		/////////////////
			System.out.println("주입할필요없음");
		}else {
			System.out.println("주입하세요[");
		}
			
		}
	}

}
