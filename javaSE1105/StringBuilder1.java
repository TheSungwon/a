package javaSE1105;

public class StringBuilder1 {
	public static void main(String[] args) {
		
		//StringBuffer는 멀티스레드 StringBuilder는 단일 스레드 환경
		
		StringBuilder a = new StringBuilder(); //StringBuilder 객체 생성
		
		
		a.append("AAAAA"); //append() 문자열을 끝에 추가
		a.append("BBBBB");
		System.out.println(a.toString());
		
		
		a.insert(0, "a");
		System.out.println(a); //insert() 0번째문자뒤에 a 삽입
		
		
		a.setCharAt(3, 'ㅁ');
		System.out.println(a); //setCharAt 3번째문자뒤에 ㅁ으로 변경
		
		a.replace(5, 7, "이젠");
		System.out.println(a);	//replacce 번쨰 문자부터 번째문자까지 ~로 대치
		
		a.delete(2,5);
		System.out.println(a); //2~4 삭제
		
		int b = a.length();
		System.out.println(b); //총문자수
		
		String c = a.toString();
		System.out.println(c); //버퍼에 있는 것을 String타입으로 리턴
		
	}

}
