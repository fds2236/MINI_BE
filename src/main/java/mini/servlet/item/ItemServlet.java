package mini.servlet.item;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import mini.common.Common;
import mini.dao.ItemDAO;
import mini.vo.ItemVO;

@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	// CORS 처리
	protected void doOptions(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Common.corsResSet(response);
	}
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Common.corsResSet(response);
		StringBuffer sb = Common.reqStringBuff(request);
		JSONObject jsonObj = Common.getJsonObj(sb);

		String reqCmd = (String)jsonObj.get("cmd");
		String reqBrand = (String)jsonObj.get("brand");
		PrintWriter out = response.getWriter();
		if(!reqCmd.equals("ItemInfo")) { // ItemInfo와 값이 다르면 NOT OK
			JSONObject resJson = new JSONObject();
			resJson.put("result", "NOK");
			out.print(resJson);
			return;
		}
		
		ItemDAO dao = new ItemDAO();
		List<ItemVO> list = dao.itemSelect(reqBrand);
		// 브랜드만 받아오기
		
		JSONArray itemArray = new JSONArray();
		for (ItemVO e : list) {
			JSONObject itemInfo = new JSONObject();
			itemInfo.put("PRO_CODE", e.getProCode()); 
			itemInfo.put("BRAND", e.getBrand());
			itemInfo.put("PRO_NAME", e.getProName());
			
			NumberFormat numberFormat = NumberFormat.getInstance();
			String numToStr = numberFormat.format(e.getPrice());
			itemInfo.put("PRICE", numToStr);
			
			DateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd");
			String dateToStr = dateFormat.format(e.getLaunDate());
			itemInfo.put("LAUN_DATE", dateToStr);
			itemArray.add(itemInfo);
		}
		System.out.println(itemArray);
		out.print(itemArray);
		
	}

}
