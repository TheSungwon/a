package javaSE1106;

import java.awt.Toolkit;

public class Beep1 {
	public static void main(String[] args) {
		Toolkit tool = Toolkit.getDefaultToolkit(); // Toolkit 객체 얻기
		for(int i=0; i<5; i++){
			tool.beep(); //비프음 발생
			try {Thread.sleep(500);}catch(Exception e) {} //0.5초간 일시정지
						
		}
		
		for(int i=0; i<5; i++) {
			System.out.println("ㄸ");
			try {Thread.sleep(500);}catch(Exception e) {} //0.5초간 정지
		}
	}

}
