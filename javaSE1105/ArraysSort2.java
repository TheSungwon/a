package javaSE1105;

import java.util.Arrays;

public class ArraysSort2 {

	public static void main(String[] args) {
		int[] a = {8,5,3};
		
		Arrays.sort(a);
		
		for(int i = 0; i<a.length; i++) {
			System.out.println(a[i]);
			System.out.println();
		}
		int aa = Arrays.binarySearch(a, 5); //배열검색
		System.out.println(aa);
		
		
		String[] b = {"d","aad","o"};
		
		Arrays.sort(b);
		for(int i = 0; i<b.length; i++) {
			System.out.println(b[i]);
		}
		
		System.out.println();
		
		ArraysSort m1 = new ArraysSort("ㅂ");
		ArraysSort m2 = new ArraysSort("ㄷ");
		ArraysSort m3 = new ArraysSort("ㅊ");
		
		ArraysSort[] m = {m1,m2,m3};
		Arrays.sort(m);
		for(int i = 0; i<m.length; i++) {
			System.out.println(m[i].name);
		}
		
	
	
	}
	


	}
