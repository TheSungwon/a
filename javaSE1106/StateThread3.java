package javaSE1106;

public class StateThread3 {

	public static void main(String[] args) {
		//a�� ��ü�� �����Ǹ� NEW���¸� ������ run()�޼ҵ尡 ����Ǹ� TERMINATED���°� �ȴ�
		
		StateThread A = new StateThread(new StateThread2()); //StateThread�� �����ؼ� �Ű������� ���޹��� StateThread2��  ���¸� ���
		A.start();

	}

}
