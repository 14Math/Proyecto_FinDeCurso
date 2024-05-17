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
        //buscaruno();
        mostrartodos();
        //alta();
        //eliminar();
        //salir();


    }
    
    public static void alta() {
        Cliente c = new Cliente("789456L", "Esponja", "Toledo",BigDecimal.valueOf(50000), "BOB", 80);
        System.out.println(cdao.alta(c));
        
    }
    
    public static void buscaruno() {
           System.out.println(cdao.buscarUno("789456L"));
        }
    public static void mostrartodos() {
        cdao.mostrarTodos().forEach(System.out::println);
    }
    public static void salir() {
        System.out.println(cdao.salir());
    }
    public static void eliminar() {
    	cdao.eliminar("789456L");
    }

}
