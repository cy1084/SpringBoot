<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>답글 입력</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
부모의 SEQ값 : ${param.seq }
	<div class="container">
		<h2>답글 입력폼</h2>
		<form action="./replyInsert.do" method="post">
			<input type="hidden" name="seq" value="${param.seq}">
			<div class="form-group">
				<label for="id">작성자</label>
				<input class="form-control" id="id" name="id" value="${sessionScope.loginVo.id}" readonly>
			</div>
			<div class="form-group">
				<label for="title">제목</label>
				<input class="form-control" name="title" required>
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea class="form-control" rows="5" name="content" required></textarea>
			</div>
			<div>
				<input type="submit" class="btn btn-success" value="답글입력">
				<input type="reset" class="btn btn-danger" value="글초기화">
				<input type="button" class="btn btn-info" value="뒤로가기" onclick="history.back(-1)">
			</div>
		</form>
	</div>
</body>
</html>