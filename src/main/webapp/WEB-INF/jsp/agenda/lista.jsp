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
	<link href="../estilos/estilos.css" rel="stylesheet" type="text/css">
</head>
<body>
		
	<c:import url="/WEB-INF/jsp/header.jsp"/>
	<div id="container">
		
		<h4>Agenda - Lista</h4>
		<hr>
	
		<c:if test="${not empty msgError}">
			<div class="alert alert-danger">
			  <strong>Erro!!</strong> ${msgError}
			</div>	
			<br>	
		</c:if>
		
		<form action="/agendamento">
			<input type="submit" value="Novo Cadastro" class="botao">
		</form>
	
	<br>	
	<div class="margem-lista" >
	<div class="lista">
	
		<c:if test="${not empty agendamentos}">	
		<table class="full_table_list">			
			<thead>
				<tr>
					<th>Id </th>
					<th>Cliente </th>
					<th>Profissional</th>
					<th>Data </th>
					<th>Horario </th>
					<th>Servicos</th>
					<th>Valor Total</th>
					<th>Consulta</th>
					<th>Exclusão</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${agendamentos}">
					<tr>
						<td>${a.id} </td>
						<td>${a.membro.nome} </td>
						<td>${a.profissional.nome} - "${a.profissional.apelido}"</td>
						<td>${a.data} </td>
						<td>${a.horario} </td>
						<td>
						<c:forEach var="s" items="${a.servicos}">						
								${s.titulo},					
						</c:forEach>
						</td>
						<td>R$${a.valorTotal} </td>
						<td class="operacao"><a class="operacao" href="/agenda/${a.id}/consultar">consultar</a></td>
						<td class="excluir"><a class="excluir" href="/agenda/${a.id}/excluir">excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	
	<c:if test="${empty agendamentos}">
			<div class="alert alert-warning">
				<strong>Sem registros cadastrados!!</strong>
			</div>
	</c:if>

	</div>
	
	</div>
	</div>
	
		<footer>
			<c:import url="/WEB-INF/jsp/footer.jsp"/>
		</footer>
			
</body>
</html>