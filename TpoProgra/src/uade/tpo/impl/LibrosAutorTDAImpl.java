package uade.tpo.impl;

import uade.tpo.model.Libro;
import uade.tpo.tda.LibrosAutorTDA;

public class LibrosAutorTDAImpl implements LibrosAutorTDA {

	class NodoLibro {
		float precio;
		String titulo;
		LibrosAutorTDA hi;
		LibrosAutorTDA hd;
	}

	private NodoLibro raiz;

	public void Inicializar() {
		raiz = null;
	}

	public void Agregar(String nombre, float precio) {
		if (LibroVacio()) {
			NodoLibro libro = new NodoLibro();
			libro.titulo = nombre;
			libro.precio = precio;
			libro.hd = new LibrosAutorTDAImpl();
			libro.hi = new LibrosAutorTDAImpl();
			libro.hd.Inicializar();
			libro.hi.Inicializar();
			raiz = libro;
		} else {
			if (raiz.precio > precio) {
				raiz.hi.Agregar(nombre, precio);
			} else {
				raiz.hd.Agregar(nombre, precio);
			}
		}
	}

	private NodoLibro buscarLibro(LibrosAutorTDAImpl libroTDA, String nombre) {
		if (libroTDA.LibroVacio()) {
			return null;
		} else {
			if (libroTDA.raiz.titulo.equals(nombre)) {
				return libroTDA.raiz;
			} else {
				NodoLibro lib = null;
				lib = buscarLibro((LibrosAutorTDAImpl) libroTDA.HijoDerecho(),
						nombre);
				if (lib == null) {
					lib = buscarLibro(
							(LibrosAutorTDAImpl) libroTDA.HijoIzquierdo(),
							nombre);
				}
				return lib;
			}
		}
	}

	public LibrosAutorTDA HijoIzquierdo() {
		return raiz.hi;
	}

	public LibrosAutorTDA HijoDerecho() {
		return raiz.hd;
	}

	public void Eliminar(String nombre) {
		if (raiz != null) {
			if (raiz.titulo.equals(nombre) && raiz.hi.LibroVacio()
					&& raiz.hd.LibroVacio()) {
				raiz = null;
			} else {
				if (raiz.titulo.equals(nombre) && !raiz.hi.LibroVacio()) {
					raiz = mayor((LibrosAutorTDAImpl) raiz.hi);
					raiz.hi.Eliminar(raiz.titulo);
				} else if (raiz.titulo.equals(nombre) && !raiz.hd.LibroVacio()) {
					raiz = menor((LibrosAutorTDAImpl) raiz.hd);
					raiz.hd.Eliminar(raiz.titulo);
				} else {
					NodoLibro lib = buscarLibro(this, nombre);
					if (raiz.precio > lib.precio) {
						raiz.hi.Eliminar(nombre);
					} else {
						raiz.hd.Eliminar(nombre);
					}
				}
			}
		}
	}

	private NodoLibro mayor(LibrosAutorTDAImpl libro) {
		if (libro.HijoDerecho().LibroVacio()) {
			return libro.raiz;
		} else {
			return mayor((LibrosAutorTDAImpl) libro.HijoDerecho());
		}

	}

	private NodoLibro menor(LibrosAutorTDAImpl libro) {
		if (libro.HijoIzquierdo().LibroVacio()) {
			return libro.raiz;
		} else {
			return menor((LibrosAutorTDAImpl) libro.HijoIzquierdo());
		}
	}

	public boolean LibroVacio() {
		return raiz == null;
	}

	public Libro obtenerLibro() {
		Libro lib = new Libro();
		lib.setPrecio(raiz.precio);
		lib.setTitulo(raiz.titulo);
		return lib;
	}

}
