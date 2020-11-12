package javaSE1112;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class File_1 {
	/* IO패키지(java.io) 에서 제공하는 File클래스는 파일크기,속성,이름 등의 정보를 얻어내는 기능, 파일 생성 삭제 기능 제공
	 * 디렉토리를 생성하고 존재하는 파일리스트를 얻어내는 기능. 그러나 파일의 데이터를 읽고 쓰는 기능은 없다
	 * 파일의 입출력은 스트림을 사용. // File file = new File(경로); /로 구분 이스케이프\\ 두번 따옴표 안이니까
	 * 
	 * File객체를 생성했다고 해서 파일이나 디렉토리가 생성되는건 아님. 생성자매개값으로 주어진 경로가 유효하지 않더라도
	 * 컴파일 에러나 예외가 발생하지 않음. 파일이나 디렉토리가 있는지 확인하려면 exists()메소드를 호출. 존재한다면 true 아니면 false
	 * boolean isExist = file.exists();
	 * 
	 * exists()메소드의 리턴값이 false라면 createNewFile(), mkdir(), mkdirs()메소드로 파일, 디렉토리 생성가능
	 * true면 can~(), get~() 를 통해 정보를 얻어낼수있음.
	 *  
	 *  디렉토리와 txt파일을 생성해보기
	 */

	public static void main(String[] args) throws Exception{
		File di = new File("C:\\Java2\\dif");
		File file = new File("C:\\Java2/file.txt");
		File uri = new File(new URI("file:///C:/Java2/uri.txt"));
		
		if(di.exists() == false) {di.mkdir();}
		if(file.exists() == false) {file.createNewFile();}
		if(uri.exists() == false) {uri.createNewFile();}
		
		File a = new File("C:\\Java2");
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd a HH:mm");
		
		File[] content = a.listFiles();
		
		for(File f : content) {
			System.out.println(dt.format(new Date(f.lastModified())));			
			if(f.isDirectory()) {
				System.out.println(f.getName());
			}else {
				System.out.println(f.length() + f.getName());
			}
		}
		
		
		
		
	}
}
