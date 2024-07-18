<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원정보 상세</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>


<body>
	<div class="container">
		<h2>회원 상세조회</h2>
		<ul class="line-group">
			<li class="list-group-item">아이디:${vo.id }</li>
			<li class="list-group-item">이름:${vo.name }</li>
			<li class="list-group-item">AUTH:
			<c:choose>
				<c:when test="${vo.auth eq 'A' }">관리자</c:when>
				<c:otherwise>사용자</c:otherwise>
			</c:choose>
			</li>
			<li class="list-group-item">가입일:${vo.joindate }</li>
		</ul>
		<button class="btn btn-info" onclick="history.back(-1)">확인</button>
	</div>
</body>
</html>