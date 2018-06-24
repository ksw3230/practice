<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이미지게시판 글보기</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu_imageList.jsp" %>
<link rel="stylesheet" href="${path}/include/tableStyle.css">
<br>
<table align="center">
	<tr>
		<th class="title" colspan="1">
			<c:set var="title" value="${fn:replace(dto.title, '<', '&lt;')}"/>
			<c:set var="title" value="${fn:replace(title, '>', '&gt;')}"/>
    		${title}
		</th>
	</tr>
	<tr>
		<td>
			작성자 : ${dto.userid}
		</td>
	</tr>
	<tr>
		<td class="center">
			<img src="${path}/images/${dto.pictureUrl}" width="70%">
		</td>
	</tr>
	<tr>
		<td>
			<c:set var="content" value="${fn:replace(dto.content, '<', '&lt;')}"/>
			<c:set var="content" value="${fn:replace(content, '>', '&gt;')}"/>
			<c:set var="content" value="${fn:replace(content, rn, '<br>')}"/>
    		${content}
		</td>
	</tr>
	<tr>
		<td class="right">
			<input type="button" value="리스트로" onclick="location.href='${path}/imageBoard/list?currentPage=${currentPage}'"/>
			<c:if test="${sessionScope.userid == dto.userid.trim() || sessionScope.admin_userid != null}">
			<input type="button" value="수정하기" onclick="location.href='${path}/imageBoard/update?currentPage=${currentPage}&idx=${dto.idx}'"/>
			<input type="button" value="삭제하기" onclick="location.href='${path}/imageBoard/delete?currentPage=${currentPage}&idx=${dto.idx}'"/>
			</c:if>
		</td>
	</tr>
</table>
<br><br>
<table align="center">
	
	<tr>
		<form action="${path}/imageComment/insert" method="post">
		<input type="hidden" name="idx" value="${dto.idx}"/>
		<input type="hidden" name="currentPage" value="${currentPage}"/>
		<td width="200">아이디<input type="text" name="userid" value="${sessionScope.userid}" readonly="readonly"></td>
		<td>내용<input type="text" class="content" name="content" placeholder="댓글을 달아주세요~~!"></td>
		<td><input type="submit" value="댓글달기">
		</form>
	</tr>
	<c:forEach var="list" items="${list}">
	<tr>
		<td colspan="2">
			${list.userid}님이 <fmt:formatDate value="${list.writeDate}" pattern="yyyy-MM-dd(HH:mm:ss)"/>에 남기신 글 입니다.<br>
			${list.content}
		</td>
		<td>
			<c:if test="${sessionScope.userid == dto.userid.trim() || sessionScope.admin_userid != null}">
			<input type="button" value="삭제하기" onclick="location.href='${path}/imageComment/delete?currentPage=${currentPage}&idx=${list.idx}&ref=${list.ref}'"/>
			</c:if>
		</td>  
	</tr>
	</c:forEach>
</table>

</body>
</html>