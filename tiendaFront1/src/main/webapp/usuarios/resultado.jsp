<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import='java.util.Date' %>
<%@ page import='tiendaFront1.Modelo.Usuarios' %>
<%@ page import='java.util.ArrayList' %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda Genérica</title>
</head>
<body>
	<p align="center"> LISTADO DE USUARIOS </p>
	<p align="center"> Hora Servidor es <%= new Date()%></p>
	<table>
		<tr>
			<td><label>Cédula</label></td>
			<td><label>Nombre</label></td>
			<td><label>Correo</label></td>
			<td><label>Usuario</label></td>
			<td><label>Password</label></td>
		</tr>
		<%
		ArrayList<Usuarios> lista = (ArrayList<Usuarios>) request.getAttribute("lista");
		for (Usuarios usuario : lista){
		%>
		<tr>
			<td><%=usuario.getCedula_usuario()%></td>
			<td><%=usuario.getNombre_usuario()%></td>
			<td><%=usuario.getEmail_usuario()%></td>
			<td><%=usuario.getUsuario()%></td>
			<td><%=usuario.getPassword()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>