<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>로그인 입력화면</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container" style="margin-top: 100px">
<form action="./login.do" method="post">
<table class="table table-hover">
<tr>
	<th>아이디</th>
	<td>
		<input type="text" name="id">
	</td>
</tr>
<tr>
	<th>비밀번호</th>
	<td>
		<input type="password" name="pw">
	</td>
</tr>
<tr>
	<th colspan="2">
		<input type="submit" value="로그인">
		<input type="button" value="회원가입" onclick="javascript:location.href='./signupForm.do'">
		<input type="button" value="아이디찾기" onclick="findId()"> <!-- 임베디드 방식 -->
	</th>
</tr>
</table>
</form>
</div>
</body>
<script type="text/javascript">
	function findId(){
		window.open("./findIdWindow.do","_blank","width=500px, height=300px");
	}
</script>

</html>