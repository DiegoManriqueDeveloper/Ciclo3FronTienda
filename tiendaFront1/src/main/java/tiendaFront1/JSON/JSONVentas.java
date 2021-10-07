package tiendaFront1.JSON;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JSONVentas {
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static ArrayList<Usuarios2> parsingUsuarios(String json) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		ArrayList<Usuarios2> lista = new ArrayList<Usuarios2>();
		JSONArray usuarios = (JSONArray) jsonParser.parse(json);
		Iterator i = usuarios.iterator();
		
		
		while (i.hasNext()) {
		JSONObject innerObj = (JSONObject) i.next();
		Usuarios2 usuario = new Usuarios2();
		usuario.setCedula_usuario(Long.parseLong(innerObj.get("cedula_usuario").toString()));
		usuario.setEmail_usuario(innerObj.get("email_usuario").toString());
		usuario.setNombre_usuario(innerObj.get("nombre_usuario").toString());
		usuario.setPassword(innerObj.get("password").toString());
		usuario.setUsuario(innerObj.get("usuario").toString());
		lista.add(usuario);
		}
		return lista;
		}
	
	public static ArrayList<Usuarios2> getJSON() throws IOException, ParseException{
		url = new URL(sitio+"usuarios/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
		json += (char)inp[i];
		}
		ArrayList<Usuarios2> lista = new ArrayList<Usuarios2>();
		lista = parsingUsuarios(json);
		http.disconnect();
		return lista;
		}
	
	public static int postJSON(Usuarios2 usuario) throws IOException {
		url = new URL(sitio+"usuarios/guardar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		try {
		http.setRequestMethod("POST");
		} catch (ProtocolException e) {
		e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		String data = "{"
		+ "\"cedula_usuario\":\""+ usuario.getCedula_usuario()
		+"\",\"email_usuario\": \""+usuario.getEmail_usuario()
		+"\",\"nombre_usuario\": \""+usuario.getNombre_usuario()
		+"\",\"password\":\""+usuario.getPassword()
		+"\",\"usuario\":\""+usuario.getUsuario()
		+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
		}
}
