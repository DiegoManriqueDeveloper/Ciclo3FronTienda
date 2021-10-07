<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8 ">
		<title>USUARIOS FULLMOTOS</title>
		<link rel="STYLESHEET" type="text/css" href="css/estilo_usuarios.css">
	</head>
	<body>
	    <div class ="titulo">
	    	<h1>tienda motofull</h1>
	    </div>
		<ul class="menu">
			<li><a href="usuarios.jsp" >usuarios</a>
			<li><a href="paginaClientes.jsp">clientes </a>
			<li><a href="paginaProveedores.jsp">proveedores</a>
			<li><a style= background:purple; href="#">producto</a>
			<li><a href="paginaVentas.jsp">ventas</a>
			<li><a href="paginaReportes.jsp">reporte</a>
			<li><a href="login.jsp">salir</a>
		</ul>
		
	
	<div class ="form-user">
	<form method="get" action="./DemoServlet"><br>
		
			<div class= "entry">
			<label for="cedula" >nombre del archivo </label>
					<input type= "text"placeholder ="ingrese producto"name="producto"><br><br>	
			
			</div>
			
			<div class=botton>
				<input type="submit" value="cargar" name="cargar">
				<input type="submit" value="examinar" name="examinar">
			
		   </div>
	</form>
	</div>
</body>
</html>