<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, servlet.*, daoTablas.*, filesMapped.*" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Vista Roles</title>
		<link rel="stylesheet" type="text/css" href="css/app_styles.css" media="screen">
	</head>
	<body>			
		<h1>Bienvenido JSP, ${sessionScope.clientName}.</h1>
		
		<form action="" method="post">
			<table border="2">
				<tr>
				    <th>Id</th>
				    <th>Nombre</th>
			    </tr>
			    <c:forEach items="${sessionScope.rolesList}" var="rol" varStatus="status" begin="0" end="${sessionScope.rolesList.size() - 1}">
			        <tr>
			        
			        	<td><c:out value="${rol.id}"></c:out></td>
			            <td><c:out value="${rol.rol}"></c:out></td>           
			        </tr>
			    </c:forEach>
			</table>
			<p class="center">
				<!-- <input type="submit" value="Comprar" id="button-create" />
				<input type="reset" value="Limpiar" id="button-clean" /> -->
				<button type="submit" formaction="PanelPrincipal.jsp">Volver</button>
			</p>
		</form>
		
	</body>
</html>