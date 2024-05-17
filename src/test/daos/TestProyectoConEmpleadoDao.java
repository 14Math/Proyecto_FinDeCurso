package test.daos;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.ProyectoConEmpleadoDao;
import modelo.dao.ProyectoConEmpleadoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Cliente;
import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;
import modelo.entidades.Proyecto;
import modelo.entidades.ProyectoConEmpleado;

public class TestProyectoConEmpleadoDao {
	
	private static ProyectoConEmpleadoDao pdao;
	private static ProyectoDao proydao;
	private static EmpleadoDao edao;
	
	static {
		pdao = new ProyectoConEmpleadoDaoImplMy8Jpa();
		proydao = new ProyectoDaoImplMy8Jpa();
		edao = new EmpleadoDaoImplMy8Jpa();
	}

	public static void main(String[] args) {
		
		//uno();
		//todos();
		//alta();
		//eliminar();
		//salir();
	//	empleadosPorProyecto();
		//asignarEmpleadosAProyecto();
		 //costeActualDelProyecto();
		//margenActualDelProyecto();
		horasAsignadas();

	}
	
	public static void uno() {
		System.out.println("Buscar uno   ---->  " + pdao.buscarUno(1));
	}
	
	public static void todos() {
		System.out.println("BUCAR TODOS");
		pdao.mostrarTodos().forEach(System.out::println);
	}
	
	public static void alta() {
		System.out.println("Probando ALTA");
		
		ProyectoConEmpleado pr = new ProyectoConEmpleado(0, Date.valueOf("2020-12-15"), 8, 
										edao.buscarUno(101), 
										proydao.buscarUno("FOR2021001"));
		
		
		System.out.println(pdao.alta(pr));
	}
	
	public static void eliminar() {
		System.out.println("Probando eliminar");
		pdao.eliminar(4);
	}
	
	public static void salir() {
		System.out.println(pdao.salir());
	}
	
	public static void empleadosPorProyecto() {
		for (ProyectoConEmpleado pce: pdao.empleadosByProyecto("FOR2"))
			System.out.println(pce.getEmpleado().getIdEmpl() + " - " + pce.getHorasAsignadas() + " - " + pce.getFechaIncorporacion());
	}
	
	
	public static void asignarEmpleadosAProyecto() {
		for(List<ProyectoConEmpleado> pe : pdao.asignarEmpleadosAProyecto(pe))
			System.out.println(pe);
	}
	
	
	public static void costeActualDelProyecto() {
		System.out.println(pdao.costeActualDeProyecto("FOR2020001"));
	}
	
	public static void horasAsignadas() {
	System.out.println(pdao.horasAsignadasAProyecto("FOR1"));
	}
	
	public static void margenActualDelProyecto() {
		System.out.println(pdao.margenActualProyecto("FOR2020001"));
	}
	

}
