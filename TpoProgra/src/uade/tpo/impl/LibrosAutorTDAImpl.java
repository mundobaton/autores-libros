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
			// raiz.titulo > nombre
			if (raiz.getTitulo().compareTo(nombre) > 0) {
				raiz.getHi().Agregar(nombre, precio);
			} else {
				raiz.getHd().Agregar(nombre, precio);
			}
		}
	}

	public boolean LibroPertenece(String nombre) {
		if (LibroVacio()) {
			return false;
		} else {
			if (raiz.getTitulo().equals(nombre)) {
				return true;
			} else {
				return raiz.getHd().LibroPertenece(nombre)
						|| raiz.getHi().LibroPertenece(nombre);
			}
		}
	}

	public LibrosAutorTDA HijoIzquierdo() {
		return raiz.getHi();
	}

	public LibrosAutorTDA HijoDerecho() {
		return raiz.getHd();
	}

	public void Eliminar(String nombre) {
		if (raiz != null) {
			if (raiz.getTitulo().equals(nombre) && raiz.getHi().LibroVacio()
					&& raiz.getHd().LibroVacio()) {
				raiz = null;
			} else {
				if (raiz.getTitulo().equals(nombre)
						&& !raiz.getHi().LibroVacio()) {
					raiz = mayor(raiz.getHi());
					raiz.getHi().Eliminar(raiz.getTitulo());
				} else if (raiz.getTitulo().equals(nombre)
						&& !raiz.getHd().LibroVacio()) {
					raiz = menor(raiz.getHd());
					raiz.getHd().Eliminar(raiz.getTitulo());
				} else if (raiz.getTitulo().compareTo(nombre) > 0) {
					raiz.getHi().Eliminar(nombre);
				} else {
					raiz.getHd().Eliminar(nombre);
				}
			}
		}
	}

	private Libro mayor(LibrosAutorTDA libro) {
		if (libro.HijoDerecho().LibroVacio()) {
			return libro.Raiz();
		} else {
			return mayor(libro.HijoDerecho());
		}

	}

	private Libro menor(LibrosAutorTDA libro) {
		if (libro.HijoIzquierdo().LibroVacio()) {
			return libro.Raiz();
		} else {
			return menor(libro.HijoIzquierdo());
		}
	}

	public Libro Raiz() {
		return raiz;
	}

	public boolean LibroVacio() {
		return raiz == null;
	}

}
