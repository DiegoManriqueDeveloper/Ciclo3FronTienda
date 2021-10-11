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

import tiendaFront1.JSON.JSONProveedores;
import tiendaFront1.Modelo.Proveedores;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/ServletProveedores")
public class ServletProveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProveedores() {
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
			agregarProveedor(request, response);

		}
		if (listar != null) {
			try {
				listarProveedor(request, response);
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
	
	public void agregarProveedor(HttpServletRequest request, HttpServletResponse response) {
		Proveedores proveedor = new Proveedores();
		
		proveedor.setNit_proveedor(Long.parseLong(request.getParameter("nitProveedor")));
		proveedor.setCiudad_proveedor(request.getParameter("ciudadproveedor"));
		proveedor.setDireccion_proveedor(request.getParameter("direccionProveedor"));
		proveedor.setNombre_proveedor(request.getParameter("nombreProvedor"));
		proveedor.setTelefono_proveedor(request.getParameter("telefonoProvedor"));
		int respuesta = 0;
		try{
			respuesta=JSONProveedores.postJSON(proveedor);
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
	
	public void listarProveedor(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException {
		try {
			ArrayList<Proveedores> lista = JSONProveedores.getJSON();
			String pagina = "/resultadoProveedores.jsp";
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
