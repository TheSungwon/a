package javaSE1105;

public class ArraysSort implements Comparable<ArraysSort>{ //배열항목정렬 . Arrays.sort()메소드의 매개값으로 저장해주면 자동으로 오름차순 정렬
	// Comparable 인터페이스를 구현하고 있어야 정렬이 된다
	
		String name;
		ArraysSort(String name){
			this.name = name;
			
		}
		//Comparable<ArraysSort>는 ArraysSort타입만 비교하기 위해 제네릭<>을 사용
		//compareTo()메소드는 비교값을 리턴하도록 오버라이딩. 이 메소드의 리턴값은 오름차순일 때 자신이 매개값보다 낮을 경우 양수, 같을경우 0, 높을경우 음수를 리턴
		//name필드값으로 정렬한다고 했으니 유니코드로 비교를 해야한다. String의 compareTo() 리턴값을 사용.. 무슨말?

	
	
	
	@Override
	public int compareTo(ArraysSort a) {
		
		return name.compareTo(a.name);
	}
	

}
