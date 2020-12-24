/*신규 그룹 번호 생성해준다.
 * 새로운 루트 게시글이 작성될 때마다 1씩 증가된 그룹번호를 생성해줘야한다. 그룹번호를 생성할때
 * 사용하기위한 용도로 id_sequence테이블생성했다. 이 테이블을 이용해서 그룹번호를 생성할수있다
 * id_seqnece테이블에서 next_value구함. 행 단위 락 사용(for update)
 *  	IdGenerator클래스는 그룹번호를 생성해주는 로직을 실행해주는 메서드를 제공
 *  sequenceName파라미터는 ID를 증가시킬 시퀀스이름을 의미, id_sequence테이블의 sequence_name칼럼의
 *  값과 매칭된다. IdGenerator의 generatorNextId()메서드는 예외를 IdG~Exception예외를 발생하므로
 *  IdG~클래스파일을 생성*/

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
			//id_sequence테이블에서 키 값 'article' 인 행의 next_value를 구한다.
			id++;
			//구한 값을 1 증가시킨다.
			
			psUp = conn.prepareStatement("update id_sequence set next_value =? " +
			" where sequence_name =?");
			psUp.setInt(1, id);
			psUp.setString(2, sequenceName);
			
			psUp.executeUpdate();
			//1증가시킨 값을 DB테이블에 반영한다.
			conn.commit();
			
			return id; //구한 값을 리턴
			
			/* id_sequence테이블에
			 * insert into id_sequence values('article',0) 의 쿼리를 삽입했다.
			 * IdGenerator클래스를 사용할 때에는 위 쿼리에서 sequence_name칼럼에 입력한
			 * 'article' 값을 사용하면 된다.
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
