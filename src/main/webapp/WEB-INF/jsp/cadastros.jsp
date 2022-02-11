<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <title>app - Cadastros</title>
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
	
		<h4>Cadastros</h4>
		<br>
			
		<div class="cards" >
		    <div class="card-secundario" id="cs1">
		      <a href="/servico/lista" >
		      <div class="card-corpo">
		       	<p class="card-texto">Cadastro de Serviços</p>
		         <button class="botao">Visualizar</button>
		      </div>
		      </a>
		    </div>
		    
		    <div class="card-secundario" id="cs2">
		      <a href="/profissional/lista" >
		    	<div class="card-corpo">
		       		<p class="card-texto">Cadastro de Profissional</p>
		        	<button class="botao">Visualizar</button>
		      	</div>
		      </a>
		    </div>
		    <br> <br>
		    <div class="card-secundario" id="cs1">
		      <a href="/membros" >
		    	<div class="card-corpo">
		       		<p class="card-texto">API - Cadastro de Membros </p>
		        	<button class="botao">Visualizar</button>
		      	</div>
		      </a>
		    </div>
		    
		    
		</div>
		

	</div>	
	
		<footer>
			<c:import url="/WEB-INF/jsp/footer.jsp"/>
		</footer>
</body>
</html>