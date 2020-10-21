package javaSE1021;

public class arrayCreateByVaueListExample1 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		
		
		int sum = 0;
		for(int i=0; i<3; i++) {
			sum += a[i];
			
		}
		System.out.println("---------");
		System.out.println(sum);
		double avg = (double) sum / 3;
		System.out.println(avg);
	}

}
