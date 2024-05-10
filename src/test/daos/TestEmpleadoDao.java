package test.daos;

import java.math.BigDecimal;
import java.sql.Date;

import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;

public class TestEmpleadoDao {
	
	private static EmpleadoDao edao;
	
	static {
		edao = new EmpleadoDaoImplMy8Jpa();
	}

	public static void main(String[] args) {
		//uno();
		//todos();
		//alta();
		//eliminar();
		//salir();
		//empleadosPorDepartamento();
		//empleadosPorSexo();
		//empleadosPorApellido();
		//salarioTotal();
		salario();

	}
	
	public static void alta() {
		System.out.println("Prueba Alta");
		Empleado e = new Empleado(45, "Patricio", "estrella@ifp.es", Date.valueOf("2020-12-15"), Date.valueOf("1992-01-20"), 
				"H", "Estrella", "contraseña",BigDecimal.valueOf(155578), 
					new Departamento(7, "Software", "Madrid"),
					new Perfil(5, "Desarollador", BigDecimal.valueOf(457)), 
					null);
		System.out.println(edao.alta(e));
		
	}
	
	public static void uno() {
		System.out.println("Buscar uno   ---->  " + edao.buscarUno(100));
		}
	public static void todos() {
		System.out.println("BUCAR TODOS");
		edao.mostrarTodos().forEach(System.out::println);;
	}
	public static void salir() {
		System.out.println(edao.salir());
	}
	public static void eliminar() {
		System.out.println("Probamdo eliminar");
		edao.eliminar(100);
	}
	
	public static void empleadosPorDepartamento() {
		edao.empleadosByDepartamento(10).forEach(System.out::println);
	}
	public static void empleadosPorSexo() {
		edao.empleadosBySexo("H");
	}
	public static void empleadosPorApellido() {
		edao.empleadosByApellido("Diaz").forEach((System.out::println));
	}
	public static void salarioTotal() {
		System.out.println(edao.salarioTotal());
	}
	public static void salario() {
		System.out.println("SALARIO DEL DEPARTAMENTO 10"+edao.salarioTotal(10));
	}

}
