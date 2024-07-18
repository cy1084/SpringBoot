<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>글 상세 페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">	
		<h2>게시글 상세</h2>
		<div>
			<div class="form-control">아이디: ${vo.id}</div>
			<div class="form-control">제목: ${vo.title}</div>
			<div class="form-control">내용: ${vo.content}</div>
			<div class="form-control">작성일: ${vo.createat}</div>
		</div>
		<div>
			<input type="button" value="삭제" onclick="deleteOne()">
			<input type="button" value="수정" onclick="">
			<input type="button" value="답글" onclick="answerboardOne()">
		</div>
	</div>
	<script type="text/javascript">
	/* EL과 js를 같이 사용하는건 js를 임베디드 방식으로 할때 가능하다.... */
	function deleteOne() {
		console.log(${vo.seq});
		var seq = ${vo.seq};
		location.href="./multiDel.do?chkVal="+seq;
	}
	
	function answerboardOne() {
		console.log(${vo.seq});
		var seq = ${vo.seq};
		location.href="./replyInsert.do?seq="+seq;
	}
	</script>
</body>
</html>