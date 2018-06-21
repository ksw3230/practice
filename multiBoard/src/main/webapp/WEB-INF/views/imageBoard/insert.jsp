<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 작성</title>
<%@ include file="../include/header.jsp" %>
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
	  <form action="insertOK" method="post" onsubmit="return chk();" enctype="multipart/form-data" name="form1">
	  <input type ="hidden" name="ip" value="${pageContext.request.remoteAddr}"/>
	    <div class="row">
	      <div class="col-20">
	        <label>이름</label>
	      </div>
	      <div class="col-80">
	        <input type="text" name="userid" value="${sessionScope.userid}" readonly="readonly" >
	      </div>
	    </div>
	     <div class="row">
	      <div class="col-20">
	        <label>제목</label>
	      </div>
	      <div class="col-80">
	       <input type="text" name="title">
	      </div>
	    </div>
        <div class="row">
	      <div class="col-20">
	        <label>이미지</label>
	      </div>
	      <div class="col-80">
	        <input type="file" name="file">
	      </div>
	    </div>
	    <div class="row">
	      <div class="col-20">
	        <label>내용</label>
	      </div>
	      <div class="col-80">
	        <textarea name="content" style="height:200px"></textarea>
	      </div>
	    </div>
	    <div align="right" class="row">	      
	      <input type="submit" value="저장하기"/>
	      <input type="reset" value="다시쓰기"/>
		  <input type="button" value="돌아가기" onclick="history.go(-1)"/>
		</div>
	  </form>
	</div>

</body>
</html>