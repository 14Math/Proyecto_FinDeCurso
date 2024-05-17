package modelo.dao;


import java.util.List;

import modelo.entidades.Empleado;
import principales.GestionClientes;

public interface EmpleadoDao extends GestionClientes<Integer, Empleado>{
	
	List<Empleado> empleadoByDepartamento(int idDepar);
	List<Empleado> empleadoBySexo(String sexo);
	List<Empleado> empleadoByApellido(String subcadena);
	double salarioTotal();
	double salarioTotal(int idDepar);
	
}
