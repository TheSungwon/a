package javaSE1112;

import java.io.FileReader;

public class File_4 {
/* FileReadŬ������ �ؽ�Ʈ ������ ���α׷����� �о���� �� ����ϴ� ���ڱ�� ��Ʈ��. ���� ������ �б� ������ �ؽ�Ʈ�� �ƴ�
 * �׸� ����� ���� ���� ������ ����������. 
 * FileRead aa = new FileRead("���");
 * or
 * File aa = new File("���");
 * FileRead bb = new FileReader(aa);
 * 
 * FileReader ��ü�� ���� �� �� ���ϰ� ���� ���� ��. ������ �������� ������ ���ܹ߻����� ó���ؾ���
 * Reader�� ����Ŭ�����̹Ƿ� ���� ����. �� ���ڸ� �б� ���ؼ� read()�޼ҵ带 ����ϰų�
 * ���� ���ڸ� char�迭�� �����ϱ� ���ؼ� read(char[] cbuf) or read(char[] cbuf, int off, int len)�޼ҵ� �̿�
 * ��ü ������ ������ �б� ���ؼ� �� �޼ҵ���� �ݺ� �����ؼ� -1�� ���ö����� �д´�.
 * 
 *  FileReader aa = new FileReader("���");
 *  int bb;
 *  char[] cc = new char[100];
 *  while(  (bb = aa.read(cc)) ! = -! ) { } aa.close();		//���� ���� �迭(cc)�� ó�� 
 */
	
	public static void main(String[] args) throws Exception {
		FileReader a = new FileReader("C:\\Java2\\App\\javaSE\\src\\javaSE1112\\File_4.java");
		
		
		int No;
		
		char[] b = new char[100];
		
		while (  (No = a.read(b))   != -1) {
		//System.out.println(b);
			String data = new String(b, 0, No);
			System.out.println(data);
		}
		a.close();
	}
	
}
