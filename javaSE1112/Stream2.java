package javaSE1112;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Stream2 {
	//FileOutputStream을 Writer로 변환해서 문자열을 파일에 저장하는 예제
	public static void main(String[] args) throws Exception{
		
		
		FileOutputStream f = new FileOutputStream("C:\\Java2\\file.txt");
		
		Writer wr = new OutputStreamWriter(f);
		
		String data = "바이트 스트림을 문자 스트림 변환";
		wr.write(data);
		
		wr.flush();
		wr.close();
		System.out.println("저장");
		
	}

}
