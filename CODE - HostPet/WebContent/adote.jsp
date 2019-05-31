<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=yes">
<link rel="stylesheet" type="text/css" href="adote.css">
<link rel="icon" type="imagem/png" href="assets/logo.png" />
<title>HostPet</title>
</head>
<body>
	<c:import url="menu.jsp"></c:import>	
		<form class="formulario">
			<h1>Encontre um amigo e deixe sua vida mais alegre!!</h1>
			<session style="display: inline-flex;">
				<div style="display: inline-flex; width: 12em; margin-right: 5em;">
					<div style="display: block;">
						<img src="assets/iconE.png"/>
						<h4>Cachorro</h4>
					</div>
					<div style="display: block;">
						<img src="assets/iconF.png"/>
						<h4  style="margin-left: 1.5em;">Gato</h4>
					</div>
				</div>
				<div style="display: block; width: 26em; margin-right: 5em;">
					<h4>Porte:</h4>
					<input type="range" min="1" max="100" value="50" class="slider" id="myRange">
					<div class="pmg" style="display: inline-flex; width: 14em;">
						<h5>P</h5>
						<h5>M</h5>
						<h5>G</h5>
					</div>
				</div>
				<div style="display: block; margin-top: -4em;">
					<h4>Cidade:</h4>
					<input type="search" class="cidade" >
				</div>
				<button type="submit"><img id="search" src="assets/iconH.png"/></button>
			</session>			
		</form>
		
		<session class="two" style="display: inline-flex;">
			<div class="feed">
				<div class="pet">
					<img src="assets/cat.jpg"/>
					<div>
						<div style="display: inline-flex; margin-top: 3em;">
							<img id="patinha" src="assets/patinha.png"/>
							<h1><!-- ${pet.nome} --> Ricardo</h1>
						</div>
						<button>Ver mais</button>
					</div>
				</div>
			</div>
			<div id="map"></div>
		    <script>
		      var map;
		      function initMap() {
		        map = new google.maps.Map(document.getElementById('map'), {
		          center: {lat: -12.97618906, lng: -38.47576906},
		          zoom: 12
		        });
		      }
		    </script>
		    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCYLLinb7c0xgQg0jC9sPDAoBQ73J4kvo0&callback=initMap"
		    async defer></script>
		</session>
		
</body>
</html>