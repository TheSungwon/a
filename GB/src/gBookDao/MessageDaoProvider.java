package gBookDao;

public class MessageDaoProvider {	//설정한dbms타입에 따라 알맞은 messageDao객체 제공

	
	private static MessageDaoProvider instance = new MessageDaoProvider();
	
	public static MessageDaoProvider getInstance() {
		return instance;
	}
	private MessageDaoProvider() {}


	
	private OracleMessageDao oracleDao = new OracleMessageDao();
	
	private String dbms;
	
	void setDbms(String dbms) {
		this.dbms =dbms;
	}
	
	public MessageDao getMessageDao() {
		if("oracle".equals(dbms)) {
			return oracleDao;
		}
		return null;
	}
	
}
