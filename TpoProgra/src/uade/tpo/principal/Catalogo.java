package uade.tpo.principal;

import Implementaciones.Conjunto;
import TDA.ConjuntoTDA;
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
	public ConjuntoTDA autoresLibrosMenorPrecioEnRango(float pmin, float pmax){
		ConjuntoTDA auts = new Conjunto();
		auts.inicializarConjunto();
		agregarAutores(auts,this.autores, pmin, pmax);
		return auts;
	}
	
	private void agregarAutores(ConjuntoTDA c, AutorTDA autor, float pmin, float pmax){
		
		if(!autor.AutorVacio()){
	
			AutorTDA hi = autor.HijoIzquierdo();
			AutorTDA hd = autor.HijoDerecho();
			LibrosAutorTDA lhi = hi.GetLibros(hi.obtenerAutor().nombre);
			LibrosAutorTDA lhd = hd.GetLibros(hd.obtenerAutor().nombre);

			LibrosAutorTDA menorHi = buscarLibroMenorPrecio(lhi);
			LibrosAutorTDA menorHd = buscarLibroMenorPrecio(lhd);
			
			if(menorHi.obtenerLibro().precio >= pmin && menorHi.obtenerLibro().precio <= pmax){
				c.agregar(hi.obtenerAutor());
			}
			if(menorHd.obtenerLibro().precio >= pmin && menorHd.obtenerLibro().precio <= pmax){
				c.agregar(hd.obtenerAutor());
			}
			agregarAutores(c, hi, pmin, pmax);
			agregarAutores(c, hd, pmin, pmax);
		}
	}
	
	//Devuelve  el libro mas barato del arbol
	private LibrosAutorTDA buscarLibroMenorPrecio(LibrosAutorTDA libro){
		if(libro.HijoIzquierdo().LibroVacio()){
			return libro;
		}else{
			return buscarLibroMenorPrecio(libro.HijoIzquierdo());
		}
	}
	
	//Determina si un determinado título de libro corresponde a un determinado autor.
	public boolean libroPertenece(Autor autor, Libro libro){
		LibrosAutorTDA libros = this.autores.GetLibros(autor.nombre);
		return buscarLibroPorTitulo(libros, libro.titulo);
	}
	
	private boolean buscarLibroPorTitulo(LibrosAutorTDA libros, String titulo){	
		if(libros.LibroVacio()){
			return false;
		}else{ 
			Libro lib = libros.obtenerLibro();
			if(lib.titulo.equals(titulo)){
				return true;
			}else{
				return buscarLibroPorTitulo(libros.HijoIzquierdo(), titulo) || buscarLibroPorTitulo(libros.HijoDerecho(), titulo);
			}
		}
	}

}
