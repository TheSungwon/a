package javaSE1022;

public class MainStringArrayArgument {
	public static void main(String[] args) {
		
		if(args.length != 2) {
			System.out.println("»ç¿ë¹ý");
			System.exit(0);
			
		}
		
		String num1 = args[0];
		String num2 = args[1];
		
		
		int n = Integer.parseInt(num1);
		int m = Integer.parseInt(num2);
		
		int result = n + m;
		System.out.println(result);
		
		
	}

}
