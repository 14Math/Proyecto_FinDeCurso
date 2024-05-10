package test.entities;

import java.math.BigDecimal;
import java.sql.Date;

import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;

public class TestEmpleado {


	public static void main(String[] args) {
		System.out.println("Entrando");
		Empleado empleado = new Empleado(45, "Patricio", "estrella@ifp.es", Date.valueOf("2020-12-15"), Date.valueOf("1992-01-20"), 
										"H", "Estrella", "contraseña",BigDecimal.valueOf(155578), 
							new Departamento(7, "Madrid", "Software"),
							new Perfil(5, "Desarollador", BigDecimal.valueOf(450)), 
							null);
		System.out.println("Prubea Alta ---> "+empleado);
		
		System.out.println("PRUEBA METODOS");
		System.out.println("Prueba obtenerEmail --> " + Empleado.obtenerEmail("Estrella", "Patricio"));
		System.out.println("Prueba literal sexo --> " + empleado.literalSexo());
		System.out.println("Prueba nombre Completo --> " + empleado.nombreCompleto());
		System.out.println("Prueba salario Mensual --> " + empleado.salarioMensual(12));
		System.out.println("prueba salario Bruto --> " + empleado.salarioBruto());


	}

}
