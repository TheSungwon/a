package soldesk.logon;

import java.sql.*;

public class LogonDBBean {
	//SingleTon Pattern
	private static LogonDBBean instance = new LogonDBBean();
   
    public static LogonDBBean getInstance() {
        return instance;
    }
   
    private LogonDBBean() {
    }
   
    private Connection getConnection() throws Exception {
    	String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";        
    	return DriverManager.getConnection(jdbcDriver);
    }
    //inputPro.jsp에서 회원가입을 할때 사용.
    public void insertMember(LogonDataBean member) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
       
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
            "insert into MEMBERS values (?,?,?,?,?,?,?,?)");
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPasswd());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getJumin1());
            pstmt.setString(5, member.getJumin2());
            pstmt.setString(6, member.getEmail());
            pstmt.setString(7, member.getBlog());
            pstmt.setTimestamp(8, member.getReg_date());

            pstmt.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
    //loginPro.jsp에서 로그온을 시도할때 호출.
    public int userCheck(String id, String passwd) throws Exception { //id passwd를 받아서 int로 리턴. 1, 0 -1리턴하게만든다.
        Connection conn = null;
        PreparedStatement pstmt = null;    
        ResultSet rs= null;
        String dbpasswd="";
        int x=-1;
        
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
            "select passwd from MEMBERS where id = ?");
            pstmt.setString(1, id);
            rs= pstmt.executeQuery();

            if(rs.next()){
				dbpasswd= rs.getString("passwd");
				if(dbpasswd.equals(passwd))
					x= 1; //인증 성공
				else
					x= 0; //비밀번호 틀림 아이디만 맞으므로
			}else
					x= -1;//해당 아이디 없음

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
        	if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return x;
	}
    //confirmId.jsp에서 ID을 체크할때 사용.
	public int confirmId(String id) throws Exception {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs= null;
	    String dbpasswd="";
	    int x=-1;
	       
	    try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement("select id from MEMBERS where id = ?");
            pstmt.setString(1, id);
            rs= pstmt.executeQuery();

			if(rs.next())
				x= 1; //해당 아이디 있음/ 해당아이디로 사용불가
			else
				x= -1;//해당 아이디 없음/ 해당아이디로 사용가능
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
        	if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
	return x;
	}
	
	//updateMember.jsp에서 수정폼에 가입된 회원의 정보를 보여줄때 사용.
    public LogonDataBean getMember(String id) throws Exception { 
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        LogonDataBean member=null;
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement("select * from MEMBERS where id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {	//수정 set메소드
                member = new LogonDataBean();
                member.setId(rs.getString("id"));
                member.setPasswd(rs.getString("passwd"));
                member.setName(rs.getString("name"));
                member.setJumin1(rs.getString("jumin1"));
                member.setJumin2(rs.getString("jumin2"));
                member.setEmail(rs.getString("email"));
                member.setBlog(rs.getString("blog"));
                member.setReg_date(rs.getTimestamp("reg_date"));    
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return member;
    }
   
    public void updateMember(LogonDataBean member) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
       
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
              "update MEMBERS set passwd=?,name=?,email=?,blog=? "+
              "where id=?");
            pstmt.setString(1, member.getPasswd());
            pstmt.setString(2, member.getName());
            pstmt.setString(3, member.getEmail());
            pstmt.setString(4, member.getBlog());
            pstmt.setString(5, member.getId());
           
            pstmt.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
   
    public int deleteMember(String id, String passwd) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        String dbpasswd="";
        int x=-1;
        
        try {
        	conn = getConnection();

            pstmt = conn.prepareStatement(
            "select passwd from MEMBERS where id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
           
			if(rs.next()){
				dbpasswd= rs.getString("passwd");
				if(dbpasswd.equals(passwd)){
					pstmt = conn.prepareStatement("delete from MEMBERS where id=?");
                    pstmt.setString(1, id);
                    pstmt.executeUpdate();
                    x= 1; //회원탈퇴 성공
				}else
					x= 0; //비밀번호 틀림
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return x;
    }
}