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
import mini.dao.MemberDAO;
import mini.dao.SignUpDAO;


//도연 작업중

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.getWriter().append("Served at: ").append(request.getContextPath());
   }
   
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
      String getPwdCheck = (String)jsonObj.get("pwdCheck");
      String getMemName = (String)jsonObj.get("memName");
      String getEmail = (String)jsonObj.get("email");
      String getEmailName = (String)jsonObj.get("emailName");
      String getPhone1 = (String)jsonObj.get("phone1");
      String getPhone2 = (String)jsonObj.get("phone2");
      String getPhone3 = (String)jsonObj.get("phone3");
      String getPhoneNum = (String)jsonObj.get("phoneNum");
      String getAddrNum = (String)jsonObj.get("addrNum");
      String getAddr1 = (String)jsonObj.get("addr1");
      String getAddr2 = (String)jsonObj.get("addr2");
      String getRegDate = (String)jsonObj.get("regDate");
      
      SignUpDAO dao = new SignUpDAO();
      boolean rstComplete = dao.memberRegister(getId, getPwd, getPwdCheck, getMemName, getEmail, getEmailName, getPhone1, getPhone2, getPhone3, getPhoneNum, getAddrNum, getAddr1, getAddr2, getRegDate ); // memberRegister : DAO라는 객체에 있는 메소드(MemberDAO 파일에 메소드 만들어야 함)
   
      PrintWriter out = response.getWriter(); 
      JSONObject resJson = new JSONObject();
      if(rstComplete) resJson.put("result", "OK");
      else resJson.put("result", "NOK");
      out.print(resJson);
      
      
      
      
   }
}