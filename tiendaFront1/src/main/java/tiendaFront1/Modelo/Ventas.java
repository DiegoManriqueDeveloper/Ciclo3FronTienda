package tiendaFront1.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ventas")
public class Ventas 
{
	@Id
	private long codigo_venta;
	
	@Column(name="ivaventa")
	private double ivaventa;
	
	@Column(name="total_venta")
	private double total_venta;
	
	@Column(name="valor_venta")
	private double valor_venta;
	
	@Column(name="fecha_creacion", length = 255, nullable = false)
	private String fecha_creacion;
	
	//Manejo de relación con la tabla Cliente
	@ManyToOne
	private Clientes clientes;
	
	
	//manejo de relación con la tabla Usuarios
	@ManyToOne
	private Usuarios usuarios;
	
	public long getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	
	public double getIvaventa() {
		return ivaventa;
	}
	public void setIvaventa(double ivaventa) {
		this.ivaventa = ivaventa;
	}
	public double getTotal_venta() {
		return total_venta;
	}
	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}
	public double getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}
	public String getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	//Para las relaciones
	public Clientes getCliente() {
		return clientes;
	}
	public void setCliente(Clientes cliente) {
		this.clientes = cliente;
	}
	public Usuarios getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	
	
	

}
