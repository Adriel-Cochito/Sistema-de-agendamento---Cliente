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
	<div class="margem-lista" >
	<div class="lista">
		<h3>Agendamento: ${operacao}</h3>
		<hr>
		<br>
		<table id="tab" class="table table-striped">
			<tbody>
				<tr>
					<th><p>Quando:</p></th>
				</tr>
				
				<tr>
					<td>Data:</td>
					<td>${agendamento.data}</td>
				</tr>

				<tr>
					<td>Horario:</td>
					<td>${agendamento.horario}</td>
				</tr>
				
				<tr>
					<td>Valor Total:</td>
					<td>R$${agendamento.valorTotal}</td>
				</tr>
				
			</tbody>
		</table>
		<br>
			
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th><p>Cliente:</p></th>
				</tr>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Sobrenome</th>
					<th>Email</th>
					<th>Telefone</th>
				</tr>
			</thead>
			<tbody>
					<tr>
						<td>${agendamento.membro.id}</td>
						<td>${agendamento.membro.nome}</td>
						<td>${agendamento.membro.sobrenome}</td>
						<td>${agendamento.membro.detalhe.email}</td>
						<td>${agendamento.membro.detalhe.telefone}</td>
					</tr>
			</tbody>
		</table>
		<br>
		
			
		<table class="table table-striped">
		
			<thead>		
				<tr>
					<th><p>Profissional:</p></th>
				</tr>
				
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Apelido</th>
				</tr>
			</thead>
			<tbody>
					<tr>
						<td>${agendamento.profissional.id}</td>
						<td>${agendamento.profissional.nome}</td>
						<td>${agendamento.profissional.apelido}</td>
					</tr>
			</tbody>
		</table>
		
		<br>
		
		<table class="table table-striped">		
			<thead>		
				<tr>
					<th><p> Serviços: </p></th>
				</tr>
				
				<tr>
					<th>Id</th>
					<th class="td-consulta">Título</th>
					<th>Descrição</th>
					<th>Preço</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="s" items="${agendamento.servicos}">
					<tr>
						<td>${s.id}</td>
						<td>${s.titulo}</td>
						<td>${s.descricao}</td>
						<td>R$${s.preco}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a href="/agenda">voltar</a>
		
	</div>
	</div>
	</div>
	
		<footer>
			<c:import url="/WEB-INF/jsp/footer.jsp"/>
		</footer>
			
</body>
</html>