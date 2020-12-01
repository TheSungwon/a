package javaCookie;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class javaCookieBox {
		/*
		 * resoponse.addCOokie()로 추가되는 쿠키는 실제로 set-cookie헤더를 통해서 전달된다 한 개의 set-cookie헤더는
		 * 한 개의 쿠키 값이 전달. 출력버퍼에 저장되어 있는 내용이 플러시 되어 웹 브라우저에 데이터가 전송되면 그 다음 부터는 응답 헤더에 새로운
		 * 값ㅇ르 추가할 수 없다고 했던 것을 기억 쿠키는 응답 헤더 형태로 웹 브라우저에 전달. 쿠키역시 출력버퍼가 플러시 된 이후 새롭게 추가
		 * 붉가. 따라서 쿠키의 추가 및 변경은 반드시 출력 버퍼가 플러시 되기 전에 처리해줘야함
		 */
//		쿠키목록을 가져와서 if esle블록에서 쿠키 이름을 비교해서 필요한 쿠키를
		//구하는	보조 유틸리티 클래스 // 쿠키박스
		
	
		private Map<String, Cookie> cookieMap = //private
				new HashMap<>();
		//쿠키를 (쿠키이름, cookie객체>쌍 형태로 저장하는 맵. generic
		
		public javaCookieBox(HttpServletRequest request) {
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for(int i=0; i<cookies.length; i++){
					cookieMap.put(cookies[i].getName(),cookies[i]);
				}
			}
		}//클래스생성자. 클래스 객채를 생성할 때 사용. 인자로 전달받은 request로부터
		//cookie배열을 읽어와[16라인 각각cookie객체를 [23라인에서 선언한 cookieMap에 저장 [라인31

		
		public static Cookie createCookies(String name, String value)
		throws IOException {
			return new Cookie(name, URLEncoder.encode(value, "euc-kr"));
		}//이름이 name이고 값이 value인 객체를 생성해 리턴
		
		public static Cookie createCookies(String name, String value, String path, int maxAge)
				throws IOException {
					Cookie cookie = new Cookie(name, URLEncoder.encode(value, "euc-kr"));
					cookie.setPath(path);
					cookie.setMaxAge(maxAge);
					return cookie;
		}//이름이name 값이value 경로가path 유효시간maxAge인 cookie객체를 생성해서 리턴
					
		public static Cookie createCookies(String name, String value, String path, int maxAge, String domain)
				throws IOException {
					Cookie cookie = new Cookie(name, URLEncoder.encode(value, "euc-kr"));
					cookie.setPath(path);
					cookie.setMaxAge(maxAge);
					cookie.setDomain(domain);
					return cookie;				
		}
		
		public Cookie getCookie(String name) {
			return cookieMap.get(name);
			
		}//cookieMap에 저장된 쿠키에서 지정한 이름의cookie객체를 구한다.
		//지정한 이름의 쿠키가 존재하지 않으면 null을 리턴
		
		public String getValue(String name) throws IOException{
			Cookie cookie = cookieMap.get(name);
			if(cookie == null) {
				return null;
			}
			return URLDecoder.decode(cookie.getValue(),"euc-kr");
		}//cookieMapo에 저장된 쿠키에서 지정한 이름이 cookie객체를 구한후
		//그 cookie객체의 값을 구한다.지정한 이름의 쿠키가 존재하지않으면 null리턴
		
		public boolean exists(String name) {
			return cookieMap.get(name) != null;
		}//지정한 이름의 cookie가 존재할 경우 true 아니면 false를 리턴
		//지정한 이름의 쿠키가 존재하지 않으면 null리턴
		
		
		
		
		
		
}
