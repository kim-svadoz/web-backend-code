<%@page import="member.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			ArrayList<MemberDTO> memList = (ArrayList<MemberDTO>)request.getAttribute("memList");
		
		%>
		<table border="1">
			<tr>
				<th>�μ� �ڵ�</th>
				<th>��� �̸�</th>
				<th>���</th>
				<th>��й�ȣ</th>
				<th>�ּ�</th>
				<th>����</th>
				<th>���</th>
				<th>����</th>
			</tr>
			<%
				for(int i=0;i<memList.size();i++){
			%>
			<tr>
				<td><a href="/serverweb/member/read.do?id=<%= memList.get(i).getId() %>"><%= memList.get(i).getId() %></a></td>
				<td><%= memList.get(i).getPass() %></td>
				<td><%= memList.get(i).getName() %></a></td>
				<td><%= memList.get(i).getAddr() %></td>
				<td><%= memList.get(i).getDeptno() %></td>
				<td><%= memList.get(i).getPoint() %></td>
				<td><%= memList.get(i).getGrade() %></td>
				<td><a href="/serverweb/member/delete.do?id=<%= memList.get(i).getId() %>">����</a></td>
			</tr>
			
			<%
				}
			%>
		</table>
	</body>
</html>