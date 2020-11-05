package javaSE1105;

import java.util.Arrays;

public class Array1 {
	public static void main(String[] args) {
		char[] a = {'a','b','c','d'};
		
		char[] b = Arrays.copyOf(a, a.length); //a 전체를 b로 복사
		
		System.out.println(b);
		
		
		char[] a1 = Arrays.copyOfRange(a, 1, 3); //a배열 1~2 를 b배열 0~1로 복사
		System.out.println(a1);
		
		
		char[] a2 = new char[a.length];
		System.arraycopy(a, 0, a2, 0, a.length); //a 전체를 a2로 복사
		
		System.out.println(a2);
		System.out.println();
		
		for(int i=0; i<a2.length; i++) {
			System.out.println(a2[i]);
		}
		
		}
}
