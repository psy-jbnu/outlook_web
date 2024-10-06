<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.1.1.min.js">

  </script>
</head>
<body>
		<h2>        </h2>
		<div class="field">
			<label>이름</label>
			<input name="contactName" type="text" value="${contact.contactName }" placeholder="이름">
		</div>
		<div class="field">
			<label>전화번호</label>
			<input name="tel" type="tel" value="${contact.tel }" >
			<input type="hidden" name="retel">
		</div>
		<div>
			<button class="ui button" type="button" onclick="telCheck()">중복 검사</button>
		</div>
		<div class="field">
			<label>주소</label>
			<input name="addr" type="text" value="${contact.addr }">		 
		</div>
		<div class="field">
		<label>이메일</label>
		<input name="email" type="email" value="${contact.email }">
		</div>
		<div class=field>
			<label>그룹</label>
			<select name="groupId" id="groupId">
				<c:forEach items="${groupIds }" var="groupId">
					<option value="${groupId }" label="${groups.get(groupId) }">${groups.get(groupId) }</option>
				</c:forEach>
				<option value="-1" label="그룹 추가" >그룹 추가</option>
			</select>

		</div>
			<button class="ui button" type="button" onclick="activeAddGroup()" >그룹 추가 활성화</button>
		<div class="field">
			<input type="hidden" name="newGroup" id="newGroup" placeholder="새로운 그룹">
		</div>
</body>
</html>