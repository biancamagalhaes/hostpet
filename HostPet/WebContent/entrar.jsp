<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="entrar.css">
</head>
<body>
	<div class="head">
		<a href="#">Iniciativa</a>
		<a href="#">Quem Somos</a>
		<img src="assets/logo-pngAzul.png" type="img/png"/>
		<a href="#">Apoiadores</a>
		<div class="icons">
			<a href="#"><img src="assets/iconFaceAzul.png" type="img/png"/></a>
			<a href="#"><img src="assets/iconInstaAzul.png" type="img/png"/></a>
			<a href="#"><img src="assets/iconMailAzul.png" type="img/png"/></a>
		</div>
	</div>
	<div class="main">
		<img src="assets/cat.jpg" type="img/jpg" />
		<form action="login.html" method="post" type="submit">
			<input id="ipt" placeholder="Login" name="login" type="email"/>
			<input id="ipt" placeholder="Senha" name="senha" type="text"/>
			<button type="submit">Entrar</button>
		</form>
	</div>
</body>
</html>