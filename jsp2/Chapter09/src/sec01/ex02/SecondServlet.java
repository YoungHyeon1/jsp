package sec01.ex02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SecondServlet
 */
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
	
		if(user_id != null && user_id.length()!= 0)
		{
			out.print("이미 로그인 상태!<br>"+user_id+"<br><br>");
			out.print("<html><body>");
			out.print("servlet 아이디"+user_id+"<br>");
			out.print("servlet 비밀번호"+user_pw+"<br>");
			out.print("servlet 주소"+user_address+"<br>");
			out.print("</html></body>");
		}else {
			out.print("<html><body>");
			out.print("로그인 하지 않았음 <br><br>");
			out.print("다시 로그인 하세요<br>");
			out.print("<a href='/Chapter09/login2.html'>로그인창으로 이동하기</>");
			out.print("</html></body>");
		}
	}

}
