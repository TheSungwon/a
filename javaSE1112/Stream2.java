package javaSE1112;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Stream2 {
	//FileOutputStream�� Writer�� ��ȯ�ؼ� ���ڿ��� ���Ͽ� �����ϴ� ����
	public static void main(String[] args) throws Exception{
		
		
		FileOutputStream f = new FileOutputStream("C:\\Java2\\file.txt");
		
		Writer wr = new OutputStreamWriter(f);
		
		String data = "����Ʈ ��Ʈ���� ���� ��Ʈ�� ��ȯ";
		wr.write(data);
		
		wr.flush();
		wr.close();
		System.out.println("����");
		
	}

}
