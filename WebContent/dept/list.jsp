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
				<th>부서 번호</th>
				<th>부서 이름</th>
				<th>부서 지역</th>
				<th>전화 번호</th>
				<th>담당자</th>
			</tr>
			<%
				for(int i=0;i<deptList.size();i++){
			%>
			<tr>
				<td><%= deptList.get(i).getDeptNo() %></td>
				<td><%= deptList.get(i).getDeptName() %></td>
				<td><%= deptList.get(i).getLoc() %></td>
				<td><%= deptList.get(i).getTel() %></td>
				<td><%= deptList.get(i).getMgr() %></td>
			</tr>
			
			<%
				}
			%>
		</table>
	</body>
</html>