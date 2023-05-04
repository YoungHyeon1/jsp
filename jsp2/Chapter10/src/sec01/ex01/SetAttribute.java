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
 * Servlet implementation class SetAttribute
 */
public class SetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String ctxMesg = "Context binding";
		String sesMesg = "session binding";
		String reqMesg = "request binding";

		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession();
		ctx.setAttribute("context", ctxMesg+"<br>");
		session.setAttribute("session", sesMesg+"<br>");
		request.setAttribute("request", reqMesg+"<br>");
		
		out.print("바인딩을 수행합니다.");

	
	}

}
