<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보수정</title>
<%@ include file="../include/header.jsp" %>
<link rel="stylesheet" href="${path}/include/loginStyle.css">
<script>
function deleteMember(){
	if(confirm("탈퇴하시겠습니까?")){
		document.form1.action="${path}/member/deleteMember";
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
		alert('이메일을 입력하세요!');
		f.email.value="";
		f.email.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body>
<%@ include file="../include/menu_editMember.jsp" %>
<c:set var="vo" value="${dto}"/>
<br>
<div>
  <form action="${path}/member/editAction" method="post" name="form1" onsubmit="return chk();">
    <h1 align="center">회원정보수정</h1><br>
    <label>아이디</label> 
    <input type="text" name="userid" value="${vo.userid}" readonly="readonly">
    <label>비밀번호</label>
    <input type="password" name="passwd" placeholder="Your Password">
    <label>이름</label>
    <input type="text" name="name" value="${vo.name}">
    <label>성별</label>
    <c:if test="${vo.gender.trim() == '남자'}">
    <select name="gender">
      <option value=""></option>
      <option value="남자" selected="selected">남자</option>
      <option value="여자">여자</option>
    </select>
    </c:if>
    <c:if test="${vo.gender.trim() == '여자'}">
    <select name="gender">
      <option value=""></option>
      <option value="남자"> 남자</option>
      <option value="여자" selected="selected">여자</option>
    </select>
    </c:if>
    <label>이메일</label>
    <input type="email" name="email" value="${vo.email}">
    <lable>사용자 레벨</lable>
    <input type="text" name="user_level" value="${vo.user_level}" readonly="readonly">
    <input type="submit" value="정보수정">
    <input type="Button" value="회원탈퇴" onclick="deleteMember()">
  </form>
 </div>
</body>
</html>