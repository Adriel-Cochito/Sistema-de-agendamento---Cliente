<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>AppAgendamento</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<link href="/estilos/estilos.css" rel="stylesheet" type="text/css">
<style type="text/css">
h3 {
	text-align: center;
}
</style>

</head>
<body>	

	<c:import url="/WEB-INF/jsp/header.jsp"/>	
	
	<div id="container">
			
			<h3>Membros: ${operacao}</h3>
		
		<div class="margem-lista" >
		<div class="lista">	
		
		<form action="/membro/incluir" method="post">
			<input type="hidden" name="id" value="${membro.id}">
		
		    <div class="form-group">
		      <label for="usr">Nome:</label>
		      <input type="text" class="form-control" name="nome" value="${membro.nome}" required="required">
		    </div>
		    
		    <div class="form-group">
		      <label for="usr">Sobrenome:</label>
		      <input type="text" class="form-control" name="sobrenome" value="${membro.sobrenome}" required="required">
		    </div>
		    
		    <div class="form-group">
		      <label for="usr">Email:</label>
		      <input type="email" class="form-control" name="email" value="${membro.detalhe.email}" required="required">
		    </div>
		    
		    <div class="form-group">
		      <label for="usr">Telefone:</label>
		      <input type="number" class="form-control" name="telefone" value="${membro.detalhe.telefone}" required="required">
		    </div>
	
	    	<button type="submit" class="btn btn-primary">Gravar ${operacao}</button>
	  		
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