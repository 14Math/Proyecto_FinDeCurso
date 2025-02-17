package comparadorweb.entidades;

import java.io.Serializable;
import java.math.BigDecimal;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name="PRODUCTOS")
public class Producto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_PRODUCTO")
	private int idProducto;
	private String nombre;
	private String marca;
	private String autor;
	private String descripcion;
	
	@Column(name="PRECIO_VENTA")
	private double precioVenta;
	
	@ManyToOne
	@JoinColumn(name= "ID_CATEGORIA")
	private Categoria categorias;

}