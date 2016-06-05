package uade.tpo.impl;

import uade.tpo.model.Libro;
import uade.tpo.tda.LibrosAutorTDA;

public class LibrosAutorTDAImpl implements LibrosAutorTDA {

	private Libro raiz;

	public void Inicializar() {
		raiz = null;
	}

	public void Agregar(String nombre, float precio) {
		if (LibroVacio()) {
			Libro libro = new Libro();
			libro.setTitulo(nombre);
			libro.setPrecio(precio);
			libro.setHd(new LibrosAutorTDAImpl());
			libro.setHi(new LibrosAutorTDAImpl());
			libro.getHd().Inicializar();
			libro.getHi().Inicializar();
			raiz = libro;
		} else {
			if (raiz.getPrecio() > precio) {
				raiz.getHi().Agregar(nombre, precio);
			} else {
				raiz.getHd().Agregar(nombre, precio);
			}
		}
	}

	public boolean LibroPertenece(String nombre) {
		// TODO Auto-generated method stub
		return false;
	}

	public LibrosAutorTDA HijoIzquierdo() {
		return raiz.getHi();
	}

	public LibrosAutorTDA HijoDerecho() {
		return raiz.getHd();
	}

	public void Eliminar(String nombre) {
		// TODO Auto-generated method stub

	}

	public Libro Raiz() {
		return raiz;
	}

	public boolean LibroVacio() {
		return raiz == null;
	}

}
