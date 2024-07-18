<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>새글쓰기 화면</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<form action="./insertBoard.do" method="post">
			<div class="form-group">
				<label for="id">아이디 :</label>	<!-- label 영역을 눌러도 인풋태그에 포커스가 간다. -->
				<div class="form-control">${loginVo.id}</div>
			</div>
			<div class="form-group">
				<label for="title">제목 :</label>
				<input type="text" class="form-control" id="title" name="title">
			</div>
			<div class="form-group">
				<label for="content">내용 :</label>
				<textarea rows="5" class="form-control" id="content" name="content"></textarea>
			</div>
			<button type="submit" class="btn btn-default">글작성</button>
			<button class="btn btb-default" onclick="history.back(-1)">뒤로가기</button>
		</form>
	</div>

</body>
</html>