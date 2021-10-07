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
			<li><a href="paginaUsuario.jsp" >usuarios</a>
			<li><a href="paginaClientes.jsp">clientes </a>
			<li><a href=style= background:purple; href="#">proveedores</a>
			<li><a href="paginaProductos.jsp">producto</a>
			<li><a href="paginaVentas.jsp">ventas</a>
			<li><a href="paginaReportes.jsp">reporte</a>
			<li><a href="login.jsp">salir</a>
		</ul>
		
	
	<div class ="form-user">
	<form method="get" action="./DemoServlet"><br>
		
			<div class= "entry">
			<label for="nit" >nit </label>
					<input type= "text"placeholder ="ingrese nit"name="nit"><br><br>	
				
			<label for="nombreProveedor">nombre proveedor  </label>
					<input type= "text"placeholder =" nombre completo"name="nombre"><br><br>
		
			<label for="direccion">e-mail </label>
					<input type= "text"placeholder ="ingrese direccion"name="direccion"><br><br>	
			
			<label for="telefono">telefono </label>
					<input type= "text"placeholder ="ingrese telefono"name="telefono"><br><br>
			
			<label for="ciudad">ciudad </label>
					<input type= "text" placeholder ="enter ciudad"name="ciudad">
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