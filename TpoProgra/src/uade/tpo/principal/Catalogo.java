package uade.tpo.principal;

import uade.tpo.impl.AutorTDAImpl;
import uade.tpo.model.Autor;
import uade.tpo.model.Libro;
import uade.tpo.tda.AutorTDA;
import uade.tpo.tda.LibrosAutorTDA;
import Implementaciones.Conjunto;
import TDA.ConjuntoTDA;

public class Catalogo {

	private AutorTDA autores;

	public Catalogo() {
		this.autores = new AutorTDAImpl();
	}

	public void agregarAutor(Autor autor) {
		this.autores.Agregar(autor.nombre);
	}

	public void agregarLibroAutor(Autor autor, Libro libro) {
		this.autores.AgregarLibro(autor.nombre, libro.titulo, libro.precio);
	}

	// Devolver los autores cuyo libro de menor precio este entre un rango de
	// valores dados.
	public ConjuntoTDA autoresLibrosMenorPrecioEnRango(float pmin, float pmax) {
		ConjuntoTDA auts = new Conjunto();
		auts.inicializarConjunto();
		agregarAutores(auts, this.autores, pmin, pmax);
		return auts;
	}

	private void agregarAutores(ConjuntoTDA c, AutorTDA autor, float pmin,
			float pmax) {

		if (!autor.AutorVacio()) {
			LibrosAutorTDA menorRaiz = buscarLibroMenorPrecio(autor.GetLibros());
			if (menorRaiz.obtenerLibro().precio >= pmin
					&& menorRaiz.obtenerLibro().precio <= pmax) {
				c.agregar(autor);
			}
			AutorTDA hi = autor.HijoIzquierdo();

			if (!hi.AutorVacio()) {
				agregarAutores(c, hi, pmin, pmax);
			}
			AutorTDA hd = autor.HijoDerecho();
			if (!hd.AutorVacio()) {
				agregarAutores(c, hd, pmin, pmax);
			}

		}
	}

	// Devuelve el libro mas barato del arbol
	private LibrosAutorTDA buscarLibroMenorPrecio(LibrosAutorTDA libro) {
		if (libro.HijoIzquierdo().LibroVacio()) {
			return libro;
		} else {
			return buscarLibroMenorPrecio(libro.HijoIzquierdo());
		}
	}

	// Determinar si un autor dado tiene un libro dado,
	// cuyo precio sea menor a uno dado.
	public boolean libroPerteneceAutorMenorPrecio(Autor autor, String titulo,
			float precio) {
		// Buscamos los libros del autor
		LibrosAutorTDA libros = buscarAutor(this.autores, autor.nombre)
				.GetLibros();
		// Verificamos que exista el libro con un precio inferior al dado
		return buscarLibroPorTituloMenorPrecio(libros, titulo, precio);
	}

	private boolean buscarLibroPorTituloMenorPrecio(LibrosAutorTDA libros,
			String titulo, float precio) {
		// Si no hay libros devolvemos false
		if (libros.LibroVacio()) {
			return false;
		} else {
			// Obtenemos el libro
			Libro lib = libros.obtenerLibro();
			// Si el libro es el que estamos buscando y el precio del mismo es
			// menor al precio dado, devolvemos true
			if (lib.titulo.equals(titulo) && lib.precio < precio) {
				return true;
			} else {
				// Seguimos buscando
				return buscarLibroPorTituloMenorPrecio(libros.HijoIzquierdo(),
						titulo, precio)
						|| buscarLibroPorTituloMenorPrecio(
								libros.HijoDerecho(), titulo, precio);
			}
		}
	}

	// Determina si un determinado titulo de libro corresponde a un
	// determinado autor.
	public boolean libroPertenece(Autor autor, Libro libro) {
		LibrosAutorTDA libros = buscarAutor(this.autores, autor.nombre)
				.GetLibros();
		return buscarLibroPorTitulo(libros, libro.titulo);
	}

	private AutorTDA buscarAutor(AutorTDA autorTDA, String nombreAutor) {
		if (autorTDA.AutorVacio()) {
			return null;
		} else {
			if (autorTDA.obtenerAutor().nombre.equals(nombreAutor)) {
				return autorTDA;
			} else {
				if (autorTDA.obtenerAutor().nombre.compareTo(nombreAutor) > 0) {
					return buscarAutor(autorTDA.HijoIzquierdo(), nombreAutor);
				} else {
					return buscarAutor(autorTDA.HijoDerecho(), nombreAutor);
				}
			}
		}
	}

	private boolean buscarLibroPorTitulo(LibrosAutorTDA libros, String titulo) {
		if (libros.LibroVacio()) {
			return false;
		} else {
			Libro lib = libros.obtenerLibro();
			if (lib.titulo.equals(titulo)) {
				return true;
			} else {
				return buscarLibroPorTitulo(libros.HijoIzquierdo(), titulo)
						|| buscarLibroPorTitulo(libros.HijoDerecho(), titulo);
			}
		}
	}

}
