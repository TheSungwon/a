package javaSE1105;

import java.util.StringTokenizer; //import ����?

public class StringTokenizer1 {
	public static void main(String[] args) {
		String a = "��/��/��/��";
		
		//��ü ��ū ���� ��� for������ ����
		StringTokenizer b = new StringTokenizer(a,"/");
		int count = b.countTokens();
		for(int i = 0; i<count; i++) {
			String token = b.nextToken();
			System.out.print(token);
			
			
			System.out.println();
			
			
			
		}
		
		//���� �ִ� ��ū�� Ȯ���ϰ� while������ ����
		b = new StringTokenizer(a,"/");
		while(b.hasMoreElements()) {
			String token = b.nextToken();
			System.out.print(token);
			
		}
	}

}
/* ���ڿ��� �� ������ �����ڷ� ����Ǿ����� ��� ���. StringTokenizer �����Ҷ� ù��°�Ű������� ��ü���ڿ��� �ְ� �ι�° �Ű������� �����ڸ� �ش�
�����ڸ� �����ϸ� ������ �⺻ �����ڰ� ��. 
int 	countTokens( )	������ �ʰ� ���� �ִ���ū�� ��

boolean		hasMoreTokens( )	���� �ִ���ū�� �ִ��� ����

String		nextT oken()		��ū���ϳ���������


nextToken�޼ҵ�� �ϳ� �������� StringTokenizer��ü�� �ش���ū�� ��������. �� �̻� ������ ��ū�� ���ٸ� ���ܸ� �߻���Ų��
�׷��� nextToken�޼ҵ带 �����ϱ� ���� hashMoreTokens �޼ҵ�� ������ ��ū�� �ִ��� Ȯ�� */