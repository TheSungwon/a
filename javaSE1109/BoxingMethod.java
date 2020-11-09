package javaSE1109;

public class BoxingMethod {

	public static void main(String[] args) {
		Box3<Integer> a = Util.<Integer>boxing(100);
		int val = a.get();
		
		Box3<String> b = Util.boxing("aaaa");
		String str = b.get();

	}

}
