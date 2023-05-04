package sec04.ex01;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginTest
 */
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context = getServletContext();
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		
		HttpSession session = request.getSession();

		LoginImpl loginUser = new LoginImpl(user_id, user_pwd);
		
		if (session.isNew()) {
			session.setAttribute("loginUser", loginUser);
		}
		
		String data = "안녕하세요"+user_id+"님 환영합니다 <br><br>";
		data += "<html>";
		data += "<head>";
		data += "<script type='text/javascript'>";
		data += "setTimeout('history.go(0);', 5000)";
		data += "</script>";
		data += "</head'>";
		data += "<body'>";
		data += "아이디 :"+loginUser.user_id+"<br>";
		data += "총 접속자수: "+loginUser.total_user+"<br>";
		data += "</body></html>";
		out.println(data);
	}

}
