package vali;

import mod.Address;
import mod.MemberInfo;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MemberInfoValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return MemberInfo.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		MemberInfo mf = (MemberInfo) target;
		if(mf.getId() == null || mf.getId().trim().isEmpty()) {
			errors.rejectValue("id", "required");
			
		}
		if(mf.getName() == null || mf.getName().trim().isEmpty()) {
			errors.rejectValue("name", "required");
			
		}
		
		Address ad = mf.getAddress();
		if(ad == null) {
			errors.rejectValue("address", "required");
		}
		
		if(ad != null) {
			errors.pushNestedPath("address");
			try {
				if(ad.getZipcode() == null || ad.getZipcode().trim().isEmpty()) {
					errors.rejectValue("zipcode", "required");
					
				}
				
				if(ad.getAddress1() == null || ad.getAddress1().trim().isEmpty()) {
					errors.rejectValue("address1", "required");
				}
			}finally{
				errors.popNestedPath();
			}
		}
		
		
	}

}
