<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>삭제글 상세 </title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>


<body>
	<div class="container">
		<h2>게시글 상세</h2>
		<div>
			<div class="form-control">아이디: ${vo.id }</div>
			<div class="form-control">제목:${vo.title}</div>
			<div class="form-control">내용:${vo.content }</div>
			<div class="form-control">작성일:${vo.createat }</div>
		</div>
		<div>
			<input type="button" value="복구" >
		</div>
	</div>
	<script type="text/javascript">
		var btn = document.getElementsByTagName("input")[0];
//		btn.addEventListener("click", function(event){
//			console.log(evnt.clientX);
//		});

	btn.addEventListener("click",restore);
	
	function restore(evnt){
		console.log(event);
		location.href="./restoreDelFlag.do?seq="+${vo.seq}
	}
		
		
	</script>
</body>
</html>