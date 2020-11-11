package javaSE1111;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadByte2 {
	public static void main(String[] args) throws Exception{
		InputStream a = new FileInputStream("C:\\java2\\test.txt");
		
		int read;
		
		byte[] bt = new byte[3];
		
		String data = "";
		 
		
		while(true) {
			read = a.read(bt);
			if(read == -1)break;
			data += new String(bt, 0, read);
		}
		System.out.println(data);
		a.close();
	}

}
