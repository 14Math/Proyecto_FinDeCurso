package comparadorweb.entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="PRODUCTOS_PROVEDORES")
public class ProductosProvedores implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_PRO")
	private int idPro;
	
	
	@ManyToOne
	@JoinColumn(name= "ID_PRODUCTO")
	private Producto producto;
	@ManyToOne
	@JoinColumn(name= "ID_PROVEDOR")
	private Provedor provedor;
	@Column(name="PRECIO_PROVEDOR")
	private double precioProvedor;
	
	
	

}