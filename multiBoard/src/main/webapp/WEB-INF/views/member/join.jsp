<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
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
	if(!f.name.value || f.name.value.trim().length == 0) {
		alert('이름을 입력하세요!');
		f.name.value="";
		f.name.focus();
		return false;
	}
	if(!f.gender.value || f.gender.value.trim().length == 0) {
		alert('성별을 입력하세요!');
		f.gender.value="";
		f.gender.focus();
		return false;
	}
	if(!f.email.value || f.email.value.trim().length == 0) {
		alert('비밀번호를 입력하세요!');
		f.email.value="";
		f.email.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body>
<%@ include file="../include/menu_join.jsp" %>
<br>
<div>
  <form action="${path}/member/joinAction" method="post" name="form1" onsubmit="return chk();">
    <h1 align="center">회원가입</h1><br>
    <label>아이디</label> 
    <input type="text" name="userid" placeholder="Your ID">
    <label>비밀번호</label>
    <input type="password" name="passwd" placeholder="Your Password">
    <label>이름</label>
    <input type="text" name="name" placeholder="Your Name">
    <label>성별</label>
    <select name="gender">
      <option value=""></option>
      <option value="남자">남자</option>
      <option value="여자">여자</option>
    </select>
    <label>이메일</label>
    <input type="email" name="email" placeholder="Your Email">
    <input type="submit" value="회원가입">
  </form>
  <c:if test="${message == 'existence_id'}">
  이미 존재하는 아이디 입니다.
  </c:if>
</div>

</body>
</html>