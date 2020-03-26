<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${res > 0 }">
<script type="text/javascript">
	alert("회원가입 완료");
	location.href="loginform.do";
</script>	
	</c:when>
	<c:otherwise>
<script type="text/javascript">
	alert("회원가입 실패");
	location.href="signupform.do";
</script>
	</c:otherwise>
</c:choose>
</body>
</html>