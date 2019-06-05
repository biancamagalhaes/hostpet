<%@page import="hostpet.model.Usuario"%>
<%@page import="hostpet.dao.PetDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 	PetDAO dao = new PetDAO(); 
    Usuario u = (Usuario) request.getSession(true).getAttribute("usuario");
	request.setAttribute("Petdoacao", dao.doacao(u));	
 %>
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
	
		<h1 id="title">Doação:</h1>
		
			<c:forEach var="e" items="${Petadocao}">
			<form  action="SobrePet" method="post" type="submit">
				<div class="pet">
					<img src="perfil/${e.foto}"/>
					<div style="display: grid; align-items: center; float: right;">
						<div style="display: inline-flex; margin-top: 3em; margin-left: -1.5em;">
							<img id="patinha" src="assets/patinha.png"/>
							<h1>${e.nome}</h1>
						</div>
						<button value="${e.id}" name="button" type="submit">Ver mais</button>
					</div>
				</div>
			</form>
			</c:forEach>

</body>
</html>