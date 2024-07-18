<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원가입 정보 입력 화면</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function duplicate(){
		console.log("아이디 중복검사 창 오픈");
		window.open("./duplication.do","중복검사","width=500px, height=500px");
	}
</script>
</head>
<body>
<div class="container">
	<form action="./signup.do" method="post">
		<h2>회원가입</h2>
		<h3>필수 값을 입력해주세요</h3>
		<div>
			<input class="form-control" type="text" name="name" id="name" placeholder="이름작성">
			<input class="form-control" type="text" name="id" id="id" placeholder="아이디작성(클릭시 중복체크 화면으로 이동)" maxlength="10"
					onclick="return duplicate()">
			<span id="result"></span>
			<input class="form-control" type="password" name="password" id="pw" placeholder="비밀번호 작성">
			<input class="form-control" type="password" id="psOk" placeholder="비밀번호 확인">
			<input class="form-control" type="text" name="email" id="email" placeholder="ex)info@gmail.com">
		</div>
		<div>
			<input class="btn btn-primary" type="submit" value="회원가입 완료">
			<input class="btn btn-danger" type="button" value="가입취소" onclick="javascript:history.back(-1)">
		</div>
	</form>
</div>

</body>
</html>