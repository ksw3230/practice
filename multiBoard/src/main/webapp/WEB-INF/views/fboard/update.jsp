<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script src="${path}/include/js/common.js"></script>
<!-- include libraries(bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>
<script>
$(function(){
	
	
	
	$(".fileDrop").on("dragenter dragover",function(e){
		e.preventDefault();
	});
	$(".fileDrop").on("drop",function(e){
		e.preventDefault();
		var files=e.originalEvent.dataTransfer.files;
		var file=files[0];
		var formData=new FormData();
		formData.append("file",file);
		$.ajax({
			url: "${path}/fboard/uploadFile",
			data: formData,
			dataType: "text",
			processData: false,
			contentType: false,
			type: "post",
			success: function(data){
				var fileInfo=getFileInfo(data);
				var html="<a href='"+fileInfo.getLink+"'>"+	fileInfo.fileName+"</a><br>";
				html += "<input type='hidden' class='file' value='" + fileInfo.fullName + "'>";
				$("#uploadedList").append(html);
			}
		});
	});
	
	//수정 버튼
	$("#btnUpdate").click(function(){
		//첨부파일 이름들을 폼에 추가
		var str="";
		$("#uploadedList .file").each(function(i){
			str+=
				"<input type='hidden' name='files["+i+"]' value='"
				+$(this).val()+"'>";
		});
		$("#form1").append(str);
		document.form1.action="${path}/fboard/update";
		document.form1.submit();
	});
	
	listAttach();
	
	//첨부파일 삭제
	$("#uploadedList").on("click",".file_del",function(e){
		var that=$(this); //클릭한 태그
//data: {fileName: $(this).attr("data-src") },		
		$.ajax({
			type: "post",
			url: "${path}/fboard/deleteFile",
			data: "fileName="+	$(this).attr("data-src"),		
			dataType: "text",
			success: function(result){
				if(result=="deleted"){
					//화면에서 태그 제거
					that.parent("div").remove();
				}
			}
		});
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
					html+="<a href='#' class='file_del' data-src='"
						+this+"'>[삭제]</a></div>";
				$("#uploadedList").append(html);
			});
		}
	});
}

</script>

<style>
.fileDrop {
             border: 2px dashed #92AAB0;
             width: 600px;
             height: 150px;
             color: #92AAB0;
             text-align: center;
             vertical-align: middle;
             padding: 10px 0px 10px 10px;
             font-size:200%;
             display: table-cell;
          }
</style>
</head>
<body>
<%@ include file="../include/menu_fboard.jsp" %>
<link rel="stylesheet" href="${path}/include/tableStyle2.css">
<br><br>
<form id="form1" name="form1" method="post" action="${path}/fboard/insertOK">
<input type="hidden" name="currentPage" value="${currentPage}">
<input type="hidden" name="idx" value="${dto.idx}">

<table align="center" width="600px">
<tr>
	<th class="title">수정</th>
</tr>
<tr>	
	<td>제목<input name="title" id="title" size="80" value="${dto.title}"></td>
</tr>
<tr>
	<td>내용 
		<textarea id="content" name="content">${dto.content}</textarea>
		<script>
		$(function() {
			//id가 memo인 태그를 summernote로 변경
			$("#content").summernote({
				height : 150,
				width : 600
			});
		});
		</script>
	</td>	
</tr>
<tr>
	<td>
		첨부파일 등록
		<div class="fileDrop">Drag & Drop Files Here</div>
		<div id="uploadedList"></div>
	</td>
</tr>
<tr>
	<td class="right">
		<button type="button" id="btnUpdate">수정</button>
		<input type="button" value="돌아가기" onclick="history.go(-1)"/>
		<input type="button" value="리스트로" onclick="location.href='${path}/fboard/list?currentPage=${currentPage}'"/>
	</td>
</tr>
	
</tr>
</table>
</form>

</body>
</html>