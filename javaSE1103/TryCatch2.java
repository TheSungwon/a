package javaSE1103;

public class TryCatch2 {
	public static void main(String[] args) {
		String a = null;
		String b = null;
		
		
		try {
			a = args[0];
			b = args[1];
			
		} catch(Exception e) { //ArrayIndexOutOfBoundsException e �־ȵɱ�
			System.out.println("�Ű��� ����");
			return;
		}
		
		try {
			int v1 = Integer.parseInt(a);
			int v2 = Integer.parseInt(b);
			int result = v1 + v2;
			System.out.println(result);
		}catch(Exception e) { //NumberFormatException e ���⵵ ?????
			System.out.println("���ں�ȯ");
		}finally {
			System.out.println("�ٽ�");
			
		}
	}

}
