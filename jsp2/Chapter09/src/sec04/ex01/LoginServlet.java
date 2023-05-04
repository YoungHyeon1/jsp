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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html;charset=utf-8");
		ServletContext context = getServletContext();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId(user_id);
		memberVO.setPwd(user_pwd);
		System.out.println(user_id);
		System.out.println(user_pwd);

		MemberDAO dao = new MemberDAO();
		boolean result = dao.isExisted(memberVO);
		if(result) {
			session.setAttribute("isLogon", true);
			session.setAttribute("login.id", user_id);
			session.setAttribute("login.pwd", user_pwd);
			
			
			out.print("<html><body>");
			out.print("안녕하세요 "+user_id+"님<br>");
			out.print("<a href='show'> 회원종보보기</a>");
			out.print("</body></html>");

			
		}else {
			out.print("<html><body> 회원아이디가 틀립니다.");
			out.print("<a href='login4.html'> 다시 로그인</a>");
			out.print("</body></html>");
		}
		
		/*
		if(session.isNew())
		{
			if (user_id != null) {
				session.setAttribute("user_id", user_id);
				out.println("<a href='login'>로그인 상태확인</a>");
			}else {
				out.print("<a hre='login2.html> 다시 로그인하세요 </a>");
			}
		}*/
		
		
	}

}
