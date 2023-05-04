package sec04.ex02;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoadAppConfig
 */
@WebServlet(name="LoadConfig", urlPatterns = {"/LoadConfig"}, loadOnStartup=1)
public class LoadAppConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	//private ServletContext context;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		context = config.getServletContext();
		
		String menu_member = context.getInitParameter("menu_member");
		String menu_order = context.getInitParameter("menu_order");
		String menu_goods = context.getInitParameter("menu_goods");
		
		context.setAttribute("menu_member", menu_member);
		context.setAttribute("menu_order", menu_order);
		context.setAttribute("menu_goods", menu_goods);

		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String menu_member = context.getInitParameter("menu_member");
		String menu_order = context.getInitParameter("menu_order");
		String menu_goods = context.getInitParameter("menu_goods");
		out.print("<html><body>");
		out.print("<table border=1 cellspacing=0><tr>메뉴이름</tr>");
		out.print("<tr><td>"+menu_member+"</td></tr>");
		out.print("<tr><td>"+menu_order+"</td></tr>");
		out.print("<tr><td>"+menu_goods+"</td></tr>");
		out.print("</table>");
		out.print("</html></body>");
	}

}
