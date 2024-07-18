<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>[관리자] 사용자 조회</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>


<body>
<div class="container">
	<h2>[관리자]회원전체 조회</h2>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>이름</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${lists }" varStatus="vs">
				<tr>
					<td>${vs.count }</td>
					<td>${vo.id }</td>
					<td>${vo.name }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<fieldset>
			<legend>회원 검색</legend>
			<form name="search-frm" autocomplete="on">
			<select name="type" id="type">
				<option value="id" selected>아이디</option>
				<option value="name">성명</option>
			</select>
			
			<input type="text" name="keyword" placeholder="이름을 작성해 주세요">
			<input type="button" value="검색" onclick="getSearchUser()">
			
			</form>
			<div id="viewDetail">
			</div>
		</fieldset>
	</div>
</div>

<script type="text/javascript">

function getSearchUser(){
	var opt = $("#type option:selected").val();
	var keyword = $("input[name=keyword]").val();
	
	console.log(opt, keyword);
	
	$.ajax({
		url:"./getSearchUser.do",
		method:"post",
		data:{"opt":opt,"keyword":keyword},
		dataType:"json",
		success:function(msg){
			//console.log(msg);
			//console.log(msg.length);
			//console.log(msg[0].name);
			//console.log(msg[0]["id"]);
			
			var jArray = msg;
			
			Object.keys(jArray).forEach(function(key){
				console.log(key,jArray[key], jArray[key].name)
			});
			for(var key in jArray){
				console.log(key,jArray[key].name)
			}
			
			var html = "<table class='table table-hover'>";
			$.each(msg,function(key,value){
				html +="<tr>"
				html +="<td>"+(key+1)+"</td>"
				html +="<td><a href='./userSelectOne.do?id="+value.id+"'>"+value.id+"</a></td>";
				html +="<td>"+value.name+"</td>";
				html +="</tr>";
			});
			$("tbody").html(html);
			
		},
		error:function(){
			console.log("통신실패")
		}
	});
}
</script>



<!-- <script type="text/javascript">
function getSearchUser() {
    var opt = document.getElementById('type').options[document.getElementById('type').selectedIndex].value;
    var keyword = document.querySelector('input[name=keyword]').value;

    console.log(opt, keyword);

    fetch("./getSearchUser.do", 
    		{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: {"opt":opt,"keyword":keyword}
        	
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('연결실패');
        }
        return response.json();
    })
    .then(data => {
        // 서버로부터 받은 JSON 데이터를 처리
        console.log(data);

        // HTML 생성
        var html = "<table class='table table-hover'>";
        data.forEach(function (value, index) {
            html += "<tr>";
            html += "<td>" + (index + 1) + "</td>";
            html += "<td><a href='./userSelectOne.do?id=" + value.id + "'>" + value.id + "</a></td>";
            html += "<td>" + value.name + "</td>";
            html += "</tr>";
        });
        html += "</table>";

        // 테이블의 tbody에 HTML 추가
        document.querySelector('tbody').innerHTML = html;
    })
    .catch(error => {
        console.error('There has been a problem with your fetch operation:', error);
    });
}
</script> -->

</body>
</html>