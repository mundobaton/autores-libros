package uade.tpo.model;

import uade.tpo.tda.AutorTDA;
import uade.tpo.tda.LibrosAutorTDA;

public class Autor {
	private String nombre;
	private LibrosAutorTDA libros;
	private AutorTDA hi;
	private AutorTDA hd;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LibrosAutorTDA getLibros() {
		return libros;
	}

	public void setLibros(LibrosAutorTDA libros) {
		this.libros = libros;
	}

	public AutorTDA getHi() {
		return hi;
	}

	public void setHi(AutorTDA hi) {
		this.hi = hi;
	}

	public AutorTDA getHd() {
		return hd;
	}

	public void setHd(AutorTDA hd) {
		this.hd = hd;
	}
	

}
