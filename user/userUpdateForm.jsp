<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	<div class="ui container">
		<h3 class="ui header">회원 정보 수정</h3>
		<form class="ui form" action="userUpdate.do" method="post" name="frm">
			<div class="field">
				<label>Email</label>
				<input type="email" name="userEmail" value="${loginUser.userEmail }">
			</div>
			<div class="field">
				<label>비밀번호</label>
				<input type="password" name="pwd" >
			</div>
			<div class="field">
				<label>비밀번호 확인</label>
				<input type="password" name="pwd_chk">
			</div>
			
			
			<button class="ui button" type="submit" onclick="return updateChk()">수정</button>
		</form>
	</div>
</body>
</html>