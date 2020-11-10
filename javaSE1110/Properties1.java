package javaSE1110;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Properties;

public class Properties1 {
	//Properties 는 Hashtable의 하위 클래스 이므로 모든 특징을 가지고 있다. 차이점은 키와 값을 String타입으로 제한한 컬렉션
	//애플리케이션의 옵션 정보, 데이터베이스 연결 정보 그리고 국제화(다국어) 정보가 저장된 프로퍼티(~.properties)파일을 읽을 때 주로 사용
	//프로퍼티 파일을 읽기 위해서 properties 객체 생성하고 load()메소드를 호출 .이 메소드는 프로퍼티 파일로부터 데이터를 읽기 위해
	//FileReader 객체를 매개값으로 받는다.
	//Properties properties = new Properties ();
	//properties .load(new FileReader("C:/~/database.properties"));
	//									---------파일경로-------
	//프로퍼티 파일은 일반적으로 ~.class 파일과 함께 저장. 클래스파일을 기준으로 프로퍼티의 경로를 얻으려면 Class의 getResource()메소드를 이용
	//이 메소드는 주어진 파일의 상대 경로를 URL객체로 리턴. URL의 getPath()는 파일의 절대 경로를 리턴
	//Properties 객체에서 해당 키의 값을 읽으려면 getProperty()메소드를 이용. properties도 Map 컬렉션이므로 get()메소드로 값을 얻을수있다
	//그러나 get()메소드는 값을 Object타입으로 리턴하므로 강제타입변환해서 String을 얻어야하기에 일반적으로 getProperty()메소드를 이용
	
	public static void main(String[] args) throws Exception {
		Properties a = new Properties();
		String path = Properties1.class.getResource("database.properties").getPath();
		path = URLDecoder.decode(path,"utf-8"); //한글변환
		a.load(new FileReader(path));
		
		String driver = a.getProperty("driver");
		String url = a.getProperty("url");
		//String username, String password
		
		System.out.println(driver);
		System.out.println(url);
		//System.out.println(username);
		//System.out.println(password);
	}
}
