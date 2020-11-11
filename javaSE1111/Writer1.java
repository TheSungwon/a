package javaSE1111;

import java.io.FileWriter;
import java.io.Writer;

public class Writer1 {
	public static void main(String[] args) throws Exception{
		Writer a = new FileWriter("C:\\java2\\test.txt");
		
		char[] data = "asdfafd".toCharArray()
				;
		for(int i=0; i<data.length; i++) {
			a.write(data[i]);
		}
		a.flush();
		a.close();

	}

}
/* for문을 사용하지 않고
a.write(data); 을 사용해도 됨

char[] 배열을 생성하지 않고
String data = "asdfasdf";
을 이요해도 됨
*/