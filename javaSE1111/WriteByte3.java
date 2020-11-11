package javaSE1111;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteByte3 {
	public static void main(String[] args) throws IOException { // / \\
		
		OutputStream a = new FileOutputStream("C:\\java2\\test.txt");
		
		byte[] data = "ffdff".getBytes();
		a.write(data,1,2);//1번 인덱스부터 2문자 넣기 //fd
		a.flush();
		a.close();
	}

}
