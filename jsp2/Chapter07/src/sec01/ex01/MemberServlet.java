package sec01.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

/**
 * Servlet implementation class MemberServlet
 */
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.listMembers();
		
		out.print("<html><body>");
		out.print("<table border = 1> <tr align='center' bgcolor = 'lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름></td><td>이메일</td><td>가입일</td>");
		
		for (int i = 0; i < list.size(); i++)
		{
			MemberVO memverVO = list.get(i);
			String id = memverVO.getId();
			String pwd = memverVO.getPwd();
			String name = memverVO.getName();
			String email = memverVO.getEmail();
			Date joinDate = memverVO.getjoinDate();
			out.print("<tr><td>"+id+"</td><td>"+pwd+"</td><td>"+name+"</td><td>"+email+"</td><td>"+joinDate+"</td>");
		}
		
		out.print("</table></body></html>");

		
	}

}
