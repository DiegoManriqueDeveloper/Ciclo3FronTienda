package tiendaFront1.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="usuarios")
public class Usuarios {
	@Id
	private long cedula_usuario;
	
	@Column(name="nombre_usuario", length = 255, nullable=false)
	private String nombre_usuario;
	
	@Column(name="email_usuario", length = 255, nullable=false)
	private String email_usuario;
	
	@Column(name="usuario", length = 255, nullable=false)
	private String usuario;
	
	@Column(name="password", length = 255, nullable= false)
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
