package comparadorweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import comparadorweb.entidades.ProductosProvedores;

public interface ProductosProvedoresRepository extends JpaRepository<ProductosProvedores, Integer>{
	
	@Query("from ProductosProvedores pr where pr.producto.idProducto =?1 ")
	public List<ProductosProvedores> findByProducto(int idProducto); 
	

}
