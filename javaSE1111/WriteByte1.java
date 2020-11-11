package javaSE1111;


import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteByte1 { //OutputStream //출력스트림//쓰기 //출력
	public static void main(String[] args) throws Exception {
	OutputStream a = new FileOutputStream("C:\\java2\\test.txt"); //FileOutputStream에서 예외발생
	
	byte[] data = "asdf".getBytes();
	
	for(int i=0; i<data.length; i++) {
		a.write(data[i]);
		//test.txt에 asdf를 하나씩 꺼내서 작성
		
		//for 문을 이용하지 않고
		//a.write(data);만 해줘도 된다. =WriteByte2
	}
	a.flush();//출력 스트림은 내부에 버퍼buffer가 있어서 데이터가 출력되기 전에
	//버퍼에 쌓여있다가 순서대로 출력. flush()메소드는 버퍼에 잔류하고 있는 데이터를
	//모두 출력시키고 버퍼를 비우는 역할. 프로그램에서 더 이상 출력할 데이터가 없다면
	//flush()메소드를 마지막으로 호출하여 버퍼에 잔류하는 모든 데이터가 출력되도록 해야한다.
	
	a.close();
	//OutputStream을 더 이상 사용하지 않을 경우에는 close()메소드를 호출해서
	//OutputStream에서 사용했던 시스템 자원을 풀어준다.
	}

}
