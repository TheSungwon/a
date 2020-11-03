package javaSE1103;

public class ArrayIndexOutOfBoundsException {
	public static void main(String[] args) {
		String a = args[0];
		String b = args[1];
		
		System.out.println(a);
		System.out.println(b);
		//배열에서 인덱스 범위를 초과하여 사용할 경우 실행예외 ArrayInderxOutOfBoundsException 발생
		//int[] arr = new int[3] 배열을 선언했다면 0~2를 사용할수있지만 3을 사용하면 인덱스 범위 초과해서 발생
		//Configurations의 Arguments탭의 Program arguments 입력란에 매개값 입력하면 실행
	}

}
