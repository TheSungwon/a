package javaSE1021;

public class stringEqualsExample {
	public static void main(String[] args) {
		String a = "a";
		String b = "a";
		
		if(a == b) {
			System.out.println("1참조가 같음");
		} else {
			System.out.println("2참조가 다름");
			}
		
		if(a.contentEquals(b)) {
			System.out.println("3문자열이 같음");
		}
		String c = new String("C");
		String d = new String("C");
		
		if(c == d) {
			System.out.println("4참조가 같음");
			
		}else {
			System.out.println("6참조가 다름");
		}
		if(c.contentEquals(d)) {
			System.out.println("7문자열이 같음");
		}
		
		}

}
