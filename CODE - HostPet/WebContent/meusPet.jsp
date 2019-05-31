<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=yes">
<link rel="stylesheet" type="text/css" href="adocao.css">
<link rel="icon" type="imagem/png" href="assets/logo.png" />
<title>HostPet</title>
</head>
<body>
	<c:import url="menu.jsp"></c:import>	
	
		<h1 id="title">Meus Pets:</h1>
		
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

</body>
</html>