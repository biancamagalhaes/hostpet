<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=yes">
<link rel="stylesheet" type="text/css" href="menu.css">
<link rel="icon" type="imagem/png" href="assets/logo.png" />
<title>HostPet</title>
</head>
<body>
<header>
	<img class="logo" src="assets/logoAzul.png"/>
	<session class="sessi">
		<div style="width: 10em;" class="divsessi">
		<img alt="" src="assets/iconA.png" class="icons"/>
		<h1 class="texto" >Adote</h1>
		</div>
		<div class="divsessi">
		<img alt="" src="assets/iconB.png" class="icons"/>
		<a class="texto" href="cadastroPet.jsp">Cadastre um pet</a>
		</div>
		<div class="divsessi">
		<img alt="" src="assets/iconC.png" class="icons"/>
		<h1 class="texto">Meus pets</h1>
		</div>
		<div class="divsessi">
		<img alt="" src="assets/iconD.png" class="icons"/>
		<h1 class="texto">Em andamento</h1>
		</div>
	</session>
</header>
<div class="corpo">
	<div class="div1">
		<image src="assets/avatar.png" class="div1img"/>
		<h1 class="div1h1">${usuario.nome}</h1>
	</div>
	<div class="div2">
	<a class="div2a" href="editarPerfil.jsp">Editar Perfil</a>
	<a class="div2a" href="cadastroOng.jsp">Cadastrar Ong</a>
	<a class="div2a">Doe R$</a>
	<a class="div2a">Inserir Feedback</a>
	</div>
</div>
</body>
</html>