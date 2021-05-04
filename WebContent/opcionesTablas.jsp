<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <!-- Title Page -->  
    <title>Opciones</title>
    <link rel="stylesheet" type="text/css" href="css/app_styles.css" media="screen">
 
<body>
		<h3>Bienvenido, ${sessionScope.clientName}, ${sessionScope.firstName}, ${sessionScope.secondName}.</h3>
	   <div id="container">
	
		<form>
			<button type="submit" formaction="altaUsuarios.jsp">Alta Usuario</button>
			<button type="submit" formaction="altaRoles.jsp">Alta Roles</button>
			<button type="submit" formaction="ListaUsuarios">Listado de usuarios</button>
			<button type="submit" formaction="ListaRoles">Listado de roles</button>
		</form>     
    </div>
    		<%@ include file="Footer.jsp" %>
        <div style="margin-top: 10px;">
		<input value = "Return" type="button" onclick="history.back() ">
		</div>
</body>
</html>