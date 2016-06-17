package uade.tpo.principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

import TDA.ConjuntoTDA;
import uade.tpo.model.Autor;
import uade.tpo.model.Libro;

public class App {

	private static final String BULK_FILE_NAME = "bulk_load.txt";

	private Catalogo catalogo;

	public static void main(String[] args) throws IOException {
		App app = new App();
		app.bulkLoad();
	}

	public App() {
		this.catalogo = new Catalogo();
	}

	public void bulkLoad() throws IOException {
		InputStream in = App.class.getResourceAsStream(BULK_FILE_NAME);
		Reader reader = new InputStreamReader(in, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line;
		StringTokenizer st1, st2, st3 = null;
		Set data = new HashSet();
		while ((line = bufferedReader.readLine()) != null) {
			st1 = new StringTokenizer(line, "=", false);
			while (st1.hasMoreTokens()) {
				Nodo nodo = new Nodo();
				String nombreAutor = st1.nextToken();
				Autor autor = new Autor();
				autor.setNombre(nombreAutor);
				nodo.autor = autor;
				st2 = new StringTokenizer(st1.nextToken(), ";", false);
				Set libroSet = new HashSet();

				while (st2.hasMoreTokens()) {
					st3 = new StringTokenizer(st2.nextToken(), ",", false);
					String nombreLibro = st3.nextToken();
					float precio = new Float(st3.nextToken()).floatValue();
					Libro libro = new Libro();
					libro.setTitulo(nombreLibro);
					libro.setPrecio(precio);
					libroSet.add(libro);
				}
				nodo.libros = libroSet;
				data.add(nodo);
			}
		}
		bufferedReader.close();
		reader.close();

	//	agregarDataCatalogo(data);
	//	Autor a = new Autor();
	//	a.setNombre("Eduardo Galeano");
		
	//	System.out.println(catalogo.libroPerteneceAutorMenorPrecio(a,"China",new Float(10).floatValue()));
		
	}

	private void agregarDataCatalogo(Set data) {
		agregarAutoresCatalogo(data);
		agregarLibrosCatalogo(data);
	}

	private void agregarAutoresCatalogo(Set data) {
		for (Iterator it = data.iterator(); it.hasNext();) {
			Nodo nodo = (Nodo) it.next();
			catalogo.agregarAutor(nodo.autor);
		}
	}

	private void agregarLibrosCatalogo(Set data) {
		for (Iterator it = data.iterator(); it.hasNext();) {
			Nodo nodo = (Nodo) it.next();
			Set libros = nodo.libros;
			for (Iterator it2 = libros.iterator(); it2.hasNext();) {
				Libro libro = (Libro) it2.next();
				catalogo.agregarLibroAutor(nodo.autor, libro);
			}
		}
	}

	class Nodo {
		Autor autor;
		Set libros;
	}

}
