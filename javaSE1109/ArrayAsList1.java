package javaSE1109;
import java.util.Arrays;
import java.util.List;

public class ArrayAsList1 {
	public static void main(String[] args) { //잘안쓰는방법? .add를 많이 쓴다?
		//List<T> list = Arrays.asList (T ... a); 고정된 객체들로 구성된 List를 생성할 때도 있다 이런 경우 사용
		//T타입 파라미터에 맞게 asList()의 매개값을 순차적으로 입력하거나 T[]배열을 매개값으로 주면 된다
		
		List<String> list1 = Arrays.asList("a","b","c");
		
		for(String a : list1) {
			System.out.print(a);
		}
		System.out.println();
		List<Integer> list2 = Arrays.asList(1,2,3,4,5);
		for(int v : list2) {
			System.out.print(v);
		}
	}

}
