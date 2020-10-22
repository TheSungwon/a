package javaSE1022;

public class arrEx1 {
	public static void main(String[] args) {
		
		int sum = 0;
		float avg = 0f;
		
		int[] sc = {1,2,3,4,5};
		
		for(int a : sc) {
			sum += a;
			avg = sum / (float)sc.length;
		}
		System.out.println(sum);
		System.out.println(avg);
	}

}
