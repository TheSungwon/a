package javaSE1102;

public class InnerA {
	
	InnerA() {System.out.println("A��ü����");} //������?
	
	
	
	//�ν��Ͻ���� Ŭ����
	
	class InnerB{
		InnerB(){System.out.println("B��ü����");} //������
		int field1;
		void method1() {}
		
		//static int field2;				static����Ҽ����� A �ȿ� �����ʱ⶧��
		//static void method2(){}
		
	}
	
	
	//������� Ŭ����
	
	static class InnerC{
		InnerC(){System.out.println("C��ü����");}
		int field1;
		void method1() {}
		
		static int field2;
		static void method2() {}
		
	}

	
	//���� Ŭ����
void method() {
	class InnerD{
		InnerD(){System.out.println("D��ü����");}
		int field1;
		void method1() {}
		
		//static int field2;
		//static void method() {}
		}
	
	InnerD d = new InnerD();
	d.field1 = 123;
	d.method1();
	}
}

