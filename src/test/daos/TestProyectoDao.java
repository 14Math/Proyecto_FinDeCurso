package test.daos;

import java.math.BigDecimal;
import java.sql.Date;


import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Cliente;
import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;
import modelo.entidades.Proyecto;

public class TestProyectoDao {
	
	private static ProyectoDao pdao;
	
	static {

	    pdao= new ProyectoDaoImplMy8Jpa();
	}
	public static void main(String[] args) {
	    //buscaruno();
	    //mostrartodos();
	    //alta();
	    //eliminar();
	    //salir();
	    //proyectosByEstado();
	    //proyectosByCliente();
	    //proyectosByJefeProyectoAndByEstado();
	    //importesVentaProyectosTerminados();
	    //margenBrutoProyectosTerminados();
	    diasATerminoProyectoActivo();
	}
	public static void alta() {
	
	    Proyecto p = new Proyecto("FOR1", null, BigDecimal.valueOf(40000), "Formación xxxx", "ACTIVO",
	            Date.valueOf("2025-01-01"), null, Date.valueOf("2024-01-01"), BigDecimal.valueOf(60000),
	            new Cliente("789456L", "Esponja", "Toledo",BigDecimal.valueOf(50000), "BOB", 80),
	            new Empleado(4, "Pereira", "kevenpereira@gmail.com", Date.valueOf("2024-01-01"),
	                    Date.valueOf("2004-25-12"), "H", "Keven", "roblox", BigDecimal.valueOf(45000),
	                    new Departamento(20, "Madrid", "Software"),
	                    new Perfil(5, "Desarrollador Web", BigDecimal.valueOf(170)), null) );
	    System.out.println(pdao.alta(p));
	}

	public static void buscaruno() {
	    System.out.println(pdao.buscarUno("FOR2020001"));
	 }
	public static void mostrartodos() {
	 pdao.mostrarTodos().forEach(System.out::println);
	}
	 public static void salir() {
	     System.out.println(pdao.salir());
	 }
	 public static void eliminar() {
	     pdao.eliminar("FOR2020001");
	 }

	 public static void proyectosByEstado() {
	    pdao.proyectosByEstado("ACTIVO").forEach(System.out::println);
	 }

	public static void proyectosByCliente() {
	    pdao.proyectosByCliente("1111111L").forEach(System.out::println);
	}
	public static void proyectosByJefeProyectoAndByEstado() {
	    pdao.proyectosByJefeProyectoAndByEstado(114, "ACTIVO").forEach(System.out::println);
	}
	public static void importesVentaProyectosTerminados() {
	     System.out.println(pdao.importesVentaProyectosTerminados());
	}
	public static void margenBrutoProyectosTerminados() {
	     System.out.println(pdao.margenBrutoProyectosTerminados());
	}

	public static void diasATerminoProyectoActivo() {
	     System.out.println(pdao.diasATerminoProyectoActivo("FOR2020001"));
	 }

}
