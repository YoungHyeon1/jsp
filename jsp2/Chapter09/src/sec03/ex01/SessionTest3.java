package sec03.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Servlet implementation class SessionTest1
 */
@WebServlet("/session3")
public class SessionTest3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		out.println("세션 아이디: "+session.getId()+"<br>");
		out.println("최초 세션 생성 시간: "+ new Date(session.getCreationTime())+"<br>");
		out.println("최근 세션 접근 시간: "+ new Date(session.getLastAccessedTime())+"<br>");
		out.println("세션 유효 시간: "+session.getMaxInactiveInterval()+"<br>");
		
		if(session.isNew())
		{
			out.println("새 새션이 만들어졌습니다.");
		}
		session.invalidate();
	}

}
