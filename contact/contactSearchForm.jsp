<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	<div class="ui container">
		<h3>연락처 검색</h3>
		<form action="contactSearch.do" method="post" name="frma">
			<div class="ui action input">
				<input type="text" placeholder="검색" name="searchVal">
				<button class="ui button" type="submit">검색</button>
			</div>
		</form>
	</div>
	<div class="ui container">
		<c:if test="${scontacts!=null  }">
			<form action="contactDelete.do" method="post" name="frm">
				<button type="submit" class="ui button">삭제</button>
				<table class="ui single line table">
					<thead>
						<tr>
							<th></th>
							<th></th>
							<th>이름</th>
							<th>전화번호</th>
							<th>주소</th>
							<th>이메일</th>
							<th>그룹</th>
							<th>수정</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${scontacts  }" var="contact" varStatus="i">
							<tr>
								<td><input type="checkbox" name="tel_chk"
									value="${contact.tel }"></td>
								<td>${i.index+1 }</td>
								<td>${contact.contactName }</td>
								<td>${contact.tel }</td>
								<td>${contact.addr }</td>
								<td>${contact.email }</td>
								<td>${groups.get(contact.groupId) }</td>
								<td>
									<button type="button" class="ui primary basic button"
										onclick="location.href='contactUpdate.do?tel=${contact.tel }'">수정</button>
								</td>
								<td>
									<button type="button" class="ui negative basic button"
										onclick="location.href='contactDelete.do?tel=${contact.tel }'">삭제</button>
								</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>

			</form>
		</c:if>
	</div>
</body>
</html>