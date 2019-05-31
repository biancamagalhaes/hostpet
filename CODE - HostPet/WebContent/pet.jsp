<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=yes">
<link rel="stylesheet" type="text/css" href="pet.css">
<link rel="icon" type="imagem/png" href="assets/logo.png" />
<title>HostPet</title>
</head>
<body>
	<c:import url="menu.jsp"></c:import>
	<session class="petmais">
		<div class="carroussel">
			<div class="slideshow-container">
			<div class="mySlides fade">
			  <img src="assets/cat.jpg" >
			</div>
			
			<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
			<a class="next" onclick="plusSlides(1)">&#10095;</a>
			
			</div>
			<br>
			
			<!--  <div style="text-align:center">
			  <span class="dot" onclick="currentSlide(1)"></span> 
			  <span class="dot" onclick="currentSlide(2)"></span> 
			  <span class="dot" onclick="currentSlide(3)"></span> 
			</div>-->
		</div>
		<div class="description">
			<div class="title" style="display: inline-flex; text-align: center;">
				<img src="assets/cat.png"/>
				<h1>Ricardo</h1>
			</div>
			<div class="info" style="display: inline-flex; text-align: center;">
				<div id="texto">
					<h2>${pet.idade}</h2>
					<h2>${pet.sexo}</h2>
					<h2>${pet.porte}</h2>
					<h2>${pet.temperamento}</h2>
				</div>
				<h2>${pet.bairro}, ${pet.adotante.cidade}, ${pet.adotante.estado}</h2>
				<p>${pet.descricao}</p>
			</div>
			<button type="button">Quero adotar</button>
		</div>
	</session>
	<script>
			var slideIndex = 1;
			showSlides(slideIndex);
			
			function plusSlides(n) {
			  showSlides(slideIndex += n);
			}
			
			function currentSlide(n) {
			  showSlides(slideIndex = n);
			}
			
			function showSlides(n) {
			  var i;
			  var slides = document.getElementsByClassName("mySlides");
			  var dots = document.getElementsByClassName("dot");
			  if (n > slides.length) {slideIndex = 1}    
			  if (n < 1) {slideIndex = slides.length}
			  for (i = 0; i < slides.length; i++) {
			      slides[i].style.display = "none";  
			  }
			  for (i = 0; i < dots.length; i++) {
			      dots[i].className = dots[i].className.replace(" active", "");
			  }
			  slides[slideIndex-1].style.display = "block";  
			  dots[slideIndex-1].className += " active";
			}
			
	</script>
</body>
</html>