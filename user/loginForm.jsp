<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script type="text/javascript" src="../script/member.js"></script>
</head>
<body>
	<c:if test="${msg != null }">
		<script type="text/javascript">
			alert('${msg }')
		</script>
	</c:if>
	<form action="login.do" method="post" name="frm">
		<div class="ui container form">
			<div class="field">
				<label>Email</label> <input type="email" name="userEmail">
			</div>
			<div class="field">
				<label>비밀번호</label> <input type="password" name="pwd">
			</div>
			<div>
				<button class="ui primary button" type="submit" onclick="return loginOK()">로그인</button>
			</div>
		</div>
						
	</form>
</body>
</html>