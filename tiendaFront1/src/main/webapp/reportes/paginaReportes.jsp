
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
			<li><a href="paginaUsuario.jps" >usuarios</a>
			<li><a href="paginaClientes.jsp">clientes </a>
			<li><a href="paginaProveedores.jsp">proveedores</a>
			<li><a href="paginaProductos.jsp">producto</a>
			<li><a href="paginaVentas.jsp">ventas</a>
			<li><a style=background:purple; href="#">reporte</a>
			<li><a href="login.jsp">salir</a>
		</ul>
		
	
	<div class ="form-user">
	<form method="get" action="./DemoServlet"><br>
		
			
		
			<div class=botton>
				<input type="submit" value="listar Usuarios" name="listarUsuarios">
			
			
				<input type="submit"value="listado De Clientes" name="ListadoDeClientes">
				
				<input type="submit" value="ventas Por Cliente" name="ventaPorCliente">
			
			
				
		   </div>
	</form>
	</div>
</body>
</html>