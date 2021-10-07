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

import tiendaFront1.JSON.JSONUsuario;
import tiendaFront1.Modelo.Usuarios;


@WebServlet("/UsuarioServlet")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public ServletUsuario() {
		super();
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String listar = request.getParameter("Listar");
		String agregar = request.getParameter("Agregar");
		String validar = request.getParameter("validar");
		if (agregar != null) {
			
			agregarUsuario(request, response);
System.out.println("aqui va");
		}
		if (listar != null) {
			try {
				listarUsuarios(request, response);
			} catch (ParseException | ServletException e) {
				
				e.printStackTrace();
			}
		}
		if (validar != null) {
			try {
				validarUsuario(request, response);
			} catch (ServletException e) {
				
				e.printStackTrace();}
			
	}

	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void agregarUsuario(HttpServletRequest request, HttpServletResponse response) {
		Usuarios usuario = new Usuarios();
		usuario.setNombre_usuario(request.getParameter("nombre"));
		usuario.setCedula_usuario(Long.parseLong(request.getParameter("cedula")));
		usuario.setEmail_usuario(request.getParameter("email"));
		usuario.setUsuario(request.getParameter("usuario"));
		usuario.setPassword(request.getParameter("password"));
		int respuesta = 0;
		try {
			respuesta = JSONUsuario.postJSON(usuario);
			PrintWriter writer = response.getWriter();
			if (respuesta == 200) {
				writer.println(" Registro Agregado!");
			} else {
				writer.println(" Error: " + respuesta);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
	}

	public void listarUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, ServletException {
		try {
			ArrayList<Usuarios> lista = JSONUsuario.getJSON();
			String pagina = "/resultado.jsp";
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void validarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			ArrayList<Usuarios> lista = JSONUsuario.getJSON();
			request.setAttribute("lista", lista);
			String usu = request.getParameter("txtUsuario");
			String pass = request.getParameter("txtPassword");
			int respuesta = 0;
			for(Usuarios usuario : lista) {
				if(usuario.getUsuario().equals(usu) && usuario.getPassword().equals(pass) ) {
					request.setAttribute("usuario", usuario);
					 request.getRequestDispatcher("principal.jsp").forward(request, response); 
					 respuesta= 1;
					System.out.println("aqui entro");
				}
			}
			if (respuesta == 0) {
				PrintWriter writer = response.getWriter();
				writer.println(" error de usuario");
			}
					
		}
		catch(IOException | ParseException e){
			e.printStackTrace();
		}
}
}