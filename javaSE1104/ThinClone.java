package javaSE1104;

public class ThinClone {

	public static void main(String[] args) {
	//������ü����
		
		Clone ori = new Clone("ȫ�浿",12,true);
		
		//���� ��ü�� ���� �� age ����
		
		Clone a = ori.getClone();
		a.age = 23;
		
		System.out.println("�����ʵ�"+a.age);
		
		System.out.println("����"+ori.age);
	}

}
