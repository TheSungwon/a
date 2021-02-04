package spring4.mvc.chap7.quickStart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	public String hell(Model model) {
		model.addAttribute("gre","����");
		return "hello";
	}

}
