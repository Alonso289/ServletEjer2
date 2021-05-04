<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <!-- Title Page -->  
    <title>Alta Roles</title>
    <link rel="stylesheet" type="text/css" href="css/app_styles.css" media="screen">
 
<body>
    <div id="container">
				<h3>Accediendo con, ${sessionScope.clientName}, ${sessionScope.firstName}, ${sessionScope.secondName}.</h3>
		<form id="altaUsuarios" action="AltaRoles" method="get">
			<input type="text" name="nombre" placeholder="Nombre" required>
			<button type="submit" title="Registrar" name="Registrar">Registrar rol</button>
		</form>
		<%@ include file="Footer.jsp" %>		
    </div>
        <div style="margin-top: 10px;">
		<input value = "Return" type="button" onclick="history.back() ">
	</div>
</body>
</html>