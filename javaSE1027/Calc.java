package javaSE1027;

public class Calc {
	int plus(int x, int y) { //plus
		int result = x + y;
		return result;
	}
	
	double avg(int x , int y) {//avg
		double sum = plus(x ,y); //no4. plus호출 2
		double result = sum / 2;
		return result;
		
	}
	
	void execute() {
		double result = avg(1,2); //no10. avg호출 1
		println("결과"+result); //no22. println호출 3
				
	}
	
	void println(String a) { //println
		System.out.println(a);
		
	}

}
//execute()메소드를 호출하면 