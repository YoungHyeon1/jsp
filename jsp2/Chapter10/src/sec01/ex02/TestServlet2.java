package sec01.ex02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class TestServlet1
 */
@WebServlet("/first/*")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String Context = request.getContextPath();
		String url = request.getRequestURL().toString();
		String mapping = request.getServletPath();
		String uri = request.getRequestURI();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Servlet 2 </title>");
		out.println("</head>");
		out.println("<body bgcolor='yellow'>");
		out.println("<b>TestServlet 2</b>");
		out.println("<b>컨텍스트명: "+Context+"</b><br>");
		out.println("<b>전체경로: "+url+"</b><br>");
		out.println("<b>매핑명: "+mapping+"</b><br>");
		out.println("</body>");
		out.println("</html>");

		
	}

}
