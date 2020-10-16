package javaSE1015;

public class CharExample {
	public static void main(String[] args) {
		char c1 = 'A';	//문자를 직접 저장
		char c2 = 65;	//10진수로 저장
		char c3 = '\u0041';		//16진수로 저장
		
		
		char c4 = '가';	//문자를 직접저장
		char c5 = 44032;	//10진수로 저장
		char c6 = '\uac00';		//16진수로 저장
		
		int uniCode = c1;	//유니코드 얻기
		
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		System.out.println(uniCode);
		//char타입 변수는 하나의 문자만 저장
		//문자열을 저장하려면 String 타입 사용
		//String 변수를 선언하고 큰따옴표로 감싼 문자열 리터럴을 대입
		
		//char c = ''; 컴파일 에러
		char c = ' ';
		String str = ""; //공백 char은 빈칸 string은 연달아
		
	}

}
