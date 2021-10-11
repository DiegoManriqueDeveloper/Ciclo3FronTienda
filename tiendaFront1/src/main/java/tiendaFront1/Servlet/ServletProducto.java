package tiendaFront1.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;

import tiendaFront1.Modelo.Productos;
import tiendaFront1.JSON.JSONProducto;
/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/ServletProducto")
public class ServletProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String listar = request.getParameter("Listar");
		String agregar = request.getParameter("Agregar");
		if (agregar != null) {
			agregarProducto(request, response);

		}
		if (listar != null) {
			try {
				listarProductos(request, response);
			} catch (ParseException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void agregarProducto(HttpServletRequest request, HttpServletResponse response) {
		Productos producto = new Productos();
		producto.setCodigo_producto(Long.parseLong(request.getParameter("codigo_producto")));
		producto.setIvacompra(Double.parseDouble(request.getParameter("ivacompra")));
		producto.setNombre_producto(request.getParameter("nombre_producto"));
		producto.setPrecio_compra(Double.parseDouble(request.getParameter("precio_compra")));
		producto.setPrecio_venta(Double.parseDouble(request.getParameter("precio_venta")));
		int respuesta = 0;
		try{
			respuesta=JSONProducto.postJSON(producto);
			PrintWriter writer = response.getWriter();
			if (respuesta == 200) {
				writer.println(" Registro Agregado!");
			}else {
				writer.println(" Error: "+respuesta);
			}
			writer.close();
		}catch (IOException e){
			e.printStackTrace();
		};
	}
	
	public void listarProductos(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException {
		try {
			ArrayList<Productos> lista = JSONProducto.getJSON();
			String pagina = "/resultadoProductos.jsp";
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
