package sec02.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class secondServlet
 */
@WebServlet("/second7")
public class secondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");   
		
		response.setContentType("text/html;charset=utf-8");
		String address = (String)request.getAttribute("address");
	    PrintWriter out = response.getWriter();	
	    out.println("<html><body>");
	    out.println("redirect 실습"+address);
	    out.println("</body></html>");


	}
}
