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

	$(function(){
		$("#loginchk").hide();    /* 로그인 정보가 잘못되었을 때 나타나게 하기 위한다. */
	});
	
	function login(){
		var memberid = $("#memberid").val().trim();
		var memberpw= $("#memberpw").val().trim();
		console.log(memberid + "/" + memberpw);
		
		if(memberid == null || memberid == "" || memberpw == null || memberpw == ""){
			alert("아이디와 비밀번호를 확인해 주세요.");
		}else{
			var loginVal = {
					"memberid" : memberid,
					"memberpw" : memberpw
			}
			
			$.ajax({
				type:"post",
				url:"ajaxlogin.do",
				data: JSON.stringify(loginVal),   //전송할 데이터 타입을 JSON형태의 문자열로 변환
				contentType:"application/json",   //서버에 데이터를 보낼 때 사용 content - type 헤더의 값
				dataType: "json",        //전송받는 데이터타입
				success: function(msg){
					if(msg.check == true){
						location.href="list.do";
					}else{
						$("#loginchk").show().text("ID or PW가 잘못되었습니다.");
					}
				},
				error: function(){
					alert("통신 실패.");
				}
			});
		}
	}
</script>
</head>
<body>
	<h1>Login</h1>

	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" id="memberid"/></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="password" id="memberpw"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="login" onclick="login();"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center" id="loginchk" style="color:red;"></td>
		</tr>
	</table>
		
</body>
</html>