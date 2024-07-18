<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시글 전체보기</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function chkBox(){
		var chks = document.getElementsByName("chkVal");
		var cnt =0;
		for(let c of chks){
			if(c.checked){
				cnt++;
			}
		}
		if(cnt==0){
			alert('한개이상의 글을 선택해주세요');
			return false;
		}
	}
	
	function allValues(val) {
		var chks = document.getElementsByName("chkVal");
		for(let c of chks){
			c.checked =val;
		}
	}

</script>
<style type="text/css">
	.viewTitle{
		width: 100px;
 		white-space: nowrap; 
		overflow: hidden;
		text-overflow: ellipsis;
	}
	div>a{
		text-decoration: none;
		color: black;
		cursor: pointer;
	}
	div>a:hover{
		text-decoration: none;
		color: black;
	}
</style>
</head>
<body>
	<div class="container">
		<c:if test="${loginVo != null}">
			${loginVo.id}님, 반갑습니다!
			<input type="button" value="로그아웃"
				onclick="location.href='./logout.do'">
		</c:if>
		<c:if test="${loginVo.auth == 'A'}">
			<input type="button" value="회원관리"
				onclick="location.href='./managementUser.do'">
		</c:if>
		<hr>
		<form action="./multiDel.do" method="post" onsubmit="return chkBox()">
			<input type="submit" value="다중삭제">
			<input type="button" value="새글입력" onclick="location.href='./insertBoard.do'">
			<c:if test="${loginVo.auth eq 'A'}">
				<input type="button" value="회원전체조회"
					onclick="location.href='./userSelectAll.do'">
				<input type="button" value="게시글복구"
					onclick="location.href='./restoreBoard.do'">
			</c:if>
			<c:set var="len" value="${fn:length(lists)}" />
			TOTAL : ${len}
			<table class="table">
				<thead>
					<tr>
						<th><input type="checkbox" onclick="allValues(this.checked)"></th>
						<th>연번</th>
						<th>제목</th>
						<th>내용</th>
						<th>작성자</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${lists}" varStatus="vs">
						<tr>
							<td><input type="checkbox" name="chkVal" value="${vo.seq}"></td>
							<td>${vs.count}</td>
							<td><div class="viewTitle"><c:if test="${vo.depth > 0}">[답글] </c:if>
								<a href="./detailBoard.do?seq=${vo.seq}" title="${vo.title}">${vo.title}</a></div></td>
							<td>${vo.content}</td>
							<td>${vo.id}</td>
							<td>
								<fmt:parseDate var ="cDate" value="${vo.createat}" pattern="yyyy-MM-dd"/>
								<fmt:formatDate value="${cDate}"/>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5"></td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>