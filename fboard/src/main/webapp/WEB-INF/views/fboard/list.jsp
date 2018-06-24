<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>

</head>
<body>
<table align="center" width="500px">
<tr>
	<th colspan="5">
		<h2>파일게시판</h2>
	<th>
</tr>
<tr>
	<th>글번호</th>
	<th>작성자</th>
	<th>제목</th>
	<th>작성일</th>
	<th>조회수</th>
</tr>
<c:choose>
<c:when test="${list != null && fn:length(list) > 0 }">
	<c:forEach items="${list}" var="vo">
		<tr>
			<td>${vo.idx}</td>
			<td>${vo.userid}</td>
			<td>
				<a href="${path}/fboard/increment?idx=${vo.idx}&currentPage=${pager.currentPage}">${vo.title}</a>
			</td>
			<td><fmt:formatDate value="${vo.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td>${vo.hit}</td>
		</tr>
	</c:forEach>
</c:when>
<c:otherwise>
	<tr>
		<td colspan="5">존재하지 않습니다.</td>
	</tr>
</c:otherwise>
</c:choose>
<tr>
 	<td colspan="3">
		<c:if test="${pager.currentPage > 1}">
			<input type="button" title="이전 페이지" value="이전" onclick="location.href='${path}/imageBoard/list?currentPage=${pager.currentPage - 1}'"/>	
		</c:if>
	
		<c:if test="${pager.currentPage < pager.totalPage}">
				<input type="button" title="다음 페이지" value="다음" onclick="location.href='?currentPage=${pager.currentPage + 1}'"/>	
		</c:if>
		
	<td align="right" colspan="2">
		<input type="button" onclick="location.href='${path}/fboard/insert'" value="글쓰기">
	</td>
</tr>
</table>
</body>
</html>