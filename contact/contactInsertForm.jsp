<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연락처 추가</title>
<script type="text/javascript" src="../script/contact.js"></script>
<script type="text/javascript" src="../script/group.js"></script>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	<div class="ui container">
		
		<h3 class="ui header">연락처 추가</h3>
		<form method="post" name="frm" action="contactInsert.do" class="ui form">
			<jsp:include page="contactForm.jsp"></jsp:include>
			<button class="ui button"type="submit" onclick="return regiCheck()">추가</button>
		</form>
	</div>
	
</body>
</html>