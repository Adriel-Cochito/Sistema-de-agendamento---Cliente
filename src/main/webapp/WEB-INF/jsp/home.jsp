<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tagValida"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
  <link href="../estilos/estilos.css" rel="stylesheet" type="text/css">

<style type="text/css">
 .home { 
 	text-align: center; 
 } 
	
 h2 { 
 	font-size: 40px; 
 	font-weight: bold; 
 }	 
 img { 
 	align-content: center; 
 } 
</style>

</head>
<body >
	<header>
		<c:import url="/WEB-INF/jsp/header.jsp"/>
	</header>
	
	
	<div id="container">
		<br>
		<div class="home">
			<h3> Seja bem vindo!</h3>
			
			<h2>Sistema de agendamento</h2>
			<img src="<c:url value="/imagens/instituto-infnet.png"/>">
			<p>Engenharia da Computação</p>
			<p class="p-footer">Trabalho: Desenvolvimento JAVA</p>
			<p>Aluno: Adriel Cochito </p>			
		</div>	
<%-- 		<img src="<c:url value="/imagens/escritorio.jpg"/>"> --%>
		
		
	</div>	
	<footer>
				<c:import url="/WEB-INF/jsp/footer.jsp"/>
	</footer>
	

</body>
</html>