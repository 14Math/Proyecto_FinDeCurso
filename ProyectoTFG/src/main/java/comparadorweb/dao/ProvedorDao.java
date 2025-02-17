package comparadorweb.dao;

import java.util.List;

import comparadorweb.entidades.Producto;
import comparadorweb.entidades.ProductosProvedores;
import comparadorweb.entidades.Provedor;

public interface ProvedorDao {
	
	 
	int insertOne (Provedor provedores);
	int updateOne (Provedor provedores);
	int deleteOne (int idProvedor);

}
