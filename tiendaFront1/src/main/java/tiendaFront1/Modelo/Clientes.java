package tiendaFront1.Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Clientes {
@Id
private long cedula_cliente;
private String direccion_cliente;
private String email_cliente;
private String nombre_cliente;
private String telefonoCliente;
public long getCedula_cliente( ) {
	return cedula_cliente;
}
public void setCedula_cliente(long cedula_cliente ) {
	this.cedula_cliente = cedula_cliente ;
}
public String getDireccion_cliente() {
	return direccion_cliente;
}
public void setDireccion_cliente(String diereccion_cliente) {
	this.direccion_cliente = diereccion_cliente;
}
public String getEmail_cliente() {
	return email_cliente;
}
public void setEmail_cliente(String email_cliente) {
	this.email_cliente = email_cliente;
}
public String getNombre_cliente() {
	return nombre_cliente;
}
public void setNombre_cliente(String nombre_cliente) {
	this.nombre_cliente = nombre_cliente;
}
public String getTelefonoCliente() {
	return telefonoCliente;
}
public void setTelefonoCliente(String telefonoCliente) {
	this.telefonoCliente = telefonoCliente;
}



}
