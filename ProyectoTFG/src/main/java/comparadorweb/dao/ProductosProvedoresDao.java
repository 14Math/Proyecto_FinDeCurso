package comparadorweb.dao;

import java.util.List;


import comparadorweb.entidades.ProductosProvedores;

public interface ProductosProvedoresDao {
	
	List<ProductosProvedores> buscarProductoYMostrarLosPreciosProvedores(int idProducto);
	
	int insertProductoProvedor (ProductosProvedores productosProvedores);
	int updateProductoProvedor (double precioProvedor);
	int deleteproductoProvedor (String precioProvedor);


}
