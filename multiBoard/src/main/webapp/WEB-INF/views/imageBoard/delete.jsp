<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이미지 게시판 삭제</title>
<%@ include file="../include/header.jsp" %>
<script>
function deleteOne(){
	if(confirm("삭제하시겠습니까?")){
		document.form1.action="${path}/imageBoard/deleteOK";
		document.form1.submit();
	}
		
}
</script>
<script type="text/javascript">
function chk() {
	f = document.form1;
	if(!f.userid.value || f.userid.value.trim().length == 0) {
		alert('아이디를 입력하세요!');
		f.userid.value="";
		f.userid.focus();
		return false;
	}
	if(!f.title.value || f.title.value.trim().length == 0) {
		alert('제목을 입력하세요!');
		f.title.value="";
		f.title.focus();
		return false;
	}
	if(!f.content.value || f.content.value.trim().length == 0) {
		alert('내용을 입력하세요!');
		f.content.value="";
		f.content.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body>
<%@ include file="../include/menu_imageList.jsp" %>
<link rel="stylesheet" href="${path}/include/imageInsert.css">
<div class="container">
	  <form method="post" onsubmit="return chk();" enctype="multipart/form-data" name="form1">
	  <input type="hidden" name="idx" value="${dto.idx}"/>
	  <input type="hidden" name="currentPage" value="${currentPage}"/>
	  <input type ="hidden" name="ip" value="${pageContext.request.remoteAddr}"/>
	    <div class="row">
	      <div class="col-20">
	        <label>이름</label>
	      </div>
	      <div class="col-80">
	        <input type="text" name="userid" value="${dto.userid}" readonly="readonly" >
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
	      </div>
	      <div class="col-80">
		    <img src="${path}/images/${dto.pictureUrl}" width="30%"> 
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
	      <input type="button" value="삭제하기" onclick="deleteOne()"/>
		  <input type="button" value="돌아가기" onclick="history.go(-1)"/>
		  <input type="button" value="리스트로" onclick="location.href='${path}/imageBoard/list?currentPage=${currentPage}'">
		</div>
	  </form>
	</div>

</body>
</html>