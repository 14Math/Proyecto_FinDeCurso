package principales;

import java.util.List;

public interface GestionClientes<K,T> {

	boolean alta(T obj);
	boolean eliminar(K clave);
	T buscarUno(K clave);
	List<T> mostrarTodos();
	String salir();
}
