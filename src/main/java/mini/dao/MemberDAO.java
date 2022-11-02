package mini.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import mini.common.Common;
// 은종
public class MemberDAO {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	// 로그인 체크 기능
	public int loginCheck(String id, String pwd) {
		int resState = 300; // 200은 로그인, 300은 Id없음, 400은 pwd 오류 => 이걸 정리한게 API문서
		try {
			conn = Common.getConnection();
			stmt = conn.createStatement(); // Statement 객체 얻기
			String sql = "SELECT * FROM MEM_TB WHERE ID = " + "'" + id + "'";
			rs = stmt.executeQuery(sql); // select문이니까 executeQuery
			
			// id없으면 진입불가
			while(rs.next()) { // 읽은 데이터가 있으면 true
				String sqlId = rs.getString("ID"); // 쿼리문 수행 결과에서 ID값을 가져 옴
				String sqlPwd = rs.getString("PASSWORD");
				
				System.out.println("ID : " + sqlId);
				System.out.println("PASSWORD : " + sqlPwd);
				
				if(id.equals(sqlId) && pwd.equals(sqlPwd)) {
					resState = 200; // 정상적으로 로그인
				} else {
					resState = 400; // pwd 틀림
				}
			}
			Common.close(rs);
			Common.close(stmt);
			Common.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return resState;
	}
	
	// ID 찾기 기능
	// 이메일이 일치하는 사람이 있다면 ID를 반환함!!!
	// 왜 이름으로 찾지 않아? => 이름은 중복될 수 있으니까
	// 왜 String타입이야? 참거짓이 아니라 id값 반환해야하니까!
	public String findID(String email) {
		String id = "NONE";
		try {
			conn = Common.getConnection();
			stmt = conn.createStatement(); // Statement 객체 얻기
			String sql = "SELECT * FROM MEM_TB WHERE EMAIL = " + "'" + email + "'";
			rs = stmt.executeQuery(sql); 
			
			while(rs.next()) {
				id = rs.getString("ID");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Common.close(rs);
		Common.close(stmt);
		Common.close(conn);
		return id; // id를 반환
	}
	
	// 비밀번호 찾기 기능
	// 왜 아이디로 찾아? => 중복되지 않는 값이니까
	public String findPWD(String id) {
		String pwd = "NONE";
		try {
			conn = Common.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM MEM_TB WHERE ID  = " + "'" + id + "'";
			rs = stmt.executeQuery(sql); // select니까 executeQuery
			
			// 이제 while문을 돌려서 비밀번호를 찾아라
			// 한 행 한 행 찾아다녀!
			while(rs.next()) {
				pwd = rs.getString("PASSWORD");
			}
		} catch (Exception e) {
			e.printStackTrace(); // 예외처리(에러날 경우 에러 원인 맨 위에 출력)
		}
		// 결과 받았으면 차례대로 다시 닫아줌
		Common.close(rs);
		Common.close(stmt);
		Common.close(conn); 
		return pwd; // 비밀번호 반환
	}
	
	
	
}
