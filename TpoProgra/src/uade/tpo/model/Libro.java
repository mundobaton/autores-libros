package uade.tpo.model;

import uade.tpo.tda.LibrosAutorTDA;

public class Libro {
	private String titulo;
	private float precio;
	private LibrosAutorTDA hi;
	private LibrosAutorTDA hd;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public LibrosAutorTDA getHi() {
		return hi;
	}

	public void setHi(LibrosAutorTDA hi) {
		this.hi = hi;
	}

	public LibrosAutorTDA getHd() {
		return hd;
	}

	public void setHd(LibrosAutorTDA hd) {
		this.hd = hd;
	}
}
