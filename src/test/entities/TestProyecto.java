package test.entities;

import java.math.BigDecimal;
import java.sql.Date;

import modelo.entidades.Cliente;
import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;
import modelo.entidades.Proyecto;

public class TestProyecto {

	public static void main(String[] args) {
		System.out.println("PRUEBA PROYECTO");
        System.out.println("\n");
        Proyecto proyecto = new Proyecto("FOR2000", BigDecimal.valueOf(10000), BigDecimal.valueOf(15000), "Formacion de habilidades directivas", "ACTIVO", Date.valueOf("2000-01-01"), 
                                        Date.valueOf("1999-10-01"), Date.valueOf("1999-01-01"), BigDecimal.valueOf(50000), 
                            new Cliente("1", "Pereira", "Calle del Centro", BigDecimal.valueOf(10000000), "Keven", 299), 
                            new Empleado(45, "Patricio", "estrella@ifp.es", Date.valueOf("2020-12-15"), Date.valueOf("1992-01-20"),"H", "Estrella", "contraseña",
                            			BigDecimal.valueOf(155578), 
                            new Departamento(7, "Sol", "Madrid"),
                            new Perfil(5, "Estrella", BigDecimal.valueOf(4567)), 
                                         null));

        System.out.println("MARGEN PREVISTO");
        System.out.println(proyecto.margenPrevisto());
        System.out.println("\n");

        System.out.println("MARGEN REAL");
        System.out.println(proyecto.margenReal());
        System.out.println("\n");

        System.out.println("DIFERENCIA GASTOS");
        System.out.println(proyecto.diferenciaGastos());
        System.out.println("\n");

        System.out.println("DIFERENCIA DIAS FECHA PREVISTA Y REAL");
        System.out.println(proyecto.diferenciaFinPrevistoReal());


    }

	}

