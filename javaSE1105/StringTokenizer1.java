package javaSE1105;

import java.util.StringTokenizer; //import 생성?

public class StringTokenizer1 {
	public static void main(String[] args) {
		String a = "ㅁ/ㄴ/ㅇ/ㄹ";
		
		//전체 토큰 수를 얻어 for문으로 루핑
		StringTokenizer b = new StringTokenizer(a,"/");
		int count = b.countTokens();
		for(int i = 0; i<count; i++) {
			String token = b.nextToken();
			System.out.print(token);
			
			
			System.out.println();
			
			
			
		}
		
		//남아 있는 토큰을 확인하고 while문으로 루핑
		b = new StringTokenizer(a,"/");
		while(b.hasMoreElements()) {
			String token = b.nextToken();
			System.out.print(token);
			
		}
	}

}
/* 문자열이 한 조율의 구분자로 연결되어있을 경우 사용. StringTokenizer 생성할때 첫번째매개값으로 전체문자열을 주고 두번째 매개값으로 굽누자를 준다
구분자를 생략하면 공백이 기본 구분자가 됨. 
int 	countTokens( )	꺼내지 않고 남아 있는토큰의 수

boolean		hasMoreTokens( )	남아 있는토큰이 있는지 여부

String		nextT oken()		토큰을하나씩꺼내옴


nextToken메소드로 하나 꺼내오면 StringTokenizer객체에 해당토큰이 없어진다. 더 이상 가져올 토큰이 없다면 예외를 발생시킨다
그래서 nextToken메소드를 실행하기 전에 hashMoreTokens 메소드로 꺼내올 토큰이 있는지 확인 */