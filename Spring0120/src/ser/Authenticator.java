package ser;

public interface Authenticator { //인증하는사람?
	
	void authenticate(LoginCommand login)
	throws AuthenticationException;

}
