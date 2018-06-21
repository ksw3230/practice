<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>답변형 게시판</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu_boardList.jsp" %>
<link rel="stylesheet" href="${path}/include/tableStyle.css">
<br>
<table align="center">
	<tr><th class="title" align="center" colspan="5">게시판 글 목록</th></tr>
	<tr>
		<td colspan="3">
			<form action="${path}/board/list" method="post">
				<select class="select" name="pageSize">
					<option>페이지당 표시할 글의 개수를 선택하세요</option>
					<option>3</option>				
					<option>5</option>				
					<option>10</option>				
					<option>15</option>				
					<option>20</option>				
				</select>
				<input type="submit" value="보기">
			</form>	
		</td>
		<td class="right" colspan="2"> 
			${init.totalCount}(${init.currentPage}/${init.totalPage}) 
		</td>
	</tr>
	<tr>
		<th class="center" width="100">번호</td>
		<th class="center" width="100">작성자</td>
		<th class="center">제목</td>
		<th class="center" width="100">작성일</td>
		<th class="center" width="100">조회수</td>
	</tr>
	<jsp:useBean id="date" class="java.util.Date"/>	<!-- 오늘 날짜 -->
	<!-- 공지글을 출력한다. -->
	<c:forEach var="notice" items="${notice}">
		<tr class="notice">
			<td class="center">
				<img src="../images/notice.png"/>
			</td>
			<td class="center">
			<c:set var="userid" value="${fn:replace(notice.userid, '<', '&lt;')}"/>
			<c:set var="userid" value="${fn:replace(userid, '>', '&gt;')}"/>
			${userid}
		</td>
		<td>
			<!-- NEW -->
			<c:if test="${date.year == notice.writeDate.year && date.month == notice.writeDate.month &&
				date.date == notice.writeDate.date}">
				<img src="../images/new.png"/>
			</c:if>
			<c:set var="title" value="${fn:replace(notice.title, '<', '&lt;')}"/>
			<c:set var="title" value="${fn:replace(title, '>', '&gt;')}"/>
			<a href="${path}/board/increment?idx=${notice.idx}&currentPage=${init.currentPage}">${title}</a>
			
			<!-- HOT -->
			<c:if test="${notice.hit >= 10}">
				<img src="../images/hot.gif">
			</c:if>	
		</td>
		<td class="center">
			<c:if test="${date.year == notice.writeDate.year && date.month == notice.writeDate.month &&
				date.date == notice.writeDate.date}">
				오늘<fmt:formatDate value="${notice.writeDate}" pattern="HH:mm:ss"/>
			</c:if>
			<c:if test="${date.year != notice.writeDate.year || date.month != notice.writeDate.month ||
				date.date != notice.writeDate.date}">
				<fmt:formatDate value="${notice.writeDate}" pattern="yyyy.MM.dd(E)"/>
			</c:if>
		</td>
		<td class="center">${notice.hit}</td>		
		
			
		</tr>
	</c:forEach>
	
	<!-- 메인글 -->
	<c:if test="${init.totalCount == 0}">
	<tr><td class="center" colspan="5"><marquee>테이블에 저장된 글이 없습니다.</marquee></td></tr>
	</c:if>
	<c:if test="${init.totalCount != 0}">
	<c:forEach var="vo" items="${list}">
	<tr>
		<td class="center"> ${vo.idx} </td> 
		<td class="center">
			<c:set var="userid" value="${fn:replace(vo.userid, '<', '&lt;')}"/>
			<c:set var="userid" value="${fn:replace(userid, '>', '&gt;')}"/>
			${userid}
		</td> 
		<td>
			<c:if test="${vo.lev > 0}">
				<c:forEach var="i" begin="0" end="${vo.lev}">
					&nbsp;&nbsp;&nbsp;&nbsp;
				</c:forEach>
				Re : 
			</c:if>
			<!-- NEW -->
			<c:if test="${date.year == vo.writeDate.year && date.month == vo.writeDate.month &&
				date.date == vo.writeDate.date}">
				<img src="../images/new.png"/>
			</c:if>
			<c:set var="title" value="${fn:replace(vo.title, '<', '&lt;')}"/>
			<c:set var="title" value="${fn:replace(title, '>', '&gt;')}"/>
			<a href="${path}/board/increment?idx=${vo.idx}&currentPage=${init.currentPage}">${title}</a>
			<!-- HOT -->
			<c:if test="${vo.hit >= 10}">
				<img src="../images/hot.gif">
			</c:if>
		
		</td> 
		<td class="center">
			<c:if test="${date.year == vo.writeDate.year && date.month == vo.writeDate.month && date.date == vo.writeDate.date}">
				오늘 <fmt:formatDate value="${vo.writeDate}" pattern="HH:mm:ss"/>
			</c:if>
			<c:if test="${date.year != vo.writeDate.year || date.month != vo.writeDate.month || date.date != vo.writeDate.date}">
				<fmt:formatDate value="${vo.writeDate}" pattern="yyyy.MM.dd(E)"/>
			</c:if>
		</td> 
		<td class="center">${vo.hit}</td> 
	</tr>
	</c:forEach>
	</c:if>
	<tr>
		<td class="center" colspan="5" align="center">
		
			<!-- startPage가 1보다 크다면 이전 10페이지가 있다. -->
			<c:if test="${init.startPage > 1}">
				<input type="button" title="처음 페이지" value="first" onclick="location.href='${path}/board/list?currentPage=1'"/>
				<input type="button" title="이전 10페이지" value="<-10" onclick="location.href='${path}/board/list?currentPage=${init.startPage - 1}'"/>
			</c:if>
			<c:if test="${init.startPage <= 1}">
				<input class="disabled" type="button" value="first" disabled="disabled"/>
				<input class="disabled" type="button" value="<-10" disabled="disabled"/>
			</c:if>
			
			<!-- currentPage가 1보다 크다면 이전 페이지가 있다. -->
			<c:if test="${init.currentPage > 1}">
				<input type="button" title="이전 페이지" value="<-1" onclick="location.href='${path}/board/list?currentPage=${init.currentPage - 1}'"/>	
			</c:if>
			<c:if test="${init.currentPage <= 1}">
				<input class="disabled" type="button" value="<-1" disabled="disabled"/>
			</c:if>
			<!-- 10 페이지 단위로 페이지 이동 버튼 표시하기 -->
			<c:forEach var="i" begin="${init.startPage}" end="${init.endPage}" step="1">

				<c:if test="${i == init.currentPage}">
					<input class="disabled" type="button" value="${i}" disabled="disabled"/> 
				</c:if>
				<c:if test="${i != init.currentPage}">
					<input type="button" value="${i}" onclick="location.href='${path}/board/list?currentPage=${i}'"/> <!-- forward로 넘긴다면 'list.jsp'를 지워도 된다. -->
				</c:if>

			</c:forEach>
			<!-- currentPage가 totalPage보다 작다면 다음 페이지가 있다. -->
			<c:if test="${init.currentPage < init.totalPage}">
				<input type="button" title="다음 페이지" value="+1>" onclick="location.href='${path}/board/list?currentPage=${init.currentPage + 1}'"/>	
			</c:if>
			<c:if test="${init.currentPage >= init.totalPage}">
				<input class="disabled" type="button" value="+1>" disabled="disabled"/>
			</c:if> 
			
			<!-- endPage가 totalPage보다 작다면 다음 10 페이지가 있다. -->
			<c:if test="${init.endPage < init.totalPage}">
				<input type="button" title="다음 10페이지" value="+10>" onclick="location.href='${path}/board/list?currentPage=${init.endPage + 1}'"/>
				<input type="button" title="마지막 페이지" value="end" onclick="location.href='${path}/board/list?currentPage=${init.totalPage}'"/>
			</c:if>
			<c:if test="${init.endPage >= init.totalPage}">
				<input class="disabled" type="button" value="+10>" disabled="disabled"/>
				<input class="disabled" type="button" value="end" disabled="disabled"/>
			</c:if>
		</td>
		
	</tr>
	<tr>
		<td class="center" colspan="5">
			<form action="${path}/board/list" method="post">
				<select name="category">
					<option>제목</option>
					<option>아이디</option>
					<option>아이디+제목</option>
				</select>
				<input type="text" name="item" value="${item}"/>
				<input type="submit" value="검색"/>
			</form>	
		</td>	
	</tr>
	
	<tr>
		<td class="right" colspan="5">
			<input type="button" value="글쓰기" onclick="location.href='${path}/board/insert'">
		</td>
	</tr>
</table>	
	
</body>
</html>