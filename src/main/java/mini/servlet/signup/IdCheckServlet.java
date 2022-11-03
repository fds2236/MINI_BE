package mini.servlet.signup;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import mini.common.Common;
import mini.dao.IdCheckDAO;
import mini.dao.MemberDAO;

// 도연 - 아이디 중복확인

@WebServlet("/IdCheckServlet")
public class IdCheckServlet extends HttpServlet {
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
		  IdCheckDAO dao = new IdCheckDAO();
 
		  boolean isNotReg = dao.IdCheck(getId); // isNotReg = TRUE 가입 안된 경우
		  
		 
		  PrintWriter out = response.getWriter();
		  JSONObject resJson = new JSONObject();
		
		  if(isNotReg) resJson.put("result", "OK"); // 가입 안되어 있으면 OK
		  else resJson.put("result", "NOK"); // 가입되어 있으면 NOK
		  out.print(resJson);
		}
	}


