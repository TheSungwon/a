package javaSE1029;

public class Plane2 extends Plane1 {
	
	
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;
	
	
	public int flyMode = NORMAL;
	
	@Override
	public void fly() {
		if(flyMode == SUPERSONIC) {
			System.out.println("SUPERSONIC");
		} else {
		super.fly(); //오버라이드 안 한 메소드 호출
		}
		
	}
		
}
