package javaSE1105;

import java.util.Arrays;

public class Array1 {
	public static void main(String[] args) {
		char[] a = {'a','b','c','d'};
		
		char[] b = Arrays.copyOf(a, a.length); //a ��ü�� b�� ����
		
		System.out.println(b);
		
		
		char[] a1 = Arrays.copyOfRange(a, 1, 3); //a�迭 1~2 �� b�迭 0~1�� ����
		System.out.println(a1);
		
		
		char[] a2 = new char[a.length];
		System.arraycopy(a, 0, a2, 0, a.length); //a ��ü�� a2�� ����
		
		System.out.println(a2);
		System.out.println();
		
		for(int i=0; i<a2.length; i++) {
			System.out.println(a2[i]);
		}
		
		}
}
