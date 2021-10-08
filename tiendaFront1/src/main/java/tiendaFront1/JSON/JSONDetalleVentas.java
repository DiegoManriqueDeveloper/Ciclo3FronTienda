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

import tiendaFront1.Modelo.DetallesVentas;


public class JSONDetallesVentas {
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static ArrayList<DetallesVentas> parsingDetallesVentas(String json) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		ArrayList<DetallesVentas> lista = new ArrayList<DetallesVentas>();
		JSONArray detalle = (JSONArray) jsonParser.parse(json);
		Iterator i = detalle.iterator();
		
		
		while (i.hasNext()) {
		JSONObject innerObj = (JSONObject) i.next();
		DetallesVentas detalleVenta = new DetallesVentas();
		
		detalleVenta.setCodigo_detalle_de_venta(Long.parseLong(innerObj.get("codigoDetalleVenta").toString()));
		detalleVenta.setCantidad_de_producto(Long.parseLong(innerObj.get("cantidadProducto").toString()));
		detalleVenta.setCodigo_producto(Long.parseLong(innerObj.get("codigoProducto").toString()));
		detalleVenta.setCodigo_venta(Long.parseLong(innerObj.get("CodigoVenta").toString()));
		detalleVenta.setValor_total(Long.parseLong(innerObj.get("valorTotal").toString()));
		detalleVenta.setValor_venta(Long.parseLong(innerObj.get("valorVenta").toString()));
		detalleVenta.setValor_iva(Long.parseLong(innerObj.get("valorIva").toString()));
		lista.add(detalleVenta);
		
		}
		return lista;
		}
	
	public static ArrayList<DetallesVentas> getJSON() throws IOException, ParseException{
		url = new URL(sitio+"DetallesVentas/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
		json += (char)inp[i];
		}
		ArrayList<DetallesVentas> lista = new ArrayList<DetallesVentas>();
		lista = parsingDetallesVentas(json);
		http.disconnect();
		return lista;
		}
	
	public static int postJSON(DetallesVentas detalleVenta) throws IOException {
		url = new URL(sitio+"DetallesVentas/guardar");
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
		+ "\"\":\"codigoDetalleVenta"+ detalleVenta.getCodigo_detalle_de_venta()
		+"\",\"cantidadProducto\": \""+detalleVenta.getCantidad_de_producto()
		+"\",\"codigoProducto\": \""+detalleVenta.getCodigo_producto()
		+"\",\"CodigoVenta\":\""+detalleVenta.getCodigo_venta()
		+"\",\"valorTotal\":\""+detalleVenta.getValor_total()
		+"\",\"valorVenta\":\""+detalleVenta.getValor_venta()
		+"\",\"valorIva\":\""+detalleVenta.getValor_iva()
		+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
		}
}
