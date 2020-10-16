package javaSE1015;

public class GarbageValueExample {
	public static void main(String[] args) {
		byte var1 = 125;
		int var2 = 125;
		for(int i=0; i<5; i++) {
			var1++;
			var2++;
			System.out.println("var1:" + var1 + "\t" + "var2:" + var2);
			// "\t" 는 tab만큼 칸을 띄워주는 역할
			// byte는 127 최대값 넘으면 -128부터 시작
		}
	}

}
