<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<ul>
  <li><a href="${path}">Untitled</a></li>
  <li><a href="${path}">메인</a></li>
  <li><a href="${path}/greet/list">가입인사</a></li>
  <li><a href="${path}/board/list">답변형게시판</a></li>
  <li class="active"><a href="${path}/imageBoard/list">이미지게시판</a></li>
  <li><a href="${path}/fboard/list">파일게시판</a></li>
  <c:if test="${sessionScope.admin_userid != null}">
  	<li><a href="${path}/admin/manage_member">회원관리</a></li>
  </c:if>
  <c:if test="${sessionScope.userid == null && sessionScope.admin_userid == null}">
	  <li class="dropdown right">
	    <a href="javascript:void(0)" class="dropbtn">로그인/회원가입</a>
	    <div class="dropdown-content">
	      <a href="${path}/member/login">로그인</a>
	      <a href="${path}/member/join">회원가입</a>
	    </div>
	  </li>
  </c:if>
  <c:if test="${sessionScope.userid != null}">
  	<li class="dropdown right">
	    <a href="javascript:void(0)" class="dropbtn">회원정보</a>
	    <div class="dropdown-content">
  			<a href="${path}/member/edit">정보수정</a>
  			<a href="${path}/member/logout">로그아웃</a>
  		</div>
  	</li>		
  </c:if>
  <c:if test="${sessionScope.admin_userid != null}">
  	<li class="dropdown right">
	    <a href="javascript:void(0)" class="dropbtn">관리자모드</a>
	    <div class="dropdown-content">
  			<a href="${path}/admin/logout">로그아웃</a>
  		</div>
  	</li>		
  </c:if>
</ul>