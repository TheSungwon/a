package javaSE1111;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteByte2 {
	public static void main(String[] args) throws Exception {
		OutputStream a = new FileOutputStream("C:\\java2\\test.txt");
		
		byte[] data = "ffffff".getBytes();
		a.write(data);
		
		a.flush();
		a.close();
	}

}
