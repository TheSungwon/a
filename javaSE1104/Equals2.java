package javaSE1104;

public class Equals2 {
	public static void main(String argsp[]) {
		Equals o1 = new Equals("a");
		Equals o2 = new Equals("a");
		Equals o3 = new Equals("b");
		
		if(o1.equals(o2)) {
			System.out.println("����");			
		} else {
			System.out.println("�޶�");
		}//�Ű��� Equals Ÿ���̰� id�ʵ尪 ����
		
		
		if(o1.equals(o3)) {
			System.out.println("����");			
		} else {
			System.out.println("�޶�");
		}//�Ű��� Equals Ÿ�������� id�ʵ尪�� �ٸ�
	}

}
