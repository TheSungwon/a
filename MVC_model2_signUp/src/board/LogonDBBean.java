package board;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
public class LogonDBBean {

	//싱글톤패턴
	private static LogonDBBean instance = new LogonDBBean();
	
	public static LogonDBBean getInstance() {
		return instance;
	}
	
	private  LogonDBBean() {
		
	}
	
	private Connection getConnection() throws Exception{
		String j = "jdbc:apache:commons:dbcp:/connectionPool";
		return DriverManager.getConnection(j);
		
	}
	//inputPro 회원가입할때사용
	public void insertMember(LogonDataBean member) throws Exception{
		Connection conn=null;
		PreparedStatement ps = null;
		try {
			conn=getConnection();
			ps=conn.prepareStatement("insert into members values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, member.getId());
            ps.setString(2, member.getPasswd());
            ps.setString(3, member.getName());
            ps.setString(4, member.getJumin1());
            ps.setString(5, member.getJumin2());
            ps.setString(6, member.getEmail());
            ps.setString(7, member.getBlog());
            ps.setTimestamp(8, member.getReg_date());
            ps.setString(9, member.getZipcode());
            ps.setString(10, member.getAddress());
            ps.executeUpdate();
            
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps !=null)try {ps.close();} catch(SQLException e) {}
			if(conn !=null)try {conn.close();} catch(SQLException e) {}
		}
	}
	
	//로그온 시도때 호출 loginPro
	public int userCheck(String id, String passwd) throws Exception {
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		String dbpass="";
		int x = -1;
		try {
			conn=getConnection();
			ps=conn.prepareStatement("select passwd from members where id=?");
			ps.setString(1, id);
			rs=ps.executeQuery();
			
		if(rs.next()) { dbpass=rs.getString("passwd");
		if(dbpass.equals(passwd))
			x=1; //인증성공
		else x=0;//비번틀림
		} else x=-1;//아이디없음
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		if(ps !=null)try {ps.close();} catch(SQLException e) {}
		if(conn !=null)try {conn.close();} catch(SQLException e) {}
		if(rs !=null)try {rs.close();} catch(SQLException e) {}
	}
		return x;
}
	//id체크 confirmId
	public int confirmId(String id )throws Exception {
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String dbpass = "";
		int x=-1;
		
		try {
			conn=getConnection();
			ps=conn.prepareStatement("select id from members where id=?");
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next())
			x=1;
			else x=-1;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps !=null)try {ps.close();} catch(SQLException e) {}
			if(conn !=null)try {conn.close();} catch(SQLException e) {}
			if(rs !=null)try {rs.close();} catch(SQLException e) {}
		}
		return x;
		}
	//수정폼에서 회원정보 보여줄때 updateMember
	public LogonDataBean getMember(String id)throws Exception{
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LogonDataBean member = null;
		try { 
			conn = getConnection();
			
			ps = conn.prepareStatement("select * from members where id =?");
			ps.setString(1, id);
			rs=ps.executeQuery();
					
			if(rs.next()) {
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
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps !=null)try {ps.close();} catch(SQLException e) {}
			if(conn !=null)try {conn.close();} catch(SQLException e) {}
			if(rs !=null)try {rs.close();} catch(SQLException e) {}
		}
		return member;
	}
	public void updateMember(LogonDataBean member) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try { conn=getConnection();
		ps=conn.prepareStatement("update members set passwd=?, name=?, email=?, blog=? where id = ?");
		ps.setString(1, member.getPasswd());
        ps.setString(2, member.getName());
        ps.setString(3, member.getEmail());
        ps.setString(4, member.getBlog());
        ps.setString(5, member.getId());
        ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps !=null)try {ps.close();} catch(SQLException e) {}
			if(conn !=null)try {conn.close();} catch(SQLException e) {}
	}

	}
	public int deleteMember(String id, String passwd) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String dbpass = "";
		int x = -1;
		
		try { conn=getConnection();
		ps=conn.prepareStatement("select passwd from members where id=?");
		ps.setString(1, id);
		rs=ps.executeQuery();
		if(rs.next()) {
			dbpass = rs.getString("passwd");
			if(dbpass.equals(passwd)) {
				ps=conn.prepareStatement("delete from members where id=?");
				ps.setString(1, id);
				ps.executeUpdate();
				x=1;
			}else x=0;
		}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps !=null)try {ps.close();} catch(SQLException e) {}
			if(conn !=null)try {conn.close();} catch(SQLException e) {}
			if(rs !=null)try {rs.close();} catch(SQLException e) {}
		}
		return x;
	}
	
//	zipcode
	public Vector zipcodeRead(String area3) {
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector vec = new Vector();
		
		try {
			conn = getConnection();
			String a = "select * from zipcode where area3 like '"+area3+"%'";
			ps = conn.prepareStatement(a);
			rs = ps.executeQuery();
			while(rs.next()) {
				ZipcodeBean tempZ = new ZipcodeBean();
				tempZ.setZipcode(rs.getString("zipcode"));
				tempZ.setArea1(rs.getString("area1"));
				tempZ.setArea2(rs.getString("area2"));
				tempZ.setArea3(rs.getString("area3"));
				tempZ.setArea4(rs.getString("area4"));
				vec.addElement(tempZ);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps !=null)try {ps.close();} catch(SQLException e) {}
			if(conn !=null)try {conn.close();} catch(SQLException e) {}
			if(rs !=null)try {rs.close();} catch(SQLException e) {}
		}
		return vec;
	}
	
	
	///////////////////회원리스트
	public LogonDataBean getMemberList(String id )throws Exception{
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LogonDataBean member = null;
		try { 
			conn = getConnection();
			
			ps = conn.prepareStatement("select * from members where id =?");
			ps.setString(1, id);
			rs=ps.executeQuery();
					
			if(rs.next()) {
				 member = new LogonDataBean();
	                member.setId(rs.getString("id"));
	                member.setPasswd(rs.getString("passwd"));
	                member.setName(rs.getString("name"));
	                member.setJumin1(rs.getString("jumin1"));
	                member.setJumin2(rs.getString("jumin2"));
	                member.setEmail(rs.getString("email"));
	                member.setBlog(rs.getString("blog"));
	                member.setReg_date(rs.getTimestamp("reg_date")); 
	                member.setZipcode(rs.getString("zipcode"));
	                member.setAddress(rs.getNString("address"));
	                
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps !=null)try {ps.close();} catch(SQLException e) {}
			if(conn !=null)try {conn.close();} catch(SQLException e) {}
			if(rs !=null)try {rs.close();} catch(SQLException e) {}
		}
		return member;
	}
}
