<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>form</title>
	</head>
	<body>
		<%@ include file="menu.jsp" %>
		<p>Welcome <c:if test="${!empty name}"><c:out value="${name} !" /></c:if></p>
		
		<form method="post" action="">
		<p>
			<label for="name">Name: </label>
			<input type="text" id="name" name="name" />
		</p>
		<p>
			<label for="login">Login: </label>
			<input type="text" id="login" name="login" />
		</p>
		<p>
			<label for="password">Password: </label>
			<input type="password" id="password" name="password" />
		</p>
			
			<input type="submit" />
		</form> 
		<c:if test="${!empty form.result}"><c:out value="${form.result} !" /></c:if> 
		
		<h2>Use Session</h2>
		<c:if test="${!empty sessionScope.nameWithSession}">
			<p>Welcome ${sessionScope.nameWithSession} !</p>
		</c:if>
	</body>
</html>