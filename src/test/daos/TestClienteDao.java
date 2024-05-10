package test.daos;

import java.math.BigDecimal;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entidades.Cliente;

public class TestClienteDao {
	
	private static ClienteDao cdao;
	
	static {
		
		cdao= new ClienteDaoImplMy8Jpa();
	}
	
	public static void main(String[] args) {
		//uno();
		//todos();
		//alta();
		//eliminar();
		salir();


	}
	
	public static void alta() {
		System.out.println("Prueba Alta");
		Cliente c = new Cliente("789456L", "Esponja", "Sol",BigDecimal.valueOf(50000), "BOB", 80);
		System.out.println(cdao.alta(c));
		
	}
	
	public static void uno() {
		System.out.println("Buscar uno");
	       System.out.println(cdao.buscarUno("A22222222"));
		}
	public static void todos() {
		System.out.println("BUCAR TODOS");
		cdao.mostrarTodos().forEach(System.out::println);
	}
	public static void salir() {
		System.out.println(cdao.salir());
	}

}
