<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <!-- Title Page -->  
    <title>OPCIONES</title>
    <link rel="stylesheet" type="text/css" href="css/app_styles.css" media="screen">
 
<body>
    <div id="container">
	<h3>Accediendo con, ${sessionScope.clientName}, ${sessionScope.firstName}, ${sessionScope.secondName}.</h3>
	<form id="altaUsuarios" action="AltaUsuarios" method="get">
	    <input type="number" name="rol" placeholder="ID Rol" required> </br>
	    <input type="text" placeholder="Email" name="email" required> </br>
	    <input type="password" placeholder="Clave" name="clave" required> </br>
	    <input type="text" placeholder="Nombre" name="nombre" required> </br>
	    <input type="text" placeholder="Primer Apellido" name="apellido1" required> </br> 
	    <input type="text" placeholder="Segundo Apellido" name="apellido2" required> </br>
	    <input type="text" placeholder="Direccion" name="direccion" required> </br>
	    <input type="text" placeholder="Localidad" name="localidad" required> </br>
	    <input type="text" placeholder="Provincia" name="provincia" required> </br>
	    <input type="text" placeholder="Telefono" name="telefono" required> </br>
	    <input type="text" placeholder="DNI" name="dni" required> </br>
	    
	    <button type="submit" title="Registrar" name="Registrar">Registrar</button>
    </form>
    
    </div>
    		<%@ include file="Footer.jsp" %>
    <div style="margin-top: 10px;">
		<input value = "Return" type="button" onclick="history.back() ">
	</div>
</body>
</html>