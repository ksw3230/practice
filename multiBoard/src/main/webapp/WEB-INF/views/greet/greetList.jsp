<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가입인사</title>
<%@ include file="../include/header.jsp" %>
<link rel="stylesheet" href="${path}/include/tableStyle.css">


</head>
<body>
<%@ include file="../include/menu_greet.jsp" %>


<br><br>
<table align="center">
	<tr>
		<th colspan="3" class="title">
			가입인사
		</th>
	</tr>	
	<tr>
		<form action="${path}/greet/insert" method="post">
		<td width="200">아이디<input type="text" name="userid" value="${sessionScope.userid}" readonly="readonly"></td>
		<td>내용<input type="text" class="content" name="content" placeholder="가입인사 말을 써주세요~!"></td>
		<td><input type="submit" value="등록">
		</form>
	</tr>
</table>
<table align="center">
	<tr>
		<th width="100">글번호</th>
		<th width="100">아이디</th>
		<th>내용</th>
		<th width="200">등록일</th>
	</tr>
<c:forEach var="list" items="${list}">
	<tr>
		<td>${list.idx}</td>
		<td>${list.userid}</td>
		<td>
			<c:set var="content" value="${fn:replace(list.content, '<', '&lt;')}"/>
			<c:set var="content" value="${fn:replace(content, '>', '&gt;')}"/>
			${content}
		</td>
		<td><fmt:formatDate value="${list.reg_date}" pattern="yyyy-MM-dd HH:mm:ss"/>
			<c:if test="${sessionScope.admin_userid != null}">
				<input type="button" value="삭제" onclick="location.href='${path}/greet/delete?idx=${list.idx}'">
			</c:if>
		</td>
	</tr>
</c:forEach>	
</table>
</body>
</html>