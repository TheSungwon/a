package javaSE1104;

import java.util.HashMap;

public class Hashcode2 {
	public static void main(String args[]) {		
		HashMap<Hashcode, String> hashMap = new HashMap<Hashcode, String>();
		
		hashMap.put(new Hashcode(1), "홍길동");
		
		String v = hashMap.get(new Hashcode(1));
		System.out.println(v);	
		
	}

}
/* HashMap의 식별키로 Hashcode객체를 사용하면 저장된 값을 찾아오지못함 왜냐하면 num의 필드값이 같더라도 hashcode()메소드에서 리턴하는
해시코드가 다르기 때문에 다른 식별키로 인식. new Hashcode(1) 객체에 홍길동을 저장하고 다시 객체에 저장된 홍길동을 읽을려고 했지만 null
Hashcode에 hashcode메소드 재정의 추가 하면 홍길동 출력*/