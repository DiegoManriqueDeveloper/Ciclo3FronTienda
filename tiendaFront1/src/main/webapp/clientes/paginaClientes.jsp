<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>clientes</title>
<link rel="STYLESHEET" type="text/css" href="css/estiloClientes.css">
</head>
<body>
	 <div class ="titulo">
	    	<h1>clientes</h1>
	    </div>
		<ul class="menu">
			<li><a href="paginaUsuario.jsp">usuarios</a>
			<li><a style= background:purple; href="#">clientes </a>
			<li><a href="paginaProveedores.jsp">proveedores</a>
			<li><a href="paginaProductos.jsp">producto</a>
			<li><a href="paginaVentas.jsp">ventas</a>
			<li><a href="paginaReportes.jsp">reporte</a>
			<li><a href="login.jsp">salir</a>
		</ul>
		
	
	<div class ="form-user">
	<form method="get" action="./DemoServletClientes"><br>
		
			<div class= "entry">
			<label for="cedula" >cedula </label>
					<input type= "text"placeholder ="ingrese cedula"name="cedula"><br><br>	
				
			<label for="nombre">nombre  </label>
					<input type= "text"placeholder =" nombre completo"name="nombre"><br><br>
		
			<label for="correo">e-mail </label>
					<input type= "text"placeholder ="ingrese e-mail"name="email"><br><br>	
			
			<label for="usuario">usuario </label>
					<input type= "text"placeholder ="enter ussername"name="usuario"><br><br>
			
			<label for="password">password </label>
					<input type= "password" placeholder ="enter password"name="password">
					<br>
					<br>
			</div>
			
			
		
		
			<div class=botton>
				<input type="submit" value="Agregar" name="Agregar">
			
			
				<input type="submit"value="listar" name="Listar">
				
				<input type="submit" value="borrar" name="borrar">
			
			
				<input type="submit"value="editar" name="editar">
		   </div>
	</form>
	</div>
</body>
</html>