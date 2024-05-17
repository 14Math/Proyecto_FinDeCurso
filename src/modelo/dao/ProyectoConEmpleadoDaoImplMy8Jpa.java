package modelo.dao;

import java.math.BigDecimal;
import java.util.List;


import modelo.entidades.ProyectoConEmpleado;

public class ProyectoConEmpleadoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ProyectoConEmpleadoDao{
	
private static ProyectoDao pdao;
	
	static {

	    pdao= new ProyectoDaoImplMy8Jpa();
	}
	
	public ProyectoConEmpleadoDaoImplMy8Jpa() {
		super();
	}
	
	

	@Override
	public boolean alta(ProyectoConEmpleado obj) {
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
	public boolean eliminar(Integer clave) {
		try {
			ProyectoConEmpleado proyectoEmp = buscarUno(clave);
			if (proyectoEmp != null) {
				tx.begin();
					em.remove(proyectoEmp);
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
	public ProyectoConEmpleado buscarUno(Integer clave) {
		// TODO Auto-generated method stub
		return em.find(ProyectoConEmpleado.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProyectoConEmpleado> mostrarTodos() {
		jpql = "select p from ProyectoConEmpleado p";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public String salir() {
		// TODO Auto-generated method stub
		return "-----FIN DE PROGRAMA CRAK-----";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProyectoConEmpleado> empleadosByProyecto(String codigoProyecto) {
		jpql= "select p from ProyectoConEmpleado p where p.proyecto.idProyecto = :cod";
		query = em.createQuery(jpql);
		query.setParameter("cod", codigoProyecto);
		return query.getResultList();
	}

	@Override
	public int asignarEmpleadosAProyecto(List<ProyectoConEmpleado> empleados) {
		
		tx.begin();
		for(ProyectoConEmpleado ep: empleados ) {
			em.persist(ep);
		}
		tx.commit();
		return empleados.size();
	}

	@Override
	public int horasAsignadasAProyecto(String codigoProyecto) {
		jpql = "select sum(p.horasAsignadas) from ProyectoConEmpleado p where p.proyecto.idProyecto = :pr";
		query = em.createQuery(jpql);
		query.setParameter("pr", codigoProyecto);
		return ((int)query.getSingleResult());
	}

	@Override
	public double costeActualDeProyecto(String codigoProyecto) {
		jpql = "select sum(p.horasAsignadas * p.empleado.perfil.tasaStandard) from ProyectoConEmpleado p where p.proyecto.idProyecto = :pr";
		query = em.createQuery(jpql);
		query.setParameter("pr", codigoProyecto);
		return ((BigDecimal)query.getSingleResult()).doubleValue();
	}

	@Override
	public double margenActualProyecto(String codigoProyecto) {
		return pdao.buscarUno(codigoProyecto).margenReal() - costeActualDeProyecto(codigoProyecto);
	}

}
