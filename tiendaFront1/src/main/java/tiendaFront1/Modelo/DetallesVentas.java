package tiendaFront1.Modelo;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class DetallesVentas {
@Id
private int codigo_detalle_de_venta;
private int cantidad_de_producto;
private int codigo_producto;
private int codigo_venta;
private double valor_total;
private double valor_venta;
private double valor_iva;
public int getCodigo_detalle_de_venta() {
	return codigo_detalle_de_venta;
}
public void setCodigo_detalle_de_venta(int codigo_detalle_de_venta) {
	this.codigo_detalle_de_venta = codigo_detalle_de_venta;
}
public int getCantidad_de_producto() {
	return cantidad_de_producto;
}
public void setCantidad_de_producto(int cantidad_de_producto) {
	this.cantidad_de_producto = cantidad_de_producto;
}
public int getCodigo_producto() {
	return codigo_producto;
}
public void setCodigo_producto(int codigo_producto) {
	this.codigo_producto = codigo_producto;
}
public int getCodigo_venta() {
	return codigo_venta;
}
public void setCodigo_venta(int codigo_venta) {
	this.codigo_venta = codigo_venta;
}
public double getValor_total() {
	return valor_total;
}
public void setValor_total(double valor_total) {
	this.valor_total = valor_total;
}
public double getValor_venta() {
	return valor_venta;
}
public void setValor_venta(double valor_venta) {
	this.valor_venta = valor_venta;
}
public double getValor_iva() {
	return valor_iva;
}
public void setValor_iva(double valor_iva) {
	this.valor_iva = valor_iva;
}


}
