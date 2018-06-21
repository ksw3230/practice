<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>답변형 게시판 - 수정</title>
<%@ include file="../include/header.jsp" %>
<script type="text/javascript">
	function chk() {
		f = document.form1;
		if(!f.userid.value || f.userid.value.trim().length == 0) {
			alert('이름을 넣으세요!');
			f.userid.value = "";
			f.userid.focus();
			return false;
		}
		if(!f.title.value || f.title.value.trim().length == 0) {
			alert('제목을 넣으세요!');
			f.title.value = "";
			f.title.focus();
			return false;
		}
		if(!f.content.value || f.content.value.trim().length == 0) {
			alert('내용을 넣으세요!');
			f.content.value = "";
			f.content.focus();
			return false;
		}
		return true;
	}
</script>

</head>
<body>
<%@ include file="../include/menu_boardList.jsp" %>
<link rel="stylesheet" href="${path}/include/imageInsert.css">
<br><br>
<div class="container">
	  <form action="${path}/board/update" method="post" onsubmit="return chk();" name="form1">
	  <input type ="hidden" name="ip" value="${pageContext.request.remoteAddr}"/>
	  <input type="hidden" name="idx" value="${dto.idx}">
	  <input type="hidden" name="currentPage" value="${currentPage}">
	    <div class="row">
	      <div class="col-20">
	        <label>이름</label>
	      </div>
	      <div class="col-50">
	        <input type="text" name="userid" value="${sessionScope.userid}" readonly="readonly" >
	      </div>
	      <div align="right" calss="col-30">
	      	<c:if test="${fn:trim(dto.notice) == 'notice'}">
		      	<label>공지글</label><input type="checkbox" name="notice" checked="checked"/>
			</c:if>
			<c:if test="${fn:trim(dto.notice) != 'notice'}">
		      	<label>공지글</label><input type="checkbox" name="notice" value="notice"/>
			</c:if>
			
	      </div>
	    </div>
	    <div class="row">
	      <div class="col-20">
	        <label>제목</label>
	      </div>
	      <div class="col-80">
	       <input type="text" name="title" value="${dto.title}">
	      </div>
	    </div>
	    <div class="row">
	      <div class="col-20">
	        <label>내용</label>
	      </div>
	      <div class="col-80">
	        <textarea name="content" style="height:200px">${dto.content}</textarea>
	      </div>
	    </div>
	    <div align="right" class="row">	      
	      <input type="submit" value="수정하기"/>
	      <input type="reset" value="다시쓰기"/>
		  <input type="button" value="돌아가기" onclick="history.go(-1)"/>
		  <input type="button" value="리스트로" onclick="location.href='${path}/board/list?currentPage=${currentPage}'"/>
		</div>
	  </form>
	</div>

</body>
</html>