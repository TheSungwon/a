package vali;

import ser.LoginCommand;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginCommandValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> arg0) {
		
		return LoginCommand.class.isAssignableFrom(arg0);
	}
	
	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "userId", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "password", "required");
	}

}
