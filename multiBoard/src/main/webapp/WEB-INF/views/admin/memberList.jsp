<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 관리</title>
<%@ include file="../include/header.jsp" %>
<link rel="stylesheet" href="${path}/include/tableStyle.css">
</head>
<body>
<%@ include file="../include/menu_memberList.jsp" %>
<br><br><br><br>
<table align="center">
	<tr>
		<th colspan="5" class="title" align="center">맴버리스트</th>
	</tr>
	<tr>
		<th>아이디</td>
		<th>이름</td>
		<th>성별</td>
		<th>가입일자</td>
		<th>이메일</td>
	</tr>
	<jsp:useBean id="date" class="java.util.Date"/>
	<c:forEach var="vo" items="${dto}">
	<tr>
		<td>${vo.userid}</td>
		<td><a href="${path}/admin/memberView?userid=${vo.userid}">${vo.name}</a></td>
		<td>${vo.gender}</td>
		<td><fmt:formatDate value="${vo.join_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td>${vo.email}</td>
	</tr> 
	</c:forEach>	

</table>
</body>
</html>

