<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<table border="1px" width="30px">
		<%
			for(int i=0; i<10; i++){
		%>
				<tr>
				<td><%= i+1 %></td>
				</tr>
		<%	
			}
		%>
		</table>
	</body>
</html>