package javaSE1022;

public class ArrayCreateByNewExample3 {
	public static void main(String[] args) {
		int[] scores = {1,2,3};
		
		int sum=0;
		for(int i=0; i<scores.length; i++) {
			sum += scores[i];
		}
		System.out.println("Че"+ sum);
		
	
	
		double avg = (double) sum / scores.length;
		System.out.println("ЦђБе"+ avg);
		
	}	

}
