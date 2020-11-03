package javaSE1103;

public class NumberFormatException {
	public static void main(String[] args) {
		String a = "100";
		String b = "aaa";
		
		int v1 = Integer.parseInt(a);
		int v2 = Integer.parseInt(b); // NumberFormatException 발생
		
		int result = v1 + v2;
		System.out.println(result);
		
		//문자열로 되어있는 데이터를 숫자로 변경하는 경우 Integer.parseInt , Double.parseDouble 을 사용. wrapper 포장 클래스라고한다
		//문자를 숫자로 변환될수있다면 리턴, 숫자로 변환될 수 없는 문자가 포함되어 있다면 NumberFormatException밢생
		
		
	}

}
