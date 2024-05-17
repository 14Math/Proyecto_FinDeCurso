package modelo.dao;

import modelo.entidades.Factura;

public class FacturaDaoImpl extends AbstractDaoImplMy8Jpa implements FacturaDao{
	
	public FacturaDaoImpl() {
		super();
	}

	@Override
	public int altaFactura(Factura factura) {
		tx.begin();
		
		tx.commit();
			return factura.hashCode();
		}

	@Override
	public Factura findById(String código) {
		// TODO Auto-generated method stub
		return em.find(Factura.class, código);
	}

}
