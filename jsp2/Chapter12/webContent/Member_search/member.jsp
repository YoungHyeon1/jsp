<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*"
    import="sec02.ex01.*"
    pageEncoding="UTF-8"
%>

<%
// 인코딩을 UTF-8 유니코드로 변환하는 과정입니다.
   request.setCharacterEncoding("utf-8");
   String _name = request.getParameter("name");
   // Request되는 값 get 방식으로 name을 받아옵니다.
   MemberVO memberVO = new MemberVO();
   //MemberVO 클레스트 new연산자로 메모리에 업로드 합니다.
   memberVO.setName(_name);
   // 메모리에 올라온 MemberVO의 내부 setName에 get으로 받아온 데이터를 params로 줍니다.
   // setName의 경우 name의 프로퍼티로 작성되어 set, get을 쉽게 할 수 있도록 지정합니다.
   MemberDAO dao=new MemberDAO();
   // MemberDAO의 경우 데이터 베이스와 연결될 설정을 정하는 곳입니다.
   List membersList=dao.listMembers(memberVO);
   // List형식으로 memberDAO에 있는 멤버를 Database에 쿼리하여 값을 넘겨줍니다.
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 정보 출력창</title>
		
		<style>
		<!-- html코드의 디자인을 하는 부분입니다. -->
			h1 {
				text-align: center;
			}
			table {
				width: 80%;
				border:1px solid black;
				border-collapse:collapse;
				margin-left: auto;
				margin-right: auto;
				border-spacing: 0px;
			}
			td, th {
				border:1px solid gray;
				padding:10px;
				vertical-align: top;
				text-align: center;
			}
			thead, th {
				background:#eee;
			}
		</style>
	</head>
	
	<body>
		<h1>회원 정보 출력</h1>		
		 <table border='1' width='800' align='center'>
		 <thead>
		 	<tr> 
			     <th>아이디</th>
			     <th>비밀번호</th>
			     <th>이름</th>
			     <th>이메일</th>
			     <th>가입일자</th>
			</tr>
		</thead>
		<%	
			//MemberList의 메모리에 전체 배열의 사이즈를 가져와 +1 식 반복하는 부분입니다.
			for (int i = 0; i < membersList.size(); i++) {
				MemberVO vo = (MemberVO)membersList.get(i);
				String id = vo.getId();
				String pwd = vo.getPwd();
				String name = vo.getName();
				String email = vo.getEmail();
				Date joinDate = vo.getJoinDate();
		%>
				<tr>
					<td><%= id %></td>
					<td><%= pwd %></td>
					<td><%= name %></td>
					<td><%= email %></td>
					<td><%= joinDate %></td>
				</tr>		   
		<%		
			}
		%>	
		</table>
	</body>
</html>