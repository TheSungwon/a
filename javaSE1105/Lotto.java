package javaSE1105;

import java.util.Arrays;
import java.util.Random;

public class Lotto {
	public static void main(String[] args) {
		//Random클래스 // java.util.Random 클래스는 난수를 얻는 다양한 메소드 제공 boolean int long float double 난수를 얻을수있다
		//종자값 seed를 설정할수있다. 종자값은 난수를 만드는 알고리즘에 사용되는 값. 종자값이 같으면 난수도 같다. 
		
		//선택번호
		
		int[] sel = new int[6]; //선택번호 6개가 저장될 배열 생성
		Random random = new Random(3);	//선택번호를 얻기위한 Random객체 생성 [seed 3 설정]
		System.out.print("No. ");
		for(int i = 0; i<6; i++) {
			sel[i] = random.nextInt(45)+1; //선택 번호를 얻어 배열에 저장
			System.out.print(sel[i]+" ");	
			
		}
		
		System.out.println();
		
		//당첨번호
		
		int[] win = new int[6]; //당첨번호 6개가 저장될 배열 생성
		random = new Random(5); //당첨 번호를 얻기 위한 Random 객체 생성 [seed5 설정]
		System.out.print("당첨");
		for(int i=0; i<win.length; i++) { //i<6 대신
		win[i] = random.nextInt(45)+1; //당첨 번호를 배열에 저장
		System.out.print
		(win[i]+" ");
	}
		System.out.println();
		
		//당첨여부
		Arrays.sort(sel);
		Arrays.sort(win); //비교하기 전에 정렬시킴
		
		boolean result = Arrays.equals(sel, win); //배열 항목 값 비교
		if(result) {
			System.out.println("당첨");
		}else {
			System.out.println("ㄴㄴ");
		}
	}
}
