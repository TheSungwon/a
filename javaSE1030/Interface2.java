package javaSE1030;

public class Interface2 implements Interface1{

	
	//Ŭ���� ����ο� implements Ű���� �߰� . �������̽� �������� ����� �� ������ �˷��ֱ� ����. ����Ŭ����
	//�������̽��� ���𵵴� �߻� �޼ҵ��� ��ü �޼ҵ� ����
	//Interface2�� Add unimplemented methods �ڵ� ����
	
	
	
	//Field
	private int volume;
	
	
	@Override
	public void on() {
		System.out.println("On");
		
	}

	@Override
	public void off() {
		System.out.println("Off");
		
	}

	
	
	//�߻� �޼ҵ��� ��ü �޼ҵ�
	//�������̽��� ����� �̿��ؼ� volume�ʵ��� ���� ����
	@Override
	public void set(int volume) {
	if(volume > Interface1.MAX_V) {
		this.volume = Interface1.MAX_V;
	} else if ( volume < Interface1.MIN_V){ 
		this.volume = Interface1.MIN_V;
	} else {
		this.volume = volume;
	}
	System.out.println("����volume  "+this.volume);
	

}
}