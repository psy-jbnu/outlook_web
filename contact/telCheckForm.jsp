<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<title>중복 검사</title>
<script type="text/javascript" src="script/contact.js"></script>
<style type="text/css">
div{
	margin: 10px;

}
</style> 
</head>

<body>
	<div id="head" class="ui container">
	<h2 class="ui header">전화번호 중복 검사</h2>
	</div>
	<div class="ui container" >
		<form action="telCheck.do" method="get" name="frm">
			<div class="ui action input">
	  			<input type="tel" placeholder="전화번호" value="${tel }" name="tel">
				<button class="ui button" type="submit">중복 검사</button>
			</div>		
		</form>
	</div>
	<div class="ui container">
		<c:if test="${result != 1 }">
			이 전화번호는 사용 가능합니다.
			<button class="ui button" type="button" onclick="telOk()">사용</button>
		</c:if>
		<c:if test="${result == 1 }">
			이 전화번호는 사용 하실 수 없습니다..
		</c:if>
	</div>
	
		
</body>
</html>