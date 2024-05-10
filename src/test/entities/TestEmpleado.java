package test.entities;

import java.math.BigDecimal;
import java.sql.Date;

import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;

public class TestEmpleado {

	public static void main(String[] args) {
		System.out.println("PRUEBA EMPLEADOS");
        Empleado empleado = new Empleado(45, "Patricio", "estrella@ifp.es", Date.valueOf("2020-12-15"), Date.valueOf("1992-01-20"), 
                                        "H", "Estrella", "contraseña",BigDecimal.valueOf(155578), 
                            new Departamento(20, "Madrid", "Software"),
                            new Perfil(5, "Desarrllador Java", BigDecimal.valueOf(170)), 
                            null);

        
        System.out.println("Prueba obtenerEmail --> " + Empleado.obtenerEmail("Estrella", "Patricio"));
        System.out.println("Prueba literal sexo --> " + empleado.literalSexo());
        System.out.println("Prueba nombre Completo --> " + empleado.nombreCompleto());
        System.out.println("Prueba salario Mensual --> " + empleado.salarioMensual(12));
        System.out.println("prueba salario Bruto --> " + empleado.salarioBruto());

	}

}
