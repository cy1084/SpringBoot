<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원관리</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	var btnOrder = "";

        document.addEventListener("DOMContentLoaded", function () {
            document.querySelectorAll("button[name=btnchk]").forEach(function (button) {
                button.addEventListener("click", function () {
                    btnOrder = this.value;
                    console.log(btnOrder);
                });
            });

            document.getElementById("searchDom").addEventListener("click", function () {
                var checkedRows = document.querySelectorAll('input[name=chkid]:checked');

                checkedRows.forEach(function (chkRow) {
                    var chkRowTagName = chkRow.parentNode.tagName;
                    console.log("dom", chkRowTagName);
                    var chkRowTagNameTR = chkRow.parentNode.parentNode.tagName;
                    console.log("domTR", chkRowTagNameTR);

                    var chkRowTrChild = chkRow.parentNode.parentNode.children[4].textContent;
                    console.log("dom child", chkRowTrChild);

                    chkRow.parentNode.parentNode.children[4].textContent = "관리자";
                });
            });
        });

        function checkBox() {
            var checCnt = document.querySelectorAll('input[name=chkid]:checked').length;
            console.log(checCnt);

            if (checCnt === 0) {
                alert("한개 이상의 수정 데이터를 선택해주세요");
                return false;
            } else {
                var data = new FormData(document.querySelector('form'));

                // 여러 항목을 배열로 서버로 전송
                var userIds = Array.from(document.querySelectorAll('input[name=chkid]:checked'))
                    .map(function (checkbox) {
                        return checkbox.value;
                    });

                userIds.forEach(function (userId) {
                    data.append('userIds', userId);
                });

                // AJAX POST 요청
                fetch('./managementUser.do', {
                    method: 'POST',
                    body: data
                })
                    .then(function (response) {
                        return response.text();
                    })
                    .then(function (msg) {
                        if (msg === "true") {
                            alert("변경되었습니다");
                        } else {
                            alert("변경사항이 없습니다");
                        }
                    })
                    .catch(function (error) {
                        console.error('Error:', error);
                        alert("잘못된 요청");
                    });
                return false;
            }
        }
</script>

</head>
<body>
	<div class="container">
		<h2>회원관리</h2>
		<form action="managementUser.do" method="post"
			onsubmit="return checkBox()">
			<table class="table">
				<thead>
					<tr>
						<th><input type="checkbox" onclick="allCheck(this.checked)"></th>
						<th>아이디</th>
						<th>이름</th>
						<th>이메일</th>
						<th>권한</th>
						<th>활성여부</th>
						<th>가입일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${listsVo}">
						<tr>
							<td><input type="checkbox" name="chkid" value="${vo.id}"></td>
							<td>${vo.id}</td>
							<td>${vo.name}</td>
							<td>${vo.email}</td>
							<td>${vo.auth eq 'U' ? '일반사용자' : '관리자'}</td>
							<td>${vo.enabled eq 'Y' ? '활성화' : '비활성화'}</td>
							<td>${vo.joindate}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="7" style="text-align: center;">
							<button name="btnChk" value="toAuth">관리자로 변경</button>
							<button name="btnChk" value="toUser">일반유저로 변경</button>
							<button name="btnChk" value="toNonActive">비활성화</button>
							<button name="btnChk" value="toactive">활성화</button>
							<button id="searchDom">탐색</button>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>