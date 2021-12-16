<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%@ include file="menu.jsp" %>
		<h1>Bonjour ${auteur.prenom}!</h1>
		<p>${auteur.actif ? 'Vous etes très actif !' : 'Vous etes inactif !' }
	</body>
</html>