package javaSE1022;

public class AdavancedFor {
	public static void main(String[] args) {
		
		int[] sc = {1,2,3,4,5};
		
		int sum=0;
		for(int a : sc) {
			sum +=a;
			
		}
		System.out.println(sum);
		
		double avg = (double) sum / sc.length;
		System.out.println(avg);
	}

}
