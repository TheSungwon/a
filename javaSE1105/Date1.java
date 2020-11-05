package javaSE1105;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date1 {

	public static void main(String[] args) {
	Date a = new Date();
	System.out.println(a);
	
	String b = a.toString();
	System.out.println(b);
	
	SimpleDateFormat c = new SimpleDateFormat("yMm");
	System.out.println(c);
	String d = c.format(a);
	System.out.println(d);
	
	

	}

}
