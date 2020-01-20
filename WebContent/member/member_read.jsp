<%@page import="member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	//서블릿이 공유한 데이터 꺼내기
	MemberDTO readList = (MemberDTO)request.getAttribute("readList");
	%>
	<div class="container-fluid">
			<form role="form" class="form-horizontal"
		action="/serverweb/action?deptno=<%= "001" %>&state=UPDATE" 
		method="get">
				<fieldset>
					<div id="legend">
						<legend>아래 양식을 작성해주세요.</legend>
					</div>
					
					<div class="form-group">
						<!-- 부서코드 -->
						<label class="control-label col-sm-2" for="orgcode">부서코드</label>
						<div class="col-sm-3">
							<!-- 부서코드를 이곳에 출력하세요 -->
							<%= readList.getDeptno() %>
						</div>
					</div>
					<div class="form-group">
						<!-- 부서명-->
						<label class="control-label col-sm-2" for="orgname">성명</label>
						<div class="col-sm-3">
							<!-- 부서명을 이곳에 출력하세요 -->
							<%= readList.getName() %>
						</div>
					</div>
					
					<div class="form-group">
						<!-- 부서위치-->
						<label class="control-label col-sm-2" for="orgloc">사번</label>
						<div class="col-sm-3">
							<!-- 부서위치를 이곳에 출력하세요 -->
							<%= readList.getId() %>
						</div>
					</div>
					<div class="form-group">
						<!-- 전화번호-->
						<label class="control-label col-sm-2" for="orgtel">패스워드</label>
						<div class="col-sm-3">
							<!-- 부서전화번호를 이곳에 출력하세요 -->
							<%= readList.getPass() %>
						</div>
					</div>

					<div class="form-group">
						<!-- 매니저-->
						<label class="control-label col-sm-2" for="orgtel">주소</label>
						<div class="col-sm-3">
							<!-- 관리자를 이곳에 출력하세요 -->
							<%= readList.getAddr() %>

						</div>
					</div>
					
					<div class="form-group">
						<!-- 부서코드 -->
						<label class="control-label col-sm-2" for="orgcode">포인트</label>
						<div class="col-sm-3">
							<!-- 부서코드를 이곳에 출력하세요 -->
							<%= readList.getPoint() %>
						</div>
					</div>
					
					<div class="form-group">
						<!-- 부서코드 -->
						<label class="control-label col-sm-2" for="orgcode">등급</label>
						<div class="col-sm-3">
							<!-- 부서코드를 이곳에 출력하세요 -->
							<%= readList.getGrade() %>
						</div>
					</div>
					
					
					<div class="form-group">
						<!-- Button -->
						<div class="col-sm-3 col-sm-offset-2">
							<input type="submit" value="수정" class="btn btn-success"/>
						</div>
					</div>
				</fieldset>
			</form>
	</div>
</body>
</html>