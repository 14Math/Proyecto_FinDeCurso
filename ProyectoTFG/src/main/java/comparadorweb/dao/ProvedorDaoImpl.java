package comparadorweb.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import comparadorweb.entidades.Provedor;
import comparadorweb.repository.ProvedorRepository;

@Repository
public class ProvedorDaoImpl implements ProvedorDao {

	@Autowired
	private ProvedorRepository prorepo;

	@Override
	public int insertOne(Provedor provedores) {
		// TODO Auto-generated method stub
		return (prorepo.save(provedores) != null) ? 1 : 0;
	}

	@Override
	public int updateOne(Provedor provedores) {
		// TODO Auto-generated method stub
		if (prorepo.existsById(provedores.getIdProvedor())) {

			prorepo.save(provedores);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteOne(int idProvedor) {
		// TODO Auto-generated method stub
		if (prorepo.existsById(idProvedor)) {

			prorepo.deleteById(idProvedor);
			return 1;
		}
		return 0;
	}

}
