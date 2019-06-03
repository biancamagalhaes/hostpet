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
	
	<form class="formulario" action="pets" method="post" type="submit" enctype="multipart/form-data" style="margin-bottom: 5em">
		<h1>Cadastre um amiguinho!!</h1>
		<session class="divform">
		<div>
			<h4 style=" margin-bottom: 1em;">Tipo</h4>
			<select name="tipo">
				<option value="gato">Gato</option>
				<option value="cachorro">Cachorro</option>
			</select>
		</div>
		<div style="display: block">
	   		<h4>Nome</h4>
			<input placeholder="nome" name="nome" type="text"/>
		</div>
		<div style="display: block">
			<h4>Idade</h4>
			<input placeholder="idade" name="idade" type="number"/>
		</div>
		<div style="display: block">
			<h4 style=" margin-bottom: 1em;">Sexo</h4>
			<select>
				<option value="femea">Fêmea</option>
				<option value="macho">Macho</option>
			</select>
		</div>
		<div style="display: block">
			<h4 style=" margin-bottom: 1em;">Porte</h4>
			<input  name="porte" type="range" min="0" max="100"/>
		</div>
		<div style="display: block">
			<h4>Bairro</h4>
			<input placeholder="bairro" name="bairro" type="text"/>
		</div>
		<div style="display: block;">
			<h4 style="margin-left: 0.65em;">Temperamento</h4>
			<input placeholder="em 3 palavras" name="temperamento" type="text"/>
		</div>
		<div style="display: block">
			<h4>Descrição</h4>
			<textarea class="area" placeholder="descrição" name="descricao" type="text"></textarea>
		</div>
		<div style="display: block">
			<h4 style="margin-left: 0.65em;">Foto</h4>
			<input type="file" name="file" id="foto" accept="image/jpg,image/jpeg,image/png"/>
			<!-- <img src="assets/iconFoto.png"/>  -->
		</div>
		</session>
		<button type="submit" style="margin-top: -1em;">Cadastrar</button>
	</form>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>