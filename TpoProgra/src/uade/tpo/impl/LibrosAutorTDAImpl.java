package uade.tpo.impl;

import uade.tpo.model.Libro;
import uade.tpo.tda.LibrosAutorTDA;

public class LibrosAutorTDAImpl implements LibrosAutorTDA {

	class NodoLibro {
		private float precio;
		private String titulo;
		private LibrosAutorTDA hi;
		private LibrosAutorTDA hd;

		public float getPrecio() {
			return precio;
		}

		public void setPrecio(float precio) {
			this.precio = precio;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
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

	private NodoLibro raiz;

	public void Inicializar() {
		raiz = null;
	}

	public void Agregar(String nombre, float precio) {
		if (LibroVacio()) {
			NodoLibro libro = new NodoLibro();
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

	private NodoLibro buscarLibro(LibrosAutorTDAImpl libroTDA, String nombre) {
		if (libroTDA.LibroVacio()) {
			return null;
		} else {
			if (libroTDA.Raiz().getTitulo().equals(nombre)) {
				return libroTDA.Raiz();
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
					raiz = mayor((LibrosAutorTDAImpl) raiz.getHi());
					raiz.getHi().Eliminar(raiz.getTitulo());
				} else if (raiz.getTitulo().equals(nombre)
						&& !raiz.getHd().LibroVacio()) {
					raiz = menor((LibrosAutorTDAImpl) raiz.getHd());
					raiz.getHd().Eliminar(raiz.getTitulo());
				} else {
					NodoLibro lib = buscarLibro(this, nombre);
					if (raiz.getPrecio() > lib.getPrecio()) {
						raiz.getHi().Eliminar(nombre);
					} else {
						raiz.getHd().Eliminar(nombre);
					}
				}
			}
		}
	}

	private NodoLibro mayor(LibrosAutorTDAImpl libro) {
		if (libro.HijoDerecho().LibroVacio()) {
			return libro.Raiz();
		} else {
			return mayor((LibrosAutorTDAImpl) libro.HijoDerecho());
		}

	}

	private NodoLibro menor(LibrosAutorTDAImpl libro) {
		if (libro.HijoIzquierdo().LibroVacio()) {
			return libro.Raiz();
		} else {
			return menor((LibrosAutorTDAImpl) libro.HijoIzquierdo());
		}
	}

	private NodoLibro Raiz() {
		return raiz;
	}

	public boolean LibroVacio() {
		return raiz == null;
	}
	
	public Libro obtenerLibro() {
		Libro lib = new Libro();
		lib.setPrecio(raiz.getPrecio());
		lib.setTitulo(raiz.getTitulo());
		return lib;
	}

}
