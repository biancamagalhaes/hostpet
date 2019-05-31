<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=yes">
<link rel="stylesheet" type="text/css" href="doePagSeguro.css">
<link rel="icon" type="imagem/png" href="assets/logo.png" />
<title>HostPet</title>
</head>
<body>
	<c:import url="menu.jsp"></c:import>
	<session class="doacao">
		<h1>Clique abaixo para poder ajudar o projeto a seguir em frente!!!</h1>
		<div>
			<a href="https://pagseguro.uol.com.br/#rmcl"><img class="pag" src="assets/pagsegurogif.gif"/></a>
		</div>
	</session>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>