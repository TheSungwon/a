package javaSE1112;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Stream1 {
//보조스트림이란 다른 스트림과 연결되어 여러가지 편리한 기능을 제공해준다. \\필터스트림이라고도함
	//보조스트림을 생성할 때에는 자신이 연결된 스트림을 생성자의 매개값으로 받는다.
	
//보조스트림   변수  =  new   보조스트림(연결스트림)
	//ㅇㅖ를 들어 콘솔입력스트림을  문자변환보조스트림인 InputStreamReader에 연결하는 코드는,
	//InputStream is = System.in;
	//InputStreamReader a = new InputStreamReader(is);
	
	//보조스트림은 다른 보조스트림과 연결해 스트림체인구성 가능
	
	//예를 들어 문자변환보조스트림인 InputStreamReader를 다시 성능향상 보조스트림인 BufferedReader에 연결하는 코드는,
	//InputStream is = System.in;
	//InputStreamReader a = new InputStreamReader(is);
	//BufferedReader b = new BufferedReader(a);
	
	
	
	public static void main(String[] args) throws Exception{
		InputStream is = System.in;
		
		
		Reader reader = new InputStreamReader(is);
		
		int No;
		
		char[] cb = new char[100];
		
		while(    (No = reader.read(cb))   !=   -1) {
			//System.out.println(cb);
			String data = new String(cb,0,No);
			System.out.println(data);
		}
		reader.close();
	}
}
