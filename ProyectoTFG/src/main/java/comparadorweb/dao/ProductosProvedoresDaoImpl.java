package comparadorweb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import comparadorweb.entidades.ProductosProvedores;
import comparadorweb.repository.ProductosProvedoresRepository;
@Repository
public class ProductosProvedoresDaoImpl implements ProductosProvedoresDao{
	
	
	
	@Autowired
	private ProductosProvedoresRepository proprorepo;

	@Override
	public int insertProductoProvedor(ProductosProvedores productosProvedores) {
		// TODO Auto-generated method stub
		return (proprorepo.save(productosProvedores) != null)? 1 : 0;
	}

	@Override
	public int updateProductoProvedor(double precioProvedor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteproductoProvedor(String precioProvedor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProductosProvedores> buscarProductoYMostrarLosPreciosProvedores(int idProducto) {
		// TODO Auto-generated method stub
		return proprorepo.findByProducto(idProducto);
	}



	

	

}
