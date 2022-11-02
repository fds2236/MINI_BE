package mini.servlet.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import mini.common.Common;

@WebServlet("/RePwdServlet")
public class RePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Common.corsResSet(response); // CORS 접근 허용
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 방지를 위해서 설정
		Common.corsResSet(response); // CORS 접근 허용 : 교차 출처 리소스 공유
		StringBuffer sb = Common.reqStringBuff(request); // 요청 메시지 받기
		JSONObject jsonObj = Common.getJsonObj(sb); // 요청 받은 메시지 JSON 파싱
		
		
	}
}
