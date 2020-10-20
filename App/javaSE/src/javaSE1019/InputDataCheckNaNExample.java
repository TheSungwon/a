package javaSE1019;

public class InputDataCheckNaNExample {
	public static void main(String[] args) {
		String userInput = "NaN";
		double val = Double.valueOf(userInput);
		
		double currentBalance = 100000.0;
		
		currentBalance += val;
		System.out.println(currentBalance);
				
	}

}
