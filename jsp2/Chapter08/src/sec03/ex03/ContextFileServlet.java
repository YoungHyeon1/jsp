package sec03.ex03;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Servlet implementation class ContextFileServlet
 */
public class ContextFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		ServletContext context = getServletContext();
		PrintWriter out = response.getWriter();
	
		InputStream is = context.getResourceAsStream("WEB-INF/bin/init.txt");
		BufferedReader buff = new BufferedReader(new InputStreamReader(is));
		
		String menu = null;
		String menu_member = null;
		String menu_order = null;
		String menu_goods = null;
		
		while((menu=buff.readLine()) != null)
		{
			StringTokenizer tokens = new StringTokenizer(menu, ",");
			menu_member = tokens.nextToken();
			menu_order = tokens.nextToken();
			menu_goods = tokens.nextToken();

		}
		out.print("<html><body>");
		out.print("<table border=1 cellspacing=0><tr>메뉴이름</tr>");
		out.print("<tr><td>"+menu_member+"</td></tr>");
		out.print("<tr><td>"+menu_order+"</td></tr>");
		out.print("<tr><td>"+menu_goods+"</td></tr>");
		out.print("</table>");
		out.print("</html></body>");
		
	}

}
