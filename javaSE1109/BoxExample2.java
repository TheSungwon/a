package javaSE1109;

public class BoxExample2 {
	public static void main(String[] args) {
		Box2<String> a = new Box2<String>();
		
		a.set("aaaaaa");
		
		String str = a.get();
		
		
		Box2<Integer> b = new Box2<Integer>();
		b.set(1);
		int val = b.get();
		
				
				
	}

}
