package ser;

import comm.CommonLogger;


public class MockAuthenticator implements Authenticator{
	
	private CommonLogger logger;
	
	@Override
	public void authenticate(LoginCommand login) throws AuthenticationException {
		
		if(!login.getUserId().equals(login.getPassword())){
			logger.log("��������----"+login.getUserId());
			throw new AuthenticationException();
		}
	}
	
	public void setCommonLogger(CommonLogger logger) {
		this.logger = logger;
	}

}
