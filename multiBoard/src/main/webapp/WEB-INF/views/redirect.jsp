<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>

<html>
<body>
<script type="text/javascript">
var message = '${message}';
var returnUrl = '${path}/${url}';
alert(message);
document.location.href = returnUrl;
</script>
</body>
</html>
