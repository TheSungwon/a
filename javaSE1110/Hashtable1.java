package javaSE1110;

import java.util.*;

public class Hashtable1 {
	//HashMap과 동일한 내부 구조. 차이점은 synchronized(동기화된) 메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 실행할 수 없고
	//하나의 스레드가 실행을 완료해야만 다른 스레드를 실행할 수 있다. 멀티 스레드 환경에서 안전하게 객체를 추가, 삭제 가능
	//이것을 스레드가 안전하다라고 한다. thread safe.
	
	Map<String, String> map = new Hashtable<>();


}
