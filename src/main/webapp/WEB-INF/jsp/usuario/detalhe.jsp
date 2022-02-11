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
	<div class="container">
	
		<div class="container-fluid" style="margin-top:80px">

			<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
			  <a class="navbar-brand" href="/sair">AppAgendamento</a>
			</nav>	
			
			<h3>Cadastro de Usuário</h3>
			
			<div class="margem-lista" >
			<div class="lista">	
		
			<form action="/usuario" method="post">

			  <div class="form-group">
			    <label for="usr">Login:</label>
			    <input type="text" class="form-control" name="login" required="required" >
			  </div>
			
			  <div class="form-group">
			    <label for="usr">Senha:</label>
			    <input type="password" class="form-control" name="senha" required="required">
			  </div>
			
			  <button type="submit" class="btn btn-primary">Cadastrar</button>
			</form>
			
	  		<p><a href="/login">Voltar</a></p>
  		</div>
  		
	</div>
	</div>
	</div>
	  	<footer>
			<c:import url="/WEB-INF/jsp/footer.jsp"/>
		</footer>

</body>
</html>