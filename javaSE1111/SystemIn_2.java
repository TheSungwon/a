package javaSE1111;

import java.io.IOException;
import java.io.InputStream;

public class SystemIn_2 {
	public static void main(String[] args) throws IOException {
		
		InputStream is = System.in;
		
		byte[] data = new byte[100];
			
		System.out.print("name: ");
		int nameByte = is.read(data);
		String name = new String(data,0,nameByte-2); // 끝에 -2바이트는 엔터키에 해당하는 캐리지 리턴 이므로 문자열에서 제외시킴
		
		
		
		
		System.out.print("say something");
		int sayByte = is.read(data); //예외발생
		String say = new String(data,0,sayByte-2);
		
		
		System.out.println("입력한이름"+name);
		System.out.println("하고싶은말"+say);
	}

}
