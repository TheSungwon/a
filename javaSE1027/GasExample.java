package javaSE1027;

public class GasExample {
	public static void main(String[] args) {
		
		Gas a = new Gas();
		///////////////
		a.setGas(6); //Gas�� setGas() �޼ҵ� ȣ��
		////////////
	
		////////////////
		boolean gasState = a.isLeftGas(); // Gas�� isLeftGas() �޼ҵ��� ȣ��
	////////////////
		
		if(gasState) {
			System.out.println("���");
		
			
			/////////
			a.run(); //Gas �� run()�޼ҵ� ȣ��
		////////////////
		if(a.isLeftGas()) {	//Gas�� isLeftGas() �޼ҵ� ȣ��
		/////////////////
			System.out.println("�������ʿ����");
		}else {
			System.out.println("�����ϼ���[");
		}
			
		}
	}

}
