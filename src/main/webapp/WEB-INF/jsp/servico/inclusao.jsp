<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		
		
		<h3>Servicos: ${operacao}</h3>
		<br>
		<hr/>
		
		<div class="margem-lista" >
		<div class="lista">	
		
		<form action="/servico/inclusao" method="post">
		
			<input type="hidden" name="id" value="${servico.id}">
			
			<div class="form-group">
				<label for="cliente">Título do serviço: </label>
				<input id="cliente" type="text" value="${servico.titulo}" class="form-control" name="titulo" aria-label="Sizing example input" required aria-describedby="inputGroup-sizing-default">
			</div>
			
			<div class="form-group">
				<label for="cliente">Descrição do serviço: </label>
				<input id="cliente" type="text" value="${servico.descricao}" class="form-control" name="descricao" aria-label="Sizing example input" required aria-describedby="inputGroup-sizing-default">
			</div>
			
			<div class="form-group">
				<label for="preco">Preço do serviço: </label>
				<input id="preco" type="text" value="${servico.preco}" class="form-control" name="preco" aria-label="Sizing example input" required aria-describedby="inputGroup-sizing-default">
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