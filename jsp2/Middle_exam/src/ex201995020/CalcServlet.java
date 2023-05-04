package ex201995020;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CalcServlet
 */
public class CalcServlet extends HttpServlet {
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
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		int num1 = Integer.parseInt(request.getParameter("num1")) ;
		int num2 = Integer.parseInt(request.getParameter("num2")) ;
		int result = 0;
		String result_op = "";
		String[] op = request.getParameterValues("select");
		for(String str : op) {
			if (str.equals("+"))
			{
				result=num1+num2;
				result_op = "+";

			}else if(str.equals("-"))
			{
				result=num1-num2;
				result_op = "-";

			}else if(str.equals("*"))
			{
				result=num1*num2;
				result_op = "*";

			}else if(str.equals("/"))
			{
				result=num1/num2;
				result_op = "/";

			}
		}
		
		String data = "";
		data += "<html> <body>";
		data += "<h1>중간고사 1번 김영현 -결과</h1>";
		data += "<br><hr>";

		data += num1+result_op+num2+"="+result;
		data += "</body></html>";
		
		out.print(data);
	    RequestDispatcher dispat = request.getRequestDispatcher("result");
	    dispat.forward(request, response);
		
	}

}
