<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
			<meta charset="ISO-8859-1">
			<title>la tienda.com</title>
			<link rel="STYLESHEET" type="text/css" href="estilo_login.css"> 
	</head>

	<body>
			<div class ="login-box" Style= border-radius:20px>
				<img class= "avatar" src="./img/moto7.jpg" alt="logo de fazt" >
				<h1>MECHANIC SERVICES</h1>
				<form method = "get" action ="./UsuarioServlet">
					<label for="ussername">ussername </label>
					<input type= "text"placeholder ="enter ussername"><br>
			
					<label for="password">password </label>
					<input type= "password" placeholder ="enter password">
			
					<input type="submit" value ="log in"name="validar">
			
					<a href ="#">lost your password?</a>
					<a href ="#">do not have an account?</a>
				</form>
			</div>	
	</body>
</html>