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

import tiendaFront1.JSON.JSONVentas;
import tiendaFront1.Modelo.Ventas;

@WebServlet("/ServletVentas")
public class ServletVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServletVentas() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String listar = request.getParameter("Listar");
		String agregar = request.getParameter("Agregar");
		if (agregar != null) {
			agregarventa(request, response);
		}
		if (listar != null) {
			try {
				listarVentas(request, response);
			} catch (ParseException | ServletException e) {
			
				e.printStackTrace();
			}
		}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void agregarventa(HttpServletRequest request, HttpServletResponse response) {
		Ventas venta = new Ventas();
		venta.setCodigo_venta(Long.parseLong(request.getParameter("codigoVentas")));
		venta.setIvaventa(Double.parseDouble(request.getParameter("ivaVentas")));
		venta.setTotal_venta(Double.parseDouble(request.getParameter("totalVentas")));
		venta.setValor_venta(Double.parseDouble(request.getParameter("valorVentas")));	
		int respuesta = 0;
		try{
			respuesta=JSONVentas.postJSON(venta);
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
	public void listarVentas(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException {
		try {
			ArrayList<Ventas> lista = JSONVentas.getJSON();
			String pagina = "/resultadoVentas.jsp";
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
