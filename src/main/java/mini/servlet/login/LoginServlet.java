package mini.servlet.login;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import mini.common.Common;
import mini.dao.MemberDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Common.corsResSet(response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 방지를 위해서 설정
		Common.corsResSet(response); // CORS 접근 허용 : 교차 출처 리소스 공유
		StringBuffer sb = Common.reqStringBuff(request); // 요청 메시지 받기
		JSONObject jsonObj = Common.getJsonObj(sb); // 요청 받은 메시지 JSON 파싱
		
		String getId = (String)jsonObj.get("id");
		String getPwd = (String)jsonObj.get("pwd");
		
		MemberDAO dao = new MemberDAO();
		boolean isRegister = dao.loginCheck(getId, getPwd);
		
		PrintWriter out = response.getWriter();
		JSONObject resJson = new JSONObject();
		
		if(isRegister) resJson.put("result", "OK"); 
		else resJson.put("result", "NOPPP!!");
		out.print(resJson);		
	}
}
