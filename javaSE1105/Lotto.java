package javaSE1105;

import java.util.Arrays;
import java.util.Random;

public class Lotto {
	public static void main(String[] args) {
		//RandomŬ���� // java.util.Random Ŭ������ ������ ��� �پ��� �޼ҵ� ���� boolean int long float double ������ �������ִ�
		//���ڰ� seed�� �����Ҽ��ִ�. ���ڰ��� ������ ����� �˰��� ���Ǵ� ��. ���ڰ��� ������ ������ ����. 
		
		//���ù�ȣ
		
		int[] sel = new int[6]; //���ù�ȣ 6���� ����� �迭 ����
		Random random = new Random(3);	//���ù�ȣ�� ������� Random��ü ���� [seed 3 ����]
		System.out.print("No. ");
		for(int i = 0; i<6; i++) {
			sel[i] = random.nextInt(45)+1; //���� ��ȣ�� ��� �迭�� ����
			System.out.print(sel[i]+" ");	
			
		}
		
		System.out.println();
		
		//��÷��ȣ
		
		int[] win = new int[6]; //��÷��ȣ 6���� ����� �迭 ����
		random = new Random(5); //��÷ ��ȣ�� ��� ���� Random ��ü ���� [seed5 ����]
		System.out.print("��÷");
		for(int i=0; i<win.length; i++) { //i<6 ���
		win[i] = random.nextInt(45)+1; //��÷ ��ȣ�� �迭�� ����
		System.out.print
		(win[i]+" ");
	}
		System.out.println();
		
		//��÷����
		Arrays.sort(sel);
		Arrays.sort(win); //���ϱ� ���� ���Ľ�Ŵ
		
		boolean result = Arrays.equals(sel, win); //�迭 �׸� �� ��
		if(result) {
			System.out.println("��÷");
		}else {
			System.out.println("����");
		}
	}
}
