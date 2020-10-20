package javaSE1019;

public class StringEqualsExample {
	public static void main(String[] args) {
		
		String s1 = "½Å¹ÎÃ¶";
		String s2 = "½Å¹ÎÃ¶";
		String s3 = new String("½Å¹ÎÃ¶");
		
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println();
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		//¹®ÀÚ¿­¸¸ ºñ±³ÇÏ·Á¸é == ´ë½Å¿¡ equals() ¸Þ¼Òµå¸¦ »ç¿ë
		
		
	}

}
