<%@page import="dept.DeptDTO"%>
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
			ArrayList<DeptDTO> deptList = (ArrayList<DeptDTO>)request.getAttribute("deptList");
		
		%>
		<table border="1">
			<tr>
				<th>�μ� ��ȣ</th>
				<th>�μ� �̸�</th>
				<th>�μ� ����</th>
				<th>��ȭ ��ȣ</th>
				<th>�����</th>
				<th>����</th>
			</tr>
			<%
				for(int i=0;i<deptList.size();i++){
			%>
			<tr>
				<td><%= deptList.get(i).getDeptNo() %></td>
				<td><a href="/serverweb/dept/read.do?deptNo=<%= deptList.get(i).getDeptNo() %>&info=�ѱ۵�����"><%= deptList.get(i).getDeptName() %></a></td>
				<td><%= deptList.get(i).getLoc() %></td>
				<td><%= deptList.get(i).getTel() %></td>
				<td><%= deptList.get(i).getMgr() %></td>
				<td><a href="/serverweb/dept/delete.do?deptNo=<%= deptList.get(i).getDeptNo() %>">����</a></td>
			</tr>
			
			<%
				}
			%>
		</table>
	</body>
</html>