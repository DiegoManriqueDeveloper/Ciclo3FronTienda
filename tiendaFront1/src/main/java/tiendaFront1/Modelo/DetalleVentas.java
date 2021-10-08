package tiendaFront1.Modelo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalle_ventas")
public class DetalleVentas 
{
	@Id
	private long codigo_detalle_venta;
	
	@Column(name="cantidad_producto")
	private int cantidad_producto;
	
	@Column(name="valor_total")
	private double valor_total;
	
	@Column(name="valor_venta")
	private double valor_venta;
	
	@Column(name="valoriva")
	private double valoriva;
	
	//Para las relaciones
	@ManyToOne
	private Productos producto;
	
	@ManyToOne
	private Ventas ventas;
	
	public long getCodigo_detalle_venta() {
		return codigo_detalle_venta;
	}
	public void setCodigo_detalle_venta(long codigo_detalle_venta) {
		this.codigo_detalle_venta = codigo_detalle_venta;
	}
	
	public int getCantidad_producto() {
		return cantidad_producto;
	}
	public void setCantidad_producto(long l) {
		this.cantidad_producto = l;
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
	public double getValoriva() {
		return valoriva;
	}
	public void setValoriva(double valoriva) {
		this.valoriva = valoriva;
	}
	public Productos getProducto() {
		return producto;
	}
	
	//Para el manejo de las relaciones
	public void setProducto(Productos producto) {
		this.producto = producto;
	}
	public Ventas getVentas() {
		return ventas;
	}
	public void setVentas(Ventas ventas) {
		this.ventas = ventas;
	}
	public String getCodigo_producto() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
