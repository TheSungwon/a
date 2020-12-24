/*�ű� �׷� ��ȣ �������ش�.
 * ���ο� ��Ʈ �Խñ��� �ۼ��� ������ 1�� ������ �׷��ȣ�� ����������Ѵ�. �׷��ȣ�� �����Ҷ�
 * ����ϱ����� �뵵�� id_sequence���̺�����ߴ�. �� ���̺��� �̿��ؼ� �׷��ȣ�� �����Ҽ��ִ�
 * id_seqnece���̺��� next_value����. �� ���� �� ���(for update)
 *  	IdGeneratorŬ������ �׷��ȣ�� �������ִ� ������ �������ִ� �޼��带 ����
 *  sequenceName�Ķ���ʹ� ID�� ������ų �������̸��� �ǹ�, id_sequence���̺��� sequence_nameĮ����
 *  ���� ��Ī�ȴ�. IdGenerator�� generatorNextId()�޼���� ���ܸ� IdG~Exception���ܸ� �߻��ϹǷ�
 *  IdG~Ŭ���������� ����*/

package service_board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO_javaBean.ConnectionProvider;
import DTO_javaBean.jdbcUtil;
import Exception_board.IdGenerationFailedException;

public class IdGenerator {
	private static IdGenerator instance = new IdGenerator();
	public static IdGenerator getInstance() {
		return instance;
	}
	private IdGenerator() {}
	////////////////////////////////////////
	
	public int generateNextId(String sequenceName) throws IdGenerationFailedException{
		Connection conn = null;
		PreparedStatement psSel = null;
		PreparedStatement psUp = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			psSel = conn.prepareStatement("select next_value from id_sequence " +
			" where sequence_name=? for update");
			psSel.setString(1, sequenceName);
			
			rs = psSel.executeQuery();
			rs.next();
			int id = rs.getInt(1);
			//id_sequence���̺��� Ű �� 'article' �� ���� next_value�� ���Ѵ�.
			id++;
			//���� ���� 1 ������Ų��.
			
			psUp = conn.prepareStatement("update id_sequence set next_value =? " +
			" where sequence_name =?");
			psUp.setInt(1, id);
			psUp.setString(2, sequenceName);
			
			psUp.executeUpdate();
			//1������Ų ���� DB���̺� �ݿ��Ѵ�.
			conn.commit();
			
			return id; //���� ���� ����
			
			/* id_sequence���̺�
			 * insert into id_sequence values('article',0) �� ������ �����ߴ�.
			 * IdGeneratorŬ������ ����� ������ �� �������� sequence_nameĮ���� �Է���
			 * 'article' ���� ����ϸ� �ȴ�.
			 * int id = IdGenerator.getInstance().generatteNextId("article");*/
			
			
		}catch(SQLException e) {
			jdbcUtil.rollback(conn);
			throw new IdGenerationFailedException(e);
		}finally {
			if(conn != null) {
				try {
					conn.setAutoCommit(true);
				}catch(SQLException ex) {
					
				}
				jdbcUtil.close(conn);
			}
		}
	}

}
