<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script src="${path}/include/js/common.js"></script>
<script>

$(function(){
	
	listAttach();
	
	//삭제 버튼
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까?")){
			document.form1.action="${path}/fboard/delete";
			document.form1.submit();
		}
	});
	
});


//첨부파일 리스트를 출력하는 함수
function listAttach(){
	$.ajax({
		type: "post",
		url: "${path}/fboard/getAttach/${dto.idx}",
		success: function(list){
			$(list).each(function(){
				var fileInfo=getFileInfo(this);
				var html="<div><a href='"+fileInfo.getLink+"'>"
					+fileInfo.fileName+"</a>&nbsp;&nbsp;";
				$("#uploadedList").append(html);
			});
		}
	});
}

</script>
</head>
<body>
<%@ include file="../include/menu_fboard.jsp" %>
<link rel="stylesheet" href="${path}/include/tableStyle2.css">
<br><br>
<form id="form1" name="form1" method="post">
<input type="hidden" name="currentPage" value="${currentPage}">
<input type="hidden" name="idx" value="${dto.idx}">
<table align="center">
<tr>
	<th class="title">
		<h2>내용보기</h2>
	</th>
<tr>	
	<td>제목 : ${dto.title}</td>
</tr>
<tr>
	<td>
		작성자 : ${dto.userid}
	</td>
</tr>
<tr>
	 <td class="right"> <div id="uploadedList">파일 : &emsp;</div></td>
</tr>
<tr>
	<td>
		내용 :<br> 
		${dto.content}
	</td>
</tr>
<tr>
	<td class="right">
		<input type="button" value="리스트로" onclick="location.href='${path}/fboard/list?currentPage=${currentPage}'"/>
		<%-- <c:if test="${sessionScope.userid == dto.userid.trim() || sessionScope.admin_userid != null}"> --%>
		<input type="button" value="수정하기" onclick="location.href='${path}/fboard/contentView?currentPage=${currentPage}&idx=${dto.idx}&job=fboard/update'"/>
		<button type="button" id="btnDelete">삭제하기</button>
		<%-- </c:if> --%>
	</td>
</tr>		
</table>
</form>
</body>
</html>