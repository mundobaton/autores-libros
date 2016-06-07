package uade.tpo.impl;

import uade.tpo.model.Autor;
import uade.tpo.tda.AutorTDA;
import uade.tpo.tda.LibrosAutorTDA;

public class AutorTDAImpl implements AutorTDA {
	private Autor raiz;

	public void Inicializar() {
		raiz = null;

	}

	public void Agregar(String nombreAutor) {
		if (raiz == null) {
			raiz = new Autor();
			raiz.setNombre(nombreAutor);
			raiz.setLibros(new LibrosAutorTDAImpl());
			raiz.getLibros().Inicializar();
			raiz.setHi(new AutorTDAImpl());
			raiz.setHd(new AutorTDAImpl());
			raiz.getHi().Inicializar();
			raiz.getHd().Inicializar();
		} else {
			if (raiz.getNombre().compareTo(nombreAutor) > 0) {
				raiz.getHi().Agregar(nombreAutor);
			} else {
				raiz.getHd().Agregar(nombreAutor);
			}
		}
	}

	public AutorTDA HijoIzquierdo() {
		return raiz.getHi();
	}

	public AutorTDA HijoDerecho() {
		return raiz.getHd();
	}

	public void Eliminar(String nombreAutor) {
		if (raiz != null) {
			if (raiz.getNombre().equals(nombreAutor) && raiz.getHi().AutorVacio() && raiz.getHd().AutorVacio()) {
				raiz = null;
			} else {
				if (raiz.getNombre().equals(nombreAutor) && !raiz.getHd().AutorVacio()) {
					raiz = Mayor(raiz.getHi());
					raiz.getHi().Eliminar(raiz.getNombre());
				} else {
					if (raiz.getNombre().equals(nombreAutor) && !raiz.getHd().AutorVacio()) {
						raiz = Menor(raiz.getHd());
						raiz.getHd().Eliminar(raiz.getNombre());
					} else {
						if (raiz.getNombre().compareTo(nombreAutor) > 0) {
							raiz.getHi().Eliminar(nombreAutor);
						} else {
							raiz.getHd().Eliminar(nombreAutor);
						}
					}
				}
			}
		}

	}

	private Autor Mayor(AutorTDA autor) {
		if (autor.HijoDerecho().AutorVacio()) {
			return autor.Raiz();
		} else {
			return Mayor(autor.HijoIzquierdo());
		}
	}

	private Autor Menor(AutorTDA autor) {
		if (autor.HijoIzquierdo().AutorVacio()) {
			return autor.Raiz();
		} else {
			return Menor(autor.HijoDerecho());
		}
	}

	public Autor Raiz() {
		return raiz;
	}

	public boolean AutorVacio() {
		return raiz == null;
	}

	public void AgregarLibro(String nombreAutor, String tituloLibro, float precio) {
		Autor aux = BuscarAutor(this, nombreAutor);
		aux.getLibros().Agregar(tituloLibro, precio);

	}

	private Autor BuscarAutor(AutorTDA autorTDA, String nombreAutor) {
		if (autorTDA.AutorVacio()) {
			return null;
		} else {
			if (autorTDA.Raiz().getNombre().equals(nombreAutor)) {
				return autorTDA.Raiz();
			} else {
				if (autorTDA.Raiz().getNombre().compareTo(nombreAutor) > 0) {
					return BuscarAutor(autorTDA.HijoIzquierdo(), nombreAutor);
				} else {
					return BuscarAutor(autorTDA.HijoDerecho(), nombreAutor);
				}
			}
		}
	}

	public LibrosAutorTDA GetLibros(String nombreAutor) {
		Autor aux = BuscarAutor(this, nombreAutor); // Como el autor tiene que
													// existir no lo chequeo.
		return aux.getLibros();
	}
}
