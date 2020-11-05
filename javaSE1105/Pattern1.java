package javaSE1105;

import java.util.regex.Pattern;/////


public class Pattern1 {

	public static void main(String[] args) {
	//정규표현식으로 문자열을 검증하는 방법 java.util.regex.Pattern 클래스의 정적메소드인 matches()가 제공
	//boolean result = Pattern.matches("정규식", "검증할 문자열");
		String a = "(02|010)-\\d{3,4}-\\d{4}"; //폰 번호 정규표현식
		String b = "010-111-1111";
		boolean c = Pattern.matches(a, b);
		if(c) {
			System.out.println("일치");
		}else {
			System.out.println("불일치");
		}
		
		a = "\\w-+@\\w+\\, \\w+(\\ \\w+)?"; // ""안에 있기때문에 \\w , \\d 사용가능 \\두번 .. 이메일정규식
		b = "angel@navercom"; //.com
		c = Pattern.matches(a, b);
		if(c) {
			System.out.println("일치");
		}else {
			System.out.println("불일치");//naver.com
		}
	}

}
