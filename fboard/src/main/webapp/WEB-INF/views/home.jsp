<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
<%@ include file="include/header.jsp" %>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="${path}/fboard/list">Go to "File Board"</a>

</body>
</html>
