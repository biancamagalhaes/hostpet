<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=yes">
<link rel="stylesheet" type="text/css" href="quero.css">
<link rel="icon" type="imagem/png" href="assets/logo.png" />
<title>HostPet</title>
</head>
<body>
	<c:import url="menu.jsp"></c:import>
		<session class="adocao" style="display: block; margin-left: 9em; padding-top: 6em;">
			<h1 id="texto">O telefone de </h1>
			<h1 id="texto">${pet.adotante}</h1>
			<h1 id="texto"> foi enviado por SMS e Email pra você!!</h1>
		</session>

</body>
</html>