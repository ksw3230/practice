<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<%@ include file="../include/header.jsp" %>
<link rel="stylesheet" href="${path}/include/loginStyle.css">
<script type="text/javascript">
function chk() {
	f = document.form1;
	if(!f.userid.value || f.userid.value.trim().length == 0) {
		alert('아이디를 입력하세요!');
		f.userid.value="";
		f.userid.focus();
		return false;
	}
	if(!f.passwd.value || f.passwd.value.trim().length == 0) {
		alert('비밀번호를 입력하세요!');
		f.passwd.value="";
		f.passwd.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body>
<%@ include file="../include/menu_login.jsp" %>
<br><br><br><br><br>
<div>
  <form action="${path}/member/loginAction" method="post" onsubmit="return chk();" name="form1">
  	<h1 align="center">로그인</h1><br>
    <label for="fname">아이디</label> 
    <input type="text" name="userid" id="userid" placeholder="Your ID">

    <label for="lname">비밀번호</label>
    <input type="password" name="passwd" id="passwd" placeholder="Your Password">
    <input type="submit" value="로그인">
  <input type="checkbox" align="right" name="admin" value="admin">관리자
  </form>
  <c:if test="${message == 'fail'}">
  	<div style="color:red; width:90%">
 		아이디와 비밀번호가 일치하지 않습니다.
  	</div>
  </c:if>
  <c:if test="${message == 'logout'}">
  	<div style="color:blue; width:90%">
  		로그아웃 되었습니다.
  	</div>
  </c:if>
  <c:if test="${message == 'nologin'}">
  	<div style="color:red; width:90%">
 		로그인 해주세요!.
  	</div>
  </c:if>
</div>
</body>
</html>