<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=yes">
<link rel="stylesheet" type="text/css" href="feedback.css">
<link rel="icon" type="imagem/png" href="assets/logo.png" />
<title>HostPet</title>
</head>
<body>
	<c:import url="menu.jsp"></c:import>
	
	<form class="formulario" action="usuarios" method="post" type="submit">
		<h1>Feedback:</h1>
		<session class="divform">
			<div style="display: block">
					<textarea class="area" placeholder="Dê sua opinião sobre o processo de adoção do animalzinho" name="feedback" type="text"></textarea>
			</div>
		</session>
		<button type="submit">Enviar</button>
	</form>
	
	<c:import url="rodape.jsp"></c:import>
</body>
</html>