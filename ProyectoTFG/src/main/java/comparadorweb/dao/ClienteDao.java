package comparadorweb.dao;

import comparadorweb.entidades.Cliente;

public interface ClienteDao {
	
	int insertOne (Cliente clientes);
	int updateOne (Cliente clientes);

}
