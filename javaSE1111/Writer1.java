package javaSE1111;

import java.io.FileWriter;
import java.io.Writer;

public class Writer1 {
	public static void main(String[] args) throws Exception{
		Writer a = new FileWriter("C:\\java2\\test.txt");
		
		char[] data = "asdfafd".toCharArray()
				;
		for(int i=0; i<data.length; i++) {
			a.write(data[i]);
		}
		a.flush();
		a.close();

	}

}
/* for���� ������� �ʰ�
a.write(data); �� ����ص� ��

char[] �迭�� �������� �ʰ�
String data = "asdfasdf";
�� �̿��ص� ��
*/