<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@
	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
 %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:set var="dan" value="${ param.dan }"/>
		<table border="1" width="800" align="center">
			<tr align="center" bgcolor="lightgreen">
				<td colspan="2"><c:out value="${dan}"/></td>
			</tr>
			<c:forEach var="i" begin="1" end="9" step="1">
				<tr align="center">
					<td>
						<c:out value="${dan}"/> * <c:out value="${ i }"/>
					</td>
					<td>
						<c:out value="${i*dan}"/>/>
					</td>
				</tr>
			</c:forEach>
		
		</table>
	
	</body>
</html>