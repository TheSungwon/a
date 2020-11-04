package javaSE1104;

public class ToSring2_2 {
	public static void main(String[] args) {
		ToString2 a = new ToString2("google","android");
		
		String str = a.toString();
		
		
		System.out.println(str);
		System.out.println(a);//a.tostring()을 자동호출해서 리턴값을 얻을 후 출력
		
	}

}
