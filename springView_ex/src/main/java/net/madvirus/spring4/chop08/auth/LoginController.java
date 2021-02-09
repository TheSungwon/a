package net.madvirus.spring4.chop08.auth;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth/login")
public class LoginController {
	
	private static final String LOING_FROM = "auth/loginForm";
	private Authenticator authenticator;
	
	@ModelAttribute("loginTypes")
	protected List<String> referenceDate(){
		List<String> loginTypes = new ArrayList<String>();
		loginTypes.add("cc");
		loginTypes.add("bb");
		loginTypes.add("aa");
		return loginTypes ;
		
	}
	
	@RequestMapping(method=RequestMethod.GET )
	public String loginFrom(LoginCommand loginCommand) {
		loginCommand.setSecurityLevel(SecurityLevel.HIGH);
		return LOING_FROM;
	}
	
	@RequestMapping(method =RequestMethod.POST)
	public String login(@Valid LoginCommand loginCommand, Errors errors, HttpServletRequest req	) {
		if(errors.hasErrors()) {
			return LOING_FROM;
		}
		try {
			Auth auth = authenticator.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
			HttpSession session = req.getSession();
			session.setAttribute("auth", auth);
			return "redirect:/index.jsp";
					
		}catch(AuthenticationException e) {
			errors.reject("invalidIdOrPassword");
			return LOING_FROM; //login form
		}
	}
	@InitBinder
	protected void initBinder(WebDataBinder binder	) {
		binder.setValidator(new); //LoginCommandValidator»ý¼º
	}
	

}
