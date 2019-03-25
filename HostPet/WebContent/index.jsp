<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head id="head">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="index.css">
<title>HostPet</title>
</head>
<body>
	
	<video id="video" playsinline autoplay muted loop preload="auto">
       <source src="assets/Dog - 598.mp4" type="video/mp4">
   </video>
   <div class="head">
		<a href="#">Iniciativa</a>
		<a href="#">Quem Somos</a>
		<img src="assets/logo-png.png" type="img/png"/>
		<a href="#">Apoiadores</a>
		<div class="icons">
			<a href="#"><img src="assets/iconFace.png" type="img/png"/></a>
			<a href="#"><img src="assets/iconInsta.png" type="img/png"/></a>
			<a href="#"><img src="assets/iconMail.png" type="img/png"/></a>
		</div>
	</div>
   <div name="index" class="main">
   		<h2>HostPet</h2>
   		<h1>Adote um amigo</h1>
   		<h3>Salve uma vida e faca ela feliz</h3>
   		<div class="btn">
   			<button id="btn" type="button" target="_blank" onclick="document.getElementById('singin').style.display = 'flex';">Entrar</button>
   			<button action="cadastrar.html">Faca parte</button>
   		</div>
   </div>
   <div id="singin" class="singin">
   		<form action="ValidarLogin" method="post" type="submit">
   		    <img src="assets/logo-pngAzul.png" type="img/png"/>
   			<h1>Sing In</h1>
			<input placeholder="Login" name="login" type="email"/>
			<input placeholder="Senha" name="senha" type="password"/>
			<button type="submit">Entrar</button>
			<div class="end">
				<a onclick="document.getElementById('singin').style.display = 'none';"><img src="assets/seta.png" type="img/png"/></a>
				<h4>Lorem ipsum <b>Lorem ipsum</b> Lorem ipsum</h4>
			</div>
			
			
		</form>
   </div>
   
</body>
</html>