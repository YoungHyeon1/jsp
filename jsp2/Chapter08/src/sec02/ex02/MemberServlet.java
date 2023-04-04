package sec02.ex02;

import jakarta.servlet.RequestDispatcher;
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
@WebServlet("/Member8")  // 수정
public class MemberServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");   
		
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out = response.getWriter();	
	    MemberDAO dao = new MemberDAO();
	    
	    List memberList = dao.listMembers();
	    request.setAttribute("memberList",memberList);
	    RequestDispatcher dispath = request.getRequestDispatcher("view");
	    dispath.forward(request, response);
	    

	}
}