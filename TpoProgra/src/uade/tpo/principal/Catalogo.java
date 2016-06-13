package uade.tpo.principal;

import uade.tpo.impl.AutorTDAImpl;
import uade.tpo.model.Autor;
import uade.tpo.model.Libro;
import uade.tpo.tda.AutorTDA;

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

}
