package uade.tpo.principal;

import uade.tpo.impl.AutorTDAImpl;
import uade.tpo.impl.LibrosAutorTDAImpl;
import uade.tpo.model.Autor;
import uade.tpo.model.Libro;
import uade.tpo.tda.AutorTDA;
import uade.tpo.tda.LibrosAutorTDA;


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
	
	//Devolver los autores cuyo libro de menor precio este entre un rango de valores dados.
//	public void autoresLibrosMenorPrecioEnRango(float pmin, float pmax){
//	
//	}
	
	//Determinar si un determinado título de libro corresponde a un determinado autor.
	public boolean libroPertenece(Autor autor, Libro libro){
		LibrosAutorTDA libros = this.autores.GetLibros(autor.nombre);
		return buscarLibro(libros, libro.titulo);
	}
	
	private boolean buscarLibro(LibrosAutorTDA libros, String titulo){	
		if(libros.LibroVacio()){
			return false;
		}else{ 
			Libro lib = libros.obtenerLibro();
			if(lib.titulo.equals(titulo)){
				return true;
			}else{
				return buscarLibro(libros.HijoIzquierdo(), titulo) || buscarLibro(libros.HijoDerecho(), titulo);
			}
		}
	}

}
