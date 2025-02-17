package comparadorweb.entidades;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="CLIENTES")
public class Cliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID_CLIENTE")
	private int idCliente;
	private String username;
	private String password;
	private String email;
	private String nombre;
	private String apellidos;
	private String direccion;
	private int enabled;
	
	@Column(name="FECHA_REGISTRO")
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	
	

}