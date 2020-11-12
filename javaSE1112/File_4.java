package javaSE1112;

import java.io.FileReader;

public class File_4 {
/* FileRead클래스는 텍스트 파일을 프로그램으로 읽어들일 때 사용하는 문자기반 스트림. 문자 단위로 읽기 때문에 텍스트가 아닌
 * 그림 오디오 비디오 등의 파일은 읽을수없다. 
 * FileRead aa = new FileRead("경로");
 * or
 * File aa = new File("경로");
 * FileRead bb = new FileReader(aa);
 * 
 * FileReader 객체가 생성 될 때 파일과 직접 연결 됨. 파일이 존재하지 않으면 예외발생으로 처리해야함
 * Reader의 하위클래스이므로 사용법 같다. 한 문자를 읽기 위해서 read()메소드를 사용하거나
 * 읽은 문자를 char배열에 저장하기 위해서 read(char[] cbuf) or read(char[] cbuf, int off, int len)메소드 이용
 * 전체 파일의 내용을 읽기 위해서 이 메소드들을 반복 실행해서 -1이 나올때까지 읽는다.
 * 
 *  FileReader aa = new FileReader("경로");
 *  int bb;
 *  char[] cc = new char[100];
 *  while(  (bb = aa.read(cc)) ! = -! ) { } aa.close();		//읽은 문자 배열(cc)를 처리 
 */
	
	public static void main(String[] args) throws Exception {
		FileReader a = new FileReader("C:\\Java2\\App\\javaSE\\src\\javaSE1112\\File_4.java");
		
		
		int No;
		
		char[] b = new char[100];
		
		while (  (No = a.read(b))   != -1) {
		//System.out.println(b);
			String data = new String(b, 0, No);
			System.out.println(data);
		}
		a.close();
	}
	
}
