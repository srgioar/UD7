import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ejercicio3App {
	
	static Hashtable<String, Double> tablaPrecio = new Hashtable<String, Double>();
	static Hashtable<String, Integer> tablaCantidad = new Hashtable<String, Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Inicia los dos hashtables
		iniciarHashtables();
		
		String input = JOptionPane.showInputDialog("Elige opción: \n 1 -> Mostrar stock \n 2-> Insertar artículo \n 3-> Consultar artículo");
		int num = Integer.parseInt(input);
		
		switch(num) {
		case 1:
			mostrarTabla();
			break;
		case 2:
			insertarArticulo();
			// Para comprobar que insertamos bien, llama siempre a mostrarTabla después:
			mostrarTabla();
			break;
		case 3:
			consultarArticulo();
			break;
		}
		
	}
	
	// Comprueba si los artículos están en stock
	// Si la compra se realiza, los resta del stock
	
	static void VenderArticulo() {
		
	}
	
	// Rellenamos las diez posiciones iniciales
	static void iniciarHashtables() {
		
		tablaPrecio.put("patata", 1.1);
		tablaCantidad.put("patata", 8);
		
		tablaPrecio.put("naranja", 2.4);
		tablaCantidad.put("naranja", 6);
		
		tablaPrecio.put("manzana", 1.7);
		tablaCantidad.put("manzana", 4);
		
		tablaPrecio.put("pera", 1.7);
		tablaCantidad.put("pera", 3);
		
		tablaPrecio.put("mandarina", 1.3);
		tablaCantidad.put("mandarina", 1);
		
		tablaPrecio.put("limon", 1.2);
		tablaCantidad.put("limon", 9);
		
		tablaPrecio.put("zanahoria", 1.6);
		tablaCantidad.put("zanahoria", 5);
		
		tablaPrecio.put("lima", 2.1);
		tablaCantidad.put("lima", 12);
		
		tablaPrecio.put("lechuga", 3.4);
		tablaCantidad.put("lechuga", 7);
		
		tablaPrecio.put("pimiento", 0.8);
		tablaCantidad.put("pimiento", 4);
		
	}
	
//	 Consulta la información de una clave concreta del hashtable
//	 En principio mostramos la info según el nombre de artículo
	static void consultarArticulo() {
		
		String nombre = JOptionPane.showInputDialog("Introduce articulo a consultar: ");
		String strCompleto = "ARTÍCULO: " + nombre.toUpperCase() + "\nCANTIDAD: " + tablaCantidad.get(nombre) + "\nPRECIO: " + tablaPrecio.get(nombre);
		
		System.out.println("Artículo: " + nombre);
		System.out.println("Cantidad: " + tablaCantidad.get(nombre));
		System.out.println("Precio: " + tablaPrecio.get(nombre));
		
		JOptionPane.showMessageDialog(null, strCompleto);
		
	}
	
	static void insertarArticulo() {
		
		String input = JOptionPane.showInputDialog("Introduce articulo: ");
		String articulo = input;
		String input2 = JOptionPane.showInputDialog("Introduce precio: ");
		Double precio = Double.parseDouble(input2);
		String input3 = JOptionPane.showInputDialog("Introduce cantidad: ");
		int cantidad = Integer.parseInt(input3);
		
		tablaPrecio.put(articulo, precio);
		tablaCantidad.put(articulo, cantidad);
		
	}
	
	// Imprime toda la información del hashtable
	// Cruza los dos hashtables, vuelca las keys en un objeto enumeration
	// Entonces, imprime -> key + precio + cantidad
	
	static void mostrarTabla() {
		
		String stringFinal = "";
		Enumeration<String> enu = tablaCantidad.keys();
		//System.out.println("Tamaño hashtable: " + tablaCantidad.size());
		String element = null;
		
		// Como los dos hashtables son del mismo tamaño con usar el tamaño de uno sirve
		// Iterar, comprobar que existan elementos para que el programa no pete y concatenar string:
		
		for (int i = 0; i < tablaCantidad.size(); i++) {
			if (enu.hasMoreElements()) {
				element = enu.nextElement();
				stringFinal += ((i+1) + ": " + element + " | Precio: " + tablaPrecio.get(element) + " | Cantidad: " + tablaCantidad.get(element) + "\n");			
			}
		} // FINAL DEL FOR
		
		JOptionPane.showMessageDialog(null, stringFinal);
	}
	
}
