<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>답변형 게시판 - 삭제</title>
<%@ include file="../include/header.jsp" %>
<script>
function deleteOne(){
	if(confirm("삭제하시겠습니까?")){
		document.form1.action="${path}/board/delete";
		document.form1.submit();
	}
		
}
</script>
</head>
<body>
<%@ include file="../include/menu_boardList.jsp" %>
<link rel="stylesheet" href="${path}/include/imageInsert.css">
<br>
<div class="container">
	<jsp:useBean id="date" class="java.util.Date"/>
	  <form method="post" name="form1">
	  <input type="hidden" name="idx" value="${dto.idx}">
	  <input type="hidden" name="currentPage" value="${currentPage}">
	  <input type ="hidden" name="ip" value="${pageContext.request.remoteAddr}"/>
	    <div class="row">
	      <div class="col-20">
	        <label>아이디</label>
	      </div>
	      <div class="col-50">
	      	<label>
	      		<c:set var="userid" value="${fn:replace(dto.userid, '<', '&lt;')}"/>
				<c:set var="userid" value="${fn:replace(userid, '>', '&gt;')}"/>
				${userid} (${dto.ip})
			</label>
	      </div>
	      <div align="right" calss="col-30">
	      	<label>조회수  ${dto.hit}</label>
	      </div>
	    </div>
	    <div class="row">
	      <div class="col-20">
	        <label>작성일</label>
	      </div>
	      <div class="col-80">
	      	<label>
	      	<c:if test="${date.year == dto.writeDate.year && date.month == dto.writeDate.month && date.date == dto.writeDate.date}">
				오늘 <fmt:formatDate value="${dto.writeDate}" pattern="HH:mm:ss"/>
			</c:if>
			<c:if test="${date.year != dto.writeDate.year || date.month != dto.writeDate.month || date.date != dto.writeDate.date}">
				<fmt:formatDate value="${dto.writeDate}" pattern="yyyy.MM.dd(E)"/>
			</c:if>
	      	</label>
	      </div>
	    </div>
	    <div class="row">
	      <div class="col-20">
	        <label>제목</label>
	      </div>
	      <div class="col-80">
	       <label>${dto.title}</label>
	      </div>
	    </div>
	    <div class="row">
	      <div class="col-20">
	        <label>내용</label>
	      </div>
	      <div class="col-80">
	        <textarea name="content" style="height:200px" readonly="readonly">${dto.content}</textarea>
	      </div>
	    </div>
	    <div align="right" class="row">
	    	<input type="button" value="삭제하기" onclick="deleteOne()"/>	
	    	<input type="button" value="돌아가기" onclick="history.go(-1)"/>
	        <input type="button" value="리스트로" onclick="location.href='${path}/board/list?currentPage=${currentPage}'"/>
	     
		</div>
	  </form>
	</div>



</body>
</html>