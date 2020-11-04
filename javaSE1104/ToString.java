package javaSE1104;

import java.util.Date;

public class ToString {

	public static void main(String[] args) {
		Object o1 = new Object();
		Date o2 = new Date();
		
		System.out.println(o1);
		System.out.println(o1.toString());
		System.out.println(o2);
		System.out.println(o2.toString());
		//java.util 패키지의 date클래스는 tostring()메소드를 재정의 해서 date 리턴

	}

}
