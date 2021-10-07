package tiendaFront1.Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Ventas {
@Id
private int codigo_venta;
private int cedula_cliente;
private long cedula_usuario;
private double ivaventa;
private double total_venta;
private double valor_venta;
public int getCodigo_venta() {
	return codigo_venta;
}
public void setCodigo_venta(int codigo_venta) {
	this.codigo_venta = codigo_venta;
}
public int getCedula_cliente() {
	return cedula_cliente;
}
public void setCedula_cliente(int cedula_cliente) {
	this.cedula_cliente = cedula_cliente;
}
public long getCedula_usuario() {
	return cedula_usuario;
}
public void setCedula_usuario(long cedula_usuario) {
	this.cedula_usuario = cedula_usuario;
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


}
