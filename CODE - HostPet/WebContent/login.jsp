<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=yes">
<link rel="stylesheet" type="text/css" href="login.css">
<link rel="icon" type="imagem/png" href="assets/logo.png" />
<title>HostPet</title>
</head>
<body>
	<div id="singin" class="singin">
   		<form action="ValidarLogin" method="post" type="submit">
   			<h1>HostPet</h1>
			<input placeholder="Login" name="login" type="text"/>
			<input placeholder="Senha" name="senha" type="password"/>
			<button type="submit">Entrar</button>
		</form>
   </div>
   <!--  <div class="alerta">
   		<h3>Login não existe, cadastre-se é fácil!</h3>
   </div>
   <div id="alertPosition" class="alerta">
   		<h3>Senha não corresponde com Login</h3>
   </div>-->
</body>
</html>