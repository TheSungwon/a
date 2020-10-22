package javaSE1022;

public class ArrauCreateByVaueListExample2 {
	public static void main(String[] args) {
		
		int[] scores;
		
		scores = new int[] {1, 2, 3};
		
		int sum1 = 0;
		
		for(int i=0; i<scores.length; i++) {
			sum1 += scores[i];
			
		}
		System.out.println("합"+sum1);
		//리턴된 총합을 sum2에 저장
		
		int sum2 = add( new int[] {5, 6, 7});
		System.out.println("총합"+sum2);
		System.out.println();
	}
	//총합을 계산해서 리턴하는 메소드
	public static int add( int[] scores) {
		int sum = 0;
		for(int i=0; i<scores.length; i++) {
			sum += scores[i];
			
		}
		return sum;
	}

}
