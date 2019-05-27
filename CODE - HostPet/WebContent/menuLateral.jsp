<%@page import="hostpet.dao.UsuarioDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=yes">
<link rel="stylesheet" type="text/css" href="menuLateral.css">
<link rel="icon" type="imagem/png" href="assets/logo.png" />
<title>HostPet</title>
</head>
<body>
<div class="div1">
	<image src="assets/avatar.png"/>
	<h1><%
	UsuarioDAO u = new UsuarioDAO();
	Usuario nome = new Usuario();
	nome = u.menuLateral();
	%></h1>
</div>
<div class="div2">
<a>Editar Perfil</a>
<a>Cadastrar Ong</a>
<a>Doe R$</a>
<a>Inserir Feedback</a>
</div>
</body>
</html>