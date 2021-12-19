<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
<body>
	<h2>Use Session Other JSP</h2>
		<c:if test="${!empty sessionScope.nameWithSession}">
			<p>Welcome ${sessionScope.nameWithSession} !</p>
		</c:if>
</body>
</html>