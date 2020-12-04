<!-- 
Ʈ������� �̿��ؼ� �� �� �̻��� ������ ��ġ �� ���� ����ó�� ó���Ѵ�
Ʈ������� ���۰� ���Ḧ �����ִ�. Ʈ����� ���� ���ķ� ����Ǵ�
��������� dbms�� �ٷιݿ������ʰ� �ӽú���. ���� Ŀ���ϸ�
�ӽ÷� ������ ��� ��������� ���������Ϳ� �ݿ� -->

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
	
	Throwable occuredException = null; //����ó�� �ֻ���..?
			
		try{
			int id = Integer.parseInt(idValue); //..?
			
			conn =DriverManager.getConnection(jdbc, user, pass);
			conn.setAutoCommit(false); //Ʈ����� ����
			
			ps1 = conn.prepareStatement("insert into item values (?,?)");
			ps1.setInt(1, id);
			ps1.setString(2, "��ǰ�̸�"+id);
			ps1.executeUpdate();
			
			if(request.getParameter("error") != null){
				throw new Exception("�ǵ��� ���ܹ߻�");
		}
			
			ps2 = conn.prepareStatement("insert into item_detail values (?,?)");
			ps2.setInt(1, id);
			ps2.setString(2, "�󼼼���"+id);
			ps2.executeUpdate();
	
	
			conn.commit(); //Ʈ�����Ŀ��
			
		}catch(Throwable e){
			if(conn != null){
				try{
					conn.rollback(); //���ܹ߻��Ұ�� �ѹ�. �߻��ѿ��ܸ� occu~E�� �Ҵ�
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
<head><title> item���Է�</title></head>

<body>

<% if (occuredException != null) { //occ~E �� null���� �ƴϸ� ���ܹ߻�
		out.println(occuredException.getMessage());
	}else{
		out.println("�����Ͱ� ���������� ��");
	}
%>




</body>
</html>