package javaSE1022;

public class ArrayCopyByFor {
	public static void main(String[] args) {
		
		int[] old = {1,2,3};
		int[] nw = new int[5];
		
		for(int i=0; i<old.length; i++) {
			nw[i] = old[i];
			System.out.println(old[i]);
		}
		for(int i=0; i<nw.length; i++) {
			System.out.print("["+nw[i]);
		}
	}

}
