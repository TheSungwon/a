package javaSE1105;

public class Split {

	public static void main(String[] args) {
	String a = "ㅁ,ㄷ,ㄱ,ㅎ,ㅁ,.ㄱ.ㅎ.&ㅁ-ㄱ-ㅎ";
	
	String[] name = a.split("&|,|-"); //slpit()메소드는 기호들을 구분자로 해서 부분 문자열을 추출
	
	System.out.println(name);
	System.out.println(a);
	
	
	for(String b : name) {
		System.out.print(b); // .안됨 print로 출력
	}

	}

}
