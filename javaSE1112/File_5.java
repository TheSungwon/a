package javaSE1112;
import java.io.File;
import java.io.FileWriter;

public class File_5 {
	/*FileWriter는 텍스트 데이터를 파일에 저장할 때 사용하는 문자 기반 스트림. 문자 단위로 저장해서 텍스트가 아닌 그림 오디오 비디오 등의
	 * 데이터를 파일로 저장못한다. 
	 * 
	 * FileWriter aa = new FileWriter("경로");
	 * or
	 * FileWriter aa = Fiile("경로");
	 * FileWriter bb = new FileWriter(aa);
	 * 
	 * 지정된 파일이 존재할 경우 그 파일을 덮어 쓰게 되므로 파일 내용 끝에 데이터를 추가할 경우에는 FileWriter생성자에 두 번째 매개값으로 true를 주면 된다.
	 * FileWriter는 Writer의 하위클래스 이므로 Wirter와 사용방법이 동일. 한 문자를 저장하기 위해서 wirte()메소드를 사용
	 * 문자열을저장하기 위해서는 Write(String str)	 메소드를 사용.
	 * wirte()메소드를 호출한 이후에 flush()메소드로 출력버퍼에있는 데이터를 파일로 완전히 출력하도록 하고 close()메소드를 호출해서 파일닫기.
	 */

	
	
	public static void main(String[] args) throws Exception{
		
		File a = new File("C:\\Java2\\file.txt");
		FileWriter fw = new FileWriter(a,true);
		
		fw.write("FileWriter는 한글"+"\r\n");  //		\r\n은 캐리지리턴과 라인피드로 엔터키와 동일한 역할 행을 바꾼다.
		fw.write("문자열출력"+"\r\n");
		fw.flush();
		fw.close();
		System.out.println("파일저장");
	}
}
