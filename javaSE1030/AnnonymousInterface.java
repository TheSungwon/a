package javaSE1030;

public class AnnonymousInterface {
	public static void main(String[] args) {
		Interface1 a = new Interface1() {
			public void on() {/*���๮*/}
			public void off() {/*���๮*/}
			public void set(int volume) {/*���๮*/}
		}; //�ۼ��� �������� �ϳ��� ���๮�̹Ƿ� ������ ; �ݵ�� �ٿ����Ѵ�
	}		//�͸� ���� ��ü
			//�������̽� ���� = new �������̽�(){��ü �żҵ� ����};

}
