package mini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import mini.common.Common;

// 도연 - 아이디 중복확인

public class IdCheckDAO {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null; // sql문을 미리 컴파일해서 재사용 => Statement 인터페이스보다 훨씬 빠름
	
	
	public boolean IdCheck(String id) {
		boolean isNotReg = false; // 기본 값이 false(가입된 경우)
		try {
			conn = Common.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM MEM_TB WHERE ID = " + "'" + id +"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) isNotReg = false; // 가입된 경우
			else isNotReg = true; // 가입 안된 경우
		} catch(Exception e) {
			e.printStackTrace();
		}
		Common.close(rs);
		Common.close(stmt);
		Common.close(conn);
		return isNotReg; // 가입 되어 있으면 false, 가입이 안되어 있으면 true
	}

}
