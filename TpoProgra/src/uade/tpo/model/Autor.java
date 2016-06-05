package uade.tpo.model;

import uade.tpo.tda.LibrosAutorTDA;

public class Autor {
	private String nombre;
	private LibrosAutorTDA libros;

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

}
