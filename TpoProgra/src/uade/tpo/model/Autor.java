package uade.tpo.model;

import uade.tpo.tda.LibroTDA;

public class Autor {
	String nombre;
	LibroTDA libros;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LibroTDA getLibros() {
		return libros;
	}

	public void setLibros(LibroTDA libros) {
		this.libros = libros;
	}

}
