package javaSE1022;

public class arr1 {
	public static void main(String[] args) {
		
		int arg1[] = {1,2,3,4,5}; //배열선언 생성 length 5
		int arg2[] = new int[10]; // 배열선언 생성10
		
		System.arraycopy(arg1,0,arg2,3,5);//arg1배열의 0번째인덱스부터
		//arg2배열의 3번째 인덱스부터 5개 값 복사
		
		for(int a : arg1)//for(int a=0; a<arg1.length; a++)
			System.out.println(a);
		System.out.println("--");
		for(int a : arg2)
			System.out.println(a);
			
	}

}
