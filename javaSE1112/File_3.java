package javaSE1112;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class File_3 {
	/* FileOutputStream  바이트 단위로 데이터를 파일에 저장할때 사용하는 바이트 기반 출력 스트림
	 * 바이트 단위로 젖아하기 때문에 그림 오디오 비디오 텍스트 등 모든 종류의 데이터 파일로 저장할수있다.
	 * 주의할 점은 파일이 이미 존재할 경우, 데이터를출력하면 파일을 덮어쓰게 되므로 기존 파일의 내용은 사라지게 됨
	 * 내용 끝에 데이터를 추가할 경우에는 FileOutputStream 생성자의 두 번째 매개값을 true로 주면 된다
	 * FileOutputStream aaa = new FileOutputStream([경로,or file],true);
	 * OUtputSteam의 하위클래스이기 때문에 outputStream과 동일. 한 바이트를 저장하기 위해서 write()메소드를 사용
	 * 
	 * write()메소드를 호출한 이후에 flush()메소드로 출력 버퍼에 잔류하는 데이터를 완전히 출력하도록하고, close()메소드를 호출해서 파일닫기.
	 * 
	 * 원본파일을 타겟파일로 복사하는 예제. 복사프로그램의 원리는 원본파일에서 읽은 바이트를 바로 타겟파일로 저장하는 것이기 때문에
	 * FileInputStream에서 읽은 바이트를 바로 FileOutputStream으로 저장하면 된다.
	 */
	
	public static void main(String[] args) throws Exception{
		String oriFile = "C:\\Java2\\test.txt";
		String tarFile = "C:\\Java2\\test2.txt";
		 
		FileInputStream fi = new FileInputStream(oriFile);
		FileOutputStream fo = new FileOutputStream(tarFile);
		
		int readNo;
		
		byte[] readByte = new byte[100];
		
		while(  (readNo = fi.read(readByte))  != -1) {
			fo.write(readByte, 0, readNo);
		}
		fo.flush();
		fo.close();
		fi.close();
		
		System.out.println("copy success");
		
	}

}
// intput의 read메소드로 한번에 100바이트를 읽어서 readByte에 저장하고 readNo에 저장한다? while문 안의 내용