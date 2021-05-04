<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>


<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <!-- Title Page -->  
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/app_styles.css" media="screen">
 
<body>          
    	<form id="loginForm" action="Login" method="get" class="center">
			<fieldset class="fontCalibri">
				<legend>Datos de acceso</legend>	
				<div>
					<label for="nombre">Nombre</label>
					<input type="text" name="login" id="nombre" />
				</div>
				<div>
					<label for="password">Password</label>
					<input type="password" name="password" id="password" />
				</div>
				<div class="center">
					<input type="submit" value="Login" id="button-login" />
				</div>
				
			</fieldset>
		</form>
		<%@ include file="Footer.jsp" %>
	</body>
</html>