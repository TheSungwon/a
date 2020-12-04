<!-- 
트랜잭션을 이용해서 한 개 이상의 쿼리를 마치 한 개의 쿼리처럼 처리한다
트랜잭션은 시작과 종료를 갖고있다. 트랜잭션 시작 이후로 실행되는
쿼리결과는 dbms에 바로반영되지않고 임시보관. 이후 커밋하면
임시로 보관된 모든 쿼리결과가 실제데이터에 반영 -->

<%@ page contentType="text/html; charset=euc-kr"%>

<%@ page import = "java.sql.DriverManager"%>
<%@ page import = "java.sql.Connection"%>
<%@ page import = "java.sql.PreparedStatement"%>
<%@ page import = "java.sql.SQLException"%>

<%
	String idValue = request.getParameter("id"); //...?

	Connection conn= null;
	PreparedStatement ps1=null;
	PreparedStatement ps2=null;
	
	String jdbc="jdbc:oracle:thin:@localhost:1521:XE";
	String user="ezen";
	String pass="oracle";
	
	Throwable occuredException = null; //예외처리 최상위..?
			
		try{
			int id = Integer.parseInt(idValue); //..?
			
			conn =DriverManager.getConnection(jdbc, user, pass);
			conn.setAutoCommit(false); //트랜잭션 시작
			
			ps1 = conn.prepareStatement("insert into item values (?,?)");
			ps1.setInt(1, id);
			ps1.setString(2, "상품이름"+id);
			ps1.executeUpdate();
			
			if(request.getParameter("error") != null){
				throw new Exception("의도적 예외발생");
		}
			
			ps2 = conn.prepareStatement("insert into item_detail values (?,?)");
			ps2.setInt(1, id);
			ps2.setString(2, "상세설명"+id);
			ps2.executeUpdate();
	
	
			conn.commit(); //트랜잭션커밋
			
		}catch(Throwable e){
			if(conn != null){
				try{
					conn.rollback(); //예외발생할경우 롤백. 발생한예외를 occu~E에 할당
				}catch(SQLException ex){}
			}
			occuredException = e;
			
			}finally{
				if(ps1 != null)
					try{ps1.close();} catch(SQLException ex){}
				if(ps2 != null)
					try{ps2.close();} catch(SQLException ex){}
				if(conn != null)
					try{conn.close();} catch(SQLException ex){}
				
		}
	
%>

<html>
<head><title> item값입력</title></head>

<body>

<% if (occuredException != null) { //occ~E 가 null값이 아니면 예외발생
		out.println(occuredException.getMessage());
	}else{
		out.println("데이터가 성공적으로 들어감");
	}
%>




</body>
</html>