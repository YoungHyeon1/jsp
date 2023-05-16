<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, sec01.ex01.*"
%>

<jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page"></jsp:useBean>

<jsp:setProperty name="m" property="*"/>

<%
	request.setCharacterEncoding("utf-8");
	
	MemberDAO memberDAO = new MemberDAO();
	memberDAO.addMember(m);
	List memberList = memberDAO.listMembers();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원목록창</title>
	</head>
	<body>
		<table align="center" width="100%">
			<tr align="center" bgcolor="#99ccff">
				<td width="7%">아이디</td>
				<td width="7%">비밀번</td>
				<td width="7%">이름</td>
				<td width="7%">이메일</td>
				<td width="7%">가입일</td>
			</tr>
			<%
				if(memberList.size() == 0){
			%>
			<tr>
				<td colspan=5>
					<p align="center"><b>등록된 회원이 없습니다.</b>
				</td>
			</tr>
			<%
				} else {
					for(int i = 0; i<memberList.size(); i++){
						MemberBean bean = (MemberBean)memberList.get(i);
			%>
				<tr align="center">
					<td><%= bean.getId() %></td>
					<td><%= bean.getPwd() %></td>
					<td><%= bean.getName() %></td>
					<td><%= bean.getEmail() %></td>
					<td><%= bean.getJoinDate() %></td>
				</tr>
			<%
					}
				}
			%>
			<tr height="1" bgcolor="#99ccff">
				<td colspan=5></td>
			</tr>
			
		</table>
	</body>
</html>