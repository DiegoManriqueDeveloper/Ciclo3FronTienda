package tiendaFront1.Modelo;

import javax.persistence.Entity; 
import javax.persistence.Id; 
 
@Entity 
public class Usuarios { 
 @Id 
 private long cedula_usuario; 
 private String nombre_usuario; 
 private String email_usuario; 
 private String usuario; 
 private String password;
public long getCedula_usuario() {
	return cedula_usuario;
}
public void setCedula_usuario(long cedula_usuario) {
	this.cedula_usuario = cedula_usuario;
}
public String getNombre_usuario() {
	return nombre_usuario;
}
public void setNombre_usuario(String nombre_usuario) {
	this.nombre_usuario = nombre_usuario;
}
public String getEmail_usuario() {
	return email_usuario;
}
public void setEmail_usuario(String email_usuario) {
	this.email_usuario = email_usuario;
}
public String getUsuario() {
	return usuario;
}
public void setUsuario(String usuario) {
	this.usuario = usuario;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
} 
}