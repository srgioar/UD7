import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ejercicio4App {
	
	// Fusión entre el ej. 2 y el ej 3
	// Permite reponer un producto (aumentar el nivel de stock)
	// El diccionario de artículos es el mismo que en el 3 (frutas/hortalizas)
	
	// Controlamos el total recaudado. Será una suma de todo lo vendido.
	static double recaudado = 0;
	
	static Hashtable<String, Double> tablaPrecio = new Hashtable<String, Double>();
	static Hashtable<String, Integer> tablaCantidad = new Hashtable<String, Integer>();
	
	// ArrayList en el que guardaremos el histórico de acciones.
	// Cada acción importante acaba con un add a este arraylist
	static ArrayList<String> historicoAcciones = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		// Inicia los dos hashtables
		iniciarHashtables();
		
		String input = JOptionPane.showInputDialog("Elige opción: \n 1 -> Mostrar stock \n 2-> Insertar artículo \n 3-> Consultar artículo \n 4->Reponer artículo \n 5-> Realizar venta");
		int num = Integer.parseInt(input);
		
		// Switch que según opción llama a un método u otro
		// Para comprobar que modificamos artículos y cantidades correctamente, llama siempre a mostrarTabla después:
		switch(num) {
		case 1:
			mostrarTabla();
			break;
		case 2:
			insertarArticulo();
			mostrarTabla();
			break;
		case 3:
			consultarArticulo();
			break;
		case 4:
			reponerArticulo();
			mostrarTabla();
			break;
		case 5:
			realizarVenta();
			mostrarTabla();
			break;
		default:
			// Forzamos reentrada de parámetros si no son correctos:
			input = JOptionPane.showInputDialog("Elige opción: \n 1 -> Mostrar stock \n 2-> Insertar artículo \n 3-> Consultar artículo \n 4->Reponer artículo \n 5-> Realizar venta");
			num = Integer.parseInt(input);
		}
		
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
	
	static void reponerArticulo() {
		// Aumenta la cantidad de un artículo según el string (apunta a la key) y la cantidad (apunta al valor)
		// Obtiene la cantidad actual de la clave para sumar la cantidad a añadir a la ya existente
		String articulo = JOptionPane.showInputDialog("Articulo a reponer: ");
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad: "));
		int cantidadActual = tablaCantidad.get(articulo);
		tablaCantidad.put(articulo, cantidadActual + cantidad);
		
	}
	
	// Es un método idéntico a reponerArticulo pero inverso, resta las cantidades establecidas al comprar cada artículo
	// NO hace comprobación de stock en negativo, por lo que si vendes más del stock, el stock quedará en negativo
	static void realizarVenta() {
		String articulo = JOptionPane.showInputDialog("Articulo a comprar: ");
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad: "));
		int cantidadActual = tablaCantidad.get(articulo);
		tablaCantidad.put(articulo, cantidadActual - cantidad);
		recaudado += tablaPrecio.get(articulo) * tablaCantidad.get(articulo);
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
		JOptionPane.showMessageDialog(null, "Total recaudado: " + recaudado);
	}
	
}
