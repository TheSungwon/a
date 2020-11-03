package javaSE1103;

public class ClassCastException {
	public static void main(String[] args) {
		Dog a = new Dog();
		change(a); //change메소드에 대입
		
		Cat b = new Cat();
		change(b);
		
		
	}
	
	public static void change(Animal animal) {
	//	if(animal instanceof Dog){
	//	Dog a = (Dog) animal; //ClassCastException 발생. instanceof로 체크
	//	} 
	}

}
// 15라인에서 ClassCastException 발생. 9라인에서 Cat객체를 매개값으로 주었기 때문에 Dog타입으로 변환활수없다.


class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}