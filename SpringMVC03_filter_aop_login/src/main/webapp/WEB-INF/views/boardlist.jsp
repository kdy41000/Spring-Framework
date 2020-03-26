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
	<h1>BoardList</h1>
	<table border="1">
		<tr>
			<th>No</th>
			<th>이름</th>
			<th style="width:100px;">제목</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<c:choose>
			<c:when test="${empty boardlist }">
				<tr>
					<td colspan="4" align="center">---작성된 글이 없습니다---</td>
				</tr>
			</c:when>
		
		<c:otherwise>
		<c:forEach items="${boardlist }" var="list">
		<tr>
			<td>${list.myno }</td>
			<td>${list.myid }</td>
			<td><a href="boarddetail.do?myno=${list.myno }">${list.mytitle }</a></td>
			<td>${list.mydate }</td>
			<td>${list.mycnt }</td>
		</tr>
		</c:forEach>
		</c:otherwise>
		</c:choose>
	</table>
	<input type="button" value="글쓰기" onclick="location.href='boardwrite.do';"/>
</body>
</html>