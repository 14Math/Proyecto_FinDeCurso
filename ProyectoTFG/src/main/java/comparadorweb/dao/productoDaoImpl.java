package comparadorweb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import comparadorweb.entidades.Producto;
import comparadorweb.repository.ProductoRepository;
@Repository
public class productoDaoImpl implements productoDao{
	
	@Autowired
	private ProductoRepository prepo;

	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		return prepo.findAll();
	}


	@Override
	public int insertOne(Producto productos) {
		// TODO Auto-generated method stub
		return (prepo.save(productos) != null)? 1 : 0;
	}




	@Override
	public Producto buscarUna(int idProducto) {
		// TODO Auto-generated method stub
		return prepo.findById(idProducto).orElse(null);
	}


	@Override
	public Producto buscarUnaPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return prepo.findByNombre(nombre);
	}

}
