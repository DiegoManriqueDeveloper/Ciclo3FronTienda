package tiendaFront1.Modelo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

@Entity
@Table(name="productos")
public class Productos 
{
	@Id
	private long codigo_producto;
	
	@Column(name="ivacompra")
	private double ivacompra;
	
	@Column(name="nombre_producto", length = 255, nullable = false)
	private String nombre_producto;
	
	@Column(name="precio_compra")
	private double precio_compra;
	
	@Column(name="precio_venta")
	private double precio_venta;
	
	@Column(name="existencia")
	private double existencia;
	
	@ManyToOne
	private Proveedores proveedores;
	
	public long getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public double getIvacompra() {
		return ivacompra;
	}
	public void setIvacompra(double ivacompra) {
		this.ivacompra = ivacompra;
	}
	
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public double getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}
	public double getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}
	public double getExistencia() {
		return existencia;
	}
	public void setExistencia(double existencia) {
		this.existencia = existencia;
	}
	
	//Para generar la llave
	public Proveedores getProveedores() {
		return proveedores;
	}
	public void setProveedores(Proveedores proveedores) {
		this.proveedores = proveedores;
	}

	
	
}
