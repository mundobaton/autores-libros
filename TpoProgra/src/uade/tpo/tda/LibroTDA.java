package uade.tpo.tda;

import uade.tpo.model.Libro;

public interface LibroTDA {
	
	//Inicializa la estructura
	//PRE: -
	//POS: Estructura inicializada
	public void Inicializar();
	
	//Agrega un libro ordenado por precio.
	//PRE: Estructura inicializada. El  libro no debe existir.
	//POS: Estructura modificada en un (1) elemento mas
	public void Agregar(String nombre, float precio);

	//Determina si un libro existe. TRUE existe, FALSE no existe.
	//PRE: Estructura inicializada
	//POS: -
	public boolean LibroPertenece(String nombre);

	//Devuelve el hijo izquierdo del árbol de libros
	//PRE: Estructura inicializada y no vacia
	//POS: -
	public LibroTDA HijoIzquierdo();

	//Devuelve el hijo derecho del árbol de libros
	//PRE: Estructura inicializada y no vacia
	//POS: -
	public LibroTDA HijoDerecho();

	//Elimina un libro
	//PRE: Estructura inicializada y no vacia.
	//POS: Estructura modificada en un (1) elemento menos.
	public void Eliminar(String nombre);

	//Devuelve un objeto libro que se encuentra en la raiz
	//PRE: Estructura inicializada y no vacia
	//POS: - 
	public Libro Raiz();

	//Determina si la estructura se encuentra vacia o no. TRUE: estructura vacia, FALSE: no vacia.
	//PRE: Estructura inicializada
	//POS: -
	public boolean LibroVacio();
}
