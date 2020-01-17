<%@page import="dept.DeptDTO"%>
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
		//서블릿이 공유한 데이터 꺼내오기	
		DeptDTO dept = (DeptDTO)request.getAttribute("mydata");
	%>
	<h1>요청 재지정으로 실행될 페이지</h1>
	<hr/>
	<h2>공유 데이터 : <%= dept.getDeptName() %></h2>
</body>
</html>