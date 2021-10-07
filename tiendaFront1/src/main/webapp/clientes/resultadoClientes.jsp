<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import='java.util.Date' %>
<%@ page import='tiendaFront1.Modelo.Clientes' %>
<%@ page import='java.util.ArrayList' %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda Genérica</title>
<link rel="STYLESHEET" type="text/css" href="css/Estilos_tienda.css">
</head>
<body class= "result" >
	<p align="center"> LISTADO DE clientes </p>
	<h5 align="right" Style=color:blue> Hora Servidor es <%=new Date()%></h5>
	<table>
		<tr>
			<td><label>Cédula</label></td>
			<td><label>direccion</label></td>
			<td><label>Correo</label></td>
			<td><label>nombre</label></td>
			<td><label>telefono</label></td>
		</tr>
		<%
		ArrayList<Clientes> lista = (ArrayList<Clientes>) request.getAttribute("lista");
				for (Clientes cliente : lista){
		%>
		<tr>
			<td><%=cliente.getCedula_cliente()%></td>
			<td><%=cliente.getDireccion_cliente()%></td>
			<td><%=cliente.getEmail_cliente()%></td>
			<td><%=cliente.getNombre_cliente()%></td>
			<td><%=cliente.getTelefonoCliente()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>l>