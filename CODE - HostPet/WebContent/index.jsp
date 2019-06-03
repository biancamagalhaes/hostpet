<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head id="head">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=yes">
<link rel="stylesheet" type="text/css" href="index.css">
<link rel="icon" type="imagem/png" href="assets/logo.png" />
<title>HostPet</title>
</head>
<body>
  <!-- <div class="head">
		<a href="#">Iniciativa</a>
		<a href="#">Quem Somos</a>
		<img src="assets/logo-png.png" type="img/png"/>
		<a href="#">Apoiadores</a>
		<div class="icons">
			<a href="#"><img src="assets/iconFace.png" type="img/png"/></a>
			<a href="#"><img src="assets/iconInsta.png" type="img/png"/></a>
			<a href="#"><img src="assets/iconMail.png" type="img/png"/></a>
		</div>
	</div>-->
	<session class="one">
		<video id="video" playsinline autoplay muted loop preload="auto">
			<source src="assets/video.mp4" type="video/mp4">
    	</video>
    	<h2>O sistema estará disponivel a partir do dia 5/6/2019</h2>
	    <div class="contentHome">
	        <div class="btn">
	            <a href="login.jsp"><button id="btn" type="button" >Entrar</button></a>
	            <a href="cadastro.jsp"><button>Faça parte</button></a>
	        </div>
	        <div name="index" class="main">
	            <h5>HostPet</h5>
	            <h1>Adote um amigo</h1>
	            <h3>Salve uma vida e a faça feliz!</h3>	
	        </div>
	     	 <a href="#two"><img class="setaHome" src="assets/setaMais.png"/></a>
	    </div>
	</session>
	<session class="two" id="two">
		<div class="bgTwo">
		  <img src="assets/logoAzul.png"/>
		  <div style="display:inline-flex" class="bgTwoInner">
		  	<div style="display:block">
		  		<h1>+200mil</h1>
		  		<h4>É o número de pets desabrigados somente na cidade de Salvador - BA </h4>
		  	</div>
		  	<div style="display:block">
		  		<h1>Ongs?</h1>
		  		<h4>Na maioria das vezes se encontram superlotadas e sem incentivo financeiro para cuidar dos fofinhos </h4>
		  	</div>
		  	<div style="display:block; border: none;">
		  		<h1>HostPet</h1>
		  		<h4>Um sistema adoção para ajudar os nossos amigunhos desabrigados, <a href="#four">conheça a iniciativa!</a></h4>
		  	</div>
		  </div>
		</div>
	</session>
	<session class="three">
		<div class="bgThree">
			<h1>"O jeito mais facil de ajudar aquele amiguinho que mora na sua rua é usando o HostPet"</h1>
		</div>
	</session>
	<session class="four" id="four">
		<div class="bgfour">
			<h1 style="font-size: 4em">É facil:</h1>
			<h1 style="padding: 0em 2em;">1- Cadastre-se</h1>
			<h1 style="padding: 0em 2em;">2- Cadastre o seu amiguinho</h1>
			<h1 style="color: #bc0973">E ele ja está pronto pra achar um lar</h1>
			<h1>Se quiser adotar é mais facil ainda:</h1>
			<h1 style="padding: 0em 2em;">1- Depois de logar, é só escolher o pet no feed</h1>
			<h1 style="padding: 0em 2em;">2- Clicar nele e em quero adotar</h1>
			<h1 style="color: #bc0973">E as informações dele serão enviadas para o seu email cadastrado</h1>
			<img src="assets/10-motivos-para-adotar-um-cachorro-vira-lata-300x203.png"/>
		</div>
	</session>
	<footer>
		<div id="bgFooter">
			<img src="assets/logo-completa.png"/>
			<div class="mediaSociais">
				<h3> Instagram/</h3>
				<h3> Facebook/</h3>
				<h3> Email</h3>
			</div>
			<h2>Ajuda?</h2>
			<div class="sobre">
				<h3>Saiba Mais</h3>
				<h4>Sobre nós</h4>
				<h4>Termos de Uso</h4>
			</div>
		</div>
	</footer>
   
</body>
</html>