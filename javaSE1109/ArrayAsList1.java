package javaSE1109;
import java.util.Arrays;
import java.util.List;

public class ArrayAsList1 {
	public static void main(String[] args) { //�߾Ⱦ��¹��? .add�� ���� ����?
		//List<T> list = Arrays.asList (T ... a); ������ ��ü��� ������ List�� ������ ���� �ִ� �̷� ��� ���
		//TŸ�� �Ķ���Ϳ� �°� asList()�� �Ű����� ���������� �Է��ϰų� T[]�迭�� �Ű������� �ָ� �ȴ�
		
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
