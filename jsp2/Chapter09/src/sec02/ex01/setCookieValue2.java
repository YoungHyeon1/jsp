package sec02.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

/**
 * Servlet implementation class setCookieValue
 */
@WebServlet("/set2")
public class setCookieValue2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Date d = new Date();
		
		Cookie c = new Cookie("cookieTest", URLEncoder.encode("JSP Programming", "utf-8"));
		//브라우저 종료시 쿠키 삭
		c.setMaxAge(-1);
		
		response.addCookie(c);
		out.println("현재시간: "+ d);
		out.println("<br> 문자열을 cookie에 저장합니다.");
		
	}

}
