import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ejercicio2App {
	
	/* 
	 * Como hasta el ejercicio 2 no se pide explícitamente definir un diccionario, de momento este programa lo que hace es 
	 * pedir una cantidad de compras (registros), por cada compra defines la cantidad de artículos y de esos artículos,
	 * defines el precio. Luego quedan todos esos registros ligados a un arraylist, cuyas celdas contienen toda la información
	 * que se pide en el ejercicio
	 * */
	
	// El arraylist representa una lista de compras, como si ojeásemos el histórico de una caja registradora a final del día
	// Cada elemento de la lista es un string que contiene todos los datos que se piden
	
	static ArrayList<String> listaVentas = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertarRegistros();
	}
	
	// Método principal. Anida varias compras.
	// Llama a introducirDatos() para meter los datos de cada compra en el ArrayList
	// Llama finalmente a mostrarDatos() para mostrar los elementos de la lista
	static void insertarRegistros() {
		String strCompras = JOptionPane.showInputDialog("Introduce cantidad de compras a listar: ");
		int compras = Integer.parseInt(strCompras);
		for (int i = 0; i < compras; i++) {
			introducirDatos();
		}
		mostrarDatos();
	}
	
	static void mostrarDatos() {
		JOptionPane.showMessageDialog(null, listaVentas.toString());
		System.out.println(listaVentas.toString());
	}
	
	// Construye un string y llena la lista con un elemento nuevo con dicho string
	static void introducirDatos() {
		
		// Identificamos la operación con el tamaño del arrayList actual
		int op = listaVentas.size()+1;
		
		// String final que añadiremos al arrayList con todos sus datos:
		String strFinal = "COMPRA ID: " + op;
		
		// Precio final de la compra (BRUTO)
		int totalBrutoCompra = 0;
		// Precio final de la compra (NETO, incluyendo cálculo de impuestos)
		int totalNetoCompra = 0;
		
		// Iva imponible sobre el que multiplicaremos
		double imponible = 0.0;
		
		// Pedimos datos. Según la cantidad de items distintos, iteramos.
		String strArticulos = JOptionPane.showInputDialog("COMPRA " + op + "\nCantidad de articulos: ");
		int articulos = Integer.parseInt(strArticulos);
		
		// Rellenamos las cantidades:
		strFinal += " | Cantidad artículos: " + articulos + " | "; 
		
		// Iterar para introducir el precio de cada artículo y su IVA:
		
		for (int i = 0; i < articulos; i++) {
			
			String strPrecio = JOptionPane.showInputDialog("Introduce precio del articulo n" + (i+1) + ": ");
			int precio = Integer.parseInt(strPrecio);
			
			String strIva = JOptionPane.showInputDialog("Introduce el IVA: 1-> 21% | 2-> 4% ");
			int iva = Integer.parseInt(strIva);
			
			strFinal += " IVA artículo " + (i+1) + ":";

			// Controlamos que el input de IVA sea correcto. Por defecto será 1 (21%) si se introduce mal.
			if (iva == 1) {
				//Tipo normal
				imponible = 0.21;
				strFinal += " 21% ";
			}
			
			else if (iva == 2) {
				imponible = 0.04;
				strFinal += " 4% ";
			}
			
			else {
				imponible = 0.21;
				strFinal += " 21% ";
			}
			
			totalBrutoCompra += precio;
			totalNetoCompra += (int)precio + (precio * imponible);
			
		}
		
		strFinal += " | BRUTO TOTAL: " + totalBrutoCompra;
		
		strFinal += " | NETO TOTAL: " + totalNetoCompra;
		
		String strPagado = JOptionPane.showInputDialog("Introduce pago: ");
		int pagado = Integer.parseInt(strPagado);
		strFinal += " | CANTIDAD PAGADA: " + pagado;
		
		int cambio = pagado - totalNetoCompra;
		strFinal += " | CAMBIO A DEVOLVER: " + cambio + "\n";
		
		listaVentas.add(strFinal);
		
	}

}
