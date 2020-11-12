package javaSE1112;

import java.io.FileInputStream;

public class File_2 {
	/* FileInputStream Ŭ������ ���Ϸκ��� ����Ʈ ������ �о���� �� ����ϴ� ����Ʈ��� �Է� ��Ʈ��. ����Ʈ ������ �б� ������
	 * �׸�,�����, ����, �ؽ�Ʈ���� �� ��� ������ ������ ���� �� ����. 
	 * 
	 * ù ��° ���
	 * FileInputStream aaa = new FileInputStream("���");
	 * 
	 * �� ��° ���
	 * File aaa = new File("���");
	 * FIleinputStream bbb = new FileInputStream(aaa);
	 * 
	 * ù ��° ����� ���ڿ��ε� ������ ��θ� ������ FileInputStream�� �����Ѵ�. ���� �о���� ������ File��ü�� �̹� �����Ǿ� �ִٸ�
	 * �ι�° ������� ���� FileInputStream�� ����������ֵ�. FileInputSteam ��ü�� ������ �� ���ϰ� ���������� �Ǵµ�, ���� ������ ��������
	 * ������ ���ܹ߻����� ����ó���� �ؾ���.
	 * 
	 * FileInputStream�� InputStream�� ����Ŭ�����̱� ������ ������� InputStream�� ����. �� ���̺z �б� ���ؼ� read()�޼ҵ带 ����ϰų�
	 * ���� ����Ʈ�� byte�迭�� �����ϱ� ���ؼ� read(byte[] b) or read(byte[] b, int off, int len)�޼ҵ带 ���
	 * ��ü ������ ������ �б� ���ؼ��� �� �޼ҵ���� �ݺ� �����ؼ� -1�� ���� �� ���� ������ �ȴ�. ������ ������ ��� �����Ŀ��� close()�޼ҵ带 ȣ���ؼ� ������ �ݾ��ش�.
	 * int a;
	 * byte[] b = new byte[100];
	 * while ( (a = fileinputstream.read(b  != -1)
	 */

	
	public static void main(String[] args) {
		try {
			FileInputStream a = new FileInputStream("C:\\Java2\\App\\javaSE\\src\\javaSE1112\\File_2.java");
			
			int data;
			while( (data = a.read()) != -1) {
				System.out.write(data); //1����Ʈ�� �а� �ֿܼ� ��� System.out.write
			}
			a.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
