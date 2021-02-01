package spring.di.chap2.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.di.chap2.AuthException;
import spring.di.chap2.AuthenticationService;
import spring.di.chap2.PasswordChangeService;
import spring.di.chap2.UserNotFoundException;

public class mainByXml {
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:config.xml");
		
		AuthenticationService authSvc = ctx.getBean("authenticationService",AuthenticationService.class);
		
		runAuthAndCathchAuthEx(authSvc, "bkchoi", "11");
		runAuthAndCathchAuthEx(authSvc, "bkchoi", "111");
		runAuthAndCathchAuthEx(authSvc, "bkchoi", "1111");
		
		try {
			authSvc.authenticate("bkchoi2", "1111");
		}catch(UserNotFoundException e	) {
			
		}
		
		authSvc.authenticate("bkchoi", "1234");
		PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
		runAuthAndCathchAuthEx(authSvc, "bkchoi", "1234");
		authSvc.authenticate("bkchoi", "5678");
		ctx.close();
		
	}
	
	private static void runAuthAndCathchAuthEx(
			AuthenticationService authSvc, String userId, String password) {
		try {
			authSvc.authenticate(userId, password);
		}catch(AuthException e	) {
			
		}
	}

}
