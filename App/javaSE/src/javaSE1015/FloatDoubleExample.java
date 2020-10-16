package javaSE1015;

public class FloatDoubleExample {
	public static void main(String[] args) {
		
		int var66 = 3000000;
		double var77 = 3e6; //e는 10의 지수
		float var88 = 3e6f;
		double var99 = 2e-3; //0.002
		
		System.out.println(var66);
		System.out.println(var77);
		System.out.println(var88);
		System.out.println(var99);

		
		//실수값 저장
		double var1 = 3.14;
		//float var2 = 3.14 컴파일 에러
		float var3 = 3.14F;
		
		//정밀도 테스트
		double var4 = 0.1234567890123456789;
		float var5 = 0.1234567890123456789F;
				
				System.out.println("var1:"+var1);
		System.out.println("var3:"+var3);
		System.out.println("var4:"+var4);
		System.out.println("var5:"+var5);
		
	}

}
