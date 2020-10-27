package javaSE1027;

public class Gas {
	
	//Field
	
	int gas;
	
	//Constructor
	
	//X
	
	//Method
	
	void setGas(int gas) {
		this.gas = gas;		//리턴값이없는 메소드로 매개값을 받아서 gas 필드값을 변경
	}
	
	boolean isLeftGas() {
		if(gas == 0) {
			System.out.println("없음");
			return false; //false를 리턴
		}
		System.out.println("있음");
		return true; 	//true를 리턴			리턴값이 boolean인 메소드로 gas필드값이 0이면 false, 아니면 true를 리턴
	}
	
	void run() {
		while(true) {
			if(gas > 0) {System.out.println("잔량gas"+gas);
			gas --; //gas -= 1;
			}else {
				System.out.println("멈춤"+"잔량gas"+gas);
				return; //메소드 실행 종료
			}
		}
	}

}
