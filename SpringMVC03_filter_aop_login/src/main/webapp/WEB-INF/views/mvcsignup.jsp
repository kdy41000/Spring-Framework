<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
function signup(){
	if($("input[name=memberid]").val()==""){
		alert("아이디를 입력해주세요.");
		return false;
	}else if($("input[name=memberpw]").val()==""){
		alert("비밀번호를 입력해주세요.");
		return false;
	}else if($("input[name=membername]").val()==""){
		alert("이름을 입력해주세요.");
		return false;
	}else{
		$("form").submit();
	}
}
</script>
</head>
<body>
<form action="signupres.do" method="post">
	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" name="memberid"/></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="password" name="memberpw"/></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="membername"/></td>
		</tr>	
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="signup" onclick="signup();"/>
			</td>
		</tr>
	</table>
</form>	
</body>
</html>