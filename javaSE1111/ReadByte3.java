package javaSE1111;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadByte3 {
	public static void main(String[] args) throws IOException {
		InputStream a = new FileInputStream("C:\\java2\\test.txt");
		
		int read;
		byte[] readByte = new byte[10]; //배열 3칸을 줌
		read = a.read(readByte,2,3); //IOE예외발생
		for(int i=0; i<readByte.length; i++) {
			System.out.println(readByte[i]);//((char)readByte[i])로 char문자변환 가능
		} //2번째 배열부터 3개 읽어오기
		a.close();
	}

}
