<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>아이디찾기</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
	onload = function (){
		document.getElementById('name').focus();
	}
	function findId() {
		var name = document.getElementById("name").value;
		var email = document.getElementById("email").value;
		var info = document.getElementById("info");
		info.innerHTML = "";

		var regEx = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		console.log(name, email);
		if (email.match(regEx)) {
			/* 
			$.ajax({
				url : "./findId.do",
				type : "post",
				async : true,
				data : {
					"name" : name,
					"email" : email
				},
				success : function(data) {
					if (data == "") {
						info.innerHTML = "아이디를 찾을 수 없습니다.";
					} else {
						info.innerHTML = "회원님의 아이디는 ["+ data + "] 입니다.";
					}
				},
				error : function() {
					alert("관리자에게 문의하세요.")
				}
			});
			*/
			
			
			//fetch 함수에 넘겨줄 파라미터 셋팅
			const searchParams = new URLSearchParams();
			searchParams.set("name", name);
			searchParams.set("email", email);

			// fetch 함수를 사용하여 AJAX 요청
			fetch("./findId.do", {
				method: "POST",
				headers: {
				    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
				},
				body: searchParams
			})
			.then(response => {
				if (!response.ok) {
					throw new Error("HTTP error! Status: "+response.status);
				}
				return response.text(); // 서버에서 받아온 데이터를 텍스트로 변환
			})
			.then(data => {
				var info = document.getElementById("info");
				
				if (data === "") {
					info.innerHTML = "아이디를 찾을 수 없습니다.";
				} else {
					info.innerHTML = "회원님의 아이디는 ["+ data + "] 입니다.";
				}
			})
			.catch(error => {
				console.error('Fetch error:', error);
				alert("관리자에게 문의하세요.");
			});

		} else {
			info.innerHTML = "이메일 형식이 아닙니다.";
		}
	}
</script>
<body>
	<div class="container" style="margin-top: 50px;">
		이름:<input type="text" id="name">
		이메일:<input type="text" id="email">
		<br><br>
		<input type="button" value="아이디찾기" onclick="findId()">
		<input type="button" value="창닫기" onclick="javascript:self.close()"><br>
		<p id="info"></p>
	</div>
</body>
</html>