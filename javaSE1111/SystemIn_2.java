package javaSE1111;

import java.io.IOException;
import java.io.InputStream;

public class SystemIn_2 {
	public static void main(String[] args) throws IOException {
		
		InputStream is = System.in;
		
		byte[] data = new byte[100];
			
		System.out.print("name: ");
		int nameByte = is.read(data);
		String name = new String(data,0,nameByte-2); // ���� -2����Ʈ�� ����Ű�� �ش��ϴ� ĳ���� ���� �̹Ƿ� ���ڿ����� ���ܽ�Ŵ
		
		
		
		
		System.out.print("say something");
		int sayByte = is.read(data); //���ܹ߻�
		String say = new String(data,0,sayByte-2);
		
		
		System.out.println("�Է����̸�"+name);
		System.out.println("�ϰ������"+say);
	}

}
