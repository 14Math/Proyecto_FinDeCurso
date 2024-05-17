package modelo.dao;

import java.math.BigDecimal;
import java.util.List;


import modelo.entidades.ProyectoConEmpleado;

public class ProyectoConEmpleadoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ProyectoConEmpleadoDao {
	private static ProyectoDao cdao;
	static {
        
        cdao= new ProyectoDaoImplMy8Jpa();
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
			ProyectoConEmpleado pce = buscarUno(clave);
			if (pce != null) {
				tx.begin();
					em.remove(pce);
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
		return "FIN DE PROGRAMA";
	}
	
	
	//METODOS DAO
	@SuppressWarnings("unchecked") 
    @Override
    public List<ProyectoConEmpleadoDao> empleadosByProyecto(String codigoProyecto) {
        jpql= "select p from ProyectoConEmpleado p where p.empleado.proyectos = :cod";
        query = em.createQuery(jpql);
        query.setParameter("cod", codigoProyecto);
        return query.getResultList();
    }

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
        return cdao.buscarUno(codigoProyecto).margenReal() - costeActualDeProyecto(codigoProyecto);
    }

}
