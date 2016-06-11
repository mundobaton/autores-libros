package uade.tpo.tda;

import uade.tpo.model.Autor;

public interface AutorTDA {

	/**
	 * Inicializa la estructura<br>
	 * PRE: -<br>
	 * POS: Estructura inicializada
	 */
	public void Inicializar();

	/**
	 * Agrega un autor<br>
	 * PRE: Estructura inicializada. El autor no debe existir.<br>
	 * POS: Estructura modificada en un (1) elemento mas
	 */
	public void Agregar(String nombreAutor);

	/**
	 * Devuelve el hijo izquierdo del �rbol de autor<br>
	 * PRE: Estructura inicializada y no vacia<br>
	 * POS: -
	 */
	public AutorTDA HijoIzquierdo();

	/**
	 * Devuelve el hijo derecho del arbol de autor<br>
	 * PRE: Estructura inicializada y no vacia.<br>
	 * POS: -
	 */
	public AutorTDA HijoDerecho();

	/**
	 * Elimina un autor<br>
	 * PRE: Estructura inicializada y no vacia.<br>
	 * POS: Estructura modificada en un (1) elemento menos.
	 */
	public void Eliminar(String nombreAutor);

	/**
	 * Devuelve una instancia del objeto Autor<br>
	 * PRE: Estructura inicializada y no vacia<br>
	 * POS: -
	 */
	public Autor obtenerAutor();

	/**
	 * Determina si la estructura se encuentra vacia o no. TRUE: estructura
	 * vacia, FALSE: no vacia.<br>
	 * PRE: Estructura inicializada<br>
	 * POS: -
	 */
	public boolean AutorVacio();

	/**
	 * Agrega un libro a un autor.<br>
	 * PRE: Estructura inicializada y no vacia. El autor debe existir.<br>
	 * POS: Elemento (autor) modificado en un (1) elemento mas.
	 */
	public void AgregarLibro(String nombreAutor, String tituloLibro,
			float precio);

	/**
	 * Devuelve una estructura (arbol) con los libros del autor.<br>
	 * PRE: Estructura inicializada y no vacia. El autor debe existir.<br>
	 * POS: -
	 */
	public LibrosAutorTDA GetLibros(String nombreAutor);
}
