<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="recuperarSenha.css">
<link rel="icon" type="imagem/png" href="assets/logo.png" />
<title>HostPet</title>
</head>
<body>
	<div id="singin" class="singin">
   		<form action="recuperarSenha" method="post">
   			<h1>Insira seu login e o link para redefini��o da senha ser� enviado para o seu email!!</h1>
			<input placeholder="Login" name="login" type="text"/>
			<button type="submit">Enviar</button>
		</form>
   </div>
   <!--  <div class="alerta">
   		<h3>Login n�o existe, cadastre-se � f�cil!</h3>
   </div>
   <div id="alertPosition" class="alerta">
   		<h3>Senha n�o corresponde com Login</h3>
   </div>-->
</body>
</html>