package javaSE1112;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Stream1 {
//������Ʈ���̶� �ٸ� ��Ʈ���� ����Ǿ� �������� ���� ����� �������ش�. \\���ͽ�Ʈ���̶����
	//������Ʈ���� ������ ������ �ڽ��� ����� ��Ʈ���� �������� �Ű������� �޴´�.
	
//������Ʈ��   ����  =  new   ������Ʈ��(���ὺƮ��)
	//���Ƹ� ��� �ܼ��Է½�Ʈ����  ���ں�ȯ������Ʈ���� InputStreamReader�� �����ϴ� �ڵ��,
	//InputStream is = System.in;
	//InputStreamReader a = new InputStreamReader(is);
	
	//������Ʈ���� �ٸ� ������Ʈ���� ������ ��Ʈ��ü�α��� ����
	
	//���� ��� ���ں�ȯ������Ʈ���� InputStreamReader�� �ٽ� ������� ������Ʈ���� BufferedReader�� �����ϴ� �ڵ��,
	//InputStream is = System.in;
	//InputStreamReader a = new InputStreamReader(is);
	//BufferedReader b = new BufferedReader(a);
	
	
	
	public static void main(String[] args) throws Exception{
		InputStream is = System.in;
		
		
		Reader reader = new InputStreamReader(is);
		
		int No;
		
		char[] cb = new char[100];
		
		while(    (No = reader.read(cb))   !=   -1) {
			//System.out.println(cb);
			String data = new String(cb,0,No);
			System.out.println(data);
		}
		reader.close();
	}
}
