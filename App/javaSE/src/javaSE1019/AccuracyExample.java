package javaSE1019;

public class AccuracyExample {
	public static void main(String[] args) {
		{	int apple = 1;
		double pieceUnit = 0.1;
		int number = 7;
		
		double result = apple - number * pieceUnit;
		
		System.out.println(result); //정확하게 계산할때는 부동소수점 타입 사용X
		
	}
		
		int apple = 1;
		
		int totalPieces = apple * 10;
		int number = 7;
		int temp = totalPieces - number;
		
		double result = temp/10.0;
		
		System.out.println(result);
		
	}

}
