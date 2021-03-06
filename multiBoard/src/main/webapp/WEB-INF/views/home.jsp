<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인</title>
<%@ include file="include/header.jsp" %>
</head>
<body>
<%@ include file="include/menu_main.jsp" %>
<link rel="stylesheet" href="${path}/include/tableStyle.css">
<p>${message}</p>
<br><br>
<table align="center" >
	<tr>	
		<th class="title">
			공지
		</th>
	</tr>
	<tr>
		<th>작성자 : ${notice.userid} &nbsp;&nbsp;&nbsp;&nbsp; 제목 : ${notice.title}</th>  
	</tr>
	<tr>
		<td>
			<br>
			<h1>
		 		<c:set var="content" value="${fn:replace(notice.content, '<', '&lt;')}"/>
				<c:set var="content" value="${fn:replace(content, '>', '&gt;')}"/>
				<c:set var="content" value="${fn:replace(content, rn, '<br>')}"/>
				${content}
			</h1>
		 	<br><br>
		<td>
	</tr>	
</table>
<c:set var="i" value="0" />
<c:set var="j" value="4" />
<table align="center">
<tr>
	<th colspan="4" class="title">
		<a href="${path}/imageBoard/list">이미지게시판</a>
	</th>
</tr>
 <c:choose>
  <c:when test="${list != null && fn:length(list) > 0 }">
   <c:forEach items="${list}" var="vo">
    <c:if test="{i%j == 0}">
     <tr>
    </c:if>
    <td class="center" width="25%">
    	
    		<img src="${path}/images/${vo.pictureUrl}" width="90%"> 
    		<br>
    		<c:set var="title" value="${fn:replace(vo.title, '<', '&lt;')}"/>
			<c:set var="title" value="${fn:replace(title, '>', '&gt;')}"/>
    		${title}
    		
   
    </td>
   <c:if test="${i%j == j-1}">
    </tr>
   </c:if> 
  <c:set var="i" value="${i+1}" />
   </c:forEach>
  </c:when>
 <c:otherwise>
  <tr>
   <td>존재하지 않습니다.</td>
  </tr>
 </c:otherwise>
 </c:choose>
 <tr>
</table>
<br>
<br>
<table align="center">
	<tr>
		<th class="title" colspan="5">
			<a href="${path}/fboard/list">파일게시판</a>
		</th>	
	</tr>
	<tr>
	<th>글번호</th>
	<th>작성자</th>
	<th>제목</th>
	<th>작성일</th>
	<th>조회수</th>
</tr>
<c:choose>
<c:when test="${flist != null && fn:length(flist) > 0 }">
	<c:forEach items="${flist}" var="vo">
		<tr>
			<td>${vo.idx}</td>
			<td>${vo.userid}</td>
			<td>
				${vo.title}
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
</table>

</body>

</html>
