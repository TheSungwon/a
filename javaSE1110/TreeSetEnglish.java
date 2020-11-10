package javaSE1110;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetEnglish {
	public static void main(String[] args) {
		TreeSet<String> a = new TreeSet<>();

		a.add("d");
		a.add("sdfd");
		a.add("retd");
		a.add("ted");
		a.add("zd");
		a.add("thd");
		a.add("yud");
		a.add("md");
		
		System.out.println("알파펫 a~z 사이의 검색단어");
		
		NavigableSet<String> b = a.subSet("a",true,"{",true); // a~z 사이 검색 (y까지?)// {를 이용해서 z ㄲㅏ지
		for(String word : b) {
			System.out.println(word);
		}
	}

}
