package javaSE1111;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadByte3 {
	public static void main(String[] args) throws IOException {
		InputStream a = new FileInputStream("C:\\java2\\test.txt");
		
		int read;
		byte[] readByte = new byte[10]; //�迭 3ĭ�� ��
		read = a.read(readByte,2,3); //IOE���ܹ߻�
		for(int i=0; i<readByte.length; i++) {
			System.out.println(readByte[i]);//((char)readByte[i])�� char���ں�ȯ ����
		} //2��° �迭���� 3�� �о����
		a.close();
	}

}
