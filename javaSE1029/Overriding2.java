package javaSE1029;

public class Overriding2 extends Overriding1 {
	
	//�������̵�
	@Override
	double circle(double r) {
	System.out.println("child");
		return Math.PI * r * r;
		
	}

}
