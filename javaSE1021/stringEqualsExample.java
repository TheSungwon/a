package javaSE1021;

public class stringEqualsExample {
	public static void main(String[] args) {
		String a = "a";
		String b = "a";
		
		if(a == b) {
			System.out.println("1������ ����");
		} else {
			System.out.println("2������ �ٸ�");
			}
		
		if(a.contentEquals(b)) {
			System.out.println("3���ڿ��� ����");
		}
		String c = new String("C");
		String d = new String("C");
		
		if(c == d) {
			System.out.println("4������ ����");
			
		}else {
			System.out.println("6������ �ٸ�");
		}
		if(c.contentEquals(d)) {
			System.out.println("7���ڿ��� ����");
		}
		
		}

}
