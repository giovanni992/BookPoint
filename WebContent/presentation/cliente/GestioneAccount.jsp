<!DOCTYPE html>
<html>
 <%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*, control.*, model.*" %>
<head>



<title>BookPoint</title>
<link rel="stylesheet" type="text/css" href="styleCliente2.css"> 
</head>
<body>


<%@ include file="header.jsp"%>


<div class="divaccesso">
	
<h3>Vuoi cambiare la password?</h3>
<form action="utente" method="post">
	Vecchia password
	<input type="password" name="vecchia" required pattern="^[A-Za-z0-9]*$">
	<br>
	Nuova password
	<input type="password" name="nuova" required pattern="^[A-Za-z0-9]*$">
	<br>
	<input type="hidden" name="action" value="cambiaPassword">
	<button type="submit"> Cambia!</button>
	</form>
</div>

 
 
 
 <%@ include file="footer.jsp"%>
 
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>
<script src="utente.js"></script>
</body>
</html>