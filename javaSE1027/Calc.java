package javaSE1027;

public class Calc {
	int plus(int x, int y) { //plus
		int result = x + y;
		return result;
	}
	
	double avg(int x , int y) {//avg
		double sum = plus(x ,y); //no4. plusȣ�� 2
		double result = sum / 2;
		return result;
		
	}
	
	void execute() {
		double result = avg(1,2); //no10. avgȣ�� 1
		println("���"+result); //no22. printlnȣ�� 3
				
	}
	
	void println(String a) { //println
		System.out.println(a);
		
	}

}
//execute()�޼ҵ带 ȣ���ϸ� 