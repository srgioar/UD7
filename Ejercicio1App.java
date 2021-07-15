import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Ejercicio1App {
	
	// Lista de media de notas por alumno
	static ArrayList<Integer> listaDeNotas = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		pedirDatos();
		mostrarDatos();

	}
	
	
	static // Introducir los numeros
	void pedirDatos() {
		
		ArrayList<Integer> lista = null;
		
		String strAlumnos = JOptionPane.showInputDialog("¿Cuantos alumnos hay?");
		String strNotas = JOptionPane.showInputDialog("¿Cuantos examenes hay?");
		
		// Probamos con 3 alumnos, cada uno de ellos 3 notas distintas
		int alumnos = Integer.parseInt(strAlumnos);
		int notas = Integer.parseInt(strNotas);
		
		// Dos for anidados para pedir todas las notas de los alumnos
		
		for (int i = 0; i < alumnos; i++) {
			
			// Lista de media de notas por alumno
			 lista = new ArrayList<>();
			
			//String input = JOptionPane.showInputDialog("Inserta nota de alumno n"+(i+1));
			for (int f = 0; f < notas; f++) {
				String input = JOptionPane.showInputDialog("ALUMNO " + (i+1) + " \n Inserta nota n"+(f+1));
				lista.add(Integer.parseInt(input));
			}
			
			listaDeNotas.add(generarMedia(lista));
		}
			
	}
	
	// Recibe un arraylist de enteros y devuelve la media aritmética de sus valores
	static int generarMedia(ArrayList <Integer> lista) {
		
		// Pretendía iterar con un for o foreach pero he usado iterator como en los docs
		
		Iterator<Integer> it = lista.iterator();
		int num = 0;
		
		while (it.hasNext()) {
			num += it.next();
		}
		
		int media = num / lista.size();
		return media;
		
	}
	
	// Mostramos la lista
	static void mostrarDatos() {
		
		JOptionPane.showMessageDialog(null, "Listado de notas: \n" + listaDeNotas.toString());
		
	}

}
