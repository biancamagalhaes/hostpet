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
	<session class="adocao">
		<h1 id="texto">Agora é só entrar em contato para adotar seu amiguinho!!!</h1>
		<div class="title" style="display: inline-flex; text-align: center;">
			<img src="assets/cat.png"/>
			<h1>${pet.nome}</h1>
		</div>
		<div class="doador">
			<img src="${pet.doador.foto}"/>
			<h1>${pet.doador.nome}</h1>
		</div>
		<a href="queroResp.jsp"><button>Receber contato para adoção do pet</button></a>
	</session>

</body>
</html>