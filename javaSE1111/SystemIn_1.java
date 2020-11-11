package javaSE1111;

import java.io.IOException;
import java.io.InputStream;

public class SystemIn_1 {
	public static void main(String[] args) throws IOException {
		System.out.println("menu");
		System.out.println("1.");
		System.out.println("2.");
		System.out.println("3.");
		System.out.println("4.");
		System.out.println("5.");
		System.out.print("select");
		
		InputStream is = System.in; //키보드 입력 스트림 얻기
		//InputStream 의 read()메소드는 1바이트만 읽기 때문에 아스키코드로 된 표현만 읽는다.
		//2바이트는 read(byte[]b) or read(byte[]b, int off, int len) 메소드로 전체 입력된 내용을 바이트 배열로 받는다.
		// 이 배열을 이용해서 String객체를 생성하면 된다.
		
		char inputChar = (char) is.read(); //아스키 코드를 읽고 문자로 리턴 //ㅇㅖ외발생
		
		switch(inputChar) {
		case '1':
		System.out.println("1");
		break;
		
		
		case '2':
		System.out.println("2");
		break;
		///중략
		}
		
	}

}
