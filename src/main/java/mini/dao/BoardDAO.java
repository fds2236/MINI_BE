package mini.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mini.common.Common;
import mini.vo.MemberVO;

public class BoardDAO {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	
	
	
	
	
	public List<MemberVO> memberSelect() {
		List<MemberVO> list = new ArrayList<>();
		try {
			conn = Common.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM BOARD";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Integer docNum = rs.getInt("DOC_NUM");
				Integer category = rs.getInt("CATEGORY");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String id = rs.getString("ID");
				Date writeDate = rs.getDate("WRITE_DATE");
				
				MemberVO vo = new MemberVO();
				
				vo.setBoardNum(docNum);
				vo.setCategory(category);
				vo.setTitle(title);
				vo.setBoardContent(content);
				vo.setId(id);
				vo.setBoardDate(writeDate);
				list.add(vo);
			}
			Common.close(rs);
			Common.close(stmt);
			Common.close(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
	
	
	
	// 게시글 가져오기 기능
	// 게시글 고유번호로 찾기
	// 정보가 많으니 배열로 반환?
	// void로 만들어서 각자 set을 해준다 
	public void findBoard (Integer boardNum) {
		
		try {
			conn = Common.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM BOARD WHERE DOC_NUM = "+ boardNum;
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	

	
	
	
}
