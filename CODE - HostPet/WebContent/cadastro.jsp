<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=yes">
<link rel="stylesheet" type="text/css" href="cadastro.css">
<link rel="icon" type="imagem/png" href="assets/logo.png" />
<title>HostPet</title>
</head>
<body>
	<div id="singin" class="singin">
   		<form class="formulario" action="pets" method="post" type="submit">
   			<h1>HostPet</h1>
   			<div>
   				<div style="display: block">
	   				<h4>nome</h4>
					<input placeholder="nome" name="nome" type="text"/>
				</div>
				<div style="display: block">
					<h4>email</h4>
					<input placeholder="email" name="email" type="email"/>
				</div>
				<div style="display: block">
					<h4>cidade</h4>
					<input placeholder="cidade" name="cidade" type="text"/>
				</div>
				<div style="display: block">
					<h4>estado</h4>
					<input placeholder="estado" name="estado" type="text"/>
				</div>
				<div style="display: block">
					<h4>cpf</h4>
					<input placeholder="xxx.xxx.xxx-xx" name="cpf" type="text"/>
				</div>
				<div style="display: block;">
					<h4 style="margin-left: 15.65em;">data de nascimento</h4>
					<input placeholder="xx/xx/xxxx" name="data" type="date"/>
				</div>
				<div style="display: block">
					<h4>login</h4>
					<input placeholder="login" name="login" type="text"/>
				</div>
				<div style="display: block">
					<h4>senha</h4>
					<input placeholder="senha" name="senha" type="password"/>
				</div>
			</div>
			<button type="submit">Cadastrar</button>
		</form>
   </div>
</body>
</html>