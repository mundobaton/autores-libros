package uade.tpo.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import uade.tpo.impl.LibrosAutorTDAImpl;
import uade.tpo.tda.LibrosAutorTDA;

public class LibrosAutorTest {

	private LibrosAutorTDA librosAutor;

	public static void main(String[] args) throws IOException {
		LibrosAutorTest test = new LibrosAutorTest();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String input = "";
		System.out.println("Ingrese el comando.. -1 para terminar..");
		while (!input.equals("-1")) {
			input = reader.readLine();
			if (input.equals("agregarLibro")) {
				test.testAgregarLibro(reader);
			} else if (input.equals("eliminarLibro")) {
				test.testEliminarLibro(reader);
			} else {
				System.out.println("Comando invalido..");
			}
			System.out.println("Ingrese el comando.. -1 para terminar..");
		}
		reader.close();
		System.out.println("Gracias vuelva prontos..");
	}

	public LibrosAutorTest() {
		this.librosAutor = new LibrosAutorTDAImpl();
	}

	public void testEliminarLibro(BufferedReader reader) throws IOException {
		String nombreLibro;
		System.out.println("Ingrese el nombre del libro:");
		nombreLibro = reader.readLine();
		librosAutor.Eliminar(nombreLibro);
	}

	public void testAgregarLibro(BufferedReader reader)
			throws NumberFormatException, IOException {
		String nombreLibro;
		float precio;
		System.out.println("Ingrese el nombre del libro:");
		nombreLibro = reader.readLine();
		System.out.println("Ingrese el precio del libro:");
		precio = new Float(reader.readLine()).floatValue();

		librosAutor.Agregar(nombreLibro, precio);
	}
}
