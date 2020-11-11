package javaSE1111;

import java.io.FileWriter;
import java.io.Writer;

public class Writer2 {
	public static void main(String[] args) throws Exception{
		Writer a = new FileWriter("C:\\java2\\test.txt");
		
		String data = "けいしかいしかいぉし";
		
		a.write(data,1,5);
		//a.write(data);
		
		a.flush();
		a.close();
		
		
	}

}
