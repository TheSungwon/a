package javaSE1104;

public class SubString {
public static void main(String[] args) {
	String a = "abcdefghi";
	String b = a.substring(2,3);	//3 까지 아니고 [-1] = 2 부터 출력
	System.out.println(b);			//(?) = 이후로 출력
}
}
