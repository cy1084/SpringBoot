<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과보기</title>
</head>
<body>
	<button onclick="javascript:history.back(-1)">뒤로가기</button>
	
	<fieldset>
		<legend>전체 조회 결과</legend>
		<div>
			<c:forEach var="vo" items="${lists}"> 
				${vo}<br>
			</c:forEach>
		</div>
	</fieldset>
	
	<fieldset>
		<legend>입력 결과</legend>
		<div>
			${insertResult}
		</div>
	</fieldset>
	
	<fieldset>
		<legend>수정 결과</legend>
		<div>
			${updateResult}
		</div>
	</fieldset>
</body>
</html>