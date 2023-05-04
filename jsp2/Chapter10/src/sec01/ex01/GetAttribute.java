package sec01.ex01;

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
 * Servlet implementation class GetAttribute
 */
public class GetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession();
		
		String ctxMesg = (String) ctx.getAttribute("context");
		String sesMesg = (String) session.getAttribute("session");
		String reqMesg = (String) request.getAttribute("request");
		
		out.print("context: "+ctxMesg);
		out.print("session: "+sesMesg);
		out.print("request: "+reqMesg);

		
	}

}
