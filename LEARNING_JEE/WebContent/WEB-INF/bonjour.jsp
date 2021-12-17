<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Welcome</title>
	</head>
	<body>
		<%@ include file="menu.jsp" %>
		<h1>Welcome ${auteur.prenom}!</h1>
		<h1><c:out value="Bonjour avec JSTL !" /></h1>
		<p>${auteur.actif ? 'You are active !' : 'You are inactive !'}</p>
		
		<h2>JSTL and variables</h2>
		<c:set var="session" value="Scope by session" scope="session" />
		<c:out value="${session}" /><br />
		<c:set var="request" value="Scope by Request" scope="request" />
		<c:out value="${request}" /><br />
		<c:set var="application" value="Scope by Application" scope="application" />
		<c:out value="${application}" /><br />
		
		<h3>Use Java Beans</h3>
		<c:set target="${auteur}" property="prenom" value="Aymen" />
		<c:out value="Welcome ${auteur.prenom}" />
		
		<h3>remove variable</h3>
		<c:remove var="session" scope="session" />
		<c:out value="${session}" default="Removed"/><br />
		
		<h2>JSTL and Conditions</h2>
		<c:if test="${50>10}" var="result">
			<p>It's true</p>
		</c:if>
		<c:choose>
			<c:when test="${10 == 5}">First Test</c:when>
			<c:when test="${10 < 15}">Second Test</c:when>
			<c:otherwise>Not found</c:otherwise>
		</c:choose>
	</body>
</html>