package javaSE1111;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadByte1 {
	public static void main(String[] args) throws Exception{
		
	
	InputStream a = new FileInputStream("C:\\java2\\test.txt");
	
	int read;
	
	
	
	
	//////////////////////////
	while((read = a.read()) != 1) {
		if(read == -1)break;
		System.out.println((char)read);
	/////////////////////////
		
		/*
		 * while(true){
		 * read = a.read();
		 * if(read == -1) break;
		 * System.out.println((char)read);
		 * 
		 */
	
	
	
	}
	
	a.close();
	}
}
