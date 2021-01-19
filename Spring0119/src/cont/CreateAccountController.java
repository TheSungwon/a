package cont;

import javax.servlet.http.HttpServletRequest;

import mod.Address;
import mod.MemberInfo;
import vali.MemberInfoValidator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account/create.do")
public class CreateAccountController {
	
	@ModelAttribute("bean")
	public MemberInfo formBacking(HttpServletRequest req) {
		
		if(req.getMethod().equalsIgnoreCase("GET")) {
			MemberInfo mi = new MemberInfo();
			Address address = new Address();
			address.setZipcode(autoZip(req.getRemoteAddr()));
			mi.setAddress(address);
			return mi;
		}else {
			return new MemberInfo();
		}
	}

	
	private String autoZip(String remoteAddr) {
		return "0";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "account/creationForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("bean") MemberInfo memberInfo, BindingResult result) {
		new MemberInfoValidator().validate(memberInfo, result);
		if(result.hasErrors()) {
			return "account/creationForm";
		}
		return "account/created";
	}
	
}
