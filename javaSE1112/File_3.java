package javaSE1112;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class File_3 {
	/* FileOutputStream  ����Ʈ ������ �����͸� ���Ͽ� �����Ҷ� ����ϴ� ����Ʈ ��� ��� ��Ʈ��
	 * ����Ʈ ������ �����ϱ� ������ �׸� ����� ���� �ؽ�Ʈ �� ��� ������ ������ ���Ϸ� �����Ҽ��ִ�.
	 * ������ ���� ������ �̹� ������ ���, �����͸�����ϸ� ������ ����� �ǹǷ� ���� ������ ������ ������� ��
	 * ���� ���� �����͸� �߰��� ��쿡�� FileOutputStream �������� �� ��° �Ű����� true�� �ָ� �ȴ�
	 * FileOutputStream aaa = new FileOutputStream([���,or file],true);
	 * OUtputSteam�� ����Ŭ�����̱� ������ outputStream�� ����. �� ����Ʈ�� �����ϱ� ���ؼ� write()�޼ҵ带 ���
	 * 
	 * write()�޼ҵ带 ȣ���� ���Ŀ� flush()�޼ҵ�� ��� ���ۿ� �ܷ��ϴ� �����͸� ������ ����ϵ����ϰ�, close()�޼ҵ带 ȣ���ؼ� ���ϴݱ�.
	 * 
	 * ���������� Ÿ�����Ϸ� �����ϴ� ����. �������α׷��� ������ �������Ͽ��� ���� ����Ʈ�� �ٷ� Ÿ�����Ϸ� �����ϴ� ���̱� ������
	 * FileInputStream���� ���� ����Ʈ�� �ٷ� FileOutputStream���� �����ϸ� �ȴ�.
	 */
	
	public static void main(String[] args) throws Exception{
		String oriFile = "C:\\Java2\\test.txt";
		String tarFile = "C:\\Java2\\test2.txt";
		 
		FileInputStream fi = new FileInputStream(oriFile);
		FileOutputStream fo = new FileOutputStream(tarFile);
		
		int readNo;
		
		byte[] readByte = new byte[100];
		
		while(  (readNo = fi.read(readByte))  != -1) {
			fo.write(readByte, 0, readNo);
		}
		fo.flush();
		fo.close();
		fi.close();
		
		System.out.println("copy success");
		
	}

}
// intput�� read�޼ҵ�� �ѹ��� 100����Ʈ�� �о readByte�� �����ϰ� readNo�� �����Ѵ�? while�� ���� ����