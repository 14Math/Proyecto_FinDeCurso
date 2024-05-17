package principales;

import java.util.ArrayList;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.FacturaDao;
import modelo.dao.FacturaDaoImpl;
import modelo.dao.ProyectoConEmpleadoDao;
import modelo.dao.ProyectoConEmpleadoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Cliente;
import modelo.entidades.Empleado;
import modelo.entidades.Proyecto;

public class ImprimirFactura {
	
	private static FacturaDao fdao;
	private static ProyectoConEmpleadoDao pcedao;
	private static ProyectoDao pdao;
	private static EmpleadoDao edao;
	private static ClienteDao cdao;
	
	static {
		fdao = new FacturaDaoImpl();
		pcedao = new ProyectoConEmpleadoDaoImplMy8Jpa();
		pdao = new ProyectoDaoImplMy8Jpa();
		edao = new EmpleadoDaoImplMy8Jpa();
		cdao = new ClienteDaoImplMy8Jpa();
	}


	public static void main(String[] args) {
		
		factura();
		cliente();
		proyecto();
		//empleado();
		productos();

	}
	
	public static void factura() {
		System.out.println("DATOS DE LA FACTURA");
			System.out.println(fdao.findById("F2020001").getFechaFactura());
	}
	public static void cliente() {
		System.out.println("DATOS DE CLIENTE");
		for(Cliente c: cdao.mostrarTodos())
			System.out.println(c.getNombre() + " - " + c.getDomicilio() );
	}
	
	public static void proyecto() {
		System.out.println("DATOS DEL PROYECTO");
		for(Proyecto p: pdao.mostrarTodos()) {
			System.out.println(p.getIdProyecto());
			System.out.println(p.getDescripcion());
			System.out.println(p.getFechaInicio());
			System.out.println(p.getFechaFinReal());
		}
		

	}
	public static void empleado(){
		System.out.println("LISTA EMPLEADOS ");
		for(Empleado e :edao.mostrarTodos())
			System.out.println(e.getApellidos() + " - " + e.getNombre() +" - " + pcedao.horasAsignadasAProyecto(null));
	}

	public static void productos() {
		//for(ArrayList<Producto> p )
			System.out.println();
	}

}
