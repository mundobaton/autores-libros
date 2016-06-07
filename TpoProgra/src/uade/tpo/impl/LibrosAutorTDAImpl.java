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

	private Libro buscarLibro(LibrosAutorTDA libroTDA, String nombre) {
		if (libroTDA.LibroVacio()) {
			return null;
		} else {
			if (libroTDA.Raiz().getTitulo().equals(nombre)) {
				return libroTDA.Raiz();
			} else {
				Libro lib = null;
				lib = buscarLibro(libroTDA.HijoDerecho(), nombre);
				if (lib == null) {
					lib = buscarLibro(libroTDA.HijoIzquierdo(), nombre);
				}
				return lib;
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
				} else {
					Libro lib = buscarLibro(this, nombre);
					if (raiz.getPrecio() > lib.getPrecio()) {
						raiz.getHi().Eliminar(nombre);
					} else {
						raiz.getHd().Eliminar(nombre);
					}
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
