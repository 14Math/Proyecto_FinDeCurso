package comparadorweb.dao;

import java.util.List;

import comparadorweb.entidades.Producto;

public interface productoDao {
	
	Producto buscarUna(int idProducto);
	Producto buscarUnaPorNombre(String nombre);
	
	List<Producto> buscarTodos();
	int insertOne (Producto productos);

}
																									