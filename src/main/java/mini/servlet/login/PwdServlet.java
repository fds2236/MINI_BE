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

@WebServlet("/PwdServlet")
public class PwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Common.corsResSet(response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 방지를 위해서 설정
		Common.corsResSet(response); // CORS 접근 허용 : 교차 출처 리소스 공유
		StringBuffer sb = Common.reqStringBuff(request); // 요청 메시지 받기
		JSONObject jsonObj = Common.getJsonObj(sb); // 요청 받은 메시지 JSON 파싱
		
		String getId = (String)jsonObj.get("id");
		
		MemberDAO dao = new MemberDAO();
		String resPwd = dao.findPWD(getId);
		System.out.println("resPwd : " + resPwd); // 비밀번호 출력
		
		// 이제 뭐해줘야 해? => 서블릿 응답!
		PrintWriter out = response.getWriter();
		JSONObject resJson = new JSONObject(); // json객체에 담아
		
		if(resPwd.equals("NONE")) resJson.put("result", "NOK");
		else {
			resJson.put("result", "OK");
			resJson.put("pwd", resPwd);
		}
		out.print(resJson);
	}
}
