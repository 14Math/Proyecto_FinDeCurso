package test.entities;

import java.math.BigDecimal;
import java.sql.Date;

import modelo.entidades.Cliente;
import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;
import modelo.entidades.Proyecto;
import modelo.entidades.ProyectoConEmpleado;

public class TestProyectoConEmpleado {

	public static void main(String[] args) {
		System.out.println("PRUEBA ALTA");
		ProyectoConEmpleado proyectoempleado = new ProyectoConEmpleado(4, Date.valueOf("2020-12-15"), 8, 
													new Empleado(45, "Patricio", "estrella@ifp.es", Date.valueOf("2020-12-15"), Date.valueOf("1992-01-20"), "H", "Estrella", 
															"contraseña",BigDecimal.valueOf(155578), 
															new Departamento(7, "Madrid", "Software"),
															new Perfil(5, "Desarollador", BigDecimal.valueOf(450)),
															null), 
												 	new Proyecto("FOR2020011", BigDecimal.valueOf(314000), BigDecimal.valueOf(304000), "Formacion Comercio", "ACTIVO", Date.valueOf("2023-01-15"),
												 			Date.valueOf("2023-03-18"), Date.valueOf("2022-05-10"), BigDecimal.valueOf(400000), 
												 			new Cliente("W7846952", "Merengue", "Ibiza", BigDecimal.valueOf(1400000), "Carlos", 50),
												 			null));
		System.out.println(proyectoempleado);
		System.out.println(proyectoempleado.costeHorasAsignadas());

	}

}
