<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tagValida"%>
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


</head>
<body>
	<header>
		<c:import url="/WEB-INF/jsp/header.jsp"/>
	</header>
	
	
	<div id="container">
	<h3>TESTE</h3>
	<h3>Empréstimos: Consulta</h3>
	
	    <div class="">
	      <label for="">Cliente:</label>
	      <label for="">${agendamento.cliente}</label>
	    </div>
	
	    <div class="">
	      <label for="">Profissional:</label>
	      <label for="">${agendamento.profissional}</label>
	    </div>
	    
	    <div class="">
	      <label for="">Data:</label>
	      <label for="">${agendamento.data}</label>
	    </div>
	    
	    <div class="">
	      <label for="">Horario:</label>
	      <label for="">${agendamento.horario}</label>
	    </div>

		<div class="">
			<label for="">Serviços:</label>

			<table class="">
			    <thead>
			      <tr>
			        <th>ID</th>
			        <th>TITULO</th>
			        <th>DESCRIÇÃO</th>
			      </tr>
			    </thead>
			    <tbody>
			    	<c:forEach var="s" items="${agendamento.servicos}">
				      <tr>
				        <td>${s.id}</td>
				        <td>${s.titulo}</td>
				        <td>${s.descricao}</td>
				      </tr>
			      </c:forEach>
			    </tbody>
			</table>	
		</div>		
	
	</div>	
	<footer>
				<c:import url="/WEB-INF/jsp/footer.jsp"/>
	</footer>
	
</body>
</html>