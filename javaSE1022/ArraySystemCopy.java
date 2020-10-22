package javaSE1022;

public class ArraySystemCopy {
	public static void main(String[] args) {
		
		String[] old = {"a","b","c"};
		String[] nw = new String[5];
		
		System.arraycopy(old, 0, nw, 0, old.length);
		
		for(int i=0; i<nw.length; i++) {
			System.out.println(nw[i]);
		}
	}

}
