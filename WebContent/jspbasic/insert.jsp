<%@page import="dept.DeptDTO"%>
<%@page import="dept.DeptDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			//��û���� ����
			request.setCharacterEncoding("euc-kr");
			String deptNo = request.getParameter("deptNo");
			String deptName = request.getParameter("deptName");
			String loc = request.getParameter("loc");
			String tel = request.getParameter("tel");
			String mgr = request.getParameter("mgr");
			
			DeptDTO dept = new DeptDTO(deptNo, deptName, loc, tel, mgr);
			
			DeptDAOImpl daoImpl = new DeptDAOImpl();
			int result = daoImpl.insert(dept);
			
			if(result > 0){ %>
				<h1><%= result%>+ ���� �� ���Լ��� </h1>
			<% }else{%>
				<h1> ���� ���� </h1>
			<%}	%>
	</body>
</html>