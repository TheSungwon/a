package javaSE1103;

public class ClassCastException {
	public static void main(String[] args) {
		Dog a = new Dog();
		change(a); //change�޼ҵ忡 ����
		
		Cat b = new Cat();
		change(b);
		
		
	}
	
	public static void change(Animal animal) {
	//	if(animal instanceof Dog){
	//	Dog a = (Dog) animal; //ClassCastException �߻�. instanceof�� üũ
	//	} 
	}

}
// 15���ο��� ClassCastException �߻�. 9���ο��� Cat��ü�� �Ű������� �־��� ������ DogŸ������ ��ȯȰ������.


class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}