<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="../script/group.js"></script>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	<div class="ui container">
		<h3 class="ui header">그룹원 보기</h3>
	</div>
	<div class="ui container">
		<table class="ui single line table">
			<thead >
				<tr>
					<th>번호</th>
					<th>그룹명</th>
					<th>그룹원 보기</th>
					<th>삭제</th>
				</tr>			
			</thead>
			<tbody>
				<c:forEach var="groupId" items="${groupIds }" varStatus="i">
					<tr>
						<td>${i.index +1 }</td>
						<td>${groups.get(groupId) }</td>
						<td><button class="ui secondary basic button" type="button"  onclick="location.href='groupMember.do?groupId=${groupId}'">그룹원 보기</button>
						<td><button class="ui negative basic button" type="button"  onclick="location.href='groupDelete.do?groupId=${groupId}'">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
		
</body>
</html>