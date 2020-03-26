<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BoardDetail</h1>
	<table border="1">
		<tr>
			<th>이름</th>
			<td>${boarddetail.myid }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${boarddetail.mytitle }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea row="10" cols="60" readonly="readonly">${boarddetail.mycontent }</textarea></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${boarddetail.mycnt }</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정" onclick="location.href='boardupdate.do?myno=${boarddetail.myno}';"/>
				<input type="button" value="삭제" onclick="location.href='boarddelete.do?myno=${boarddetail.myno}';"/>
				<input type="button" value="목록" onclick="location.href='list.do';"/>
			</td>
		</tr>
	</table>

</body>
</html>