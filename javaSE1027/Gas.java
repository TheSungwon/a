package javaSE1027;

public class Gas {
	
	//Field
	
	int gas;
	
	//Constructor
	
	//X
	
	//Method
	
	void setGas(int gas) {
		this.gas = gas;		//���ϰ��̾��� �޼ҵ�� �Ű����� �޾Ƽ� gas �ʵ尪�� ����
	}
	
	boolean isLeftGas() {
		if(gas == 0) {
			System.out.println("����");
			return false; //false�� ����
		}
		System.out.println("����");
		return true; 	//true�� ����			���ϰ��� boolean�� �޼ҵ�� gas�ʵ尪�� 0�̸� false, �ƴϸ� true�� ����
	}
	
	void run() {
		while(true) {
			if(gas > 0) {System.out.println("�ܷ�gas"+gas);
			gas --; //gas -= 1;
			}else {
				System.out.println("����"+"�ܷ�gas"+gas);
				return; //�޼ҵ� ���� ����
			}
		}
	}

}
