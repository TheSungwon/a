package ser;

public interface Authenticator { //�����ϴ»��?
	
	void authenticate(LoginCommand login)
	throws AuthenticationException;

}
