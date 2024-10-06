<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="script/jquery-3.1.1.min.js">
</script>
<script	src="script/semantic.min.js"></script>
<link rel="stylesheet"
	href="css/semantic.min.css">

<title>Insert title here</title>
<script type="text/javascript">
$('div.ui.dropdown.item')
.dropdown()
;
</script>
<c:if test="${loginUser == null }">
	<jsp:forward page="login.do"></jsp:forward>
</c:if>
<c:if test="${msg != null }">
	<script type="text/javascript">
		alert('${msg }')
	</script>

</c:if>
<style type="text/css">
div.ui.container{
	margin-top: 5px;
}
#head{
	margin: 15px;
}
</style>
</head>
<body>

	<div id="head" class="ui container">
	<h2 class="ui header">연락처 관리 프로그램</h2>
	</div>
	
	<div class="ui container menu">
		<a class="item" onclick="location.href='login.do'">메인 페이지</a>
		<a class="item" onclick="location.href='userUpdate.do'">회원 정보 수정</a>
		<a class="item" onclick="location.href='contactInsert.do'">연락처 추가</a>
		<a class="item" onclick="location.href='contactSearch.do'">연락처 검색</a>
		<a class="item" onclick="location.href='group.do'">그룹 보기</a>
		<div class="right menu">
			<div class="item">
				<button class="ui primary button"
					onclick="location.href='logout.do'">로그아웃</button>
			</div>
		</div>
	</div>
</body>
</html>