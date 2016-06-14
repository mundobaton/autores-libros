package uade.tpo.tda;

import uade.tpo.model.Libro;

public interface LibrosAutorTDA {

	/**
	 * Inicializa la estructura
	 * PRE: -
	 * POS: Estructura inicializada
	 */
	public void Inicializar();

	/**
	 * Agrega un libro ordenado por precio.
	 * PRE: Estructura inicializada. El libro no debe existir.
	 * POS: Estructura modificada en un (1) elemento mas
	 */
	public void Agregar(String nombre, float precio);

	/**
	 * Devuelve el hijo izquierdo del arbol de libros
	 * PRE: Estructura inicializada y no vacia
	 * POS: -
	 */
	public LibrosAutorTDA HijoIzquierdo();

	/**
	 * Devuelve el hijo derecho del arbol de libros
	 * PRE: Estructura inicializada y no vacia
	 * POS: -
	 */
	public LibrosAutorTDA HijoDerecho();

	/**
	 * Elimina un libro
	 * PRE: Estructura inicializada y no vacia.
	 * POS: Estructura modificada en un (1) elemento menos.
	 */
	public void Eliminar(String nombre);

	/**
	 * Determina si la estructura se encuentra vacia o no. TRUE: estructura
	 * vacia, FALSE: no vacia.
	 * PRE: Estructura inicializada
	 * POS: -
	 */
	public boolean LibroVacio();
	
	/**
	 * Devuelve un objeto del tipo libro
	 * PRE: Estructura inicializada y no vacia
	 * POS: -
	 */
	public Libro obtenerLibro();
}
