<%@page import="member.MemberDTO"%>
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
		//������ ������ ������ ������
		int result = (int)request.getAttribute("insertResult");
	%>
	<h1>����������</h1>
	<hr/>
	<h2><%= result %>���� ���� ����!!!</h2>
		 
</body>
</html>