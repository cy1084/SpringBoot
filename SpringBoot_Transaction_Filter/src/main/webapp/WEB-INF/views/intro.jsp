<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫 페이지 intro</title>
</head>
<body>
	<fieldset>
		<legend>전체조회</legend>	
		<a href="./selectJobs.do">jobs 전체조회</a>	
	</fieldset>
	
	<fieldset>
		<legend>입력</legend>	
		<div>
			<form action="./insertJob.do" method="post">
				아이디:<input name="job_id" value="IT_Man"><br>
				직업:<input name="job_title" value="IT 전문가"><br>
				최소급여:<input name="min_salary" value="1000"><br>
				최대급여:<input name="max_salary" value="10000"><br>
				<input type="submit" value="입력">
			</form>
		</div>
	</fieldset>
	
	<fieldset>
		<legend>수정</legend>
		<a href="./updateJob.do">jobs 수정</a>		
	</fieldset>
	
	<fieldset>
		<legend>트랜잭션 처리</legend>
		<a href="./transaction.do">업데이트 성공/ 인서트 실패</a>
	</fieldset>
</body>
</html>