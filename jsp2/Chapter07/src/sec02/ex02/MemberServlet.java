package sec02.ex02;

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
@WebServlet("/member4")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 추가
		request.setCharacterEncoding("utf-8");   
		
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out = response.getWriter();	
	    MemberDAO dao = new MemberDAO();
	    
	    // 추가
	    String command=request.getParameter("command");
	    if(command!= null && command.equals("addMember")){
			 String _id = request.getParameter("id");
			 String _pwd = request.getParameter("pwd");
			 String _name = request.getParameter("name");
			 String _email = request.getParameter("email");
			 
			 MemberVO vo=new MemberVO();
			 vo.setId(_id);
			 vo.setPwd(_pwd);
			 vo.setName(_name);
			 vo.setEmail(_email);
		     dao.addMember(vo);
	    }
	    
	    List<MemberVO> list = dao.listMembers();   
		
	    out.print("<html><body>");
	    out.print("<table  border=1><tr align='center' bgcolor='lightgreen'>");
	    out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
	     
		for (int i=0; i<list.size();i++){
			MemberVO memberVO=(MemberVO) list.get(i);
			String id=memberVO.getId();
			String pwd = memberVO.getPwd();
			String name=memberVO.getName();
			String email=memberVO.getEmail();
			Date joinDate = memberVO.getjoinDate();
			out.print("<tr><td>"+id+"</td><td>"+
		                pwd+"</td><td>"+
		                name+"</td><td>"+
		                email+"</td><td>"+
		                joinDate+"</td></tr>");		
		}
		out.print("</table></body></html>");
		
		// 추가
		out.print("<a href='/Chapter07/memberForm.html'>새 회원 등록하기</a>");  
	}
//		List<MemberVO> list = dao.listMembers();
//		
//		out.print("<html><body>");
//		out.print("<table border = 1> <tr align='center' bgcolor = 'lightgreen'>");
//		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td>");
//		
//		for (int i = 0; i < list.size(); i++)
//		{
//			MemberVO memverVO = list.get(i);
//			String id = memverVO.getId();
//			String pwd = memverVO.getPwd();
//			String name = memverVO.getName();
//			String email = memverVO.getEmail();
//			Date joinDate = memverVO.getjoinDate();
//			out.print("<tr><td>"+id+"</td><td>"+pwd+"</td><td>"+name+"</td><td>"+email+"</td><td>"+joinDate+"</td>");
//		}
//		
//		out.print("</table></body></html>");

		
//	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(req, resp);
	}

}
