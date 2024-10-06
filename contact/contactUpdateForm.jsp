<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="../script/contact.js"></script>
<script type="text/javascript" src="../script/group.js"></script>
<title>Insert title here</title>

</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	<div class="ui container">
	<h3 class="ui header">연락처 수정</h3>
		<form class="ui form" method="post" name="frm" action="contactUpdate.do">
			<jsp:include page="contactForm.jsp"></jsp:include>
			<input name="oldTel"type="hidden" value="${oldTel }">
			<button class="ui button" type="submit" onclick="return regiCheck()">수정</button>
		</form>
	</div>
</body>
</html>