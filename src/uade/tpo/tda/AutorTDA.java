package uade.tpo.tda;

public interface AutorTDA {

	//Inicializa la estructura
	//PRE: -
	//POS: Estructura inicializada
	public void Inicializar();

	//Agrega un autor
	//PRE: Estructura inicializada. El autor no debe existir.
	//POS: Estructura modificada en un (1) elemento mas
	public void Agregar(String nombreAutor);

	//Determina si un autor existe. TRUE existe, FALSE no existe.
	//PRE: Estructura inicializada
	//POS: -
	public boolean AutorPertenece(String nombreAutor);

	//Devuelve el hijo izquierdo del árbol de autor
	//PRE: Estructura inicializada y no vacia
	//POS: -
	public AutorTDA HijoIzquierdo();

	//Devuelve el hijo derecho del arbol de autor
	//PRE: Estructura inicializada y no vacia.
	//POS: -
	public AutorTDA HijoDerecho();

	//Elimina un autor
	//PRE: Estructura inicializada y no vacia.
	//POS: Estructura modificada en un (1) elemento menos.
	public void Eliminar(String nombreAutor);

	//Devuelve el nombre del autor que se encuentra en la raiz
	//PRE: Estructura inicializada y no vacia
	//POS: - 
	public String Raiz();

	//Determina si la estructura se encuentra vacia o no. TRUE: estructura vacia, FALSE: no vacia.
	//PRE: Estructura inicializada
	//POS: -
	public boolean AutorVacio();

	//Agrega un libro a un autor.
	//PRE: Estructura inicializada y no vacia. El autor debe existir.
	//POS: Elemento (autor) modificado en un (1) elemento mas.
	public void AgregarLibro(String nombreAutor, String tituloLibro, float precio);

	//Devuelve una estructura (arbol) con los libros del autor.
	//PRE: Estructura inicializada y no vacia. El autor debe existir.
	//POS: -
	public LibroTDA GetLibros(String nombreAutor);
}
