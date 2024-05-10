package modelo.dao;

import java.util.List;

import modelo.entidades.Empleado;
import principales.GestionClientes;

public interface EmpleadoDao extends GestionClientes<Integer, Empleado>{
	
	List<Empleado> empleadosByDepartamento(int idDepar);
	List<Empleado> empleadosBySexo(String sexo);
	List<Empleado>  empleadosByApellido(String subcadena);
	double salarioTotal();
	double salarioTotal(int idDepar);

}
