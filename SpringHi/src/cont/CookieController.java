package cont;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	
	@RequestMapping("/cookie/make.do")
	public String make(HttpServletResponse res) {
		res.addCookie(new Cookie("au", "1"));
		return "cookie/made";
	}
	
	@RequestMapping("cookie/view.do")
	public String view(
			@CookieValue(value = "au", defaultValue="0")String au) {
		System.out.println("ÄíÅ°....."+au);
		return "cookie//view";
	}
	

}
