package javaSE1111;

import java.io.IOException;
import java.io.InputStream;

public class SystemIn_1 {
	public static void main(String[] args) throws IOException {
		System.out.println("menu");
		System.out.println("1.");
		System.out.println("2.");
		System.out.println("3.");
		System.out.println("4.");
		System.out.println("5.");
		System.out.print("select");
		
		InputStream is = System.in; //Ű���� �Է� ��Ʈ�� ���
		//InputStream �� read()�޼ҵ�� 1����Ʈ�� �б� ������ �ƽ�Ű�ڵ�� �� ǥ���� �д´�.
		//2����Ʈ�� read(byte[]b) or read(byte[]b, int off, int len) �޼ҵ�� ��ü �Էµ� ������ ����Ʈ �迭�� �޴´�.
		// �� �迭�� �̿��ؼ� String��ü�� �����ϸ� �ȴ�.
		
		char inputChar = (char) is.read(); //�ƽ�Ű �ڵ带 �а� ���ڷ� ���� //���ƿܹ߻�
		
		switch(inputChar) {
		case '1':
		System.out.println("1");
		break;
		
		
		case '2':
		System.out.println("2");
		break;
		///�߷�
		}
		
	}

}
