<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=yes">
<link rel="stylesheet" type="text/css" href="editarPerfil.css">
<link rel="icon" type="imagem/png" href="assets/logo.png" />
<title>HostPet</title>
</head>
<body>
	<c:import url="menu.jsp"></c:import>
	
	<form class="formulario" action="usuarios" method="post" type="submit">
		<h1>Cadastro Ong:</h1>
		<session class="divform">
		<div style="display: block">
	   		<h4>Nome</h4>
			<input placeholder="nome" name="nome" type="text"/>
		</div>
		<div style="display: block">
			<h4>Email</h4>
			<input placeholder="email" name="email" type="email"/>
		</div>
		<div style="display: block">
			<h4>Cidade</h4>
			<input placeholder="cidade" name="cidade" type="text"/>
		</div>
		<div style="display: block">
			<h4>Estado</h4>
			<input placeholder="estado" name="estado" type="text"/>
		</div>
		<div style="display: block">
			<h4>Telefone</h4>
			<input placeholder="xxx.xxx.xxx-xx" name="telefone" type="text"/>
		</div>
		<div style="display: block">
			<h4>Descrição</h4>
			<textarea class="area" placeholder="descrição" name="descricao" type="text"></textarea>
		</div>
		<div style="display: block">
			<h4 style="margin-left: 0.65em;">Foto</h4>
			<img/>
		</div>
		</session>
		<button type="submit">Cadastrar</button>
	</form>
	
	<c:import url="rodape.jsp"></c:import>
</body>
</html>