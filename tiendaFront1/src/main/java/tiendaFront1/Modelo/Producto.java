package tiendaFront1.Modelo;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Producto {
@Id
private int codigo_producto;
private double ivacompra;
private int nitproveedor;
private String nombre_producto;
private Double precio_compra;
private Double precio_venta;
public int getCodigo_producto() {
	return codigo_producto;
}
public void setCodigo_producto(int codigo_producto) {
	this.codigo_producto = codigo_producto;
}
public double getIvacompra() {
	return ivacompra;
}
public void setIvacompra(double ivacompra) {
	this.ivacompra = ivacompra;
}
public int getNitproveedor() {
	return nitproveedor;
}
public void setNitproveedor(int nitproveedor) {
	this.nitproveedor = nitproveedor;
}
public String getNombre_producto() {
	return nombre_producto;
}
public void setNombre_producto(String nombre_producto) {
	this.nombre_producto = nombre_producto;
}
public Double getPrecio_compra() {
	return precio_compra;
}
public void setPrecio_compra(Double precio_compra) {
	this.precio_compra = precio_compra;
}
public Double getPrecio_venta() {
	return precio_venta;
}
public void setPrecio_venta(Double precio_venta) {
	this.precio_venta = precio_venta;
}
}
