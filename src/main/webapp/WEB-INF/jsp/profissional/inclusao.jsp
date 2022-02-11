<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <title>app</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<link href="/estilos/estilos.css" rel="stylesheet" type="text/css">
</head>
<body>
	
	<c:import url="/WEB-INF/jsp/header.jsp"/>	
	<div id="container">	
		
		<h3>Cadastro de Profissional: ${operacao} </h3>
		<br>
		<hr/>
       
       <div class="margem-lista" >
		<div class="lista">	
		
		<form action="/profissional/inclusao" method="post">
		
			<input type="hidden" name="id" value="${profissional.id}">
			
			<div class="form-group">
				<label for="cliente">Nome do profissional: </label>
				<input id="cliente" value="${profissional.nome}" type="text" class="form-control" name="nome" aria-label="Sizing example input" required aria-describedby="inputGroup-sizing-default">
			</div>
			
			<div class="form-group">
				<label for="cliente">Apelido do Profissional: </label>
				<input id="cliente" type="text" value="${profissional.apelido}" class="form-control" name="apelido" aria-label="Sizing example input" required aria-describedby="inputGroup-sizing-default">
			</div>

			<button type="submit" class="btn btn-primary">Cadastrar ${operacao}</button>
		
		<br>
		<hr/>
		<a href="/cadastro">voltar</a>
		
		</form>
		 
		
	</div>
	</div>
	</div>	
	<footer>
		<c:import url="/WEB-INF/jsp/footer.jsp"/>
	</footer>
	
</body>
</html>