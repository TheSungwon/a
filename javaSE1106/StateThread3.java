package javaSE1106;

public class StateThread3 {

	public static void main(String[] args) {
		//a가 객체로 생성되면 NEW상태를 가지고 run()메소드가 종료되면 TERMINATED상태가 된다
		
		StateThread A = new StateThread(new StateThread2()); //StateThread를 생성해서 매개값으로 전달받은 StateThread2의  상태를 출력
		A.start();

	}

}
