package sp1;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HiController {
	
	@RequestMapping("/hi.do")
	public ModelAndView hi() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hi");
		mav.addObject("greeting", getGreeting());
		return mav;
	}
	
	
	private String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		if(hour >= 6 && hour <= 10) {
			return "Á¶Àº¾ÆÄ§";
			
		}else if(hour >= 12 && hour <= 15) {
			return "½Ä»ç ÇÏ¼Ì³ª¿ä";
			
		}else if(hour >= 18 && hour <= 22) {
			return "ÁÁÀº ¹ã";
			
		}
		return "¾È³ç";
	}
	
}
