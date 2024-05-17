package modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import modelo.entidades.Proyecto;

public class ProyectoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ProyectoDao{

	@Override
	public boolean alta(Proyecto obj) {
		try {
			tx.begin();
				em.persist(obj);
			tx.commit();
			return true;
		}catch(Exception e) {
		//	e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
			
		}
	}

	@Override
	public boolean eliminar(String clave) {
		try {
			Proyecto proyecto = buscarUno(clave);
			if (proyecto != null) {
				tx.begin();
					em.remove(proyecto);
				tx.commit();
				return true;
			}else
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Proyecto buscarUno(String clave) {
		return em.find(Proyecto.class, clave);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> mostrarTodos() {
		jpql = "select p from Proyecto p";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public String salir() {
		return "FIN DE PROGRAMA";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByEstado(String estado) {
		jpql= "select p from Proyecto p where p.estado= :est";
        query = em.createQuery(jpql);
        query.setParameter("est", estado);
        return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		jpql= "select p from Proyecto p where p.cliente.cif = :cif";
        query = em.createQuery(jpql);
        query.setParameter("cif", cif);
        return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado) {
		jpql= "select p from Proyecto p where p.empleado.idEmpl = :jefe and p.estado = :est";
        query = em.createQuery(jpql);
        query.setParameter("jefe", jefeProyecto);
        query.setParameter("est", estado);
        return query.getResultList();
	}

	@Override
	public double importesVentaProyectosTerminados() {
		jpql = "select sum(p.ventaPrevisto) from Proyecto p where p.estado = 'TERMINADO'";
        query = em.createQuery(jpql);
        return ((BigDecimal)query.getSingleResult()).doubleValue();
	}

	@Override
	public double margenBrutoProyectosTerminados() {
		// Diferencia suma Importes venta y gastos reales
		jpql = "select sum(p.ventaPrevisto-p.costeReal) from Proyecto p where p.estado = 'TERMINADO'";
        query = em.createQuery(jpql);
        return ((BigDecimal)query.getSingleResult()).doubleValue();
	}
	
	@Override
	public int diasATerminoProyectoActivo(String codigoProyecto) {
		// Cuantos días quedan para terminar el proyecto (diferencia entre fecha_fin_previsto y la fecha de hoy)
		jpql= "select datediff(current_date(),p.fechaFinPrevisto)  from Proyecto p where p.idProyecto= :codP"; 
		// select current_date() as dia_de_hoy , fecha_fin_previsto, datediff(current_date(),fecha_fin_previsto) 
		// as dia_de_hoy_menos_fin_previsto from proyectos;
        query = em.createQuery(jpql);
        query.setParameter("codP", codigoProyecto);
        return (int)query.getSingleResult();
	}

}
