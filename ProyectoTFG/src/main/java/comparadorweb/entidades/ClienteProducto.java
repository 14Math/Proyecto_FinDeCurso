package comparadorweb.entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="CLIENTES_PRODUCTOS")
public class ClienteProducto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="ID_CLIPROD")
	private int idCliProd;
	
	@ManyToOne
	@JoinColumn(name= "ID_CLIENTE")
	private Cliente clientes;
	
	@ManyToOne
	@JoinColumn(name= "ID_PRODUCTO")
	private Producto productos;
	
	private String opinion;
	private int valoracion;


}