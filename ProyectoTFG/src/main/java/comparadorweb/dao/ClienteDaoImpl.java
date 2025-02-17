package comparadorweb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import comparadorweb.entidades.Cliente;
import comparadorweb.repository.ClienteRepository;
@Repository
public class ClienteDaoImpl implements ClienteDao{
	
	@Autowired
	private ClienteRepository crepo;

	@Override
	public int insertOne(Cliente clientes) {
		// TODO Auto-generated method stub
		return (crepo.save(clientes) != null)? 1 : 0;
	}

	@Override
	public int updateOne(Cliente clientes) {
		// TODO Auto-generated method stub
		if (crepo.existsById(clientes.getIdCliente())) {

			crepo.save(clientes);
			return 1;
		}
		return 0;
	}



}
