package test.daos;

import java.math.BigDecimal;
import java.sql.Date;

import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;


public class TestEmpleadoDao {

private static EmpleadoDao cdao;
    
    static {
        
        cdao= new EmpleadoDaoImplMy8Jpa();
    }
	
	public static void main(String[] args) {
		//buscaruno();
        //mostrartodos();
        //alta();
        //eliminar();
        //salir();
		//salarioTotal();
		salario();

	}
	public static void alta() {
        Empleado c = new Empleado(4, "Pereira", "kevenpereira@gmail.com", Date.valueOf("2024-01-01"), 
        							Date.valueOf("2004-25-12"), "H", "Keven", "roblox", BigDecimal.valueOf(45000), 
        							new Departamento(20, "Madrid", "Software"),
                                    new Perfil(5, "Desarrollador Web", BigDecimal.valueOf(170)), null);
        System.out.println("Probando Alta --->"+ cdao.alta(c));
        
    }
    
    public static void buscaruno() {
           System.out.println(cdao.buscarUno(4));
        }
    public static void mostrartodos() {
        System.out.println("BUCAR TODOS");
        cdao.mostrarTodos().forEach(System.out::println);
        System.out.println("----------------------FIN---------------------------");
    }
    public static void salir() {
        System.out.println(cdao.salir());
    }
    public static void eliminar() {
    	System.out.println("Eliminar Probando -->" + cdao.eliminar(100));
    }
    public static void salarioTotal() {
    	System.out.println("Salario Total de los Empleados -->" +cdao.salarioTotal());
    }
    public static void salario() {
    	System.out.println("Salario del Departamento 10  ---> "+cdao.salarioTotal(10));
    }
    
}
