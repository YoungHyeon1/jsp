package sec04.ex01;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginTest
 */
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init method call");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		System.out.println("아이디 "+ id);
		System.out.println("패스워 "+ pw);
		
		if(id != null &&(id.length() != 0))
		{
			out.print("<html>");
			out.print("<body>");
			out.print(id+ " 님!! 로그인 하셨습니다.");
			out.print("</body>");
			out.print("</html>");

		}else {
			out.print("<html>");
			out.print("<body>");
			out.print("아이디를 입력하세요!!!");
			out.print("<br>");
			out.print("<a href='http://localhost:8081/pro06/test01/login.html'>");
			out.print("</body>");
			out.print("</html>");

		}
	}

	public void destory() {
		System.out.println("destory method call");
	}

}
