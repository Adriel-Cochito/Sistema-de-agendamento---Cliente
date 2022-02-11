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
		<h4>Agendamento</h4>
		<br>
		
		<div class="margem-lista" >
		<div class="lista">	
		
		<form action="/agendar" method="post" autocomplete="on">
			
			<div class="form-group">
				<label for="exampleFormControlSelect1">Escolha o Cliente/membro : </label>
				<select class="form-control"	id="exampleFormControlSelect1" name="membro" required>
					<c:forEach var="m" items="${membros}">
						<option value="${m.id}">${m.nome} - ${m.detalhe.email}</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="form-group">
				<label for="exampleFormControlSelect1">Escolha o Profissional: </label>
				<select class="form-control"	id="exampleFormControlSelect1" name="profissional" required>
					<c:forEach var="p" items="${profissionais}">
						<option value="${p.id}">${p.nome} - "${p.apelido}"</option>
					</c:forEach>
				</select>
			</div>

			<div class="form-group">
				<p>Escolha os servicos:</p>
				
				<c:forEach var="s" items="${servicos}">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" name="serv"	value="${s.id }">
						<label class="form-check-label"	for="defaultCheck1"> ${s.titulo} : ${s.descricao} = R$${s.preco} </label>
					</div>
				</c:forEach>

				<c:if test="${not empty msgError}">
					<div class="alert alert-danger">
						<strong>Erro!!</strong> ${msgError}
					</div>
				</c:if>

			</div>

			<br>

			<div class="form-group">
				<label>Escolha a data: </label>
				<input type="date" name="data" min="${dataAtual}" max="${dataLimite}" required>
			</div>

			<div class="form-group">
				<label>Escolha o horario: </label>
				<input type="time" min="08:00" max="18:00" name="horario" step="900" value="08:00" required>
			</div>


			<button type="submit" class="btn btn-primary">Agendar</button>
		
			<br>
			<hr/>
	  		<p><a href="/membros">Voltar</a></p>
		
		</form>
	</div>
	</div>
	</div>	
		<footer>
			<c:import url="/WEB-INF/jsp/footer.jsp"/>
		</footer>
</body>
</html>