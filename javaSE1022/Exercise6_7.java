package javaSE1022;

public class Exercise6_7 {
	public static void main(String[] args) {
		
		
		int[] array = {1,5,3,8,2};
		int max = array[0];
		for(int i=0; i<array.length; i++) {
			if(max < array[i]) {
				max = array[i];//0<1 1<5 5<8 8...
			
			}
		}
		System.out.println(max);
	}

}
