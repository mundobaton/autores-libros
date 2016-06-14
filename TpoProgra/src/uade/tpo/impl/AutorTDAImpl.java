package uade.tpo.impl;

import uade.tpo.model.Autor;
import uade.tpo.tda.AutorTDA;
import uade.tpo.tda.LibrosAutorTDA;

public class AutorTDAImpl implements AutorTDA {

	class NodoAutor {
		String nombre;
		LibrosAutorTDA libros;
		AutorTDA hi;
		AutorTDA hd;
	}

	private NodoAutor raiz;

	public void Inicializar() {
		raiz = null;
	}

	public void Agregar(String nombreAutor) {
		if (AutorVacio()) {
			NodoAutor autor = new NodoAutor();
			autor.nombre = nombreAutor;
			autor.libros = new LibrosAutorTDAImpl();
			autor.libros.Inicializar();
			autor.hi = new AutorTDAImpl();
			autor.hd = new AutorTDAImpl();
			autor.hi.Inicializar();
			autor.hd.Inicializar();
			raiz = autor;
		} else {
			if (raiz.nombre.compareTo(nombreAutor) > 0) {
				raiz.hi.Agregar(nombreAutor);
			} else {
				raiz.hd.Agregar(nombreAutor);
			}
		}
	}

	public AutorTDA HijoIzquierdo() {
		return raiz.hi;
	}

	public AutorTDA HijoDerecho() {
		return raiz.hd;
	}

	public void Eliminar(String nombreAutor) {
		if (!AutorVacio()) {
			if (raiz.nombre.equals(nombreAutor) && raiz.hi.AutorVacio()
					&& raiz.hd.AutorVacio()) {
				raiz = null;
			} else {
				if (raiz.nombre.equals(nombreAutor) && !raiz.hi.AutorVacio()) {
					raiz = mayor((AutorTDAImpl) raiz.hi);
					raiz.hi.Eliminar(raiz.nombre);
				} else if (raiz.nombre.equals(nombreAutor)
						&& !raiz.hd.AutorVacio()) {
					raiz = menor((AutorTDAImpl) raiz.hd);
					raiz.hd.Eliminar(raiz.nombre);
				} else {
					if (raiz.nombre.compareTo(nombreAutor) > 0) {
						raiz.hi.Eliminar(nombreAutor);
					} else {
						raiz.hd.Eliminar(nombreAutor);
					}
				}
			}
		}
	}

	private NodoAutor mayor(AutorTDAImpl autor) {
		if (autor.HijoDerecho().AutorVacio()) {
			return autor.raiz;
		} else {
			return mayor((AutorTDAImpl) autor.HijoIzquierdo());
		}
	}

	private NodoAutor menor(AutorTDAImpl autor) {
		if (autor.HijoIzquierdo().AutorVacio()) {
			return autor.raiz;
		} else {
			return mayor((AutorTDAImpl) autor.HijoDerecho());
		}
	}

	public boolean AutorVacio() {
		return raiz == null;
	}

	public void AgregarLibro(String nombreAutor, String tituloLibro, float precio) {
		NodoAutor aux = buscarAutor(this, nombreAutor);
		aux.libros.Agregar(tituloLibro, precio);

	}

	private NodoAutor buscarAutor(AutorTDAImpl autorTDA, String nombreAutor) {
		if (autorTDA.AutorVacio()) {
			return null;
		} else {
			if (autorTDA.raiz.nombre.equals(nombreAutor)) {
				return autorTDA.raiz;
			} else {
				if (autorTDA.raiz.nombre.compareTo(nombreAutor) > 0) {
					return buscarAutor((AutorTDAImpl) autorTDA.HijoIzquierdo(),
							nombreAutor);
				} else {
					return buscarAutor((AutorTDAImpl) autorTDA.HijoDerecho(),
							nombreAutor);
				}
			}
		}
	}

	public LibrosAutorTDA GetLibros(String nombreAutor) {
		// Como el autor tiene que existir no lo chequeo
		NodoAutor aux = buscarAutor(this, nombreAutor);
		return aux.libros;
	}

	public Autor obtenerAutor() {
		Autor autor = new Autor();
		autor.setNombre(raiz.nombre);
		return autor;
	}
}
