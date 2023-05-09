<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
 <%
 	String id = request.getParameter("user_id");
	String pw = request.getParameter("user_pw");

	
 %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 결과</title>
	</head>
	<body>
		<h1>로그인 결과 출력</h1>
		<%
			if (id == null || id.length() == 0){
				
		%>
			아이디를 입력하세요 <br>
			<a href="/Chapter12/login.html">로그인 하기</a>
		<%
			} else if(id.equals("admin")){
		%>
				<h2>관리자님 환영합니다.</h2>
		<%
			}else {
		%>
			<h2> <%= id %> 님 환영합니다</h2>
		<%
			}
		%>
	</body>
</html>