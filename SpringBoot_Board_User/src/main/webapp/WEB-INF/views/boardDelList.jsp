<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>삭제글 리스트 </title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>


<body>
<div class="container">
<c:set var="len" value="${fn:length(lists)}"/>
		TOTAL : ${len }
		<table class="table">
			<thead>
				<tr class="info">
					<th><input type="checkbox" onclick="allValues(this.checked)"> </th>
					<th>연번</th>
					<th>아이디</th>
					<th>제목</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${lists }" varStatus="vs">
					<tr>
						<td>${vs.count }</td>
						<td>${vo.id }</td>
						<td>
							<div id="viewTitle"><a href="./restoreDetailBoard.do?seq=${vo.seq }" title="${vo.title }">${vo.title }</a> </div>
						</td>
						<td>
						<fmt:parseDate var="cDate" value="${vo.createat }" pattern="yyyy-MM-dd"/>
						<fmt:formatDate value="${cDate }"/>
						${vo.createat }
						</td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
</div>
</body>
</html>