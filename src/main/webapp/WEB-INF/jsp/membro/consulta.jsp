<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <title>app - Agendamento</title>
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

		<h3>Membro: ${operacao}</h3>
		
		<div class="margem-lista" >
		<div class="lista">	
	
		<table id="tab" class="full_table_list">
			<tbody>
				
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Sobrenome</th>
				</tr>
				
				<tr>
					<td>${membro.id}</td>
					<td>${membro.nome}</td>
					<td>${membro.sobrenome}</td>
				</tr>

			</tbody>
		</table>

		<table class="full_table_list">
			<thead>
				<tr>
					<th><label>Detalhes:</label></th>
				</tr>
				<tr>
					<th>Id</th>
					<th class="td-consulta">Email</th>
					<th class="td-consulta">Telefone</th>
				</tr>
			</thead>
			<tbody>	
					<tr>
						<td>${detalhe.id}</td>
						<td>${detalhe.email}</td>
						<td>${detalhe.telefone}</td>
					</tr>
				
			</tbody>
		</table>
		
		<a href="/membros">voltar</a>
		</div>
		</div>
	</div>
	
		<footer>
			<c:import url="/WEB-INF/jsp/footer.jsp"/>
		</footer>
			
</body>
</html>