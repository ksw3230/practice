<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이미지 게시판</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu_imageList.jsp" %>
<link rel="stylesheet" href="${path}/include/tableStyle.css">
<c:set var="i" value="0" />
<c:set var="j" value="4" />
<table align="center">
<tr>
	<th colspan="4" class="title">
		이미지 게시판
	</th>
</tr>
 <c:choose>
  <c:when test="${list != null && fn:length(list) > 0 }">
   <c:forEach items="${list}" var="vo">
    <c:if test="{i%j == 0}">
     <tr>
    </c:if>
    <td class="center" width="25%">
    	<a href="${path}/imageBoard/view?idx=${vo.idx}&currentPage=${init.currentPage}">
    		<img src="${path}/images/${vo.pictureUrl}" width="90%"> 
    		<br>
    		<c:set var="title" value="${fn:replace(vo.title, '<', '&lt;')}"/>
			<c:set var="title" value="${fn:replace(title, '>', '&gt;')}"/>
    		${title}
    		(${vo.replyCount})
    	</a>
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
 	<td colspan="2">
		<c:if test="${init.currentPage > 1}">
			<input type="button" title="이전 페이지" value="이전" onclick="location.href='${path}/imageBoard/list?currentPage=${init.currentPage - 1}'"/>	
		</c:if>
		<c:if test="${init.currentPage <= 1}">
			<input class="disabled" type="button" value="이전" disabled="disabled">
		</c:if>
		<c:if test="${init.currentPage < init.totalPage}">
				<input type="button" title="다음 페이지" value="다음" onclick="location.href='?currentPage=${init.currentPage + 1}'"/>	
		</c:if>
		<c:if test="${init.currentPage >= init.totalPage}">
			<input class="disabled" type="button" value="다음" disabled="disabled">
		</c:if>
 	</td>
 	<td colspan="2" class="right">
 		<input type="button" onclick="location.href='${path}/imageBoard/insert'" value="글쓰기">
 	</td>
 </tr>
</table>


</body>
</html>