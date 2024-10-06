<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="ui container">
	<form action="contactDelete.do" method="post" name="frm" >
	
	
		<button type="submit" class="ui button">삭제</button>
		<table class="ui single line table">
			<thead>
				<tr>
					<th></th>
					<th>번호</th>
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
				<c:forEach items="${contacts  }" var="contact" varStatus="i">
					<tr>
						<td>
							<div>
								<input type="checkbox" name="tel_chk" value="${contact.tel }">
							</div>
						</td>
						<td>${i.index+1 }</td>
						<td>${contact.contactName }</td>
						<td>${contact.tel }</td>
						<td>${contact.addr }</td>
						<td>${contact.email }</td>
						<td>${groups.get(contact.groupId) }</td>
						<td>
							<button  class="ui primary basic button" type="button" 
								onclick="location.href='contactUpdate.do?tel=${contact.tel }'">수정</button> 
						</td>
						<td>
							<button class="ui negative basic button" type="button" 
								onclick="location.href='contactDelete.do?tel=${contact.tel }'">삭제</button>
						</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</form>
</div>	
</body>
</html>