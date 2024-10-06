<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ContactsManager</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div class="ui container">
	<h3 class="ui header">메인 화면</h3>
</div>
<jsp:include page="contacts.jsp"></jsp:include>		
</body>
</html>