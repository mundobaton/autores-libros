package uade.tpo.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import uade.tpo.impl.AutorTDAImpl;
import uade.tpo.impl.LibrosAutorTDAImpl;
import uade.tpo.tda.AutorTDA;
import uade.tpo.tda.LibrosAutorTDA;

public class AutorTest {

	private AutorTDA Autor;

	public static void main(String[] args) throws IOException {
		AutorTest test = new AutorTest();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String input = "";
		System.out.println("Ingrese el comando.. -1 para terminar..");
		while (!input.equals("-1")) {
			input = reader.readLine();
			if (input.equals("agregarAutor")) {
				test.testAgregarAutor(reader);
			} else if (input.equals("eliminarAutor")) {
				test.testEliminarAutor(reader);
			} else {
				System.out.println("Comando invalido..");
			}
			System.out.println("Ingrese el comando.. -1 para terminar..");
		}
		reader.close();
		System.out.println("Grax!!");
	}

	public AutorTest() {
		this.Autor = new AutorTDAImpl();
	}

	public void testEliminarAutor(BufferedReader reader) throws IOException {
		String nombreAutor;
		System.out.println("Ingrese el nombre del autor:");
		nombreAutor = reader.readLine();
		Autor.Eliminar(nombreAutor);
	}

	public void testAgregarAutor(BufferedReader reader)
			throws NumberFormatException, IOException {
		String nombreAutor;
		System.out.println("Ingrese el nombre del autor:");
		nombreAutor = reader.readLine();
		Autor.Agregar(nombreAutor);
	}
}

