<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <title>app - Agenda</title>
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
	
	
		<h4>Servicos Cadastrados:</h4>
		<hr>

		
		<c:if test="${not empty msgError}">
			<div class="alert alert-danger">
			  <strong>Erro!!</strong> ${msgError}
			</div>		
		</c:if>

		<form action="/servico/cadastro">
			<input type="submit" value="Novo Cadastro" class="botao">
		</form>
	<br>	
	<div class="margem-lista" >
	<div class="lista">	
	
	
		<c:if test="${not empty servicos}">	
		<table class="table table-striped">			
			<thead>
				<tr>
					<th>Id </th>
					<th>Titulo </th>
					<th>Descrição</th>
					<th>Preco</th>
					<th>Alteração</th>
					<th>Exclusão</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="s" items="${servicos}">
					<tr>
						<td>${s.id} </td>
						<td>${s.titulo} </td>
						<td>${s.descricao}</td>
						<td>R$${s.preco}</td>
						<td ><a class="operacao" href="/servico/${s.id}/alterar">alterar</a></td>
				        <td ><a class="excluir" href="/servico/${s.id}/excluir">excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	
	<c:if test="${empty servicos}">
			<div class="alert alert-warning">
				<strong>Sem registros cadastrados!!</strong>
			</div>
	</c:if>
		
		<a href="/cadastro">voltar</a>
	</div>
	</div>
	</div>
	
		<footer>
			<c:import url="/WEB-INF/jsp/footer.jsp"/>
		</footer>
			
</body>
</html>