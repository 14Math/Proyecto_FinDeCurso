package test.daos;

import modelo.dao.FacturaDao;
import modelo.dao.FacturaDaoImpl;


public class TestFacturadao {

	private static FacturaDao fdao;

	
	static {
		
		fdao = new FacturaDaoImpl();

	}
	public static void main(String[] args) {
		
		BuscarUno();
		//altaFactura();

	}
	
	public static void BuscarUno() {
		System.out.println(fdao.findById("F2020001"));
	}

}
