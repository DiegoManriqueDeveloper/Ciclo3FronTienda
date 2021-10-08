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

import tiendaFront1.JSON.JSONDetallesVentas;
import tiendaFront1.Modelo.DetallesVentas;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/ServletDetallesVentas")
public class Servlet_DetallesVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_DetallesVentas() {
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
			agregarDetalleVentas(request, response);

		}
		if (listar != null) {
			try {
				listarDetalleVentas(request, response);
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
	
	public void agregarDetalleVentas(HttpServletRequest request, HttpServletResponse response) {
		DetallesVentas detalle = new DetallesVentas();
		detalle.setCodigo_detalle_de_venta(Long.parseLong(request.getParameter("codigoDetalleVenta")));
		detalle.setCantidad_de_producto(Long.parseLong(request.getParameter("CantidaProducto")));
		detalle.setCodigo_producto(Long.parseLong(request.getParameter("CodigoProducto")));
		detalle.setCodigo_venta(Long.parseLong(request.getParameter("CodigoVenta")));
		detalle.setValor_total(Long.parseLong(request.getParameter("ValorTotal")));
		detalle.setValor_venta(Long.parseLong(request.getParameter("ValorVenta")));
		detalle.setValor_iva(Long.parseLong(request.getParameter("ValorIva")));
		
		
		
		
		int respuesta = 0;
		try{
			respuesta=JSONDetallesVentas.postJSON(detalle);
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
	
	public void listarDetalleVentas(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException {
		try {
			ArrayList<DetallesVentas> lista = JSONDetallesVentas.getJSON();
			String pagina = "/resultadoDetallesVentas.jsp";
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}