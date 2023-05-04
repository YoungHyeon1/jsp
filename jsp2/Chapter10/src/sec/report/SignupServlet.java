package sec.report;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pw= request.getParameter("user_pw");
		String user_pw_ck = request.getParameter("user_pw_check");
		String user_name = request.getParameter("user_name");
		String data = "";
		if(user_pw.equals(user_pw_ck)) {
			data += "<html><body>";
			data += "<h2> User ID: "+user_id+"</h2><br>";
			data += "<h2>Password : "+user_pw+"</h2><br>";
			data += "<h2>Name: "+user_name+"</h2><br>";
			data += "</html></body>";
		}else {
			data += "Password Error";
		}
		out.println(data);
	}

}
