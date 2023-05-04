package sec01.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		String user_address = request.getParameter("user_address");
		String user_email = request.getParameter("user_email");
		String user_hp = request.getParameter("user_hp");
		out.print("안녕하세요!<br>"+user_id+"님 환영합니다<br><br>");
		out.print("<html><body>");
		out.print("아이디"+user_id+"<br>");
		out.print("비밀번호"+user_pw+"<br>");
		out.print("주소"+user_address+"<br>");
		out.print("이메일"+user_email+"<br>");
		out.print("전화번호"+user_hp+"<br>");
		out.print("</html></body>");

		
	}

}
