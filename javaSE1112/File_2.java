package javaSE1112;

import java.io.FileInputStream;

public class File_2 {
	/* FileInputStream 클래스는 파일로부터 바이트 단위로 읽어들일 때 상요하는 바이트기반 입력 스트림. 바이트 단위로 읽기 때문에
	 * 그림,오디오, 비디오, 텍스트파일 등 모든 종류의 파일을 읽을 수 있음. 
	 * 
	 * 첫 번째 방법
	 * FileInputStream aaa = new FileInputStream("경로");
	 * 
	 * 두 번째 방법
	 * File aaa = new File("경로");
	 * FIleinputStream bbb = new FileInputStream(aaa);
	 * 
	 * 첫 번째 방법은 문자열로된 파일의 경로를 가지고 FileInputStream을 생성한다. 만약 읽어야할 파일이 File객체로 이미 생성되어 있다면
	 * 두번째 방법으로 쉽게 FileInputStream을 생성ㅎ라수있따. FileInputSteam 객체가 생성될 때 파일과 직접연결이 되는데, 만약 파일이 존재하지
	 * 않으면 예외발생으로 예외처리를 해야함.
	 * 
	 * FileInputStream은 InputStream의 하위클래스이기 때문에 사용방법이 InputStream과 동일. 한 바이틑 읽기 위해서 read()메소드를 사용하거나
	 * 읽은 바이트를 byte배열에 저장하기 위해서 read(byte[] b) or read(byte[] b, int off, int len)메소드를 사용
	 * 전체 파일의 내용을 읽기 위해서는 이 메소드들을 반복 실행해서 -1이 나올 때 까지 읽으면 된다. 파일의 내용을 모두 읽은후에는 close()메소드를 호출해서 파일을 닫아준다.
	 * int a;
	 * byte[] b = new byte[100];
	 * while ( (a = fileinputstream.read(b  != -1)
	 */

	
	public static void main(String[] args) {
		try {
			FileInputStream a = new FileInputStream("C:\\Java2\\App\\javaSE\\src\\javaSE1112\\File_2.java");
			
			int data;
			while( (data = a.read()) != -1) {
				System.out.write(data); //1바이트씩 읽고 콘솔에 출력 System.out.write
			}
			a.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
