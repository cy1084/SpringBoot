<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>아이디 중복검사</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		document.getElementById("btnUseIf").style.display="none";
		
		//방법 2	_ jQuery
		//$("#btnUseIf").css("display","none");
			
	});
	
	function checkId() {
		var id = document.getElementById("id").value;
		//$("#id").val();
		console.log("id : " + id);
		
		if(id != ""){
			/* 
			$.ajax({
				url:"./duplicationAjax.do",
				type:"post",
				data:"checkId="+id,
				// dataType:"json",
				async:true,
				success:function(msg){
					console.log(msg, typeof msg);
					//var chk = JSON.parse(msg)
					//console.log(chk, typeof chk);
					if(msg == "true"){
						document.getElementById("condition").innerHTML = "사용가능한 아이디 입니다.";
						document.getElementById("btnUseId").style.display = "block";
					}else{
						document.getElementById("condition").innerHTML = "사용 할 수 없는 아이디 입니다.";
						document.getElementById("btnUseId").style.display = "none";
					}
				},
				error:function(){
					alert("잘못된 요청처리 입니다.");
					return;
				}
			});
			*/
			
			
			//fetch 함수에 넘겨줄 파라미터 셋팅
			const searchParams = new URLSearchParams();
			searchParams.set("checkId", id);

			// fetch 함수를 사용하여 AJAX 요청
			fetch("./duplicationAjax.do", {
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
				//console.log("data : " + data)
				if(data == "true"){
					document.getElementById("condition").innerHTML = "사용가능한 아이디 입니다.";
					document.getElementById("btnUseId").style.display = "block";
				}else{
					document.getElementById("condition").innerHTML = "사용 할 수 없는 아이디 입니다.";
					document.getElementById("btnUseId").style.display = "none";
				}
			})
			.catch(error => {
				console.error('Fetch error:', error);
				alert("관리자에게 문의하세요.");
			});
		}else{
			alert("아이디를 입력해주세요.");
			document.getElementById("id").focus();
		}
	}
	
	
	function useId(){
		var id = document.getElementById("id").value;
		opener.document.getElementById("id").value=id;
		opener.document.getElementById("pw").focus();
		self.close();
	}
	
	
/*	function checkId(){
		var id = document.getElementById("id").value;
	//	$("#id").val();
		console.log(id);
		
		if(id != ""){
			$.ajax{
				url:"./duplicationAjax.do",
				type:"post",
				data:"chechId="+id,
				success:function(){
					
				},
				error:function(){
					alert("잘못된 요청처리 입니다");
				}				
			});
		}else{
			alert("아이디를 입력해주세요");
		}
	}*/

</script>
</head>
<body>
<div class="container">
	<h4>아이디 중복확인</h4>
	<h4>아이디를 입력해주세요</h4>
	<input type="text" id="id" class="form-control">
	<input type="button" value="확인" class="btn btn-success" onclick="checkId()">
	<input type="button" value="사용하기" class="btn btn-info" id="btnUseId" onclick="useId()">
	<div id="condition"></div>
</div>
</body>
</html>